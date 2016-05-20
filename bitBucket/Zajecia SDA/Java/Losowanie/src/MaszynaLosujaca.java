import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MaszynaLosujaca {
	Random rand = new Random();
	Kula kula;

	public List<Kula> generowanieLiczb() {
		int booleanCounter = 0;

		List<Kula> kule = new ArrayList<>();
		for (int i = 0; i < 60; i++) {
			if (booleanCounter != 6) {
				kule.add(kula = new Kula(i + 1, false));
			}
		}
		while (booleanCounter != 6) {
			int random = rand.nextInt(60);
			if (kule.get(random).isUsed() != true) {
				kule.get(random).setUsed(true);
				booleanCounter++;
			}
		}
		return kule;
	}

	public List<Kula> losujLiczbyArray(List<Kula> kula) {
		Random rand = new Random();
		List<Kula> tempNumbers = new ArrayList<>();
		while (tempNumbers.size() != 6) {
			int r = rand.nextInt(60) + 1;
			if (!tempNumbers.contains(r))
				tempNumbers.add(kula.get(r));
		}

		return tempNumbers;
	}

	public void losowanie(int ileRazy, List<Kula> wygenerowaneLiczby) {
		Kula tymczasowaKula;
		int licznik = 0;

		while (licznik != ileRazy) {
			int drugaLosowa = rand.nextInt(60);
			int pierwszaLosowa = rand.nextInt(60);
			int iloscPrzesuniec = 0;
			if (drugaLosowa != pierwszaLosowa) {
				tymczasowaKula = wygenerowaneLiczby.get(drugaLosowa);
				wygenerowaneLiczby.set(drugaLosowa, wygenerowaneLiczby.get(pierwszaLosowa));
				wygenerowaneLiczby.set(pierwszaLosowa, tymczasowaKula);
				while (iloscPrzesuniec != 6) {
					for (Kula kula : wygenerowaneLiczby) {
						if (kula.isUsed() == true && wygenerowaneLiczby.indexOf(kula) != 0) {
							tymczasowaKula = wygenerowaneLiczby.get(wygenerowaneLiczby.indexOf(kula) - 1);
							wygenerowaneLiczby.set(wygenerowaneLiczby.indexOf(kula) - 1, kula);
							wygenerowaneLiczby.set(wygenerowaneLiczby.indexOf(kula), tymczasowaKula);
						}
					}
					iloscPrzesuniec++;
				}

			}
			licznik++;
		}
	}

	public List<Kula> zwycieskieLiczby(List<Kula> kule) {
		List<Kula> tempKule = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			tempKule.add(kule.get(i));
		}
		return tempKule;
	}
}
