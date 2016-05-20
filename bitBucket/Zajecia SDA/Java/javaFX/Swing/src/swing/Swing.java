package swing;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Swing {
	public static void main (String [] args){
	
	EventQueue.invokeLater(new Runnable (){
		public void run() {
			try{
				JFrame frame = new JFrame();
				frame.setBounds(100,100,450,300);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				JLabel label = new JLabel("Hello World");
				frame.add(label);

			} catch (Exception e){
			e.printStackTrace();
		}
	}
	});
}
	static class Zadanie implements Runnable {
		public void run(){
			
		}
	}
}
