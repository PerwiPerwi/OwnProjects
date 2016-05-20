package pl.szkolenie.java;

import java.util.Collection;

public class countAll {

	public static double countAvg(Collection<Double> rates){
		double sums = 0;
		
		for(double currency : rates){
			sums += currency;
		}
		return sums / rates.size();

	}
	
}
