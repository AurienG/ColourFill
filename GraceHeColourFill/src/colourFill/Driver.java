package colourFill;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Text (console) based driver for testing purposes.
 * @author Hutchison
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
		Scanner in = new Scanner(System.in);
		boolean done = false;
		String value = "";
		String colour = "0";
		
		while (done != true) {
			colour = getColour();
			board.change(colour);
			board.display();
		}
		
		}
	
	
	private static String getColour() {
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		String colour = "";
		
		while (valid != true) {
			String prompt = String.format("Which Colour (" + "R" + "B" + "Y" + "G" +"): " ); 
			System.out.println(prompt);
			colour = in.nextLine();
			if (colour.equals("R") || colour.equals("G") || colour.equals("B") || colour.equals("Y")) {
				valid = true;
			}
			else {
				valid = false;
			}
		}
		return colour;
	}
}


