
public class Kwadrat implements Figura {
	
	private double a;



	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public Kwadrat() {

	}
	
	public Kwadrat(double a) {
		setA(a);
	}

	@Override
	public double ObliczPole() {
		return this.a + this.a + this.a + this.a;
	}

	@Override
	public double ObliczObwod() {
		return this.a * this.a;
	}

	@Override
	public void przedstawSie() {
		System.out.println("Jestem Kwadratem!");

	}



}
