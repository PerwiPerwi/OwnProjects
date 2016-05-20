package swingBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SmallCalc {

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
					SmallCalc window = new SmallCalc();
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
	public SmallCalc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
		
		textField = new JTextField();
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_1.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e){
				calc();	
			}
		});
		textField.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e){
				calc();	
			}
		});
		
	}
	
	public void calc(){
		try {
			if(textField.getText().equals("")){
				return;
			}
			else if(textField_1.getText().equals("")){
				return;
			}
			int first = Integer.parseInt(textField.getText());
			int second = Integer.parseInt(textField_1.getText());
			textField_2.setText(Integer.toString((first + second)));
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
