package zajecia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Osoba> osoby = new ArrayList<>();

		osoby.add(new Osoba("Jan", "Kowalski"));
		osoby.add(new Osoba("Janina", "Kucyk"));
		osoby.add(new Osoba("Andrzej", "Andrzejewski"));
		
		Collections.sort(osoby, new Comparator<Osoba>() {

			public int compare(Osoba o1, Osoba o2) {
				int ret = o1.getNazwisko().compareTo(o2.getNazwisko());
				if (ret == 0) {
					ret = o1.getImie().compareTo(o2.getImie());
				}
				return ret;
			}

		});
		
/*		for (Osoba osoba : osoby) {
			System.out.println(osoba.getImie() + " "+ osoba.getNazwisko());
			
		}*/
	}
}
