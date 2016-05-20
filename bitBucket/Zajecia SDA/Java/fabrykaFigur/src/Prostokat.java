
public class Prostokat implements Figura {

	public Prostokat(double a, double b) {
		setA(a);
		setB(b);
	}

	private double a;
	private double b;

	public Prostokat() {
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	@Override
	public double ObliczPole() {
		return this.a * this.b;
	}

	@Override
	public double ObliczObwod() {
		if (this.a == 0 || this.b == 0) {
			return 0;
		}
		return this.a + this.b;
	}

	@Override
	public void przedstawSie() {
		System.out.println("Jestem prostokatem!");

	}

}
