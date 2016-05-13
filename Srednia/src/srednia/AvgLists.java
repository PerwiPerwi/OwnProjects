package srednia;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class AvgLists {

	/*
	 * Deklaracja g��wnych HashMap gdzie kluczami g��wnymi s� imie i nazwisko
	 * Studenta oraz wewnetrznych hashmap z ocenami student�w jako warto�ciami
	 * ktorej klucz, jest wartosci� g��wnej mapy gdzie wygl�da to np. tak: <
	 * "Jan Kowalski",<"Przedmiot x:, 4.5>>
	 */

	static AvgLists instance = new AvgLists();

	public static AvgLists getInstance() {
		return instance;
	}

	public Map<String, Map<String, Double>> bwStudents = new HashMap<>();
	public Map<String, Double> innerBwStudents = new HashMap<String, Double>();

	public Map<String, Map<String, Double>> msiStudents = new HashMap<>();
	public Map<String, Double> innerMsiStudents = new HashMap<String, Double>();

	// Metoda wy�wietlaj�ca ocen� konkretnego studenta, z konkretnego przedmiotu
	public void displayValues(String firstKey, String secondKey) {

		String value = msiStudents.get(firstKey).get(secondKey).toString();
		System.out.println("Ocena z " + secondKey + " wynosi: " + value);
	}

	// Wy�wietlanie �redniej konkretnego studenta na podstawie podanego klucza
	// (imienia i nazwiska)
	public void displayStudentAvg(String key, Map<String, HashMap<String, Double>> mainMap,
			Map<String, Double> innerMap) {

		// Przyjecie formatu wyswietlania sredniej

		DecimalFormat df = new DecimalFormat("#.00");
		int counter = 0;
		double avg = 0;
		// Petla do dodawania poszczegolnych ocen oraz zwiekszania countera po
		// kazdym przedmiocie
		for (String secondKey : innerMap.keySet()) {
			avg += mainMap.get(key).get(secondKey);
			counter++;
		}
		String decimalDouble = df.format(avg / counter);
		System.out.println("Srednia studenta " + key + " wynosi: " + decimalDouble);
		System.out.println("-----------------------------------------");
	}

	// Metoda do usuwania student�w na podstawie podanego klucza g��wnego
	public void removeStudent(String key, Map<String, HashMap<String, Double>> mainMap) {
		mainMap.remove(key);
		System.out.println("Student " + key + " zosta� usuni�ty");
	}

	public void displayAllStudentsAvg(Map<String, HashMap<String, Double>> mainMap, Map<String, Double> innerMap) {
		String student = null;
		int counter = 0;
		double avg = 0;
		for (String key : mainMap.keySet()) {
			for (String secondKey : innerMap.keySet()) {
				avg += mainMap.get(key).get(secondKey);
				counter++;
			}
			student = key;
		}
		System.out.println("Srednia studenta " + student + " wynosi: " + (avg / counter));
	}
}
