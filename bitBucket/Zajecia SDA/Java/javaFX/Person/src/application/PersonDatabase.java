package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class PersonDatabase {
	private ObservableList<Person> persons = FXCollections.observableArrayList();
	private ObservableMap<String, HashMap<String, Double>> persons2 = FXCollections.observableHashMap();

	public void add(Person person) {
		persons.add(person);
	}

	public void remove(Person person) {
		persons.remove(person);
	}

	public void save() {
		try (PrintStream dataBaseFile = new PrintStream("person.txt")) {
			dataBaseFile.println(Integer.toString(persons.size()));

			for (Person person : persons) {
				person.print(dataBaseFile);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void load(){
		persons.clear();
		try(Scanner sc = new Scanner(new File("person.txt"))){
			int size = sc.nextInt();
			for(int i = 0; i < size; i++){
				Person fromFile = new Person();
				fromFile.readFromFile(sc);
				persons.add(fromFile);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ObservableList<Person> getPerson() {
		return persons;
	}
	public static void main(String [] args){
		PersonDatabase dataBase = new PersonDatabase();
		Person jan = new Person();
		jan.setName("Jan");
		jan.setSurnname("Kowalski");
		jan.setAge(4);
		jan.setPesel(333);
		Person john = new Person();
		john.setName("John");
		john.setSurnname("Nazwisko");
		john.setAge(34);
		john.setPesel(333);
		dataBase.getPerson().addAll(jan, john);
		dataBase.save();
		
		PersonDatabase personDataBase2 = new PersonDatabase();
		personDataBase2.load();
		for (Person person : personDataBase2.getPerson()) {
			System.out.println(person);		
		}
	}

}
