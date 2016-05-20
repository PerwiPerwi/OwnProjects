package pl.szkolenie.java;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CurrencyMain {
	public static void main(String[] args) {
		CurrencyRateReader reader = new CurrencyRateReader();
		try {
			Map<LocalDate, Double> rates = reader.loadCurrencyRateMap("C:\\tmp\\Euro_2015.csv");
			// System.out.println(countAll.countAvg(rates.values()));
			// for (Entry<LocalDate, Double> rate : rates.entrySet()) {
			// System.out.println(rate.getKey() + " " + rate.getValue());
			// }
			Set<LocalDate> keys = rates.keySet();
			HashMap<Integer, Collection<Double>> kursy = new HashMap<>();
			for (LocalDate key : keys) {
				int month = key.getMonthValue();
				
				Collection<Double> wartosci = kursy.get(month);				
				if (wartosci == null) {
					wartosci = new ArrayList<>();
				}
					wartosci.add(rates.get(key));
					kursy.put(month, wartosci);
			}
			
			for (Integer month : kursy.keySet()) {
				System.out.println(countAll.countAvg(kursy.get(month)));
				
			}
			
		} catch (IOException e) {
			System.out.println("Problem podczas odczytu pliku.");
			e.printStackTrace();
		}

	}

}
