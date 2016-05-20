package addStudents;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.AvgLists;
import application.SampleController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddMsiStudent extends AddStudent {
	SampleController sc = new SampleController();
	AvgLists avgLists = AvgLists.getInstance();
	private ArrayList<Double> innerList;

	final private String[] MSISUBJECTS = { "Kontrola i Audyt w Bezpieczeñstwie",
			"Ochrona Prawna Funkcjonariuszy Publicznych", "Ocena Ryzyka i Prognozowanie w Bezpieczeñstwie",
			"Systemy Informatyczne w Administracji Publicznej" };

	@FXML
	private TextField nameMsi, surnameMsi, firstMarkMsi, secondMarkMsi, thirdMarkMsi, fourthMarkMsi;

	private Button back;

	@FXML
	protected void backToMain(ActionEvent event) throws IOException {
		sc.changeScene(back, "..addStudents/addStudent.fxml");
	}

	@FXML
	protected void exitProgram(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void addMsiStudent(ActionEvent event) {

		List<String> errors = new ArrayList<>();

		String mainKey = addNameOrSurname(nameMsi, errors) + " " + addNameOrSurname(surnameMsi, errors);

		innerList = new ArrayList<>();

		innerList.add(addMark(firstMarkMsi, MSISUBJECTS[0], errors));
		avgLists.msiStudents.put(mainKey, innerList);

		innerList.add(addMark(secondMarkMsi, MSISUBJECTS[1], errors));
		avgLists.msiStudents.put(mainKey, innerList);

		innerList.add(addMark(thirdMarkMsi, MSISUBJECTS[2], errors));
		avgLists.msiStudents.put(mainKey, innerList);

		innerList.add(addMark(fourthMarkMsi, MSISUBJECTS[3], errors));
		avgLists.msiStudents.put(mainKey, innerList);

		if (errors.isEmpty()) {
			nameMsi.clear();
			surnameMsi.clear();
			firstMarkMsi.clear();
			secondMarkMsi.clear();
			thirdMarkMsi.clear();
			fourthMarkMsi.clear();
		}

		showDialogInfo(errors);

	}
}
