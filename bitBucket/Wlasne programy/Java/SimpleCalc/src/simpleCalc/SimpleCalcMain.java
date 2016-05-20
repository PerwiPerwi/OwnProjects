package simpleCalc;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleCalcMain {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String patternChoice = "^([0-4])$";
		double firstNumber = 0;
		double secondNumber = 0;
		String option;
		double result = 0;

		while (firstNumber == 0) {
			firstNumber = insertValue(firstNumber);
		}

		while (secondNumber == 0) {
			secondNumber = insertValue(secondNumber);
		}
		sc.nextLine();
		while (true) {
			try {
				System.out.println("First number: " + firstNumber + " Second number: " + secondNumber);
				System.out.println("Choose Your option: 1 = Add, 2 = Substract, 3 = Multiple, 4 = Divide, 0 = Exit");
				option = sc.nextLine();
				Pattern pattern = Pattern.compile(patternChoice);
				Matcher matcher = pattern.matcher(option);
				if (matcher.find()) {
					int choose = Integer.parseInt(option);
					System.out.println(choose);
					switch (choose) {
					case 1:
						result = addValues(firstNumber, secondNumber);
						break;

					case 2:
						result = substractValues(firstNumber, secondNumber);
						break;

					case 3:
						result = multipleValues(firstNumber, secondNumber);
						break;

					case 4:
						result = divideValues(firstNumber, secondNumber);
						break;

					case 0:
						System.out.println("You choosed exit");
						System.exit(0);
						break;

					default:
						System.out.println("You inserted wrong value");
						break;
					}
				}
				System.out.println("The result is: " + result);
				System.out.println("");
			} catch (InputMismatchException e) {
				System.out.print("Wrong choose, try again.");
				// e.printStackTrace();
			}
		}
	}

	public static double insertValue(double number) {
		try {
			System.out.print("Insert number: ");
			number = sc.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Inserted wrong number try in format like thi 4 or 4.5");
			sc.next();
		}
		return number;
	}

	public static double addValues(double a, double b) {
		return a + b;
	}

	public static double substractValues(double a, double b) {
		return a - b;
	}

	public static double multipleValues(double a, double b) {
		return a * b;
	}

	public static double divideValues(double a, double b) {
		return a / b;
	}
}
