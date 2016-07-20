package ca.nwam.v.kcp;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.util.Random;

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
		String message = "You just pressed the \"" + charPressed + "\" key.";
		JOptionPane optionPane = new JOptionPane("<html><body><div width='200px' align='center'>" + message + "</div></body></html>", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
		JDialog dialog = optionPane.createDialog("Input Information");
		
		//set the icon
		Class<?> cl=new Object(){}.getClass().getEnclosingClass();
		dialog.setIconImage(Toolkit.getDefaultToolkit().getImage(cl.getResource("/ca/nwam/v/kcp/img/keyboard.png")));
		
		//set other options to make the box annoying
		dialog.setAlwaysOnTop(true);
		dialog.setModal(true);
		//set the box size as (almost) fullscreen
		Random generator = new Random(System.nanoTime());
		int wiggle_x = (int)(generator.nextDouble() * 366) - 366/2;
		int wiggle_y = (int)(generator.nextDouble() * 202) - 202/2;
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int screenWidth = gd.getDisplayMode().getWidth();
		int screenHeight = gd.getDisplayMode().getHeight();
		dialog.setSize(screenWidth, screenHeight);
		dialog.setLocation(0+wiggle_x,0+wiggle_y);
		dialog.setResizable(false);
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
