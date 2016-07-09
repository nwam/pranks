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
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class App {
	private static boolean run = true;
	public static void main(String[] args) {
				
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
			
            @Override public void keyPressed(GlobalKeyEvent event) {
                System.out.println(event);
                if(event.getVirtualKeyCode()==GlobalKeyEvent.VK_ESCAPE)
                	System.out.println(event);
                	createPrompt();
            }
            
            @Override public void keyReleased(GlobalKeyEvent event) {
                System.out.println(event); 
            }
        });
		
		//keep the threads (keylistener) alive
		try {
			while(run) Thread.sleep(128); 
		} 
		catch(InterruptedException e) { /* nothing to do here */ 
	    } 
		finally { khook.shutdownHook(); 
	    }
		
	}
	
	private static void createPrompt() {
		
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
