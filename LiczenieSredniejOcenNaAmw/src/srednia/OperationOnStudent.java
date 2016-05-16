package srednia;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
//Modul wykonujacy operacje na studentach (dodawanie, usuwanie, wyswietlanie, liczenie sredniej)
public class OperationOnStudent {

	// Deklaracja komunikat�w kt�re b�d� wy�wietlane u�ytkownikowi podczas
	// podawania ocen
	private final String[] MSISUBJECTSFIELDS = { "Podaj ocene z Kontroli i Audytu w Bezpiecze�stwie: ",
			"Podaj ocene z Ochrny Prawnej Funkcjonariuszy Publicznych: ",
			"Podaj ocene z Oceny Ryzyka i Prognozowania w Bezpiecze�stwie: ",
			"Podaj ocene z System�w Informatycznych w Administracji Publicznej: " };

	private final String[] BWSUBJECTSFIELDS = { "Podaj ocene z Podstaw Prawnych Zarz�dzania Kryzysowego: ",
			"Podaj ocene z Oceny Ryzyka i Prognozowania w Bezpiecze�stwie: ",
			"Podaj ocene z Systemu Zarz�dzania Kryzysowego w Administracji Publicznej: " };

	// Deklaracja Kluczy do HashMapy, gdzie warto�ciami b�d� oceny kt�re
	// wprowadzi u�ytkownik
	private final String[] MSISUBJECTSKEYS = { "Kontrola i Audyt w Bezpiecze�stwie: ",
			"Ochrona Prawna Funkcjonariuszy Publicznych: ", "Ocena Ryzyka i Prognozowanie w Bezpiecze�stwie: ",
			"Systemy Informatyczne w Administracji Publicznej: " };

	private final String[] BWSUBJECTSKEYS = { "Podstawy Prawne Zarz�dzania Kryzysowego: ",
			"Ocena Ryzyska i Prognozowanie w Bezpiecze�stwie",
			"System Zarz�dzania Kryzysowego w Administracji Publicznej: " };

	// Mapa do ktorej beda przypisywane przedmioty i oceny
	private Map<String, Double> innerMap;

	// Deklaracja instancji klas
	private AvgMarks avgMarks = new AvgMarks();
	private AddData addData = new AddData();
	private AvgLists avgLists = AvgLists.getInstance();

	// Wyswietlanie wszystkich studentow (kluczy HashMapy)
	public void displayStudentsforAvg(Map<String, Map<String, Double>> subjectMap, String studySubject) {
		if (subjectMap.isEmpty()) {
			System.out.println("Nie dodano jeszcze �adnego studenta");
			System.out.println("-----------------------------------------");
		} else {
			System.out.println("Dodani studenci: ");
			for (String key : subjectMap.keySet()) {
				System.out.println("Student: " + key);
				System.out.println("-----------------------------------------");
			}
			displayStudentAvg(studySubject);
		}
	}

	// Metoda wyswietlajaca studentow z mozliwoscia ich usuniecia
	public void displayStudentsForRemove(Map<String, Map<String, Double>> subjectMap, String studySubject) {
		if (subjectMap.isEmpty()) {
			System.out.println("Nie dodano jeszcze �adnego studenta");
			System.out.println("-----------------------------------------");
		} else {
			System.out.println("Dodani studenci: ");
			for (String key : subjectMap.keySet()) {
				System.out.println("Student: " + key);
				System.out.println("-----------------------------------------");
				removeStudent(studySubject);
			}
		}
	}

