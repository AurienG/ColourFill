package colourFill;




import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	
	final static int WIDTH=400;
	final static int HEIGHT=200;
	Board board = new Board(5,5, 1);
	Button[][] slots = new Button[5][5];
	
	public static void main(String[] args) {
		launch(args);
	}
	
		
	@Override
	public void start(Stage stage) throws Exception {
		
		GridPane grid = new GridPane();
		final int buttonW = 100;
		final int buttonH = 100;
		
		/**
		//Board Size Button
		Label boardSize = new Label ("Board size");
		GridPane.setConstraints(boardSize, 0, 0);
		
		TextField boardSizeIn = new TextField();
		boardSizeIn.setPromptText("S, M, or B");
		
		Button btnPlay = new Button ("play");
		
		btnPlay.setOnAction(e -> {
			
		});
		**/
		
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
		
		grid.setAlignment(Pos.TOP_LEFT);
		grid.add(btnRed, 0, 0);
		grid.add(btnBlue, 1,0);
		grid.add(btnYellow, 2, 0);
		grid.add(btnGreen,3,0);
		
		//slots
		for (int i=0; i<board.getNumRows(); i++) {
			for (int j=0; j<board.getNumCols(); j++) {
				slots[i][j] = new Button();
				slots[i][j].setPrefSize(buttonW, buttonH);
				slots[i][j].setStyle("-fx-base: #000000;");
			}
		}
		for (int i=0; i<board.getNumRows(); i++) {
			for (int j=0; j<board.getNumCols(); j++) {
				grid.add(slots[i][j], j, i+1);
				
			}
		}
		
		//Button Clicks
		
			
		
		Scene scene = new Scene(grid);
		stage.setScene(scene);
		stage.show();
		
	}
}
