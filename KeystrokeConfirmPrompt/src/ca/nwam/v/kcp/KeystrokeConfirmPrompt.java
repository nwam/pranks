package ca.nwam.v.kcp;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class KeystrokeConfirmPrompt {
	private static void createPrompt() {
		//set look and feel of the prompt
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		//create and display the prompt
		JOptionPane optionPane = new JOptionPane("Are you sure you want to input BLAH?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
		final JDialog dialog = optionPane.createDialog("Confirm Input");
		dialog.setAlwaysOnTop(true);
		dialog.setModal(true);
		dialog.setVisible(true);
	}
	
	public static void main(String args[]){
		createPrompt();
	}
}
