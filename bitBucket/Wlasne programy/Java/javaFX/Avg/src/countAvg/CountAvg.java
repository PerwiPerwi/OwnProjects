package countAvg;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

import application.AvgLists;
import application.SampleController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class CountAvg {

	private Label studentLabel;
	private Label avgLabel;

	SampleController sc = new SampleController();
	AvgLists avgLists = AvgLists.getInstance();

	@FXML
	private Button exitButton, countBw, countMsi, back;

	@FXML
	void countMsiStudent(ActionEvent event) throws IOException {
		sc.changeScene(countMsi, "../countAvg/CountMsiStudent.fxml");
	}

	@FXML
	void countBwStudent(ActionEvent event) throws IOException {
		sc.changeScene(countBw, "../countAvg/CountBwStudent.fxml");
	}

	@FXML
	void back(ActionEvent event) throws IOException {
		sc.changeScene(back, "Sample.fxml");
	}

	@FXML
	void exitProgram(ActionEvent event) {
		System.exit(0);
	}

	public void displayStudentAvg(GridPane studentGrid, GridPane avgGrid, Map<String, ArrayList<Double>> mapWithMarks) {

		DecimalFormat df = new DecimalFormat("#.00");
		int gridCounter = 1;
		int counter = 0;
		double avg = 0;
		for (String mainKey : mapWithMarks.keySet()) {
			ArrayList<Double> tempArray = mapWithMarks.get(mainKey);
			for (int i = 0; i < tempArray.size(); i++) {
				avg += tempArray.get(i);
				counter++;
			}
			String decimalDouble = df.format(avg / counter);
			studentLabel = new Label(gridCounter + ") " + mainKey);
			avgLabel = new Label(decimalDouble);

			studentLabel.setPadding(new Insets(20));
			avgLabel.setPadding(new Insets(20));
			studentLabel.setFont(Font.font("System", 15));
			avgLabel.setFont(Font.font("System", 15));

			studentGrid.add(studentLabel, 0, gridCounter);
			avgGrid.add(avgLabel, 0, gridCounter);
			gridCounter++;
			avg = 0;
			counter = 0;
		}
	}

}
