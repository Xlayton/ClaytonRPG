package info.claytonschrumpf_consoleIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ConsoleUI {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Prints using println
	 * 
	 * @param print
	 */
	public static void printLine(String print) {
		System.out.println(print);
	}

	/**
	 * Prints using print
	 * 
	 * @param print
	 */
	public static void print(String print) {
		System.out.print(print);
	}

	/**
	 * Generates a console-based menu using the Strings in options as the menu
	 * items. Reserves the number 0 for the "quit" option when withQuit is true.
	 * 
	 * @param options  - Strings representing the menu options
	 * @param withQuit - adds option 0 for "quit" when true
	 * @return the int of the selection made by the user
	 */
	public static int promptForMenuSelection(String[] options, boolean withQuit) {
		if (options == null) {
			throw new IllegalArgumentException("Your menu needs items...");
		}
		int amtOptions = options.length;
		int minInput = 1;
		int selection;
		if (withQuit) {
			System.out.println("0. Quit");
			minInput = 0;
		}
		for (int i = 0; i < amtOptions; i++) {
			System.out.println((i + 1) + ". " + options[i]);
		}
		selection = promptForInt("What is your selection?", minInput, amtOptions);
		return selection;
	}

	/**
	 * Generates a prompt that expects the user to enter one of two responses that
	 * will equate to a boolean value. The trueString represents the case
	 * insensitive response that will equate to true. The falseString acts
	 * similarly, but for a false boolean value. Example: Assume this method is
	 * called with a trueString argument of "yes" and a falseString argument of
	 * "no". If the enters "YES", the method returns true. If the user enters "no",
	 * the method returns false. All other inputs are considered invalid, the user
	 * will be informed, and the prompt will repeat.
	 * 
	 * @param prompt      - the prompt to be displayed to the user
	 * @param trueString  - the case insensitive value that will evaluate to true
	 * @param falseString - the case insensitive value that will evaluate to false
	 * @return the boolean value
	 */
	public static boolean promptForBool(String prompt, String trueString, String falseString) {
		checkPrompt(prompt);
		boolean isNotValid = true;
		String userInput = null;
		boolean answerBool = true;

		while (isNotValid) {
			userInput = promptForInput(prompt, false);
			if (trueString.equalsIgnoreCase(userInput)) {
				answerBool = true;
				isNotValid = false;
			} else if (falseString.equalsIgnoreCase(userInput)) {
				answerBool = false;
				isNotValid = false;
			} else {
				System.out.println("That is not a valid input.");
				isNotValid = true;
			}
		}
		return answerBool;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a byte value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt - the prompt to be displayed to the user
	 * @param min    - the inclusive minimum boundary
	 * @param max    - the inclusive maximum boundary
	 * @return the byte value
	 */
	public static byte promptForByte(String prompt, byte min, byte max) {
		checkPrompt(prompt);
		byte userInput = 0;
		boolean isInvalidData = true;

		while (isInvalidData) {
			System.out.println(prompt);
			try {
				userInput = Byte.parseByte(in.readLine());
			} catch (IOException ioex) {
				System.out.println("That is very wrong\n");
				continue;
			} catch (NumberFormatException nfex) {
				System.out.println("Please insert a valid number\n");
				continue;
			}
			if (userInput >= min && userInput <= max) {
				isInvalidData = false;
			} else {
				System.out.println("Please input a number between " + min + " and " + max + "\n");
			}
		}
		return userInput;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a short value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt - the prompt to be displayed to the user
	 * @param min    - the inclusive minimum boundary
	 * @param max    - the inclusive maximum boundary
	 * @return the short value
	 */
	public static short promptForShort(String prompt, short min, short max) {
		checkPrompt(prompt);
		short userInput = 0;
		boolean isInvalidData = true;

		while (isInvalidData) {
			System.out.println(prompt);
			try {
				userInput = Short.parseShort(in.readLine());
			} catch (IOException ioex) {
				System.out.println("That is very wrong\n");
				continue;
			} catch (NumberFormatException nfex) {
				System.out.println("Please input a valid number\n");
			}
			if (userInput >= min && userInput <= max) {
				isInvalidData = false;
			} else {
				System.out.println("Please input a number between " + min + " and " + max + "\n");
			}
		}
		return userInput;
	}

	/**
	 * Generates a prompt that expects a numeric input representing an int value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt - the prompt to be displayed to the user
	 * @param min    - the inclusive minimum boundary
	 * @param max    - the inclusive maximum boundary
	 * @return the int value
	 */
	public static int promptForInt(String prompt, int min, int max) {
		if (prompt == null) {
			throw new IllegalArgumentException("Dont pass null. Thats bad mmkay");
		}
		int userInput = max + 5;
		boolean isInvalidData = true;

		while (isInvalidData) {
			System.out.println(prompt);
			try {
				userInput = Integer.parseInt(in.readLine());
			} catch (IOException ioex) {
				System.out.println("That is very wrong\n");
				continue;
			} catch (NumberFormatException nfex) {
				System.out.println("Please input a valid number");
			}
			if (userInput >= min && userInput <= max) {
				isInvalidData = false;
			} else {
				System.out.println("Please input a number between " + min + " and " + max);
			}
		}
		return userInput;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a long value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt - the prompt to be displayed to the user
	 * @param min    - the inclusive minimum boundary
	 * @param max    - the inclusive maximum boundary
	 * @return the long value
	 */
	public static long promptForLong(String prompt, long min, long max) {
		checkPrompt(prompt);
		long userInput = 0;
		boolean isInvalidData = true;

		while (isInvalidData) {
			System.out.println(prompt);
			try {
				userInput = Long.parseLong(in.readLine());
				if (userInput >= min && userInput <= max) {
					isInvalidData = false;
				} else {
					System.out.println("Please input a number between " + min + " and " + max + "\n");
				}
			} catch (IOException ioex) {
				System.out.println("That is very wrong\n");
				continue;
			} catch (NumberFormatException nfex) {
				System.out.println("Please input a valid number\n");
			}
		}
		return userInput;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a float value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt - the prompt to be displayed to the user
	 * @param min    - the inclusive minimum boundary
	 * @param max    - the inclusive maximum boundary
	 * @return the float value
	 */
	public static float promptForFloat(String prompt, float min, float max) {
		checkPrompt(prompt);
		float userInput = 0;
		boolean isInvalidData = true;

		while (isInvalidData) {
			System.out.println(prompt);
			try {
				userInput = Float.parseFloat(in.readLine());
			} catch (IOException ioex) {
				System.out.println("That is very wrong\n");
				continue;
			} catch (NumberFormatException nfex) {
				System.out.println("Please input a valid number\n");
			}
			if (userInput >= min && userInput <= max) {
				isInvalidData = false;
			} else {
				System.out.println("Please input a number between " + min + " and " + max + "\n");
			}
		}
		return userInput;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a double value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt - the prompt to be displayed to the user
	 * @param min    - the inclusive minimum boundary
	 * @param max    - the inclusive maximum boundary
	 * @return the double value
	 */
	public static double promptForDouble(String prompt, double min, double max) {
		checkPrompt(prompt);
		double userInput = 0;
		boolean isInvalidData = true;

		while (isInvalidData) {
			System.out.println(prompt);
			try {
				userInput = Double.parseDouble(in.readLine());
			} catch (IOException ioex) {
				System.out.println("That is very wrong\n");
				continue;
			} catch (NumberFormatException nfex) {
				System.out.println("Please input a valid number\n");
			}
			if (userInput >= min && userInput <= max) {
				isInvalidData = false;
			} else {
				System.out.println("Please input a number between " + min + " and " + max + "\n");
			}
		}
		return userInput;
	}

	/**
	 * Generates a prompt that allows the user to enter any response and returns the
	 * String. When allowEmpty is true, empty responses are valid. When false,
	 * responses must contain at least one character (including whitespace).
	 * 
	 * @param prompt     - the prompt to be displayed to the user.
	 * @param allowEmpty - when true, makes empty responses valid
	 * @return the input from the user as a String
	 */
	public static String promptForInput(String prompt, boolean allowEmpty) {
		checkPrompt(prompt);
		String userInput = null;
		boolean isInvalidData = true;
		String userInputTrimmed = null;

		while (isInvalidData) {
			System.out.println(prompt);
			try {
				userInput = in.readLine();
			} catch (IOException ioex) {
				System.out.println("That is very wrong\n");
			}
			userInputTrimmed = userInput.trim();
			if (userInputTrimmed.equals("")) {
				if (allowEmpty) {
					isInvalidData = false;
				} else {
					System.out.println("Sorry, you cant enter nothing.");
				}
			} else {
				isInvalidData = false;
			}
		}
		return userInputTrimmed;
	}

	/**
	 * Generates a prompt that expects a single character input representing a char
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt - the prompt to be displayed to the user
	 * @param min    - the inclusive minimum boundary
	 * @param max    - the inclusive maximum boundary
	 * @return the char value
	 */
	public static char promptForChar(String prompt, char min, char max) {
		checkPrompt(prompt);
		char userInput = 0;
		String rawInput = null;
		boolean isInvalidData = true;
		char[] brokeInput;

		while (isInvalidData) {
			System.out.println(prompt);
			try {
				rawInput = in.readLine();
				userInput = rawInput.charAt(0);
			} catch (IOException ioex) {
				System.out.println("That is very wrong\n");
				continue;
			} catch (StringIndexOutOfBoundsException siobex) {
				System.out.println("Please enter a value\n");
			}
			brokeInput = rawInput.toCharArray();
			if (brokeInput.length > 1) {
				System.out.println("Only enter a SINGLE character please.");
				continue;
			}
			if (userInput >= min && userInput <= max) {
				isInvalidData = false;
			} else {
				System.out.println("Please input a char between " + min + " and " + max + "\n");
			}
		}
		return userInput;
	}

	public static void checkPrompt(String prompt) {
		if (prompt == null) {
			throw new IllegalArgumentException("Dont pass null, thats bad mmkay");
		}
	}
}
