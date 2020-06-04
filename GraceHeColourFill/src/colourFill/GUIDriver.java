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
import javafx.stage.Stage;

public class GUIDriver extends Application {
	
	final static int WIDTH=500;
	final static int HEIGHT=500;
	Board board = new Board(5,5, 1);
	Button[][] slots = new Button[5][5];
	
	public static void main(String[] args) {
		launch(args);
	}
	
		
	@Override
	public void start(Stage stage) throws Exception {
		
		GridPane grid = new GridPane();
		final int buttonW = 200;
		final int buttonH = 200;
		
		//Board Size Button
		Label boardSize = new Label ("Board size");
		GridPane.setConstraints(boardSize, 0, 0);
		
		ComboBox<String> boardSizeOptions = new ComboBox<String>();
		boardSizeOptions.getItems().addAll(
				"5 X 5",
				"7 X 7",
				"9 X 9"
				);
				
		boardSizeOptions.setPromptText("Size Board");
		GridPane.setConstraints(boardSizeOptions, 1, 0);
		
		
		Label gameType = new Label ("Game Type");
		GridPane.setConstraints(gameType, 0, 1);
		
		
		ComboBox<String> gameTypeOptions = new ComboBox<String>();
		gameTypeOptions.getItems().addAll(
				"One Player",
				"Two Player",
				"Robot"
				);
				
		gameTypeOptions.setPromptText("Players");
		GridPane.setConstraints(gameTypeOptions, 1, 1);
		
		Label difficulty = new Label ("Difficulty");
		GridPane.setConstraints(difficulty, 0, 2);
		
		ComboBox<String> difficultyOptions = new ComboBox<String>();
		difficultyOptions.getItems().addAll(
				"4",
				"6",
				"8"
				);
				
		difficultyOptions.setPromptText("Colours");
		GridPane.setConstraints(difficultyOptions, 1, 2);
		
		Button btnPlay = new Button ("play");
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

		grid.setAlignment(Pos.TOP_CENTER);
		grid.add(btnRed, 0, 3);
		grid.add(btnBlue, 1, 3);
		grid.add(btnYellow, 2, 3);
		grid.add(btnGreen, 3, 3);
				
		grid.getChildren().addAll(boardSize, boardSizeOptions, gameType, gameTypeOptions, difficulty, difficultyOptions, btnPlay);

		// slots
		for (int i = 0; i < board.getNumRows(); i++) {
			for (int j = 0; j < board.getNumCols(); j++) {
				slots[i][j] = new Button();
				slots[i][j].setPrefSize(buttonW, buttonH);
				slots[i][j].setStyle("-fx-base: #000000;");
			}
		}
		for (int i = 0; i < board.getNumRows(); i++) {
			for (int j = 0; j < board.getNumCols(); j++) {
				grid.add(slots[i][j], j, i + 4);

			}
		}
		Scene scene = new Scene(grid);
		stage.setScene(scene);
		stage.show();

	}
}
