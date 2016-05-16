package srednia;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
//Modul wykonujacy operacje na studentach (dodawanie, usuwanie, wyswietlanie, liczenie sredniej)
public class OperationOnStudent {

	// Deklaracja komunikatów które bêd¹ wyœwietlane u¿ytkownikowi podczas
	// podawania ocen
	private final String[] MSISUBJECTSFIELDS = { "Podaj ocene z Kontroli i Audytu w Bezpieczeñstwie: ",
			"Podaj ocene z Ochrny Prawnej Funkcjonariuszy Publicznych: ",
			"Podaj ocene z Oceny Ryzyka i Prognozowania w Bezpieczeñstwie: ",
			"Podaj ocene z Systemów Informatycznych w Administracji Publicznej: " };

	private final String[] BWSUBJECTSFIELDS = { "Podaj ocene z Podstaw Prawnych Zarz¹dzania Kryzysowego: ",
			"Podaj ocene z Oceny Ryzyka i Prognozowania w Bezpieczeñstwie: ",
			"Podaj ocene z Systemu Zarz¹dzania Kryzysowego w Administracji Publicznej: " };

	// Deklaracja Kluczy do HashMapy, gdzie wartoœciami bêd¹ oceny które
	// wprowadzi u¿ytkownik
	private final String[] MSISUBJECTSKEYS = { "Kontrola i Audyt w Bezpieczeñstwie: ",
			"Ochrona Prawna Funkcjonariuszy Publicznych: ", "Ocena Ryzyka i Prognozowanie w Bezpieczeñstwie: ",
			"Systemy Informatyczne w Administracji Publicznej: " };

	private final String[] BWSUBJECTSKEYS = { "Podstawy Prawne Zarz¹dzania Kryzysowego: ",
			"Ocena Ryzyska i Prognozowanie w Bezpieczeñstwie",
			"System Zarz¹dzania Kryzysowego w Administracji Publicznej: " };

	// Mapa do ktorej beda przypisywane przedmioty i oceny
	private Map<String, Double> innerMap;

	// Deklaracja instancji klas
	private AvgMarks avgMarks = new AvgMarks();
	private AddData addData = new AddData();
	private AvgLists avgLists = AvgLists.getInstance();

	// Wyswietlanie wszystkich studentow (kluczy HashMapy)
	public void displayStudentsforAvg(Map<String, Map<String, Double>> subjectMap, String studySubject) {
		if (subjectMap.isEmpty()) {
			System.out.println("Nie dodano jeszcze ¿adnego studenta");
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
			System.out.println("Nie dodano jeszcze ¿adnego studenta");
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
			System.out.println("Zosta³ wybrany kierunek Bezpieczenstwo Wewnetrzne");

			// Przypisanie wartosci (imienia, nazwiska, ocen)
			avgMarks.setName(addData.addNameOrSurname("Wprowadz imiê: "));
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
			System.out.println("Student kierunku Bezpieczenstwo Wewnetrzne " + studentKey + " zosta³ dodany.");

		} else {
			// Analogicznie jak w przypadku powyzszego kodu, z roznica, ze
			// studenci beda innego kierunku
			System.out.println("-----------------------------------------------------");
			System.out.println("Zosta³ wybrany kierunek Systemy Informacyjne w Bezpieczeñstwie");

			avgMarks.setName(addData.addNameOrSurname("Wprowadz imiê: "));
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
			System.out.println("Student kierunku Systemy Informacyjne " + studentKey + " zosta³ dodany.");
		}
	}

	// Metoda do usuwania studenta
	private void removeStudent(String studySubject) {
		if (studySubject.equals("BW")) {
			while (true) {
				String studentToRemove = addData
						.addFullName("Wprowadz imiê i nazwisko studenta którego chesz usun¹æ: ");

				if (avgLists.bwStudents.containsKey(studentToRemove)) {
					avgLists.bwStudents.remove(studentToRemove);
					System.out.println("Student " + studentToRemove + " zosta³ usuniêty pomyœlnie.");
					break;

				} else {
					System.out.println("Student " + studentToRemove + " nie zosta³ dodany, wybierz jeszcze raz");
					break;
				}
			}
		} else {
			while (true) {
				String studentToRemove = addData
						.addFullName("Wprowadz imiê i nazwisko studenta którego chesz usun¹æ: ");
				if (avgLists.msiStudents.containsKey(studentToRemove)) {
					avgLists.msiStudents.remove(studentToRemove);
					System.out.println("Student " + studentToRemove + " zosta³ usuniêty.");
					break;
				} else {
					System.out.println("Student " + studentToRemove + " nie zosta³ dodany, wybierz jeszcze raz");
					break;
				}
			}
		}
	}

	// Wyœwietlanie œredniej konkretnego studenta na podstawie podanego klucza
	// (imienia i nazwiska)
	private void displayStudentAvg(String studySubject) {
		DecimalFormat df = new DecimalFormat("#.00");
		int counter = 0;
		double avg = 0;
		if (studySubject.equals("BW")) {
			String studentName = addData.addFullName("Wprowadz imiê i nazwisko studenta, którego chcesz wyœwietliæ.");
			for (String innerMapKey : innerMap.keySet()) {
				avg += avgLists.bwStudents.get(studentName).get(innerMapKey);
				counter++;
			}
		} else {
			String studentName = addData.addFullName("Wprowadz imiê i nazwisko studenta, którego chcesz wyœwietliæ.");

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
