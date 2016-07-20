package ca.nwam.v.kc;

import java.io.IOException;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class App {


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
			//press
            @Override public void keyPressed(GlobalKeyEvent event) {
                System.out.println(event);
                if(event.getVirtualKeyCode()==GlobalKeyEvent.VK_ESCAPE)
                	System.out.println(event);
                
                String charPressed = Character.toString(event.getKeyChar());
                System.out.println(charPressed);
                //run the prompt as a separate program to allow it to regain focus and multiply
                ProcessBuilder pb = new ProcessBuilder("java", "-jar", 
                		"kcp.jar", charPressed);
                try {
					pb.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
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
