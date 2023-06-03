/**
 * This application enciphers and deciphers a message by using a key.
 * The user receives the enciphered or deciphered message 
 * and the cipher square created from the key.
 */
package com.vicilanaya.cyf;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.vicilanaya.cyf.components.Cell;


/**
 * @author Florence Vicil Anaya Copyright 2020 vicilanaya@gmail.com
 *
 */
public class CyF extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */

	static final char IJx = '\u0132';
	static Cell A = new Cell('A');
	static Cell B = new Cell('B');
	static Cell C = new Cell('C');
	static Cell D = new Cell('D');
	static Cell E = new Cell('E');
	static Cell F = new Cell('F');
	static Cell G = new Cell('G');
	static Cell H = new Cell('H');
	static Cell IJ = new Cell(IJx);
	static Cell K = new Cell('K');
	static Cell L = new Cell('L');
	static Cell M = new Cell('M');
	static Cell N = new Cell('N');
	static Cell O = new Cell('O');
	static Cell P = new Cell('P');
	static Cell Q = new Cell('Q');
	static Cell R = new Cell('R');
	static Cell S = new Cell('S');
	static Cell T = new Cell('T');
	static Cell U = new Cell('U');
	static Cell V = new Cell('V');
	static Cell W = new Cell('W');
	static Cell X = new Cell('X');
	static Cell Y = new Cell('Y');
	static Cell Z = new Cell('Z');
	static ArrayList<Cell> defaultSquare  = new ArrayList<>();
			
	static Scanner keyboardInput = new Scanner(System.in);
	static String originalMessage = null;
	static String originalKey = null;
	static String validMessage = null;
	static String validKey = null;
	static char[] squareCharacters = new char[25];
	static ArrayList<Cell> square  = new ArrayList<>();
	static String encipheredMessage = null;
	static String decipheredMessage = null;
	
	public static void main(String[] args) {
		
		System.out.println("Building defaultSquare");	// TEST
		buildDefaultSquare(A,B,C,D,E,F,G,H,IJ,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z);
		System.out.println("defaultSquare built");	// TEST
		
		System.out.println("Showing intro");	// TEST
		showIntro();
		System.out.println("Intro shown");	// TEST

		System.out.println("Getting selection started");	// TEST
		getSelection();
		
	}	// end main method
	
	/** in main method */
	private static void buildDefaultSquare(Cell...cells) {
		for (Cell element : cells)
			defaultSquare.add(element);
	}	// end buildDefaultSquare method

	private static String showIntro() {
		return "*******Welcome to CyF*******\n"
				+ "CyF is a cryptographic engine created by Florence Vicil Anaya. (Copyright 2020)\n"
				+ "This application enciphers and deciphers messages by using a key. You receive\n" 
				+ "the enciphered or deciphered message and the cipher square created from the key.\n"
				+ "This engine is currently limited to processing the following characters:\n"
				+ "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.\n"
				+ "Numbers, punctuation, and symbols will be ignored.\n"
				+ "The characters I and J will be treated as equals.\n";
	}	// end showIntro method
	
	private static String showMenu() {
		return "Choose your option:\n"
				+ "1 - Encipher a message\n"
				+ "2 - Decipher a message\n"
				+ "3 - Show history\n"
				+ "0 - Exit application\n";
	}	// end showMenu method
	
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
			
			System.out.println("Switch started");	// TEST
			switch (selection) {
			case 0: System.out.print("Thank you for using CyF. You may restart the program.");
					System.exit(1);
			case 1: encipher(); break;
			case 2: decipher(); break;
			case 3: showInstructions(); break;
			case 4: showHistory(); break;
			}	// end switch
			System.out.println("Switch ended");	// TEST
			System.out.println("End of content in while loop");	// TEST
		} while (true);	// always show menu after execution of switch
	}	// end getSelection method
	
	/** option 1 */
	private static void encipher() {
		System.out.print("Enter the message you want to encipher: ");
		validMessage = getInput("message");
		System.out.print("Enter your key (Shorter is better.): ");
		validKey = getInput("key");
		keyboardInput.close();
		System.out.println("keyboardInput closed");	// TEST
		
		System.out.print("Prepping square elements");	// TEST
		prepKeyAlphabet(validKey);
		System.out.println("Square elements prepped\n");	// TEST

		System.out.println("Building square");	// TEST
		buildSquare(squareCharacters);
		System.out.println("Square built\n");	// TEST

		System.out.println("Printing square");	// TEST
		printSquare(square, originalKey);
		System.out.println("Square printed\n");	// TEST

		System.out.println("Processing deciphered message");	// TEST
		encipheringMessage(validMessage);
		System.out.println("Deciphered message processed = message enciphered\n");	// TEST

		System.out.println("Printing enciphered message");	// TEST
		printEncipheredMessage(originalMessage, encipheredMessage);
		System.out.println("Enciphered message printed\n");	// TEST
	}	// end encipher method
	
	/** option 2 */
	private static void decipher() {
		System.out.print("Enter the message you want to decipher: ");
		validMessage = getInput("message");
		System.out.print("Enter your key (Shorter is better.): ");
		validKey = getInput("key");
		keyboardInput.close();
		System.out.println("keyboardInput closed");	// TEST
		
		System.out.print("Prepping square elements");	// TEST
		prepKeyAlphabet(validKey);
		System.out.println("Square elements prepped\n");	// TEST
		
		System.out.println("Building square");	// TEST
		buildSquare(squareCharacters);
		System.out.println("Square built\n");	// TEST

		System.out.println("Printing square");	// TEST
		printSquare(square, originalKey);
		System.out.println("Square printed\n");	// TEST
		
		System.out.println("Processing enciphered message");	// TEST
		decipheringMessage(validMessage);
		System.out.println("Enciphered message processed = message deciphered\n");	// TEST
		
		System.out.println("Printing deciphered message");	// TEST
		printDecipheredMessage(originalMessage, decipheredMessage);
		System.out.println("Deciphered message printed\n");	// TEST
	}	// end decipher method
	
	/** option 3 */
	private static void showInstructions() {
		System.out.println("Instructions:\n"
				+ "1. Select an option from the menu.\n"
				+ "2. Enter the message you want to encipher or decipher.\n"
				+ "3. Enter the cipher key.\n"
				+ "4. The application will display\n"
				+ "\tthe cipher key,\n"
				+ "\tthe cipher square,\n"
				+ "\tthe original message\n"
				+ "\tthe enciphered or deciphered message.");
	}	// end showInstructions method
	
	/** option 4 */
	private static void showHistory() {
		System.out.println("History of the CyF project:\n"
				+ "When I was little, I used to read the Encyclopedia Britannica.\n"
				+ "I used to look stuff up about brownies, the human body,\n"
				+ "and number theory. One time I stumbled upon cryptography.\n"
				+ "Cryptography was fascinating because I learned I could create\n"
				+ "secret messages. Morethan anything, I was learning and doing\n"
				+ "no other kids my age did.\n\n"
				+ "As a programmer, I needed to create projects with the skills I\n"
				+ "was learning. The I remembered a cryptography square in the\n"
				+ "encyclopedia and how much I enjoyed working with it back then.\n\n"
				+ "This is how CyF was born.");
	}	// end showHistory method

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
	
	private static ArrayList<Character> prepMessage(String validMessage) {
		char[] a = validMessage.toCharArray();
		char alternate = 'Z';
		
		ArrayList<Character> b = new ArrayList<>();	// this is returned
		for (char character : a) {
			b.add(character);
		}	// end for each loop
		
		/* complete last pair */
		b.trimToSize();
		if (b.size() % 2 != 0) {	// if size is not even number
			if (b.get(b.size() - 1) == alternate) {	// use X as alternate if character equals Z
				alternate = 'X';
			}
			b.add(alternate);	// complete last pair by adding alternate
			alternate = 'Z';	// reset alternate to Z
		}
		System.out.println("b.size() = even number is " + (b.size() % 2 == 0));	// TEST
		
		/* eliminate pairs of duplicates */
		for (int i = 0, j = 1; i < b.size(); ) {
			if (b.get(i) == b.get(j)) {	// split duplicates
				if (b.get(i) == alternate) {	// use X as alternate if the duplicates equal Z
					alternate = 'X';
				}
				b.add(j, alternate);	// insert Z if duplicate character is Z
				b.add(j + 2, alternate);
				i = i + 4;	// skip new split pair and alternates, go to next pair
				j = i + 1;
				alternate = 'Z';	// reset alternate to Z
			}
			else {	// no duplicates
				i = i + 2;	// go to next pair
				j = j + 2;
			}	// end if else
		}	// end for loop
		
		return b;	// ArrayList<Character> prepped message ready to be enciphered/deciphered
	}	// end prepMessage method
	
	private static String stripDuplicates(String validKey) {	// CONTINUE HERE
		
		// strip duplicates
		
		return validKey;
	}	// end stripDuplicates method
	
	/** square processing */
	private static void prepKeyAlphabet(String validKey) {
		char[] alphabet = {'A','B','C','D','E','F','G','H',IJx,'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		System.out.print("alphabet is: ");// TEST
		System.out.println(alphabet);	// TEST
		
		String preppedKey = stripDuplicates(validKey);
		System.out.println("prepped key is: " + preppedKey);	// TEST
		
		int i;	// count key character elements
		for (i = 0; i < preppedKey.length(); i++) {	// adding key characters to squareCharacters array
			squareCharacters[i] = preppedKey.charAt(i);	// converting input string to char array
		}	// end for loop
		System.out.print("squareCharacters array after adding key is: ");	// TEST
		System.out.println(squareCharacters);	// TEST
		
		for (int j = i, characterIndex = 0; j < squareCharacters.length; ) {	// completing squareCharacters array with alphabet
			if (!linearSearch(squareCharacters, alphabet[characterIndex])) {	// alphabet character not found in squareCharacters
				System.out.println("alphabet character " + alphabet[characterIndex] + "not found in squareCharacter array");	// TEST
				squareCharacters[j] = alphabet[characterIndex];	// completing squareCharacters array by adding alphabet
				System.out.println("alphabet character " + alphabet[characterIndex] + "added to squareCharacter array");	// TEST
				characterIndex++;
				j++;
				System.out.println("character is: " + characterIndex);	// TEST
				System.out.println("j is: " + j);	// TEST
			}
			else {
				System.out.println("alphabet character " + characterIndex + "already in squareCharacter array");	// TEST
				characterIndex++;
				System.out.println("character is: " + characterIndex);	// TEST
				System.out.println("j is: " + j);	// TEST
			}	// end if else
		}	// end for loop
		System.out.print("squareCharacters array after adding alphabet is: ");	// TEST
		System.out.println(squareCharacters);	// TEST
	}	// end prepKeyAlphabet method
	
	private static boolean linearSearch(char[] squareCharacters, char alphabetCharacter) {
		for (int i = 0; i < squareCharacters.length; i++)
			if (alphabetCharacter == squareCharacters[i])
				return true;
		return false;
	}	// end linearSearch method
	
	private static void buildSquare(char[] squareCharacters) {
		int row = 1;
		int column = 1;
		int cellNumber = 1;
		int index = 0;
		ArrayList<Cell> tempSquare = (ArrayList<Cell>)defaultSquare.clone();	// make a copy of defaultSquare to hold unsorted cells
		System.out.println("defaultSquare cloned into tempSquare");	// TEST
		for (char character : squareCharacters) {
			index = tempSquare.indexOf(character);	// index of cell with this character
			Cell cell = tempSquare.get(index);	// cell with this index
			cell.setRow(row);
			cell.setColumn(column);
			cell.setCellNumber(cellNumber);
			System.out.println("Attributes added to cell at index " + index + ": " + cell.toString());	// TEST
			if (column % 5 == 0) {	// reset column to 1 if column is multiple of 5
				row++;
				column = 1;
				cellNumber++;
			}
			else {
				column++;
				cellNumber++;
			}	// end if else
		}	// end for loop
		
		System.out.println("Attributes added to cells in defaultSquare");	// TEST
		java.util.Collections.sort(tempSquare);
		System.out.println("tempSquare sorted");	// TEST
		square = (ArrayList<Cell>)tempSquare.clone();	// CloneNotSupportedException
		System.out.println("tempSquare cloned into square");	// TEST
		System.out.println("square built");	// TEST
			
	}	// end buildSquare method
	
	/** message processing */
	private static void encipheringMessage(String validMessage) {	// CONTINUE HERE
		ArrayList<Character> b = prepMessage(validMessage);	// prepped message
		
		char char0 = '\u0000';	// Character pair in message
		char char1 = '\u0000';
		int index0 = 0;
		int index1 = 0;
		Cell cell0 = null;	// Cell pair in square
		Cell cell1 = null;
		for (int i = 0, j = 0; i < b.size(); ) {
			char0 = b.get(i);	// get Character pair in b
			char1 = b.get(j);
			index0 = square.indexOf(new Cell(char0));	// find index of character in square	char0.toString().charAt(0)
			index1 = square.indexOf(new Cell (char1));	// WILL THIS WORK?
			cell0 = square.get(index0);	// get Cell pair in square
			cell1 = square.get(index1);
			
			if (isSameRow(cell0, cell1)) {
				cell0.getCellNumber();
				cell1.getCellNumber();
			}
			if (isSameColumn(cell0, cell1)) {
				
			}
			else {	// different row and different column
				
			}
		}	// end for loop
//		b.indexOf(character);
		
		
		
		// switch characters = calculate new cellNumbers
		// get characters from new cellNumbers
		// add new pair to preEncipheredMessage
		// group in 5 + space
		// return enciphered message
		// replace IJ
	}	// end encipheringMessage method
	
	private static void decipheringMessage(String validMessage) {	// CONTINUE HERE
		
	}	// end decipheringMessage method
	
	private static boolean isSameRow(Cell cell0, Cell cell1) {
		if (cell0.getRow() == cell1.getRow())
			return true;
		return false;
	}	// end isSameRow method
	
	private static boolean isSameColumn(Cell cell0, Cell cell1) {
		if (cell0.getColumn() == cell1.getColumn())
			return true;
		return false;
	}	// end isSameColumn method

	/** printing */
	private static void printSquare(ArrayList<Cell> square, String originalKey) {
		System.out.println("Your key: " + originalKey);
		System.out.println("Your crypto square:");
		square.forEach(e -> {
			System.out.print(" " + e.printCharacter() + " ");
			if (e.getCellNumber() % 5 == 0) {	// go to next line if cellNumber is multiple of 5
				System.out.print("\n");
			}
		});	// end lambda expression
	}	// end printSquare method
	
	private static void printEncipheredMessage(String originalMessage, String encipheredMessage) {
		System.out.println("The original message is: ");
		System.out.println(originalMessage);
		System.out.println("The enciphered message is: ");
		System.out.println(encipheredMessage);
	}	// end printEncipheredMessage method
	
	private static void printDecipheredMessage(String originalMessage, String decipheredMessage) {
		System.out.println("The original message is: ");
		System.out.println(originalMessage);
		System.out.println("The deciphered message is: ");
		System.out.println(decipheredMessage);
	}	// end printDecipheredMessage method
	
}	// CyF class


