package colourFill;

import java.util.Random;;

public class Cell {
	Random rand = new Random();
	char[] chars = "RYGBOPVT".toCharArray();
	private char state;

	/**
	 * Constructor with known state.
	 * 
	 * @param cs initial state
	 */
	public Cell(char cs) {
		state = cs;
	}

	/**
	 * Fills the cells of the board with random colours depending on difficulty
	 * @param difficulty
	 */
	public Cell(int difficulty) {
		if (difficulty == 4) {
			state = chars[rand.nextInt(4)];
		}
		else if (difficulty == 6) {
			state = chars[rand.nextInt(6)];
		}
		else if (difficulty == 8) {
			state = chars[rand.nextInt(chars.length)];
		}
		
	}

	/**
	 * Change the state of a cell.
	 * 
	 * @param cs new state
	 */
	public void setState(char colour) {
		if (colour == 'R') {
			state = 'R';
		} else if (colour == 'G') {
			state = 'G';
		} else if (colour == 'B') {
			state = 'B';
		} else if (colour == 'Y') {
			state = 'Y';
		} else if (colour == 'O') {
			state = 'O';
		} else if (colour == 'P') {
			state = 'P';
		} else if (colour == 'V') {
			state = 'V';
		} else if (colour == 'T') {
			state = 'T';
		}
		
	}

	/**
	 * Check state of a cell
	 * 
	 * @return state of a cell
	 */
	public char getState() {
		return state;
	}

	/**
	 * String representation of a cell
	 */
	@Override
	public String toString() {
		String cell = "0";
		if (state == 'R') {
			cell = "R";
		} else if (state == 'B') {
			cell = "B";
		} else if (state == 'Y') {
			cell = "Y";
		} else if (state == 'G') {
			cell = "G";
		} else if (state == 'O') {
			cell = "O";
		} else if (state == 'P') {
			cell = "P";
		} else if (state == 'V') {
			cell = "V";
		} else if (state == 'T') {
			cell = "T";
		}
		return cell;
	}
}
