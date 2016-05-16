package srednia;

import java.util.HashMap;
import java.util.Map;
// Modu³ do przechowywania studentow, przedmiotow i ocen
public class AvgLists {
 
	static AvgLists instance = new AvgLists();

// metoda zwracajaca instancje klasy, dzieki czemu metody beda zawsze
// odwolywac sie do tego obiektu, a nie tworzyc nowy

	public static AvgLists getInstance() {
		return instance;
	}

//Mapy do przechowywania danych (Klucz g³ówny - imie i nazwisko,
// klucz wewnetrznej mapy(wartosc glownej mapy)  - nazwa przedmiotu, wartosc
// wewnetrznej mapy - ocena
	public Map<String, Map<String, Double>> bwStudents = new HashMap<>();
	public Map<String, Map<String, Double>> msiStudents = new HashMap<>();

}
