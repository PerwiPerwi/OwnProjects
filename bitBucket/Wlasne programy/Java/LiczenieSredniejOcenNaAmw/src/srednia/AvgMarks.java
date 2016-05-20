package srednia;

public class AvgMarks {

	private String name;
	private String surname;
	private double firstMark;
	private double secondMark;
	private double thirdMark;
	private double fourMark;

	/*
	 * Deklaracja Setterow oraz Getterow do wprowadzania imienia, nazwiska oraz
	 * poszczegolnych ocen
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getFirstMark() {
		return firstMark;
	}

	public void setFirstMark(double firstMark) {
		this.firstMark = firstMark;
	}

	public double getSecondMark() {
		return secondMark;
	}

	public void setSecondMark(double secondMark) {
		this.secondMark = secondMark;
	}

	public double getThirdMark() {
		return thirdMark;
	}

	public void setThirdMark(double thirdMark) {
		this.thirdMark = thirdMark;
	}

	public double getFourMark() {
		return fourMark;
	}

	public void setFourMark(double fourMark) {
		this.fourMark = fourMark;
	}

}