	// Metoda dodania nowego studenta
	public void addStudent(String studySubject) {

		// Tworzenie nowej "wewnetrznej" HashMapy do przechowywania przedmiotow
		// i ocen
		innerMap = new HashMap<String, Double>();
		if (studySubject.equals("BW")) {
			System.out.println("-----------------------------------------------------");
			System.out.println("Zosta� wybrany kierunek Bezpieczenstwo Wewnetrzne");

			// Przypisanie wartosci (imienia, nazwiska, ocen)
			avgMarks.setName(addData.addNameOrSurname("Wprowadz imi�: "));
			avgMarks.setSurname(addData.addNameOrSurname("Wprowadz nazwisko: "));
			avgMarks.setFirstMark(addData.setValue(BWSUBJECTSFIELDS[0]));
			avgMarks.setSecondMark(addData.setValue(BWSUBJECTSFIELDS[1]));
			avgMarks.setThirdMark(addData.setValue(BWSUBJECTSFIELDS[2]));

			// Tworzenie klucza do glownej HashMapy (imie i nazwisko studenta)
			String studentKey = avgMarks.getName() + " " + avgMarks.getSurname();

			// Dodanie przedmiotow i ocen do konkretnego studenta
			innerMap.put(BWSUBJECTSKEYS[0], avgMarks.getFirstMark());
			avgLists.bwStudents.put(studentKey, innerMap);

			innerMap.put(BWSUBJECTSKEYS[1], avgMarks.getSecondMark());
			avgLists.bwStudents.put(studentKey, innerMap);

			innerMap.put(BWSUBJECTSKEYS[2], avgMarks.getThirdMark());
			avgLists.bwStudents.put(studentKey, innerMap);

			System.out.println("---------------------------------------------------------------");
			System.out.println("Student kierunku Bezpieczenstwo Wewnetrzne " + studentKey + " zosta� dodany.");

		} else {
			// Analogicznie jak w przypadku powyzszego kodu, z roznica, ze
			// studenci beda innego kierunku
			System.out.println("-----------------------------------------------------");
			System.out.println("Zosta� wybrany kierunek Systemy Informacyjne w Bezpiecze�stwie");

			avgMarks.setName(addData.addNameOrSurname("Wprowadz imi�: "));
			avgMarks.setSurname(addData.addNameOrSurname("Wprowadz nazwisko: "));
			avgMarks.setFirstMark(addData.setValue(MSISUBJECTSFIELDS[0]));
			avgMarks.setSecondMark(addData.setValue(MSISUBJECTSFIELDS[1]));
			avgMarks.setThirdMark(addData.setValue(MSISUBJECTSFIELDS[2]));
			avgMarks.setFourMark(addData.setValue(MSISUBJECTSFIELDS[3]));

			String studentKey = avgMarks.getName() + " " + avgMarks.getSurname();

			innerMap.put(MSISUBJECTSKEYS[0], avgMarks.getFirstMark());
			avgLists.msiStudents.put(studentKey, innerMap);

			innerMap.put(MSISUBJECTSKEYS[1], avgMarks.getSecondMark());
			avgLists.msiStudents.put(studentKey, innerMap);

			innerMap.put(MSISUBJECTSKEYS[2], avgMarks.getThirdMark());
			avgLists.msiStudents.put(studentKey, innerMap);

			innerMap.put(MSISUBJECTSKEYS[3], avgMarks.getFourMark());
			avgLists.msiStudents.put(studentKey, innerMap);

			System.out.println("---------------------------------------------------------------");
			System.out.println("Student kierunku Systemy Informacyjne " + studentKey + " zosta� dodany.");
		}
	}

	// Metoda do usuwania studenta
	private void removeStudent(String studySubject) {
		if (studySubject.equals("BW")) {
			while (true) {
				String studentToRemove = addData
						.addFullName("Wprowadz imi� i nazwisko studenta kt�rego chesz usun��: ");

				if (avgLists.bwStudents.containsKey(studentToRemove)) {
					avgLists.bwStudents.remove(studentToRemove);
					System.out.println("Student " + studentToRemove + " zosta� usuni�ty pomy�lnie.");
					break;

				} else {
					System.out.println("Student " + studentToRemove + " nie zosta� dodany, wybierz jeszcze raz");
					break;
				}
			}
		} else {
			while (true) {
				String studentToRemove = addData
						.addFullName("Wprowadz imi� i nazwisko studenta kt�rego chesz usun��: ");
				if (avgLists.msiStudents.containsKey(studentToRemove)) {
					avgLists.msiStudents.remove(studentToRemove);
					System.out.println("Student " + studentToRemove + " zosta� usuni�ty.");
					break;
				} else {
					System.out.println("Student " + studentToRemove + " nie zosta� dodany, wybierz jeszcze raz");
					break;
				}
			}
		}
	}

	// Wy�wietlanie �redniej konkretnego studenta na podstawie podanego klucza
	// (imienia i nazwiska)
	private void displayStudentAvg(String studySubject) {
		DecimalFormat df = new DecimalFormat("#.00");
		int counter = 0;
		double avg = 0;
		if (studySubject.equals("BW")) {
			String studentName = addData.addFullName("Wprowadz imi� i nazwisko studenta, kt�rego chcesz wy�wietli�.");
			for (String innerMapKey : innerMap.keySet()) {
				avg += avgLists.bwStudents.get(studentName).get(innerMapKey);
				counter++;
			}
		} else {
			String studentName = addData.addFullName("Wprowadz imi� i nazwisko studenta, kt�rego chcesz wy�wietli�.");

			for (String innerMapKey : innerMap.keySet()) {
				avg += avgLists.msiStudents.get(studentName).get(innerMapKey);
				counter++;
			}
			String decimalDouble = df.format(avg / counter);
			System.out.println("Srednia studenta " + studentName + " wynosi: " + decimalDouble);
			System.out.println("-----------------------------------------");
		}
	}
}
