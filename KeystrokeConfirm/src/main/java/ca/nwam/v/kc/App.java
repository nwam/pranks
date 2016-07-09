package ca.nwam.v.kc;

/**
 * Hello world!
 *
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {
	public static void main(String[] args) {
		
		//set look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		//create frame
		JFrame frame = new JFrame();
		SwingUtilities.updateComponentTreeUI(frame);
		
		String[] options = {"No", "Yes"};
		JOptionPane.showOptionDialog(frame.getContentPane(),"Are you sure you want to input BLAH?","Confirm Keystroke", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
	}
	
}
