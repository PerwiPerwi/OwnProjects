package addStudents;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddBwStudent extends AddStudent {
	AvgLists avgLists = AvgLists.getInstance();
	SampleController sc = new SampleController();
	private ArrayList<Double> innerList;

	final private String[] BWSUBJECTS = { "Podstawy Prawne Zarzadzania Kryzysowego",
			"Ocena Ryzyka i Prognozowanie w Bezpieczeñstwie", "System Zarzadzania Kryzysowego Administracji Publicznej",
			"Systemy Informatyczne Administracji Publicznej" };
	@FXML
	private Button back;

	@FXML
	private TextField nameBw, surnameBw, firstMarkBw, secondMarkBw, thirdMarkBw, fourthMarkBw;

	@FXML
	protected void back(ActionEvent event) throws IOException {
		sc.changeScene(back, "Sample.fxml");
	}

	@FXML
	protected void exitProgram(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void addBwStudent(ActionEvent event) {

		List<String> errors = new ArrayList<String>();

		String mainKey = addNameOrSurname(nameBw, errors) + " " + addNameOrSurname(surnameBw, errors);

		innerList = new ArrayList<>();

		innerList.add(addMark(firstMarkBw, BWSUBJECTS[0], errors));
		avgLists.bwStudents.put(mainKey, innerList);

		innerList.add(addMark(secondMarkBw, BWSUBJECTS[1], errors));
		avgLists.bwStudents.put(mainKey, innerList);

		innerList.add(addMark(thirdMarkBw, BWSUBJECTS[2], errors));
		avgLists.bwStudents.put(mainKey, innerList);

		innerList.add(addMark(fourthMarkBw, BWSUBJECTS[3], errors));
		avgLists.bwStudents.put(mainKey, innerList);
		
		if(errors.isEmpty()){
			nameBw.clear();
			surnameBw.clear();
			firstMarkBw.clear();
			secondMarkBw.clear();
			thirdMarkBw.clear();
			fourthMarkBw.clear();
		}
		
		showDialogInfo(errors);
	
	}
}
