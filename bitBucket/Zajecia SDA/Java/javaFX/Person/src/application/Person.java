package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.Scanner;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person implements Cloneable{

	private StringProperty name = new SimpleStringProperty();
	private StringProperty surnname = new SimpleStringProperty();
	private IntegerProperty age = new SimpleIntegerProperty();
	private IntegerProperty pesel = new SimpleIntegerProperty();
	
	
	public final StringProperty nameProperty() {
		return this.name;
	}
	
	public final String getName() {
		return this.nameProperty().get();
	}
	
	public final void setName(final String name) {
		this.nameProperty().set(name);
	}
	
	public final StringProperty surnnameProperty() {
		
		return this.surnname;
	}
	
	public final String getSurnname() {
		return this.surnnameProperty().get();
	}
	
	public final void setSurnname(final String surnname) {
		this.surnnameProperty().set(surnname);
	}
	
	public final IntegerProperty ageProperty() {
		return this.age;
	}
	
	public final int getAge() {
		return this.ageProperty().get();
	}
	
	public final void setAge(final int age) {
		this.ageProperty().set(age);
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name.get() + ", surnname=" + surnname.get() + ", age=" + age.get() + ", pesel=" + pesel.get() + "]";
	}
	public void writeToFile(){
		 try{
			  // Create file 
			  FileWriter fstream = new FileWriter("out.txt");
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write(toString());
			  //Close the output stream
			  out.close();
			  }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
	}
	public void print(PrintStream out){
		out.println(name.get());
		out.println(surnname.get());
		out.println(age.get());
		out.println(pesel.get());
	}

	
	public void readFromFile(Scanner sc) throws FileNotFoundException{
		name.set(sc.next());
		surnname.set(sc.next());
		age.set(sc.nextInt());
		pesel.set(sc.nextInt()); 
	}

	public final IntegerProperty peselProperty() {
		return this.pesel;
	}
	

	public final int getPesel() {
		return this.peselProperty().get();
	}
	

	public final void setPesel(final int pesel) {
		this.peselProperty().set(pesel);
	}
	
	protected Person clone() {
		Person person = new Person();
		person.age.set(age.get());
		person.name.set(name.get());
		person.surnname.set(surnname.get());
		person.pesel.set(pesel.get());
		return person;
		
		
	}
	
	
	
	
}
