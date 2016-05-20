import java.util.Scanner;

public class Zeros {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaj liczbê");
		String number = sc.nextLine();
		char[] numbers = number.toCharArray();
		int counter = 0;
		int tempCounter = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == '0') {
				tempCounter++;
				if(numbers.length < i+1){
				if (numbers[i + 1] != '0') {
					System.out.println(tempCounter);
					if (tempCounter > counter) {
						counter = tempCounter;
						tempCounter = 0;
					}
				}
			}
		}
		System.out.println(counter);

	}

}
