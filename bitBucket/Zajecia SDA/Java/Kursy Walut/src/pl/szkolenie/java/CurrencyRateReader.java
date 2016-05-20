package pl.szkolenie.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CurrencyRateReader {

	/**
	 * wczytuje mapê kursu Euro z podanego pliku
	 * 
	 * @param pathToFile
	 *            sie¿ka do pliku
	 * @return mapa kursów, gdzie kluczem jest dzieñ kursu, wartoœci¹ jest kurs
	 * @throws IOException
	 */
	public Map<LocalDate, Double> loadCurrencyRateMap(String pathToFile) throws IOException {

		List<String> linesInFile = loadLinesFormFile(pathToFile);
		Map<LocalDate, Double> rates = new TreeMap<>();
		for (String line : linesInFile) {
			RateData data = parseLine(line);
			rates.put(data.date, data.rate);
		}
		return rates;

	}

	private List<String> loadLinesFormFile(String pathToFile) throws IOException {
		List<String> lines = new ArrayList<>();
		File file = new File(pathToFile);
		Scanner in = new Scanner(new FileReader(file));

		while (in.hasNext()) {
			lines.add(in.next());
		}
		in.close();
		return lines;
	}

	private RateData parseLine(String line) {
		String[] data = line.split(";");
		LocalDate date = parseDate(data[0]);
		Double rate = Double.parseDouble(data[1]);
		return new RateData(date, rate);

	}

	private LocalDate parseDate(String dateAsString) {
		return LocalDate.parse(dateAsString, DateTimeFormatter.ISO_DATE);
	}

	private class RateData {
		LocalDate date;
		double rate;

		RateData(LocalDate date, double rate) {
			this.date = date;
			this.rate = rate;
		}

	}

}
