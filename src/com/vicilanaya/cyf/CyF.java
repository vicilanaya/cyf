/**
 * This application enciphers and deciphers a message by using a key.
 * The user receives the enciphered or deciphered message 
 * and the cipher square created from the key.
 */
package com.vicilanaya.cyf;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.vicilanaya.cyf.components.Square;
import com.vicilanaya.cyf.processors.MenuProcessor;
import com.vicilanaya.cyf.utils.ConstantsLibrary;


/**
 * @author Florence Vicil Anaya Copyright 2020 vicilanaya@gmail.com
 *
 */
public class CyF extends Exception {

	private static final long serialVersionUID = 1L;

	public final Square defaultSquare = new Square(null);
	public Square customSquare = null;
	
	static Scanner keyboardInput = new Scanner(System.in);
	
	
	static String originalMessage = null;
	static String originalKey = null;
	static String validMessage = null;
	static String validKey = null;
	static String encipheredMessage = null;
	static String decipheredMessage = null;
	
	public static void main(String[] args) {
		
		System.out.println(ConstantsLibrary.getIntro());
		System.out.println(MenuProcessor.getMainMenu());

		MenuProcessor.processMainMenuSelection(keyboardInput.nextInt());

		
		
	}	// end main method
	
	
	private static void getSelection() {
		Integer selection = 100;	// Integer (not int) so that it can be compared to null
		do {
			do {
				System.out.println("Showing menu");	// TEST
				showMenu();
				System.out.println("Intro shown");	// TEST
				System.out.print("Your selection: ");
				try {
					selection = keyboardInput.nextInt();	// input must be an integer
					if (selection < 0 || selection > 4 || selection == null) {	// input must be 0, 1, 2, 3 or 4
						System.out.println("Your selection is not an option and cannot be null.");
						keyboardInput.nextLine();	// discard input
					}
				}
				catch (InputMismatchException exception) {
					exception.printStackTrace();	// TEST
					System.out.println("Your selection must be one of the following numbers:\n"
							+ "1, 2, 3, 4 or 0 (no other characters or spaces allowed).");
					keyboardInput.nextLine();	// discard input
				}	// end try catch
				System.out.println("End of content in do while loop ends");	// TEST
			} while (selection < 0 || selection > 4 || selection == null);
		} while (true);	// always show menu after execution of switch
	}	// end getSelection method

	

	
//	/** option 3 */
//	private static void showInstructions() {
//		System.out.println("Instructions:\n"
//				+ "1. Select an option from the menu.\n"
//				+ "2. Enter the message you want to encipher or decipher.\n"
//				+ "3. Enter the cipher key.\n"
//				+ "4. The application will display\n"
//				+ "\tthe cipher key,\n"
//				+ "\tthe cipher square,\n"
//				+ "\tthe original message\n"
//				+ "\tthe enciphered or deciphered message.");
//	}	// end showInstructions method
	

	/** valid input processing */
	private static String getInput(String whichInput) {	// get and clean key and message
		String validInput = null;
		do {
			try {
				validInput = keyboardInput.nextLine().trim().replaceAll("[^a-zA-Z]", "").toUpperCase();	// clean input
				// eliminate non-letters (numbers, punctuation, spaces)
				System.out.println(whichInput + " is: " + validInput);	// TEST
				if (validInput == null || validInput == "") {
					System.out.println("Your " + whichInput + " must contain letters. Enter your " + whichInput + " again: ");
					validInput = null;
				}
			}
			catch (NoSuchElementException exception2) {
				exception2.printStackTrace();
				System.out.println("Your " + whichInput + " must contain letters. Enter your " + whichInput + " again: ");
				validInput = null;
			}	// end try catch
		} while (validInput == null);	// end do while loop
		
		return validInput;
	}	// end getInput method
	

	

//	private static boolean linearSearch(char[] squareCharacters, char alphabetCharacter) {
//		for (int i = 0; i < squareCharacters.length; i++)
//			if (alphabetCharacter == squareCharacters[i])
//				return true;
//		return false;
//	}	// end linearSearch method
	
	
	
}	// CyF class


