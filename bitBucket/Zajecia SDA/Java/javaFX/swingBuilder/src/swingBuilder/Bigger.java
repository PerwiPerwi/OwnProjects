package swingBuilder;

import java.awt.EventQueue;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class Bigger {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bigger window = new Bigger();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bigger() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		frame.getContentPane().add(textField, BorderLayout.WEST);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1, BorderLayout.EAST);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		frame.getContentPane().add(textField_2, BorderLayout.CENTER);
		textField_2.setColumns(10);
		
		textField_1.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e){
				checkNumber();		
			}
		});
		
	}
	public void checkNumber(){
		try {
			int firstNumber = Integer.parseInt(textField.getText());
			int secondNumber = Integer.parseInt(textField_1.getText());
			
			if(firstNumber > secondNumber){
			textField_2.setText(firstNumber +"");
			}
			else{
			textField_2.setText(secondNumber +"");
			}
			
		} catch (NumberFormatException e) {
			textField_2.setText("B³¹d");
		}

	}
	

}
