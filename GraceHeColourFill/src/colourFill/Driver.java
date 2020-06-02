package colourFill;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Text (console) based driver for testing purposes.
 * 
 * @author not Hutchison
 *
 */
public class Driver {

	public static void main(String[] args) throws InterruptedException {

		// Setup "constants" for the Board
		int numRows = 0;
		int numCols = 0;
		
		// console input
		Scanner in = new Scanner(System.in);
		char colour = ' ';

		boolean inPlay = true;

		while (inPlay) {
			boolean single = false;
			boolean singleWin = false;

			boolean multi = false;
			boolean player1Win = false;
			boolean player2Win = false;

			boolean robot = false;
			boolean robotWin = false;
			boolean humanWin = false;

			String mode = "";

			int count = 0;

			mode = getMode();// for now, 1 is single, 2 is multi,3 is robot, create buttons later
			if (mode.equals("1")) {
				single = true;
			} else if (mode.equals("2")) {
				multi = true;
			} else if (mode.equals("3")) {
				robot = true;
			}
			
			System.out.println("What size board");//S = SMALL, M = MEDIUM, B = BIG (5,7,9)
			int size = in.nextInt();

			/**
			// create the board
			if (size.equals("S")) {
				numRows=5;
				numCols=5;
			}else if (size.equals("M")){
				numRows=7;
				numCols=7;
			}else if (size.equals("B")) {
				numRows=9;
				numCols=9;
			}
			**/
			numRows = size;
			numCols = size;
			Board board = new Board(numRows, numCols);
			board.display();

			if (single) {
				while (!singleWin) {
					singleWin = true;
					colour = getColour();
					board.floodFill(0, 0, board.getCellState(0, 0), colour);
					board.display();
					count++;
					singleWin = isWinner(board);
				}
			} else if (multi) {
				while (!player1Win && !player2Win) {
					player1Win = true;
					player2Win = true;
					System.out.print("Player 1, ");
					colour = getColour();// more clear when there are buttons for whose turn it is
					board.floodFill(0, 0, board.getCellState(0, 0), colour);
					board.display();
					player1Win = isWinner(board);

					if (!player1Win) {
						System.out.print("Player 2, ");
						colour = getColour();
						board.floodFill(numRows - 1, numCols - 1, board.getCellState(numRows - 1, numCols - 1), colour);
						board.display();
						player2Win = isWinner(board);
					}
					player2Win = false;
				}
			} else if (robot) {
				while (!humanWin && !robotWin) {
					humanWin = true;
					robotWin = true;
					colour = getColour();
					board.floodFill(0, 0, board.getCellState(0, 0), colour);
					board.display();
					count++;
					humanWin = isWinner(board);

					if (!humanWin) {
						System.out.println("Robot is going...");
						TimeUnit.SECONDS.sleep(1);
						colour = getRobotColour(board);
						board.floodFill(numRows - 1, numCols - 1, board.getCellState(numRows - 1, numCols - 1), colour);
						board.display();
						robotWin = isWinner(board);
					}
					robotWin = false;
				}
			}
			if (singleWin) {
				System.out.println(count + " clicks used!");
			} else if (player1Win) {
				System.out.println("Winner: Player 1!");
			} else if (player2Win) {
				System.out.println("Winner: Player 2!");
			} else if (robotWin) {
				System.out.println("Winner: Robot!");
			} else if (humanWin) {
				System.out.println("Winner: You!");
			}

			System.out.println("Play again?");// buttons later, so just Y or N for now
			String repeat = in.next();
			if (repeat.equals("N")) {
				inPlay = false;
			}

		}
		System.out.println("Bye!");
	}

	private static String getMode() {
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		String mode = "";
		while (valid != true) {
			System.out.println("Single player, 2 player, or vs robot?");// for now, 1 is single, 2 is multi, 3 is robot,
																		// create buttons later
			mode = in.next();
			if (mode.equals("1") || mode.equals("2") || mode.contentEquals("3")) {
				valid = true;
			} else {
				valid = false;
			}
		}
		return mode;
	}

	private static char getColour() {
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		String colour = "";

		while (!valid) {
			String prompt = String.format("Which Colour (" + "R" + "B" + "Y" + "G" + "): ");
			System.out.println(prompt);
			colour = in.nextLine();
			if (colour.equals("R") || colour.equals("G") || colour.equals("B") || colour.equals("Y")) {
				valid = true;
			} else {
				valid = false;
			}
		}
		return colour.charAt(0);
	}

	private static boolean isWinner(Board board) {
		int numRows = board.getNumRows();
		int numCols = board.getNumCols();
		int row = 0;
		int col = 0;

		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++) {
				if (board.getCellState(row, col) != board.getCellState(r, c)) {
					return false;
				}
			}
		}

		return true;
	}

	private static char getRobotColour(Board board) {
		int[] numEachColour = new int[4];
		char[] colours = { 'G', 'R', 'B', 'Y' };
		int numRows = board.getNumRows();
		int numCols = board.getNumCols();
		char greatestColour = colours[0];

		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++) {
				if (board.getCellState(r, c) == 'G') {
					numEachColour[0]++;
				} else if (board.getCellState(r, c) == 'R') {
					numEachColour[1]++;
				} else if (board.getCellState(r, c) == 'B') {
					numEachColour[2]++;
				} else if (board.getCellState(r, c) == 'Y') {
					numEachColour[3]++;
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			if (numEachColour[i] <= numEachColour[i + 1]) {
				greatestColour = colours[i + 1];
			}
		}

		return greatestColour;

	}
}
