package ca.nwam.v.kc;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class App implements Runnable {

	@Override
	public void run() {
		createPrompt();
		
	}
	
	private static void createPrompt() {
		JOptionPane optionPane = new JOptionPane("Are you sure you want to input BLAH?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
		JDialog dialog = optionPane.createDialog("Confirm Input");
		dialog.setAlwaysOnTop(true);
		dialog.setModal(true);
		dialog.setVisible(true);
/*	
		//create frame
		JFrame frame = new JFrame();
		SwingUtilities.updateComponentTreeUI(frame);
		
		//display frame
		String[] options = {"No", "Yes"};
		JOptionPane.showOptionDialog(frame.getContentPane(),"Are you sure you want to input BLAH?","Confirm Keystroke", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
*/
	}
	
	public static void main(String[] args) {
		
		//set look and feel of the prompt
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	
		//init keyboard hook
		GlobalKeyboardHook khook;
		try {
			khook = new GlobalKeyboardHook();
		} catch (UnsatisfiedLinkError e) {
			e.printStackTrace();
			return;
		}
		
		//set keystroke actions
		khook.addKeyListener(new GlobalKeyAdapter() {
			//press
            @Override public void keyPressed(GlobalKeyEvent event) {
                System.out.println(event);
                if(event.getVirtualKeyCode()==GlobalKeyEvent.VK_ESCAPE)
                	System.out.println(event);
                	createPrompt();
//                	(new Thread(new App())).start();
            }  
            //release
            @Override public void keyReleased(GlobalKeyEvent event) {
                System.out.println(event); 
            }
        });
		
		//keep the threads (keylistener) alive
		try {
			while(true) Thread.sleep(128); 
		} 
		catch(InterruptedException e) { /* nothing to do here */ 
	    } 
		finally { khook.shutdownHook(); 
	    }
		
	}
	
}
