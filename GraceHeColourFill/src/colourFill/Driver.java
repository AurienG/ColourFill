package colourFill;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Text (console) based driver for testing purposes.
 * 
 * @author not Hutchison
 *
 */
public class Driver {

	public static void main(String[] args) {

		// Setup constants for the Board
		final int ROWS = 6;
		final int COLS = 7;

		// create the board
		Board board = new Board(ROWS, COLS);
		board.display();

		// console input
		boolean done = false;
		String value = "";
		char colour = 'f';

		int count = 0;
		
		while (done != true) {
			done = true;
			colour = getColour();
			board.floodFill(0, 0, board.getCellState(0, 0), colour);
			board.display();
			count++;
			for(int row = 0; row<6;row++) {
				for (int col = 0;col<7;col++) {
					if (board.getCellState(0,0)!= board.getCellState(row,col)) {
						done = false;
					}
				}
			}
		}
		System.out.println("You used" + count + " clicks");

	}

	private static char getColour() {
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		String colour = "";

		while (valid != true) {
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
}
