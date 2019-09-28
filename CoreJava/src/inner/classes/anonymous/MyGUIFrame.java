package inner.classes.anonymous;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyGUIFrame {
	
	JButton b1;
	JButton b2;
	JButton b3;
	
	public static void main(String[] args) {
		 
		MyGUIFrame frame = new MyGUIFrame();
		
		frame.b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// b1 specific functionality
				
			}
		});
		
		frame.b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// b1 specific functionality
				
			}
		});
	}
}
