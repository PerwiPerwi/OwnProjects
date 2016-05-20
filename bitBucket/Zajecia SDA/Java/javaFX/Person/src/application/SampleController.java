package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.NumberStringConverter;

public class SampleController implements Initializable {
    @FXML
    private TableView<Person> personsTableView;

    @FXML
    private TableColumn<Person, String> nameC;

    @FXML
    private TableColumn<Person, String> surnameC;

    @FXML
    private TableColumn<Person, Integer> ageC;

    @FXML
    private TableColumn<Person, Integer> peselC;
	
	Person person = new Person();
	PersonDatabase personDb = new PersonDatabase();
	
    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField age;
    
    @FXML
    private TextField pesel;
    
    @FXML
    void add(ActionEvent event) {
    	person.setName("-");
    	person.setSurnname("-");
    	person.setAge(0);
    	person.setPesel(0);
    }
    
    @FXML
    void print(ActionEvent event) {
    	System.out.println(person.toString());

    }
    @FXML
    void addToFile(ActionEvent event) {
    	personDb.save();
    }
    
    @FXML
    void read(ActionEvent event) {
    	personDb.load();
    }
    
    @FXML
    void addToColumn(ActionEvent event) {
    	
    }
    @FXML
    void addPerson(ActionEvent event) {
    	personDb.add(person.clone());
    }
   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		name.textProperty().bindBidirectional(person.nameProperty());
		surname.textProperty().bindBidirectional(person.surnnameProperty());
		age.textProperty().bindBidirectional(person.ageProperty(), new NumberStringConverter());
		pesel.textProperty().bindBidirectional(person.peselProperty(), new NumberStringConverter());
		
		nameC.setCellValueFactory(new PropertyValueFactory<>("name"));
		surnameC.setCellValueFactory(new PropertyValueFactory<>("surnname"));
		ageC.setCellValueFactory(new PropertyValueFactory<>("age"));
		peselC.setCellValueFactory(new PropertyValueFactory<>("pesel"));
		personsTableView.setItems(personDb.getPerson());
		
		
	}
	
}
