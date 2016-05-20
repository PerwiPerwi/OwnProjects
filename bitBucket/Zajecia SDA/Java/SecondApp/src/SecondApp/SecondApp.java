package SecondApp;

import java.util.Random;

public class SecondApp {
	public static void main(String[] args) {
		int[] tab = new int[10];

		Random rn = new Random();

/*		for (int i = 0; i < tab.length; i++) {
			tab[i] = rn.nextInt(10);
		}*/

		int[] tab2 = new int[100];
		int counter = 0;
		for (int i = 0; i < tab2.length; i++) {
			tab2[i] = rn.nextInt(10);
			if (tab2[i] == 6) {
				counter++;
			}
		}
		System.out.println("Tyle wynosi liczb 6: "+counter+".");
	}
}
