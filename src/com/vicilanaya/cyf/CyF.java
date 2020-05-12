/**
 * 
 */
package com.vicilanaya.cyf;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Florence Vicil Anaya vicilanaya@gmail.com
 *
 */
public class CyF {

	/**
	 * @param args
	 */
	
	static char[] squareCharacters = new char[25];
	static ArrayList<Cell> square  = new ArrayList<>();
	
	public static void main(String[] args) {
		
		/** get input */
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your message: ");
		String key = input.nextLine().trim();
		System.out.println("key is: " + key);	// TEST
		System.out.println("Enter your key (Only letters will be used.): ");
		String message = input.nextLine().trim();
		System.out.println("message is: " + message);	// TEST
		input.close();
		System.out.println("input closed");	// TEST
		
		/** prep square elements */
		System.out.print("squareCharacters is: ");	// TEST
		System.out.println(squareCharacters);	// TEST
		prepKeyAlphabet(key);

		/** build square */
		buildSquare(squareCharacters);	// CONTINUE HERE
		
		
		/** display square */
		
		
		
		/** process message */
		
		
		
		/** display enciphered message */
		
		
		
		
	}	// end main method

	private static void prepKeyAlphabet(String key) {
		char[] alphabet = {'A','B','C','D','E','F','G','H','I','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		System.out.println("alphabet is: ");// TEST
		System.out.println(alphabet);	// TEST
		
		String preppedKey = prepInput(key);
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
			}
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

	
	private static String prepInput(String input) {
		
		String result = null;
		// .toUpperCase()
		// strip string of punctuation, spaces, duplicates
		// copy numbers
		// replace IJ
		
		return result;
		
	}	// end prepInput method
	
	
	private static ArrayList<Cell> buildSquare(char[] squareCharacters) {	// CONTINUE HERE
		int row = 1;
		int column = 1;
		int index = 0;
		for (char character : squareCharacters) {
			square.add(new Cell(character, row, column, index));
		
		}	// end for loop
		
		
		return null;
	}	// end buildSquare method
	
	
	boolean isSameRow() {
		return true;
	}
	
	boolean isSameColumn() {
		return true;
	}	
	
	boolean isDuplicate() {
		return true;
	}
}	// CyF class



class Cell implements Comparable<Cell>{
	
	char character = '\u0000';	// keyCharacters[0]
	int row = 1;
	int column = 1;
	int index = 0;
//	char characterDisplayed;	// cubeCharacters[0]	// not needed
	
	Cell(char character, int row, int column, int index) {
		this.character = character;
		this.row = row;
		this.column = column;
		this.index = index;
	}	// end constructor

	@Override
	public int compareTo(Cell cell) {
		return index - cell.index;
	}
	@Override
	public String toString() {
		return character + "";
	}
//	@Override
//	public String toString() {	// default toString
//		return "Cell [character=" + character + ", row=" + row + ", column=" + column + ", index=" + index + "]";
//	}
	

}// end Cell class

