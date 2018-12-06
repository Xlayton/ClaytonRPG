package info.claytonschrumpf;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
	public static void main(String[] args) {
		KeyChecker keyLogger = new KeyChecker();
		while(true) {
			keyLogger.getKeyPressed()
		}
		
//		try {
//			if (args[0] != null && args[0].equals("gui")) {
//				new GuiGame().run();
//			} else {
//				new ConsoleGame().run();
//			}
//		} catch (ArrayIndexOutOfBoundsException ex) {
//			new ConsoleGame().run();
//		}
	}
}
