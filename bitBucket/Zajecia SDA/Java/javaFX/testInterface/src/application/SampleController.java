package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SampleController {
	
	Investment investment = new InvestmentTest();
	
    @FXML
    private TextField peroidValue;
	
    @FXML
    private TextField interestValue;
	
    @FXML
    private TextField taxValue;

    @FXML
    private TextField amountValue;

    @FXML
    private TextField countProfit;

    @FXML
    private TextField countAccBalance;

    @FXML
    private Button all;

    @FXML
    private Button profit;

    @FXML
    private Button accBalance;

    @FXML
    void countAccBalance(ActionEvent event) {

    }

    @FXML
    void countAll(ActionEvent event) {
  	
    	double interest = getDoubleNumber(interestValue);
    	investment.setInterest(interest);
    	
    	double tax = getDoubleNumber(taxValue);
    	investment.setTax(tax);
    	
    	int amount = getIntNumber(amountValue);
    	investment.setAmount(amount);
    	
    	int peroid = getIntNumber(peroidValue);
    	investment.setPeriod(peroid);
    	
    	countAccBalance.setText(Integer.toString(investment.countAccountBallance()));
    	countProfit.setText(Integer.toString(investment.countProfit()));
    }

    @FXML
    void countProfit(ActionEvent event) {

    }
    
	private int getIntNumber(TextField number) {
		try {
			return Integer.parseInt(number.getText());
		} catch (Exception e) {
			System.out.println("B³êdna typ danych");
			return 0;
	}
}
	private double getDoubleNumber(TextField number) {
		try {
			return Double.parseDouble(number.getText());
		} catch (Exception e) {
			System.out.println("B³êdny typ danych");
			return 0;
	}
}
	}


