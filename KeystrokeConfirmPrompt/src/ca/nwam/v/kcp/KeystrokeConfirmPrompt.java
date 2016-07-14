package ca.nwam.v.kcp;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Image;
import javax.swing.ImageIcon;

 class KeystrokeConfirmPrompt {
	private static void createPrompt(String charPressed) {
		//set look and feel of the prompt
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		//create and display the prompt
		JOptionPane optionPane = new JOptionPane("You just pressed the \"" + charPressed + "\" key.", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
		JDialog dialog = optionPane.createDialog("Input Information");
		System.out.println(System.getProperty("java.class.path"));
//		Image keyboardIcon = new ImageIcon(KeystrokeConfirmPrompt.class.getResource("../img/keybaord.png")).getImage();
//		dialog.setIconImage(keyboardIcon);;
		dialog.setAlwaysOnTop(true);
		dialog.setModal(true);
		dialog.setVisible(true);
	}
	
	public static void main(String args[]){
		String charPressed = args[1];
		createPrompt(charPressed);
	}
}
