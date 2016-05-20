package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.House.HeatingLevel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

public class SampleController implements Initializable {
	
	private House house = new HouseForTest();
	
    @FXML
    private ChoiceBox<HeatingLevel> heatingLevelChoiceBox;
  
    @FXML
    private CheckBox windowsClosedCheckBox;

    @FXML
    void showOptions(ActionEvent event) {
    	house.showOptions();
    }

    @FXML
    void showUpdates(ActionEvent event) {
    	house.showUpdates();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		heatingLevelChoiceBox.getItems().addAll(HeatingLevel.values());
		windowsClosedCheckBox.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				house.setWindowsClosed(windowsClosedCheckBox.isSelected());
				
			}
		});
		heatingLevelChoiceBox.getSelectionModel().selectedItemProperty()
		.addListener(new ChangeListener<HeatingLevel>() {

			@Override
			public void changed(ObservableValue<? extends HeatingLevel> observable, HeatingLevel oldValue,
					HeatingLevel newValue) {
				house.setHeatingLevel(newValue);
				
			}
	
		});
	}

}
