package colourFill;

import colourFill.Cell;

public class Board {
	
	private Cell[][] board;
	private int rows;
	private int cols;

	/**
	 * Constructor for Boards.
	 * @param aRows number of rows in board
	 * @param aCols number of columns in board
	 */
	public Board(int aRows, int aCols) {
		board = new Cell[aRows][aCols];
		rows = aRows;
		cols = aCols;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = new Cell(); // no color
			}
		}
	}
	
	public char getCellState(int col, int row) {
		return board[col][row].getState();
	}

	public void floodFill(int col, int row,char targetColour, char replaceColour) {
		if (targetColour == replaceColour||board[col][row].getState() != targetColour) {
			return; 
		}
		else{board[col][row].setState(replaceColour);}

		if (col>0) {
			floodFill((col-1),row,targetColour, replaceColour);
		}
		if(col<6) {
			floodFill((col+1),row,targetColour, replaceColour);
		}
		if(row>0) {
			floodFill(col,(row-1),targetColour, replaceColour);
		}
		if(row<5) {
			floodFill(col,(row+1),targetColour, replaceColour);
		}
	}
	
	public void display() {
		System.out.println("BOARD");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%s ", board[i][j]);
			}
			System.out.println();
		}
	}
}
