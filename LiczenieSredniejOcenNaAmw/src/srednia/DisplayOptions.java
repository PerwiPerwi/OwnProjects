package srednia;

import java.util.InputMismatchException;
import java.util.Scanner;
// Modul do wyswietlania opcji i nawigowanie po nich
public class DisplayOptions {

	private Scanner sc = new Scanner(System.in);

//Deklaracja instancji klas	
	OperationOnStudent operationOnStudent = new OperationOnStudent();
	AvgLists avgLists = AvgLists.getInstance();

// G³ówna pêtla programu gdzie wybierane s¹ poszczególne funkcjonalnoœci
// programu	
	public void mainMenu() {
		int option = 0;
		while (option != 3) {
			try {
				// Wyœwietlenie dostêpnych opcji programu
				displayOptions();
				option = sc.nextInt();
				switch (option) {
				case 0:
					addStudent();
					break;
				case 1:
					removeStudent();
					break;
				// Wyœwietlenie wprowadzonych studentów
				case 2:
					displayStudents();
					break;
				case 3:
					System.out.println("Zosta³a wybrana opcja zamkniêcia programu");
					System.exit(0);
				}
			} catch (InputMismatchException e) {
				System.out.println("B³êdny wybór!");
				System.out.println("Proszê wybraæ jeszcze raz poœród dostêpnych opcji");
				System.out.println("------------------------------------------------------");
				sc.next();
			} catch (NumberFormatException e) {
				System.out.println("B³êdny wybór!");
				System.out.println("Proszê wybraæ jeszcze raz poœród dostêpnych opcji");
				System.out.println("------------------------------------------------------");
				sc.next();
			}
		}
	}
// Glowne opcje programu
	public void displayOptions() {
		System.out.println("Witam w programie do Liczenia œredniej na AMW w Gdyni!");
		System.out.println("Proszê wybraæ poœród dostêpnych poni¿ej opcji: ");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("0: Dodanie studenta i wyliczenie œredniej");
		System.out.println("1: Usuniêcie studenta i jego œredniej");
		System.out.println("2: Sprawdzenie wprowadzonych studentów i ich œrednich");
		System.out.println("3: Zakoñczenie programu");
		System.out.println("----------------------------------------------------------------------------");

	}

// Metoda dodania nowego studenta
	private void addStudent() {
		boolean endWhileLoop = true;
		int option;
		while (endWhileLoop) {
			System.out.println("---------------------------------------------");
			System.out.println("Studenta jakiego kierunku chcesz dodaæ ?");
			System.out.println("0: Systemy Informacyjne w Bezpieczeñœtwie");
			System.out.println("1: Bezpieczeñstwo Wewnêtrzne");
			System.out.println("2: Wyjœcie do Menu g³ównego");
			try {
				option = sc.nextInt();
				switch (option) {
				// Dodanie studenta na kierunku Systemy Informacyjne w
				// Bezpieczeñœtwie
				case 0:
					operationOnStudent.addStudent("MSI");
					break;
				// Dodanie studenta na kierunku Bezpieczeñstwo Wewnêtrznego
				case 1:
					operationOnStudent.addStudent("BW");
					break;
				// Wyjœcie z opcji dodawania studentów
				case 2:
					endWhileLoop = false;
					break;
				default:
					System.out.println("Zosta³ podany b³êdy wybór, podaj poprawn¹ opcje");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("B³êdny format wyboru opcji, wprowadz w³aœciw¹ liczbê");
				sc.next();
			} catch (NumberFormatException e) {
				System.out.println("B³êdny format wyboru opcji, wprowadz w³aœciw¹ liczbê");
				sc.next();
			}
		}
	}

	// Metoda usuwaj¹ca studenta z listy
	private void removeStudent() {
		boolean endOfWhileLoop = true;
		int option;
		while (endOfWhileLoop) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Zosta³a wybrana opcja usuniêcia studenta");
			System.out.println("Wybierz kierunek z którego chcesz usun¹æ studenta");
			System.out.println("0: Systemy Informacyjne w Bezpieczeñœtwie");
			System.out.println("1: Bezpieczeñœtwo Wewnêtrzne");
			System.out.println("2: Wyjœcie do Menu");
			try {
				option = sc.nextInt();
				switch (option) {
				// Usuniecie studenta z kierunku Systemy Informacyjne
				case 0:
					operationOnStudent.displayStudentsForRemove(avgLists.msiStudents, "MSI");
					break;
				// Usuniecie studenta z kierunku Bezpieczenstwo Wewnetrzne
				case 1:
					operationOnStudent.displayStudentsForRemove(avgLists.bwStudents, "BW");
					break;
				case 2:
					// Wybor wyjscia do menu, przerwanie dzialania petli
					endOfWhileLoop = false;
				default:
					System.out.println("Zosta³ podany b³êdy wybór, podaj poprawn¹ opcje");
				}
			} catch (InputMismatchException e) {
				System.out.println("B³êdny format wyboru, wybierz ponownie poprawn¹ opcje");
				sc.next();
			} catch (NumberFormatException e) {
				System.out.println("B³êdny format wyboru opcji, wprowadz w³aœciw¹ liczbê");
				sc.next();
			}
		}
	}

	// Metoda odpowaidajaca za wyswietlenie wprowadzonych studentow
	private void displayStudents() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Zosta³a wybrana opcja wyœwietlenia studentów");
		int option = 0;
		boolean endOfWhileLoop = true;
		while (endOfWhileLoop) {
			try {
				System.out.println("Wybierz kierunek studiów:");
				System.out.println("0: Systemy Informacyjne w Bezpieczeñstwie");
				System.out.println("1: Bezpieczeñstwo Wewnêtrzne");
				System.out.println("2: Wyjœcie do g³ównego Menu");
				option = sc.nextInt();
				switch (option) {
				case 0:
					operationOnStudent.displayStudentsforAvg(avgLists.msiStudents, "MSI");
					break;
				case 1:
					operationOnStudent.displayStudentsforAvg(avgLists.bwStudents, "BW");
					break;
				case 2:
					endOfWhileLoop = false;
					break;
				default:
					System.out.println("B³edny wybór, wybierz jeszcze raz");
				}
			} catch (InputMismatchException e) {
				System.out.println("B³êdny format, wybierz albo 0, albo 1");
				sc.next();
			} catch (NumberFormatException e) {
				System.out.println("B³êdny format wyboru opcji, wprowadz w³aœciw¹ liczbê");
				sc.next();
			}
		}
	}
}
