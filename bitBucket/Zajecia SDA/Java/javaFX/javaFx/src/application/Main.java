package application;
	
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
/*			VBox root = new VBox();
			root.getChildren().add(new Button("Hello World"));
			root.getChildren().add(new Button("Hello World 2"));
			HBox h = new HBox();
			h.getChildren().add(new Label("asdasdasdasd"));
			h.getChildren().add(new Label("a343434td"));
			root.getChildren().add(h);*/
			Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root ,200,300);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);

		
	}
}
