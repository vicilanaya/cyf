package com.vicilanaya.cyf.processors;

public class InputProcessor {
	private static String inputCipherKey = null;
	private static String preparedCipherKey = null;


	public static String getInputCipherKey() {
		return inputCipherKey;
	}

	public static void setInputCipherKey(String input) {
		InputProcessor.inputCipherKey = input;
	}

	public static String getPreparedCipherKey() {
		return preparedCipherKey;
	}

	public static void setPreparedCipherKey() {
		preparedCipherKey = prepareCipherKey(inputCipherKey);
	}

	public static String validateInput(String input) {
		// TODO needed?
		return null;
	}
	
	public static String prepareCipherKey(String inputCipherKey) {
		// TODO delete duplicates?
		// TODO convert to array?
		// TODO eliminate non ALPHABET characters
		return inputCipherKey;
	}
	
	
//	/** square processing */
//	private static void prepKeyAlphabet(String validKey) {
//		char[] alphabet = {'A','B','C','D','E','F','G','H',IJx,'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
//		System.out.print("alphabet is: ");// TEST
//		System.out.println(alphabet);	// TEST
//		
//		String preppedKey = stripDuplicates(validKey);
//		System.out.println("prepped key is: " + preppedKey);	// TEST
//		
//		int i;	// count key character elements
//		for (i = 0; i < preppedKey.length(); i++) {	// adding key characters to squareCharacters array
//			squareCharacters[i] = preppedKey.charAt(i);	// converting input string to char array
//		}	// end for loop
//		System.out.print("squareCharacters array after adding key is: ");	// TEST
//		System.out.println(squareCharacters);	// TEST
//		
//		for (int j = i, characterIndex = 0; j < squareCharacters.length; ) {	// completing squareCharacters array with alphabet
//			if (!linearSearch(squareCharacters, alphabet[characterIndex])) {	// alphabet character not found in squareCharacters
//				System.out.println("alphabet character " + alphabet[characterIndex] + "not found in squareCharacter array");	// TEST
//				squareCharacters[j] = alphabet[characterIndex];	// completing squareCharacters array by adding alphabet
//				System.out.println("alphabet character " + alphabet[characterIndex] + "added to squareCharacter array");	// TEST
//				characterIndex++;
//				j++;
//				System.out.println("character is: " + characterIndex);	// TEST
//				System.out.println("j is: " + j);	// TEST
//			}
//			else {
//				System.out.println("alphabet character " + characterIndex + "already in squareCharacter array");	// TEST
//				characterIndex++;
//				System.out.println("character is: " + characterIndex);	// TEST
//				System.out.println("j is: " + j);	// TEST
//			}	// end if else
//		}	// end for loop
//		System.out.print("squareCharacters array after adding alphabet is: ");	// TEST
//		System.out.println(squareCharacters);	// TEST
//	}	// end prepKeyAlphabet method
	

} // end KeyProcessor class
