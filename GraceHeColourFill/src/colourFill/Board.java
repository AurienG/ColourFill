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

	public void change(char colour) {
		int x = 0;
		int y = 0;

		
		for (int i = 0; i < rows; i++) {
			while(board[0][0]==board[i][x]) {
				x++;}
			board[i][x].setState(colour);
		}

		board[0][0].setState(colour);
	
		
		
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