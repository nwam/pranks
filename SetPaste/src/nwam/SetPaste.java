package nwam;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Random;

public class SetPaste {

	public static void main(String[] args) {
		
		String[] msgs = {"Your", "memes", "here"
				};
		Random random = new Random();
		
		while(true){
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int randomNum = random.nextInt(msgs.length);
			String myString = msgs[randomNum];
			StringSelection stringSelection = new StringSelection(myString);
			Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
			clpbrd.setContents(stringSelection, null);
		}

		

	}

}
