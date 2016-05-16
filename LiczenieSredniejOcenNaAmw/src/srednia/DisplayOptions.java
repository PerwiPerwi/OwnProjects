package srednia;

import java.util.InputMismatchException;
import java.util.Scanner;
// Modul do wyswietlania opcji i nawigowanie po nich
public class DisplayOptions {

	private Scanner sc = new Scanner(System.in);

//Deklaracja instancji klas	
	OperationOnStudent operationOnStudent = new OperationOnStudent();
	AvgLists avgLists = AvgLists.getInstance();

// G��wna p�tla programu gdzie wybierane s� poszczeg�lne funkcjonalno�ci
// programu	
	public void mainMenu() {
		int option = 0;
		while (option != 3) {
			try {
				// Wy�wietlenie dost�pnych opcji programu
				displayOptions();
				option = sc.nextInt();
				switch (option) {
				case 0:
					addStudent();
					break;
				case 1:
					removeStudent();
					break;
				// Wy�wietlenie wprowadzonych student�w
				case 2:
					displayStudents();
					break;
				case 3:
					System.out.println("Zosta�a wybrana opcja zamkni�cia programu");
					System.exit(0);
				}
			} catch (InputMismatchException e) {
				System.out.println("B��dny wyb�r!");
				System.out.println("Prosz� wybra� jeszcze raz po�r�d dost�pnych opcji");
				System.out.println("------------------------------------------------------");
				sc.next();
			} catch (NumberFormatException e) {
				System.out.println("B��dny wyb�r!");
				System.out.println("Prosz� wybra� jeszcze raz po�r�d dost�pnych opcji");
				System.out.println("------------------------------------------------------");
				sc.next();
			}
		}
	}
// Glowne opcje programu
	public void displayOptions() {
		System.out.println("Witam w programie do Liczenia �redniej na AMW w Gdyni!");
		System.out.println("Prosz� wybra� po�r�d dost�pnych poni�ej opcji: ");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("0: Dodanie studenta i wyliczenie �redniej");
		System.out.println("1: Usuni�cie studenta i jego �redniej");
		System.out.println("2: Sprawdzenie wprowadzonych student�w i ich �rednich");
		System.out.println("3: Zako�czenie programu");
		System.out.println("----------------------------------------------------------------------------");

	}

// Metoda dodania nowego studenta
	private void addStudent() {
		boolean endWhileLoop = true;
		int option;
		while (endWhileLoop) {
			System.out.println("---------------------------------------------");
			System.out.println("Studenta jakiego kierunku chcesz doda� ?");
			System.out.println("0: Systemy Informacyjne w Bezpiecze�twie");
			System.out.println("1: Bezpiecze�stwo Wewn�trzne");
			System.out.println("2: Wyj�cie do Menu g��wnego");
			try {
				option = sc.nextInt();
				switch (option) {
				// Dodanie studenta na kierunku Systemy Informacyjne w
				// Bezpiecze�twie
				case 0:
					operationOnStudent.addStudent("MSI");
					break;
				// Dodanie studenta na kierunku Bezpiecze�stwo Wewn�trznego
				case 1:
					operationOnStudent.addStudent("BW");
					break;
				// Wyj�cie z opcji dodawania student�w
				case 2:
					endWhileLoop = false;
					break;
				default:
					System.out.println("Zosta� podany b��dy wyb�r, podaj poprawn� opcje");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("B��dny format wyboru opcji, wprowadz w�a�ciw� liczb�");
				sc.next();
			} catch (NumberFormatException e) {
				System.out.println("B��dny format wyboru opcji, wprowadz w�a�ciw� liczb�");
				sc.next();
			}
		}
	}

	// Metoda usuwaj�ca studenta z listy
	private void removeStudent() {
		boolean endOfWhileLoop = true;
		int option;
		while (endOfWhileLoop) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Zosta�a wybrana opcja usuni�cia studenta");
			System.out.println("Wybierz kierunek z kt�rego chcesz usun�� studenta");
			System.out.println("0: Systemy Informacyjne w Bezpiecze�twie");
			System.out.println("1: Bezpiecze�two Wewn�trzne");
			System.out.println("2: Wyj�cie do Menu");
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
					System.out.println("Zosta� podany b��dy wyb�r, podaj poprawn� opcje");
				}
			} catch (InputMismatchException e) {
				System.out.println("B��dny format wyboru, wybierz ponownie poprawn� opcje");
				sc.next();
			} catch (NumberFormatException e) {
				System.out.println("B��dny format wyboru opcji, wprowadz w�a�ciw� liczb�");
				sc.next();
			}
		}
	}

	// Metoda odpowaidajaca za wyswietlenie wprowadzonych studentow
	private void displayStudents() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Zosta�a wybrana opcja wy�wietlenia student�w");
		int option = 0;
		boolean endOfWhileLoop = true;
		while (endOfWhileLoop) {
			try {
				System.out.println("Wybierz kierunek studi�w:");
				System.out.println("0: Systemy Informacyjne w Bezpiecze�stwie");
				System.out.println("1: Bezpiecze�stwo Wewn�trzne");
				System.out.println("2: Wyj�cie do g��wnego Menu");
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
					System.out.println("B�edny wyb�r, wybierz jeszcze raz");
				}
			} catch (InputMismatchException e) {
				System.out.println("B��dny format, wybierz albo 0, albo 1");
				sc.next();
			} catch (NumberFormatException e) {
				System.out.println("B��dny format wyboru opcji, wprowadz w�a�ciw� liczb�");
				sc.next();
			}
		}
	}
}
