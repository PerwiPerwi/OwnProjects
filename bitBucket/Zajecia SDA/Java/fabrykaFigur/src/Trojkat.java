
public class Trojkat implements Figura {
	private double a;
	private double b;
	private double c;

	Exception exception = new ArithmeticException("B³êdne boki trójk¹ta");

	public Trojkat(double a, double b, double c) throws Exception {
		if (!(a + b > c) && (a + c > b) && (b + c > a)) {
			throw exception;

		}
		if (a == 0 && b == 0 && c == 0) {
			throw exception;
		}
		setA(a);
		setB(b);
		setC(c);
	}

	public Trojkat() {

	}

	@Override
	public double ObliczPole() {
		return (0.5 * this.a) * this.c;
	}

	@Override
	public double ObliczObwod() {
		// TODO Auto-generated method stub
		return this.a + this.b + this.c;
	}
	
	
	@Override
	public void przedstawSie() {
		System.out.println("Jestem Trójk¹tem");

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

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

}
