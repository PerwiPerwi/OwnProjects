package countAvg;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import application.AvgLists;
import application.SampleController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class CountMsiStudent extends CountAvg implements Initializable {

	SampleController sc = new SampleController();

	AvgLists avgLists = AvgLists.getInstance();

	@FXML
	private Label empty;

	@FXML
	private BorderPane borderPane;

	@FXML
	private Button exitButton;

	@FXML
	private Button back;

	@FXML
	private GridPane students, avg;

	@FXML
	void exitProgram(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void backToMenu(ActionEvent event) throws IOException {
		sc.changeScene(back, "../countAvg/CountAvg.fxml");
	}

	public void displayStudents(Map<String, HashMap<String, Double>> student) {
		Set<String> keys = avgLists.msiStudents.keySet();
		Iterator<String> iterator = keys.iterator();
		while (iterator.hasNext()) {
			String value = iterator.next();
			int counter = 0;
			Label studentName = new Label(value);
			students.add(studentName, 0, counter);
			counter++;
		}
	}

	private void countAvg() {
		if (avgLists.msiStudents.isEmpty()) {
			empty.setPadding(new Insets(15));
			empty.setFont(Font.font("System", 15));
			empty.setText("Jeszcze nie dodano studentów");

		} else {
			displayStudentAvg(students, avg, avgLists.msiStudents);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		countAvg();
	}

}
