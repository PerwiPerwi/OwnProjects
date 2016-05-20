package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class SampleController implements Initializable{

    @FXML
    private TextField firstField;

    @FXML
    private TextField secondField;

    @FXML
    private TextField thirdField;

    @FXML
    private TextField fourthField;

    @FXML
    private TextField textArea;

    @FXML
    private DatePicker date;



    @FXML
    void showSmth(KeyEvent event) {
    	String patternNameAndSurname = "^([az-AZ])$";
    	Pattern nameAndSurnameCompiled = Pattern.compile(patternNameAndSurname);
    	String numbers = "^([0-9])$";
    	Pattern numbersCompiled = Pattern.compile(numbers);
    	String email = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    	Pattern emailCompiled = Pattern.compile(email);
		try {
			Matcher nameMatcher = nameAndSurnameCompiled.matcher(firstField.getText());
			Matcher numberMatcher = numbersCompiled.matcher(fourthField.getText());
			Matcher emailMatcher = emailCompiled.matcher(thirdField.getText());
			if()
			
			int firstValue = Integer.parseInt(firstField.getText());
			int secondValue = Integer.parseInt(secondField.getText());

			thirdField.setText((Integer.toString(firstValue + secondValue)));
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("B³¹d aplikacji");
			alert.setHeaderText("Popraw");
			alert.setContentText("WprowadŸ liczbê!");
			alert.showAndWait();
		}
    }







	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
