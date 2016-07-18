package ca.nwam.v.kcp;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Toolkit;

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
		
		//set the icon
		Class<?> cl=new Object(){}.getClass().getEnclosingClass();
		dialog.setIconImage(Toolkit.getDefaultToolkit().getImage(cl.getResource("/ca/nwam/v/kcp/img/keyboard.png")));
		
		//set other options to make the box annoying
		dialog.setAlwaysOnTop(true);
		dialog.setModal(true);
		dialog.setVisible(true);
	}
	
	public static void main(String args[]) {
		String charPressed;
		if(args.length <= 0) {
			charPressed = "undefined";
		} else {
			charPressed = args[0];
		}
		createPrompt(charPressed);
		System.exit(0);
	}
}
