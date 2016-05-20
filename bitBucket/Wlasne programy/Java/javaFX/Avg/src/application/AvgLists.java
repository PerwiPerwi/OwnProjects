package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AvgLists {

	public Map<String, ArrayList<Double>> bwStudents = new HashMap<>();

	public Map<String, ArrayList<Double>> msiStudents = new HashMap<>();

	private AvgLists() {
	}

	private static AvgLists instance = new AvgLists();

	public static AvgLists getInstance() {
		return instance;
	}
}
