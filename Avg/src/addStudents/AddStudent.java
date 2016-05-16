package addStudents;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import application.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddStudent {

	SampleController sc = new SampleController();

	String patternName = "^([a-zA-Z]{3,25})$";
	String patternNumber = "^([25])$|^([34])?([/.])?(0|5)?$";

	Pattern nameCompiled = Pattern.compile(patternName);
	Pattern numberCompiled = Pattern.compile(patternNumber);

	// protected AvgLists avgLists = AvgLists.getInstance();

	@FXML
	private Button exitButton, addBw, addMsi, back, backToMainMenu;

	@FXML
	void addMsi(ActionEvent event) throws IOException {
		sc.changeScene(addMsi, "../addStudents/addMsiStudent.fxml", 310, 600);
	}

	@FXML
	void addBw(ActionEvent event) throws IOException {
		sc.changeScene(addBw, "../addStudents/addBwStudent.fxml", 310, 600);
	}

	@FXML
	protected void back(ActionEvent event) throws IOException {
		sc.changeScene(back, "../addStudents/AddStudent.fxml");

	}

	@FXML
	void backToMain(ActionEvent event) throws IOException {
		sc.changeScene(backToMainMenu, "Sample.fxml");
	}

	@FXML
	void exitProgram(ActionEvent event) {
		System.exit(0);
	}

	protected void showDialogInfo(List<String> errors) {
		if (errors.size() > 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Dodawanie studenta");
			alert.setHeaderText(null);
			alert.setContentText("Popraw pola: " + errors.toString());
			alert.showAndWait();
			errors.removeAll(errors);
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Dodawanie studenta");
			alert.setHeaderText(null);
			alert.setContentText("Student zosta³ pomyœlnie dodany");
			alert.showAndWait();
		}
	}

	protected String addNameOrSurname(TextField valueField, List<String> errors) {
		try {
			Matcher matcher = nameCompiled.matcher(valueField.getText().trim());
			String value;
			if (matcher.find()) {
				value = valueField.getText().trim();
				return value;
			} else {
				errors.add("Imiê");
			}
		} catch (Exception e) {
			System.out.println("B³êdne wartoœci");
		}
		return null;

	}

	protected Double addMark(TextField fieldValue, String subject, Collection<String> errors) {
		try {
			Matcher matcher = numberCompiled.matcher(fieldValue.getText().trim());
			if (matcher.find()) {
				double mark = Double.parseDouble(fieldValue.getText().trim());
				return mark;
			} else {
				errors.add(subject);
			}
		} catch (Exception e) {
			System.out.println("B³êdna treœæ");
			errors.add(subject);

		}
		return null;
	}

}
