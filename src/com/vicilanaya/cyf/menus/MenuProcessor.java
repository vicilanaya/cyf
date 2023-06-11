package com.vicilanaya.cyf.menus;

public class MenuProcessor {

	private static final String MAIN_MENU = 
			"Choose your action:\n" 
			+ "1 - Encipher a message\n"
			+ "2 - Decipher a message\n" 
			+ "3 - Display all objects\n"
			+ "4 - Go to display menu\n" 
			+ "0 - Exit application\n";
	
	private static final String DISPLAY_MENU = 
			"Choose your action:\n" 
			+ "1 - Display cipher key\n"
			+ "2 - Display square\n" 
			+ "3 - Display introduction\n" 
			+ "4 - Display history log\n" 
			+ "5 - Go back to main menu\n" 
			+ "0 - Exit application\n";

	public static String getMainMenu() {
		return MAIN_MENU;
	}

	public static String getDisplayMenu() {
		return DISPLAY_MENU;
	}
	
	public static void processMainMenuSelection(int selection) {
		switch (selection) {
		case 0: System.out.print("Thank you for using CyF. You may restart the program.");
				System.exit(1);
		case 1: encipher(); break;
		case 2: decipher(); break;
		case 3: showInstructions(); break;
		case 4: showHistory(); break;
		}
	}
	
	public static void processDisplayMenuSelection(int selection) {
		switch (selection) {
		case 0: System.out.print("Thank you for using CyF. You may restart the program.");
				System.exit(1);
		case 1: encipher(); break;
		case 2: decipher(); break;
		case 3: showInstructions(); break;
		case 4: showHistory(); break;
		}
	}
	
} // end MenuProcessor class
