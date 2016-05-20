package removeStudents;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class RemoveBwStudent extends RemoveStudent implements Initializable{
	Button button;
	
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button exitButton;

    @FXML
    private GridPane students;

    @FXML
    private Button back;

    @FXML
    private Label empty;

    @FXML
    void exitProgram(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void backToMenu(ActionEvent event) throws IOException {
    	sc.changeScene(back, "../removeStudents/RemoveStudent.fxml");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		displayStudentForRemove(empty, button, students, avgLists.bwStudents, "../removeStudents/RemoveBwStudent.fxml");	
	}
	
}
