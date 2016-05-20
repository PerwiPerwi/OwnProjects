package applicationCode;

import java.awt.TextField;
import java.io.File;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane parent = new BorderPane();
			addMenu(parent);
			Scene scene = new Scene(parent, 400, 400);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

	private static void addMenu(BorderPane parent ) {
	
		Menu menu = new Menu("File");
		Menu menu1 = new Menu("Edit");
		Menu menu2 = new Menu("Help");
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(menu, menu1,menu2);
		
		MenuItem menuItem = new MenuItem("Open");
		MenuItem menuItem2 = new MenuItem("Save");
		MenuItem menuItem3 = new MenuItem("Close");
		menu.getItems().addAll(menuItem, menuItem2, menuItem3);
		
		TextField textField = new TextField();
		parent.getChildren().add(textField);
		parent.setTop(menuBar);
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("EDIT ERROR");
		alert.setHeaderText("Czytaj wiadomoœ");
		alert.setContentText("hue hue ehue");
		
		
		
		
		
		menuItem3.setOnAction(e-> {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(null);
		textField.setText(file.getName());
			
		});
	    menuItem2.setOnAction(e->alert.showAndWait());

	}
}
