package com.vicilanaya.cyf.utils;


public class EncipherProcessor extends MessageProcessor {
	
	public static void encipher() {
		
	}
	
	
//	/** message processing */
//	private static void encipheringMessage(String validMessage) {	// CONTINUE HERE
//		ArrayList<Character> b = prepMessage(validMessage);	// prepped message
//		
//		char char0 = '\u0000';	// Character pair in message
//		char char1 = '\u0000';
//		int index0 = 0;
//		int index1 = 0;
//		Cell cell0 = null;	// Cell pair in square
//		Cell cell1 = null;
//		for (int i = 0, j = 0; i < b.size(); ) {
//			char0 = b.get(i);	// get Character pair in b
//			char1 = b.get(j);
//			index0 = square.indexOf(new Cell(char0));	// find index of character in square	char0.toString().charAt(0)
//			index1 = square.indexOf(new Cell (char1));	// WILL THIS WORK?
//			cell0 = square.get(index0);	// get Cell pair in square
//			cell1 = square.get(index1);
//			
//			if (isSameRow(cell0, cell1)) {
//				cell0.getCellNumber();
//				cell1.getCellNumber();
//			}
//			if (isSameColumn(cell0, cell1)) {
//				
//			}
//			else {	// different row and different column
//				
//			}
//		}	// end for loop
////		b.indexOf(character);
//		
//		// switch characters = calculate new cellNumbers
//		// get characters from new cellNumbers
//		// add new pair to preEncipheredMessage
//		// group in 5 + space
//		// return enciphered message
//		// replace IJ
//	}	// end encipheringMessage method
	
	
//	private static void encipher() {
//		System.out.print("Enter the message you want to encipher: ");
//		validMessage = getInput("message");
//		System.out.print("Enter your key (Shorter is better.): ");
//		validKey = getInput("key");
//		keyboardInput.close();
//		System.out.println("keyboardInput closed");	// TEST
//		
//		System.out.print("Prepping square elements");	// TEST
//		prepKeyAlphabet(validKey);
//		System.out.println("Square elements prepped\n");	// TEST
//
//		System.out.println("Building square");	// TEST
//		buildSquare(squareCharacters);
//		System.out.println("Square built\n");	// TEST
//
//		System.out.println("Printing square");	// TEST
//		printSquare(square, originalKey);
//		System.out.println("Square printed\n");	// TEST
//
//		System.out.println("Processing deciphered message");	// TEST
//		encipheringMessage(validMessage);
//		System.out.println("Deciphered message processed = message enciphered\n");	// TEST
//
//		System.out.println("Printing enciphered message");	// TEST
//		printEncipheredMessage(originalMessage, encipheredMessage);
//		System.out.println("Enciphered message printed\n");	// TEST
//	}	// end encipher method
	
	
//	private static void printEncipheredMessage(String originalMessage, String encipheredMessage) {
//		System.out.println("The original message is: ");
//		System.out.println(originalMessage);
//		System.out.println("The enciphered message is: ");
//		System.out.println(encipheredMessage);
//	}	// end printEncipheredMessage method

} // end EncipherProcessor class
