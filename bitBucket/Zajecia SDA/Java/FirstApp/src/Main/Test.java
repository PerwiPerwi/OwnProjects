package Main;

public class Test {
	public static void main(String[] args) {
		// System.out.println("Raz Raz");

		Prostokat prostokat = new Prostokat(3.5F, 4.2F);
		Prostokat prostokatDwa = new Prostokat(4.5F, 3.2F);
		double pole = prostokat.liczPole();
		System.out.println(prostokat.liczPole());

		double x = 5.0;
		double y = 6.0;
		int c = (int)x;
		System.out.println(prostokat.liczObwod(x, y));
		
	}
}
