package srednia;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddData {
	Scanner sc = new Scanner(System.in);
	/*
	 * Pattern do sprawdzania poprawnoœci wprowadzonej oceny zakres od 2 do 5 z
	 * mo¿liwoœci¹ wprowadzania ocen po³owicznych np 3.5, 4.5
	 */

	private final String PATTERNFORMARKS = "^([25])$|^([34])?([/.])?(0|5)?$";
	private Pattern patternForNumbersCompiled = Pattern.compile(PATTERNFORMARKS);

	// Pattern do wprowadzania imion lub nazwisk
	private final String PATTERNFORNAME = "^([a-zA-Z]{3,25})$";
	private Pattern patternForNamesCompiled = Pattern.compile(PATTERNFORNAME);
	
	//Pattern do wprowadzania imienia i nazwiska
	private final String PATTERNFULLNAME = "^([a-zA-Z].*)$";
	private Pattern patternForFullName = Pattern.compile(PATTERNFULLNAME);

// Metoda wprowadzenia imienia lub naziwska sprawdzaj¹ca wyra¿enie regularne
	public String addNameOrSurname(String textForName) {
		while (true) {
			System.out.print(textForName);
			try {
				String nameOrSurname = sc.nextLine().trim();
				if (checkRegex(nameOrSurname, patternForNamesCompiled)) {
					return nameOrSurname;
				}
			} catch (InputMismatchException e) {
				System.out.println("Wprowadzone nazwisko jest w b³êdnym formacie");
				sc.nextLine();
			}
		}
	}
//Metoda wprowadzenia imienia i nazwiska	
	public String addFullName(String textForName) {
		while (true) {
			System.out.println(textForName);
			try {
				String fullName = sc.nextLine().trim();
				if (checkRegex(fullName, patternForFullName)) {
					return fullName;
				}
			} catch (InputMismatchException e) {
				System.out.println("Wprowadzone nazwisko jest w b³êdnym formacie");
				sc.nextLine();
			}
		}
	}
//Metoda sprawdzajaca wyrazenie regularne
	public boolean checkRegex(String value, Pattern pattern) {
		Matcher matcher = pattern.matcher(value);
		boolean verified = matcher.find() ? true : false;
		return verified;
	}
//Metoda do wprowadzania ocen
	public double setValue(String textForMarks) {
		double result = 0;
		while (true) {
			System.out.print(textForMarks);		
			try {
				String temp = sc.nextLine().trim();
				if (checkRegex(temp, patternForNumbersCompiled)) {
					result = Double.parseDouble(temp);
					return result;
				}
			} catch (NullPointerException e) {
				System.out.println("B³êdne dane, wprowadz dane ponownie w formacie od 2 do 5");
				sc.nextLine();
			} catch (NumberFormatException e) {
				System.out.println("B³êdne dane, wprowadz dane ponownie w formacie od 2 do 5");
				sc.nextLine();
			}
			
		}
	}

}
