/**
 * This application enciphers and deciphers a message by using a key.
 * The user receives the enciphered or deciphered message 
 * and the cipher square created from the key.
 */
package com.vicilanaya.cyf;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

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

	static Cell A = new Cell('A', 0, 0, 0);
	static Cell B = new Cell('B', 0, 0, 0);
	static Cell C = new Cell('C', 0, 0, 0);
	static Cell D = new Cell('D', 0, 0, 0);
	static Cell E = new Cell('E', 0, 0, 0);
	static Cell F = new Cell('F', 0, 0, 0);
	static Cell G = new Cell('G', 0, 0, 0);
	static Cell H = new Cell('H', 0, 0, 0);
	static Cell IJ = new Cell('\u0132', 0, 0, 0);
	static Cell K = new Cell('K', 0, 0, 0);
	static Cell L = new Cell('L', 0, 0, 0);
	static Cell M = new Cell('M', 0, 0, 0);
	static Cell N = new Cell('N', 0, 0, 0);
	static Cell O = new Cell('O', 0, 0, 0);
	static Cell P = new Cell('P', 0, 0, 0);
	static Cell Q = new Cell('Q', 0, 0, 0);
	static Cell R = new Cell('R', 0, 0, 0);
	static Cell S = new Cell('S', 0, 0, 0);
	static Cell T = new Cell('T', 0, 0, 0);
	static Cell U = new Cell('U', 0, 0, 0);
	static Cell V = new Cell('V', 0, 0, 0);
	static Cell W = new Cell('W', 0, 0, 0);
	static Cell X = new Cell('X', 0, 0, 0);
	static Cell Y = new Cell('Y', 0, 0, 0);
	static Cell Z = new Cell('Z', 0, 0, 0);
	static ArrayList<Cell> alphabetSquare  = new ArrayList<>();
			
	static Scanner keyboardInput = new Scanner(System.in);
	static String originalMessage = null;
	static String originalKey = null;
	static String validMessage = null;
	static String validKey = null;
	static final char IJx = '\u0132';
	static char[] squareCharacters = new char[25];
	static ArrayList<Cell> square  = new ArrayList<>();
	static String encipheredMessage = null;
	static String decipheredMessage = null;
	
	public static void main(String[] args) {
		
		System.out.println("Building alphabetSquare");	// TEST
		alphabetSquare.add(A);
		alphabetSquare.add(B);
		alphabetSquare.add(C);
		alphabetSquare.add(D);
		alphabetSquare.add(E);
		alphabetSquare.add(F);
		alphabetSquare.add(G);
		alphabetSquare.add(H);
		alphabetSquare.add(IJ);
		alphabetSquare.add(K);
		alphabetSquare.add(L);
		alphabetSquare.add(M);
		alphabetSquare.add(N);
		alphabetSquare.add(O);
		alphabetSquare.add(P);
		alphabetSquare.add(Q);
		alphabetSquare.add(R);
		alphabetSquare.add(S);
		alphabetSquare.add(T);
		alphabetSquare.add(U);
		alphabetSquare.add(V);
		alphabetSquare.add(W);
		alphabetSquare.add(X);
		alphabetSquare.add(Y);
		alphabetSquare.add(Z);
		System.out.println("alphabetSquare built");	// TEST
		
		System.out.println("Showing intro");	// TEST
		showIntro();
		System.out.println("Intro shown");	// TEST

		System.out.println("Getting selection started");	// TEST
		getSelection();
		
	}	// end main method
	

	/** in main method */
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
	
	private static String showMenu() {
		return "Choose your option:\n"
				+ "1 - Encipher a message\n"
				+ "2 - Decipher a message\n"
				+ "3 - Show history\n"
				+ "0 - Exit application\n";
	}	// end showMenu method
	
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
	
	private static ArrayList<Character> prepMessage(String validMessage) {	// for message
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
	
	private static void buildSquare(char[] squareCharacters) {	// FIX LOGIC
		int row = 1;
		int column = 1;
		int cellNumber = 1;
		int index = 0;
		for (char character : squareCharacters) {
			square.add(new Cell(character, row, column, cellNumber));
			System.out.println("built cell " + square.get(index).getCellNumber()  + " with character " + square.get(index).getCharacter() 
					+ " in row " + square.get(index).getRow() + " and column " + square.get(index).getColumn());	// TEST
			if (column % 5 == 0) {	// reset column to 1 if column is multiple of 5
				row++;
				column = 1;
				cellNumber++;
				index++;
			}
			else {
				column++;
				cellNumber++;
				index++;
			}	// end if else
		}	// end for loop
		System.out.println("square built");	// TEST
	}	// end buildSquare method
	
	/** message processing */
	private static void encipheringMessage(String validMessage) {	// CONTINUE HERE	// FIX LOGIC
//		ArrayList<Character> b = new ArrayList<>();
//		b = prepMessage(validMessage);
		ArrayList<Character> b = prepMessage(validMessage);	// prepped message
//		ArrayList<Character> c = new ArrayList<>();
//		char[] temp = new char[2];
		for (int fromIndex = 0, toIndex = 1; fromIndex < b.size(); ) {
			List<Character> subList = b.subList(fromIndex, toIndex);	// sublist of each pair
			int x = square.indexOf(subList.get(0));
			int y = square.indexOf(subList.get(0));
			int m = square.indexOf(subList.get(0));
			int n = square.indexOf(subList.get(0));
		}	// end for loop
		
		// set row, column, cellNumber of Cells in alphabetSquare
		// copy alphabetSquare to square
		// sort square by cellNumber
		
		// get character pair in b
		// find character pair in square
		// isSameRow, isSameColumn
		// switch characters = calculate new cellNumbers
		// get characters from new cellNumbers
		// add new pair to preEncipheredMessage
		// group in 5 + space
		// return enciphered message
		// replace IJ
	}	// end encipheringMessage method
	
	private static void decipheringMessage(String validMessage) {	// CONTINUE HERE
		
	}	// end decipheringMessage method
	
	private static boolean isSameRow(Cell cell1, Cell cell2) {
		if (cell1.getRow() == cell2.getRow())
			return true;
		return false;
	}	// end isSameRow method
	
	private static boolean isSameColumn(Cell cell1, Cell cell2) {
		if (cell1.getColumn() == cell2.getColumn())
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


/** OBJECT CLASS */
//class Cell {
class Cell implements Comparable<Cell>{
	
	private char character = '\u0000';
	private int row = 1;
	private int column = 1;
	private int cellNumber = 1;
	
	Cell(char character, int row, int column, int cellNumber) {	// fix constructor with default values
		this.character = character;
		this.row = row;
		this.column = column;
		this.cellNumber = cellNumber;
	}	// end constructor

	public char getCharacter() {
		return character;
	}
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	public int getCellNumber() {
		return cellNumber;
	}
	public void setCharacter(char character) {
		this.character = character;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public void setCellNumber(int cellNumber) {
		this.cellNumber = cellNumber;
	}

	@Override
	public int compareTo(Cell cell) {
		return cellNumber - cell.cellNumber;
	}
	public String printCharacter() {
		if (character == 'I' || character == 'J')	// CHECK IF THIS IS NEEDED
			return '\u0132' + "";	// IJ
		return character + "";
	}
	@Override
	public String toString() {
//		return "Cell [character=" + character + ", row=" + row + ", column=" + column + ", cellNumber=" + cellNumber + "]";	// default toString
		return "Cell " + cellNumber + " [character=" + character + ", row=" + row + ", column=" + column + "]";
	}

}	// end Cell class
