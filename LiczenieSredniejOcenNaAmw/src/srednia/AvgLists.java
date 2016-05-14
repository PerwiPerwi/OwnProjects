package srednia;

import java.util.HashMap;
import java.util.Map;

public class AvgLists {
 
	static AvgLists instance = new AvgLists();

// metoda zwracajaca instancje klasy, dzieki czemu metody beda zawsze
// odwolywac sie do tego obiektu, a nie tworzyc nowy

	public static AvgLists getInstance() {
		return instance;
	}

	public Map<String, Map<String, Double>> bwStudents = new HashMap<>();
	public Map<String, Map<String, Double>> msiStudents = new HashMap<>();

}
