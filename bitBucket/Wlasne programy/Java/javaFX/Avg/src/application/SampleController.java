package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SampleController {
	AvgLists avgLists = AvgLists.getInstance();
	@FXML
	private Button addStudent, countAvg, exitButton, removeStudent, firstButton3, addBw, addMsi, back;

	@FXML
	void addStudent(ActionEvent event) throws IOException {
		changeScene(addStudent, "../addStudents/AddStudent.fxml");
	}

	@FXML
	void removeStudent(ActionEvent event) throws IOException {
		changeScene(removeStudent, "../removeStudents/RemoveStudent.fxml");
	}

	@FXML
	void countAvg(ActionEvent event) throws IOException {
		changeScene(countAvg, "../countAvg/CountAvg.fxml");
	}

	@FXML
	void displayStudents(ActionEvent event) throws IOException {
		changeScene(firstButton3, "DisplayStudents.fxml");
	}

	@FXML
	public void exitProgram(ActionEvent event) {
		System.exit(0);
	}

	public void changeScene(Button button, String fxml) throws IOException {
		Stage stage;
		Parent root;
		// przypisanie nowej sceny do buttona
		stage = (Stage) button.getScene().getWindow();
		// zaladowanie nowego pliku fxml
		root = FXMLLoader.load(getClass().getResource(fxml));
		// create a new scene with root and set the stage
		Scene scene = new Scene(root, 300, 430);
		stage.setScene(scene);
		stage.show();
	}

	public void changeScene(Button button, String fxml, int rootFirst, int rootSecond) throws IOException {
		Stage stage;
		Parent root;
		// przypisanie nowej sceny do buttona
		stage = (Stage) button.getScene().getWindow();
		// zaladowanie nowego pliku fxml
		root = FXMLLoader.load(getClass().getResource(fxml));
		// create a new scene with root and set the stage
		Scene scene = new Scene(root, rootFirst, rootSecond);
		stage.setScene(scene);
		stage.show();
	}
}
