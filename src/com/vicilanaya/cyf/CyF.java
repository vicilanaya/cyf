/**
 * This application enciphers and deciphers a message 
 * provided by the user by using a user-defined key.
 * The user receives the enciphered or deciphered message 
 * and the cipher square created from the key.
 */
package com.vicilanaya.cyf;

import java.util.ArrayList;
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

	static Scanner input = new Scanner(System.in);
	static String message = null;
	static String key = null;
	static final char IJ = '\u0132';
	static char[] squareCharacters = new char[25];
	static ArrayList<Cell> square  = new ArrayList<>();
	static String encipheredMessage = null;
	static String decipheredMessage = null;
	
	public static void main(String[] args) {
		
		System.out.println("Showing intro");	// TEST
		showIntro();
		System.out.println("Intro shown");	// TEST
		
		/** obtain input */
		System.out.println("Routing selection");	// TEST
		router(getSelection());
		
		System.out.print("Thank you for using CyF. You may restart the program.");
		System.exit(0);
		
	}	// end main method
	
	private static void showIntro() {
		System.out.println("*******Welcome to CyF*******"
				+ "CyF is a cryptographic engine created by Florence Vicil Anaya. (Copyright 2020)\n"
				+ "This application enciphers and deciphers messages by using a key. You receive\n" 
				+ "the enciphered or deciphered message and the cipher square created from the key.\n");
		System.out.println("This engine is currently limited to processing the following characters:\n"
				+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ.");
		System.out.println("Numbers, punctuation, and symbols will be ignored.\n"
				+ "The characters I and J will be treated as equals.");
	}	// end intro method
	
	private static String showMenu() {
		return "Choose your option:\n"
				+ "1 - Encipher a message\n"
				+ "2 - Decipher a message\n"
				+ "3 - Show history\n"
				+ "0 - Exit application\n";
	}	// end showMenu method
	

	private static int getSelection() {	// THROW invalid input EXCEPTION
		int selection = 0;
		do {
			showMenu();
			System.out.print("Your selection: ");
			selection = input.nextInt();
			if (selection < 0 || selection > 2) {
				System.out.print("Your selection is not an option.");
			}
		} while (selection < 0 || selection > 3);
		return selection;
	}	// end getOption method
	
	private static void router(int selection) {
		System.out.println("Switch started");	// TEST
		switch (selection) {
		case 0: System.out.print("Thank you for using CyF. You may restart the program.");
				System.exit(1);
		case 1: encipher(); break;
		case 2: decipher(); break;
		case 3: showHistory(); break;
		}	// end switch
		System.out.println("Switch ended");	// TEST
	}	// end router method
	
	private static void encipher() {
		System.out.print("Enter the message you want to encipher: ");
		message = input.nextLine().trim();
		System.out.println("message is: " + message);	// TEST
		System.out.print("Enter your key (Shorter is better.): ");
		key = input.nextLine().trim();
		System.out.println("key is: " + key);	// TEST
		input.close();
		System.out.println("input closed");	// TEST

		System.out.print("Prepping square elements");	// TEST
		prepKeyAlphabet(key);
		System.out.println("Square elements prepped\n");	// TEST

		System.out.println("Building square");	// TEST
		buildSquare(squareCharacters);
		System.out.println("Square built\n");	// TEST

		System.out.println("Printing square");	// TEST
		printSquare(square, key);
		System.out.println("Square printed\n");	// TEST

		System.out.println("Processing deciphered message");	// TEST
		encipheringMessage(message);
		System.out.println("Deciphered message processed = message enciphered\n");	// TEST

		System.out.println("Printing enciphered message");	// TEST
		printEncipheredMessage(message, encipheredMessage);
		System.out.println("Enciphered message printed\n");	// TEST
		
	}	// end encipher method
	
	private static void decipher() {	// CONTINUE HERE
		System.out.print("Enter the message you want to decipher: ");
		message = input.nextLine().trim();
		System.out.println("message is: " + message);	// TEST
		System.out.print("Enter your key (Shorter is better.): ");
		key = input.nextLine().trim();
		System.out.println("key is: " + key);	// TEST
		input.close();
		System.out.println("input closed\n");	// TEST
		
		System.out.println("Building square");	// TEST
		buildSquare(squareCharacters);
		System.out.println("Square built\n");	// TEST

		System.out.println("Printing square");	// TEST
		printSquare(square, key);
		System.out.println("Square printed\n");	// TEST
		
		System.out.println("Processing enciphered message");	// TEST
		decipheringMessage();	// CONTINUE HERE arguments
		System.out.println("Enciphered message processed = message deciphered\n");	// TEST
		
		System.out.println("Printing deciphered message");	// TEST
		printDecipheredMessage();	// CONTINUE HERE arguments
		System.out.println("Deciphered message printed\n");	// TEST
		
	}	// end decipher method
	
	private static void showHistory() {
		System.out.println("History of this project:\n\n"
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

	private static void prepKeyAlphabet(String key) {
		char[] alphabet = {'A','B','C','D','E','F','G','H',IJ,'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		System.out.print("alphabet is: ");// TEST
		System.out.println(alphabet);	// TEST
		
		String semiPreppedKey = prepInput1(key);
		String preppedKey = stripDuplicates(semiPreppedKey);
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
	

	private static String prepInput1(String input) {	// CONTINUE HERE
		
		String result = null;
		result = input.toUpperCase();
		// strip string of numbers, punctuation, spaces
		// replace IJ
		
		return result;
		
	}	// end prepInput method
	
	
	private static String stripDuplicates(String key) {	// CONTINUE HERE
		
		// strip duplicates
		
		return key;
	}	// end stripDuplicates method
	
	
	private static void buildSquare(char[] squareCharacters) {
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
	
	
	private static void printSquare(ArrayList<Cell> square, String key) {
		System.out.println("Your key: " + key);
		System.out.println("Your crypto square:");
		square.forEach(e -> {
			System.out.print(" " + e.printCharacter() + " ");
			if (e.getCellNumber() % 5 == 0) {	// go to next line if cellNumber is multiple of 5
				System.out.print("\n");
			}
		});	// end lambda expression
	}	// end printSquare method
	
	
	private static void encipheringMessage(String message) {	// CONTINUE HERE
		ArrayList<Character> b = prepInput2(message);
		
		
		// pair characters
		// switch characters
		// replace IJ
		// group in 5 + space
	}	// end encipheringMessage method
	
	
	private static void decipheringMessage() {	// CONTINUE HERE
		
	}	// end decipheringMessage method
	
	
	private static ArrayList<Character> prepInput2(String input) {
		char[] a = prepInput1(input).toCharArray();
		char alternate = 'Z';
		
		ArrayList<Character> b = new ArrayList<>();
		for (char character : a) {
			b.add(character);
		}	// end for each loop
		
		/* complete pairs */
		b.trimToSize();
		if (b.size() % 2 != 0) {	// if size is not even number
			if (b.get(b.size() - 1) == alternate) {	// use A as alternate if the duplicates equal Z
				alternate = 'A';
			}
			b.add(alternate);	// complete pair of last character by adding alternate
			alternate = 'Z';	// reset alternate to Z
		}
		System.out.println("b.size() = even number is " + (b.size() % 2 == 0));	// TEST
		
		/* eliminate pairs of duplicates */
		for (int i = 0, j = 1; i < b.size(); ) {
			if (b.get(i) == b.get(j)) {	// split duplicates
				if (b.get(i) == alternate) {	// use A as alternate if the duplicates equal Z
					alternate = 'A';
				}
				b.add(j, alternate);	// insert Z if duplicate character is Z
				b.add(j + 2, alternate);
				i = i + 4;	// skip split pair and alternates, go to next pair
				j = i + 1;
				alternate = 'Z';	// reset alternate to Z
			}
			else {	// no duplicates
				i = i + 2;	// go to next pair
				j = j + 2;
			}	// end if else
		}	// end for loop
		
		return b;
	}	// end prepInput2 method
	
	
//	private static boolean isSameCharacter(Character character1, Character character2) {
//		if (character1 == character2)
//			return true;
//		return false;
//	}
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

	private static void printEncipheredMessage(String message, String encipheredMessage) {
		System.out.println("The original message is: ");
		System.out.println(message);
		System.out.println("The enciphered message is: ");
		System.out.println(encipheredMessage);
	}	// end printEncipheredMessage method
	
	
	private static void printDecipheredMessage() {	// CONTINUE HERE
		
	}	// end printDecipheredMessage method
		
}	// CyF class



class Cell {
//	class Cell implements Comparable<Cell>{
	
	private char character = '\u0000';
	private int row = 1;
	private int column = 1;
	private int cellNumber = 1;
	
	Cell(char character, int row, int column, int cellNumber) {
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

//	@Override
//	public int compareTo(Cell cell) {
//		return cellNumber - cell.cellNumber;
//	}
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

