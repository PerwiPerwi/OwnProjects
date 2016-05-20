package pl.szkolenie.java;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class Generator {
	
	public static void main(String[] args) {
		
		LocalDate date = LocalDate.of(2015, 01, 01);
		double kurs = 4.200;
		Random rn = new Random();
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
		nf.setMinimumFractionDigits(3);
		nf.setMaximumFractionDigits(3);
		
		for (int i = 0; i < date.getDayOfYear(); i++) {
			System.out.println(date.toString() +";"+nf.format(kurs) );
			double dailyChange = ((rn.nextDouble()-0.499)/10);
			kurs += dailyChange;
			date = date.plusDays(1);
		}
	}

}
