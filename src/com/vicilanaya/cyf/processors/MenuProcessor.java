package com.vicilanaya.cyf.processors;

import com.vicilanaya.cyf.util.ConstantsLibrary;

public class MenuProcessor {

	private static final String MAIN_MENU = 
			"Choose your action:\n" 
			+ "1 - Encipher a message\n"
			+ "2 - Decipher a message\n" 
			+ "3 - Go to display menu\n" 
			+ "0 - Exit application\n";
	
	private static final String DISPLAY_MENU = 
			"What do you want to display?\n" 
			+ "1 - Cipher key\n"
			+ "2 - My Square\n" 
			+ "3 - Default square\n" 
			+ "4 - Introduction\n"  
			+ "5 - CyF History\n" 
			+ "6 - History log\n" 
			+ "7 - Main menu\n" 
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
		case 1: EncipherProcessor.encipher(); break;
		case 2: DecipherProcessor.decipher(); break;
		case 3: getDisplayMenu(); break;
		}
	}
	
	public static void processDisplayMenuSelection(int selection) {
		switch (selection) {
		case 0: System.out.print("Thank you for using CyF. You may restart the program.");
				System.exit(1);
		case 1: customSquare.getCipherKey(); break;
		case 2: customSquare.printSquare(); break;
		case 3: defaultSquare.printSquare(); break;
		case 4: ConstantsLibrary.getIntro(); break;
		case 5: ConstantsLibrary.getCyfHistory(); break;
		case 6: displayHistoryLog(); break;
		case 7: getMainMenu(); break;
		}
	}
	
} // end MenuProcessor class
