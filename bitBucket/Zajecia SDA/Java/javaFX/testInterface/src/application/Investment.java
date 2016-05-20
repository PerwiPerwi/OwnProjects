package application;

public interface Investment {

	void setInterest(double interest);
	void setTax(double tax);
	void setAmount(int dolarsAmount);
	void setPeriod(int months);
	int countProfit() throws IllegalArgumentException;
	int countAccountBallance() throws IllegalArgumentException;
	
	
	
	
}
