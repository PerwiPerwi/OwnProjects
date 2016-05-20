package application;

import javafx.scene.control.TextField;

public class InvestmentTest implements Investment {

	@Override
	public void setInterest(double interest) { 
		System.out.println(interest);
	}

	@Override
	public void setTax(double tax) {
		System.out.println(tax);

	}

	@Override
	public void setAmount(int dolarsAmount) {
		System.out.println(dolarsAmount);

	}

	@Override
	public void setPeriod(int months) {
		System.out.println(months);

	}

	@Override
	public int countProfit() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 70;
	}

	@Override
	public int countAccountBallance() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 50;
	}
	

	

}
