package removeStudents;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import application.AvgLists;
import application.SampleController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class RemoveStudent {

	SampleController sc = new SampleController();
	AvgLists avgLists = AvgLists.getInstance();

	@FXML
	private Button removeMsi, exitButton, removeBw, back;

	@FXML
	void removeMsiStudent(ActionEvent event) throws IOException {
		sc.changeScene(removeMsi, "../removeStudents/RemoveMsiStudent.fxml");
	}

	@FXML
	void removeBwStudent(ActionEvent event) throws IOException {
		sc.changeScene(removeBw, "../removeStudents/RemoveBwStudent.fxml");
	}

	@FXML
	void back(ActionEvent event) throws IOException {

		sc.changeScene(back, "Sample.fxml");
	}

	@FXML
	void exitProgram(ActionEvent event) {
		System.exit(0);
	}

	public void displayStudentForRemove(Label label, Button button, GridPane gridPane,
			Map<String, ArrayList<Double>> mapWithMarks, String fxml) {
		if (mapWithMarks.isEmpty()) {
			label.setText("Nie dodano jeszcze ¿adnego studenta.");
			label.setPadding(new Insets(15));
			label.setFont(Font.font("System", 15));
		} else {
			int counter = 0;
			for (String keyMap : mapWithMarks.keySet()) {
				button = new Button();
				button.setText(keyMap.toString());
				button.setOnAction((event) -> {
					mapWithMarks.remove(keyMap);
					try {
						showDialogInfo(fxml);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
				button.setFont(Font.font("System", 13));
				button.setPadding(new Insets(17));
				gridPane.add(button, 0, counter);
				counter++;
			}
		}
	}

	protected void showDialogInfo(String fxml) throws IOException {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Usuwanie studenta");
		alert.setHeaderText(null);
		alert.setContentText("Student zosta³ pomyœlnie usuniêty");
		sc.changeScene(back, fxml);
		alert.showAndWait();
	}
}
