package srednia;

import java.text.DecimalFormat;
import java.util.Map;

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

	private AvgMarks avgMarks = new AvgMarks();
	// private AvgLists avgLists = new AvgLists();
	private AddData addData = new AddData();
	AvgLists avgLists = AvgLists.getInstance();

	// Wyswietlanie wszystkich studentow, tj. imion i nazwisk czyli kluczy
	// g³ównej HashMapy
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

	public void displayStudentsForRemove(Map<String, Map<String, Double>> subjectMap, String studySubject ) {
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

	public void addStudent(String studySubject) {

		if (studySubject.equals("BW")) {
			System.out.println("-----------------------------------------------------");
			System.out.println("Zosta³ wybrany kierunek Bezpieczenstwo Wewnetrzne");

			avgMarks.setName(addData.addNameOrSurname("Wprowadz imiê: "));
			avgMarks.setSurname(addData.addNameOrSurname("Wprowadz nazwisko: "));
			avgMarks.setFirstMark(addData.setValue(BWSUBJECTSFIELDS[0]));
			avgMarks.setSecondMark(addData.setValue(BWSUBJECTSFIELDS[1]));
			avgMarks.setThirdMark(addData.setValue(BWSUBJECTSFIELDS[2]));

			String studentKey = avgMarks.getName() + " " + avgMarks.getSurname();

			avgLists.innerBwStudents.put(BWSUBJECTSKEYS[0], avgMarks.getFirstMark());
			avgLists.bwStudents.put(studentKey, avgLists.innerBwStudents);

			avgLists.innerBwStudents.put(BWSUBJECTSKEYS[1], avgMarks.getSecondMark());
			avgLists.bwStudents.put(studentKey, avgLists.innerBwStudents);

			avgLists.innerBwStudents.put(BWSUBJECTSKEYS[2], avgMarks.getThirdMark());
			avgLists.bwStudents.put(studentKey, avgLists.innerBwStudents);

			System.out.println(avgLists.bwStudents.size());

			System.out.println("---------------------------------------------------------------");
			System.out.println("Student kierunku Bezpieczenstwo Wewnetrzne " + studentKey + " zosta³ dodany.");

		} else {

			System.out.println("-----------------------------------------------------");
			System.out.println("Zosta³ wybrany kierunek Systemy Informacyjne w Bezpieczeñstwie");

			avgMarks.setName(addData.addNameOrSurname("Wprowadz imiê: "));
			avgMarks.setSurname(addData.addNameOrSurname("Wprowadz nazwisko: "));
			avgMarks.setFirstMark(addData.setValue(MSISUBJECTSFIELDS[0]));
			avgMarks.setSecondMark(addData.setValue(MSISUBJECTSFIELDS[1]));
			avgMarks.setThirdMark(addData.setValue(MSISUBJECTSFIELDS[2]));
			avgMarks.setFourMark(addData.setValue(MSISUBJECTSFIELDS[3]));

			String studentKey = avgMarks.getName() + " " + avgMarks.getSurname();

			avgLists.innerMsiStudents.put(MSISUBJECTSKEYS[0], avgMarks.getFirstMark());
			avgLists.msiStudents.put(studentKey, avgLists.innerMsiStudents);

			avgLists.innerMsiStudents.put(MSISUBJECTSKEYS[1], avgMarks.getSecondMark());
			avgLists.msiStudents.put(studentKey, avgLists.innerMsiStudents);

			avgLists.innerMsiStudents.put(MSISUBJECTSKEYS[2], avgMarks.getThirdMark());
			avgLists.msiStudents.put(studentKey, avgLists.innerMsiStudents);

			avgLists.innerMsiStudents.put(MSISUBJECTSKEYS[3], avgMarks.getFourMark());
			avgLists.msiStudents.put(studentKey, avgLists.innerMsiStudents);

			System.out.println(studentKey);

			System.out.println("---------------------------------------------------------------");
			System.out.println("Student kierunku Systemy Informacyjne " + studentKey + " zosta³ dodany.");
		}
	}

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
		// Przyjecie formatu wyswietlania sredniej
		DecimalFormat df = new DecimalFormat("#.00");
		int counter = 0;
		double avg = 0;
		if (studySubject.equals("BW")) {
			String studentName = addData.addFullName("Wprowadz imiê i nazwisko studenta, którego chcesz wyœwietliæ.");
			for (String innerMapKey : avgLists.innerBwStudents.keySet()) {
				System.out.println("AVG");
				avg += avgLists.bwStudents.get(studentName).get(innerMapKey);
				counter++;
			}
		} else {
			String studentName = addData.addFullName("Wprowadz imiê i nazwisko studenta, którego chcesz wyœwietliæ.");
			for (String innerMapKey : avgLists.innerMsiStudents.keySet()) {
				avg += avgLists.msiStudents.get(studentName).get(innerMapKey);
				counter++;
			}
			String decimalDouble = df.format(avg / counter);
			System.out.println("Srednia studenta " + studentName + " wynosi: " + decimalDouble);
			System.out.println("-----------------------------------------");
		}
	}
}
