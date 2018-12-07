package info.claytonschrumpf;

public class Main {
	public static void main(String[] args) {
		try {
			if (args[0] != null && args[0].equals("gui")) {
				new GuiGame().run();
			} else {
				new ConsoleGame().run();
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			new ConsoleGame().run();
		}
	}
}
