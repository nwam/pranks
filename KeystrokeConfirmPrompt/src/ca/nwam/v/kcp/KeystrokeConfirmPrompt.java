package ca.nwam.v.kcp;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
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
		
		//set the icon
		try {
			dialog.setIconImage(ImageIO.read(new File("img/keyboard.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
//		URL iconURL = KeystrokeConfirmPrompt.class.getResource("img/keyboard.png");
//		System.out.println(iconURL);
//		ImageIcon icon = new ImageIcon(iconURL);
//		dialog.setIconImage(icon.getImage());
//		Image keyboardIcon = new ImageIcon(KeystrokeConfirmPrompt.class.getResource("img/keyboard.png")).getImage();
//		dialog.setIconImage(keyboardIcon);
		
		//set other options to make the box annoying
		dialog.setAlwaysOnTop(true);
		dialog.setModal(true);
		dialog.setVisible(true);
	}
	
	public static void main(String args[]) {
		String charPressed;
		charPressed = args[1];
		createPrompt(charPressed);
	}
}
