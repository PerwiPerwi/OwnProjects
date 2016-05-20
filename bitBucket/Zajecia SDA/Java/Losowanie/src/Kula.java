public class Kula {


	private int number;
	private boolean used = false;

	public Kula(int number, boolean used) {
		setNumber(number);
		setUsed(used);
	}

	public Kula() {

	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	
	@Override
	public String toString() {
		return "Number: " + number + ", czy uzyta? " + used;
	}


}
