import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kula kula = new Kula();

		MaszynaLosujaca maszynaLosujaca = new MaszynaLosujaca();
		//Losuje 60 liczb
		List<Kula> wygenerowaneLiczby = maszynaLosujaca.generowanieLiczb();
		//"Miesza liczby"
		maszynaLosujaca.losowanie(2, wygenerowaneLiczby);
		
		
		//Losuje 6 zwycieskich cyfr
		//List<Kula> wylosowaneLiczby = maszynaLosujaca.zwycieskieLiczby(wygenerowaneLiczby);
		 

		//wyswietlenie zwycieskich liczb
		for (Kula kulka : maszynaLosujaca.zwycieskieLiczby(wygenerowaneLiczby)) {
			System.out.println(kulka);
		}

		

		
	}

}
