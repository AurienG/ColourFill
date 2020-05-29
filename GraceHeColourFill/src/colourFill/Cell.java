package colourFill;


import java.util.Random;;

public class Cell {
	Random rand = new Random();
	char[] chars = "RYGB".toCharArray();
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
	 * Default constructor with empty state.
	 */
	public Cell() {
		state = chars[rand.nextInt(chars.length)];
	}

	/**
	 * Change the state of a cell.
	 * 
	 * @param cs new state
	 */
	public void setState(char colour) {
		if (colour == 'R') {
			state = 'R';
		}else if(colour == 'G') {
			state = 'G';	
		}else if(colour == 'B') {
			state = 'B';}
		else if(colour == 'Y') {
			state = 'Y';}
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
			}
		else if (state == 'B') {
			cell = "B";
		}
		else if (state == 'Y') {
			cell = "Y";
		}
		else if (state == 'G'){
			cell = "G";
		}
		return cell;
		}
	}
