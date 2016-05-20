package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class SampleController implements Initializable{
	
    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu menu;
	
	@FXML
	private MenuItem addItem;

	@FXML
	private MenuItem minusItem;

	@FXML
	private TextField firstField;

	@FXML
	private TextField secondField;

	@FXML
	private TextField thirdResult;

	@FXML
	void add(ActionEvent event) {
		try{
		addNumbers(getNumber(firstField), getNumber(secondField));
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("B³¹d kalkulatora");
			alert.setHeaderText("B³êdne liczby");
			alert.setContentText("SprawdŸ podan¹ liczbê");
			alert.showAndWait();


		}
	}

	@FXML
    void minus(ActionEvent event) {
		try{
    	minusNumbers(getNumber(firstField),getNumber(secondField));
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("B³¹d kalkulatora");
			alert.setHeaderText("B³êdne liczby");
			alert.setContentText("SprawdŸ podan¹ liczbê");
			alert.showAndWait();
		}
    }

	private int getNumber(TextField number) {
			try {
				return Integer.parseInt(number.getText());
			} catch (Exception e) {
				System.out.println("coœ");
				return 0;
		}
	}

	private void addNumbers(int first, int second) {
		thirdResult.setText(Integer.toString(first + second));

	}

	private void minusNumbers(int first, int second) {
		thirdResult.setText(Integer.toString(first - second));
	}
	
	private void addNewOption(Operations o){
		
		
		MenuItem menuNew = new MenuItem(o.getName());
		menu.getItems().add(menuNew);

		
		
		menuNew.setOnAction(e->{
			int result = o.licz(getNumber(firstField),getNumber(secondField));
			thirdResult.setText(Integer.toString(result));
			
			
		});		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		addNewOption(new Operations() {
			
			@Override
			public int licz(int a, int b) {
				return a/b;
			}
			
			@Override
			public String getName() {
				return "Dzielenie";
			}
		});
	
	}
}
