package colourFill;




import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class GUIDriver extends Application {
	private int counter = 1;
	private Label labelCount = new Label ("Count: ");
	
	public static void main(String[] args) {
		launch(args);
	}
	
		
	@Override
	public void start(Stage stage) throws Exception {
		
		boolean inPlay = true;
		
		//Shows which player is playing
		Label labelPlayer1 = new Label ("Player 1");
		labelPlayer1.setFont(Font.font("Verdana", 20));
		GridPane.setConstraints(labelPlayer1, 5, 1);
		
		Label labelPlayer2 = new Label ("Player 2");
		labelPlayer2.setFont(Font.font("Verdana", 20));
		GridPane.setConstraints(labelPlayer2, 5, 1);
		
		
		
		//Pop up for Winning
		Popup popEnd = new Popup();
		Label labelEnd = new Label();
		labelEnd.setStyle(" -fx-background-color: white");
		popEnd.getContent().add(labelEnd);
		
		GridPane grid = new GridPane();
		final int buttonW = 200;
		final int buttonH = 200;

		// Board Size DropDown Options
		Label boardSize = new Label("Board size");
		GridPane.setConstraints(boardSize, 0, 0);

		ComboBox<String> boardSizeOptions = new ComboBox<String>();
		boardSizeOptions.getItems().addAll("5 X 5", "7 X 7", "9 X 9");

		boardSizeOptions.setPromptText("Size Board");
		GridPane.setConstraints(boardSizeOptions, 1, 0);

		// Player Drop down Options
		Label gameType = new Label("Game Type");
		GridPane.setConstraints(gameType, 0, 1);

		ComboBox<String> gameTypeOptions = new ComboBox<String>();
		gameTypeOptions.getItems().addAll("One Player", "Two Player", "Robot");

		gameTypeOptions.setPromptText("Players");
		GridPane.setConstraints(gameTypeOptions, 1, 1);

		// Difficulty of Colours Options
		Label difficulty = new Label("Difficulty");
		GridPane.setConstraints(difficulty, 0, 2);

		ComboBox<String> difficultyOptions = new ComboBox<String>();
		difficultyOptions.getItems().addAll("4", "6", "8");

		difficultyOptions.setPromptText("Colours");
		GridPane.setConstraints(difficultyOptions, 1, 2);

		//Buttons Used
		Button btnPlay = new Button("play");
		btnPlay.setPrefSize(50, 10);
		GridPane.setConstraints(btnPlay, 3, 0);

		Button btnRed = new Button();
		btnRed.setStyle("-fx-base: #dc143c;");
		btnRed.setPrefSize(buttonW, buttonH);

		Button btnBlue = new Button();
		btnBlue.setStyle("-fx-base: #1e90ff;");
		btnBlue.setPrefSize(buttonW, buttonH);

		Button btnYellow = new Button();
		btnYellow.setStyle("-fx-base: #ffd700;");
		btnYellow.setPrefSize(buttonW, buttonH);

		Button btnGreen = new Button();
		btnGreen.setStyle("-fx-base: #008000;");
		btnGreen.setPrefSize(buttonW, buttonH);
		
		Button btnOrange = new Button();
		btnOrange.setStyle("-fx-base: #ff8c00;");
		btnOrange.setPrefSize(buttonW, buttonH);
		
		Button btnPink = new Button();
		btnPink.setStyle("-fx-base: #ff1493;");
		btnPink.setPrefSize(buttonW, buttonH);
		
		Button btnViolet = new Button();
		btnViolet.setStyle("-fx-base: #9370db;");
		btnViolet.setPrefSize(buttonW, buttonH);
		
		Button btnTeal = new Button();
		btnTeal.setStyle("-fx-base: #40e0d0;");
		btnTeal.setPrefSize(buttonW, buttonH);
		
		grid.getChildren().addAll(boardSize, boardSizeOptions, gameType, gameTypeOptions, difficulty, difficultyOptions,
				btnPlay);
		Scene start = new Scene(grid);
		stage.setScene(start);
		stage.show();
		
		
		
		btnPlay.setOnAction(e -> {
			
			//Set up constants for the board
			int numRows = 0;
			int numCols = 0;
			

			boolean single = false;
			boolean singleWin = false;
			
			boolean multi = false;
			boolean player1Win = false;
			boolean player2Win = false;
			
			int count = 0;
			
			Text txtColour = new Text("Colour Choices");
			txtColour.setFont(Font.font("Verdana", 20));
			grid.add(txtColour, 0, 3);
			
			Text txtBoard = new Text("Board");
			txtBoard.setFont(Font.font("Verdana", 20));
			grid.add(txtBoard, 0, 5);
			
			
			
			
			//getting baordSize
			if (boardSizeOptions.getValue().equals("5 X 5")) {
				numRows = 5;
				numCols = 5;
			}
			else if (boardSizeOptions.getValue().equals("7 X 7")) {
				numRows = 7;
				numCols = 7;
			}
			else if (boardSizeOptions.getValue().equals("9 X 9")) {
				numRows = 9;
				numCols = 9;
			}
			
			//getting how many colours
			if (difficultyOptions.getValue().equals("4")) {
				grid.add(btnRed, 0, 4);
				grid.add(btnBlue, 1, 4);
				grid.add(btnYellow, 2, 4);
				grid.add(btnGreen, 3, 4);
			}
			else if (difficultyOptions.getValue().equals("6")) {
				grid.add(btnRed, 0, 4);
				grid.add(btnBlue, 1, 4);
				grid.add(btnYellow, 2, 4);
				grid.add(btnGreen, 3, 4);
				grid.add(btnOrange, 4, 4);
				grid.add(btnPink, 5, 4);
			}
			else if (difficultyOptions.getValue().equals("8")) {
				grid.add(btnRed, 0, 4);
				grid.add(btnBlue, 1, 4);
				grid.add(btnYellow, 2, 4);
				grid.add(btnGreen, 3, 4);
				grid.add(btnOrange, 4, 4);
				grid.add(btnPink, 5, 4);
				grid.add(btnViolet, 6, 4);
				grid.add(btnTeal, 7, 4);
				
			}
			
			
			//creating board
			Board board = new Board(numRows,numCols,Integer.parseInt(difficultyOptions.getValue()));
			Button[][] slots = new Button[numCols][numRows];
			
			// slots
			for (int i = 0; i < board.getNumRows(); i++) {
				for (int j = 0; j < board.getNumCols(); j++) {
					slots[i][j] = new Button();
					slots[i][j].setPrefSize(buttonW, buttonH);
					slots[i][j].setStyle("-fx-base: #9400d3;");
				}
			}
			for (int i = 0; i < board.getNumRows(); i++) {
				for (int j = 0; j < board.getNumCols(); j++) {
					grid.add(slots[i][j], j, i + 6);

				}
			}
			
			updateBoard(board, slots);
			
			if (gameTypeOptions.getValue().equals("One Player")) {
				while (!singleWin){
					singleWin = true;
					
					
					btnRed.setOnAction(f -> {
						board.floodFill(0, 0, board.getCellState(0, 0), 'R');
						labelCount.setText("Count: " + Integer.toString(counter));
						counter();
						updateBoard(board, slots);
						
					});

					btnBlue.setOnAction(f -> {
						board.floodFill(0, 0, board.getCellState(0, 0), 'B');
						labelCount.setText("Count: " + Integer.toString(counter));
						counter();
						updateBoard(board, slots);
					});

					btnYellow.setOnAction(f -> {
						board.floodFill(0, 0, board.getCellState(0, 0), 'Y');
						labelCount.setText("Count: " + Integer.toString(counter));
						counter();
						updateBoard(board, slots);
					});

					btnGreen.setOnAction(f -> {
						board.floodFill(0, 0, board.getCellState(0, 0), 'G');
						labelCount.setText("Count: " + Integer.toString(counter));
						counter();
						updateBoard(board, slots);
					});
					
					btnOrange.setOnAction(f -> {
						board.floodFill(0, 0, board.getCellState(0, 0), 'O');
						labelCount.setText("Count: " + Integer.toString(counter));
						counter();
						updateBoard(board, slots);
					});
					
					btnPink.setOnAction(f -> {
						board.floodFill(0, 0, board.getCellState(0, 0), 'P');
						labelCount.setText("Count: " + Integer.toString(counter));
						counter();
						updateBoard(board, slots);
					});
					
					btnViolet.setOnAction(f -> {
						board.floodFill(0, 0, board.getCellState(0, 0), 'V');
						labelCount.setText("Count: " + Integer.toString(counter));
						counter();
						updateBoard(board, slots);
					});
					
					btnTeal.setOnAction(f -> {
						board.floodFill(0, 0, board.getCellState(0, 0), 'T');
						labelCount.setText("Count: " + Integer.toString(counter));
						counter();
						updateBoard(board, slots);
						
					});
					if (isWinner(board) == true) {
						slots[0][0].setStyle("-fx-base: #fffafa;");
					}
					else if (isWinner(board) == false) {
						slots[0][0].setStyle("-fx-base: #708090;");
					}
					grid.add(labelCount, 5, 0);
					
					Scene scene = new Scene(grid);
					stage.setScene(scene);
					stage.show();
					
					
					
					
					}
				}
			else if (gameTypeOptions.getValue().equals("Two Player")) {
				while(!player1Win && !player2Win) {
					player1Win = true;
					player2Win = true;
					grid.getChildren().remove(labelPlayer2);
					grid.getChildren().add(labelPlayer1);
					
					
					
					btnRed.setOnAction(f -> {
						board.floodFill(0, 0, board.getCellState(0, 0), 'R');
						updateBoard(board, slots);
						grid.getChildren().remove(labelPlayer1);
						grid.getChildren().add(labelPlayer2);
					});

					btnBlue.setOnAction(f -> {
						board.floodFill(0, 0, board.getCellState(0, 0), 'B');
						updateBoard(board, slots);
					});

					btnYellow.setOnAction(f -> {
						board.floodFill(0, 0, board.getCellState(0, 0), 'Y');
						updateBoard(board, slots);
					});

					btnGreen.setOnAction(f -> {
						board.floodFill(0, 0, board.getCellState(0, 0), 'G');
						updateBoard(board, slots);
					});
					
					btnOrange.setOnAction(f -> {
						board.floodFill(0, 0, board.getCellState(0, 0), 'O');
						updateBoard(board, slots);
					});
					
					btnPink.setOnAction(f -> {
						board.floodFill(0, 0, board.getCellState(0, 0), 'P');
						updateBoard(board, slots);
					});
					
					btnViolet.setOnAction(f -> {
						board.floodFill(0, 0, board.getCellState(0, 0), 'V');
						updateBoard(board, slots);
					});
					
					btnTeal.setOnAction(f -> {
						board.floodFill(0, 0, board.getCellState(0, 0), 'T');
						updateBoard(board, slots);
						
						
					});
					
					Scene scene = new Scene(grid);
					stage.setScene(scene);
					stage.show();
					player1Win = isWinner(board);
					
					//player 2 turn
					if (!player1Win) {
						grid.getChildren().remove(labelPlayer1);
						grid.getChildren().add(labelPlayer2);
						int r = numRows;
						int c = numCols;
						

						btnRed.setOnAction(f -> {
							board.floodFill(r - 1, c - 1, board.getCellState(r - 1, c - 1), 'R');
							updateBoard(board, slots);
						});

						btnBlue.setOnAction(f -> {
							board.floodFill(r - 1, c - 1, board.getCellState(r - 1, c - 1), 'B');
							updateBoard(board, slots);
						});

						btnYellow.setOnAction(f -> {
							board.floodFill(r - 1, c - 1, board.getCellState(r - 1, c - 1), 'Y');
							updateBoard(board, slots);
						});

						btnGreen.setOnAction(f -> {
							board.floodFill(r - 1, c - 1, board.getCellState(r - 1, c - 1), 'G');
							updateBoard(board, slots);
						});
						
						btnOrange.setOnAction(f -> {
							board.floodFill(r - 1, c - 1, board.getCellState(r - 1, c - 1), 'O');
							updateBoard(board, slots);
						});
						
						btnPink.setOnAction(f -> {
							board.floodFill(r - 1, c - 1, board.getCellState(r - 1, c - 1), 'P');
							updateBoard(board, slots);
						});
						
						btnViolet.setOnAction(f -> {
							board.floodFill(r - 1, c - 1, board.getCellState(r - 1, c - 1), 'V');
							updateBoard(board, slots);
						});
						
						btnTeal.setOnAction(f -> {
							board.floodFill(r - 1, c - 1, board.getCellState(r - 1, c - 1), 'T');
							updateBoard(board, slots);
							
							
						});
						stage.setScene(scene);
						stage.show();
						player2Win = isWinner(board);
					}
					player2Win = false;
				}
			}
			
			
			if (singleWin) {
				labelEnd.setText("You finished with " + counter + " clicks");
				popEnd.show(stage);
			}
			else if (player1Win) {
				labelEnd.setText("Winner!!! Player 1");
				popEnd.show(stage);
			}
			else if (player2Win) {
				labelEnd.setText("Winner!!! Player 2");
				popEnd.show(stage);
			}
		});
		
	}

	private void updateBoard(Board board, Button[][] slots) {

		for (int i = 0; i < board.getNumRows(); i++) {
			for (int j = 0; j < board.getNumCols(); j++) {
				switch (board.getCellState(i, j)) {
				case 'R':
					slots[i][j].setStyle("-fx-base: #dc143c;");
					break;
				case 'B':
					slots[i][j].setStyle("-fx-base: #1e90ff;");
					break;
				case 'Y':
					slots[i][j].setStyle("-fx-base: #ffd700;");
					break;
				case 'G':
					slots[i][j].setStyle("-fx-base: #008000;");
					break;
				case 'O':
					slots[i][j].setStyle("-fx-base: #ff8c00;");
					break;
				case 'P':
					slots[i][j].setStyle("-fx-base: #ff1493;");
					break;
				case 'V':
					slots[i][j].setStyle("-fx-base: #9370db;");
					break;
				case 'T':
					slots[i][j].setStyle("-fx-base: #40e0d0;");
					break;
				}

			}
		}

	}
	
	private static boolean isWinner (Board board) {
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
	
	public void counter() {
		counter++;
	}
}
