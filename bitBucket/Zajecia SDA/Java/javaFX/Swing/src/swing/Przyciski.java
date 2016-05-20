package swing;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Przyciski {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 150, 150);
		JButton button = new JButton("Ok");
		JButton button2 = new JButton("Zamknij");
		frame.setLayout(new GridLayout(2, 2));
		frame.add(button);
		frame.add(button2);
		frame.setVisible(true);

		
		
	}
}
