package colourFill;

import colourFill.Cell;

public class Board {

	private Cell[][] board;
	private int numRows;
	private int numCols;

	/**
	 * Constructor for Boards.
	 * 
	 * @param aRows number of rows in board
	 * @param aCols number of columns in board
	 */
	public Board(int numRows, int numCols) {
		board = new Cell[numRows][numCols];
		this.numRows = numRows;
		this.numCols = numCols;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				board[i][j] = new Cell(); // no color
			}
		}
	}

	public char getCellState(int row, int col) {
		return board[row][col].getState();
	}

	public int getNumRows() {
		return numRows;
	}

	public int getNumCols() {
		return numCols;
	}

	public void floodFill(int row, int col, char targetColour, char replaceColour) {
		if (targetColour == replaceColour || board[row][col].getState() != targetColour) {
			return;
		} else {
			board[row][col].setState(replaceColour);
		}

		if (col > 0) {
			floodFill(row, (col - 1), targetColour, replaceColour);
		}
		if (col < numCols-1) {
			floodFill( row, (col + 1), targetColour, replaceColour);
		}
		if (row > 0) {
			floodFill((row - 1),col, targetColour, replaceColour);
		}
		if (row < numRows-1) {
			floodFill((row + 1),col, targetColour, replaceColour);
		}
	}

	public void display() {
		System.out.println("BOARD");
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				System.out.printf("%s ", board[i][j]);
			}
			System.out.println();
		}
	}
}
