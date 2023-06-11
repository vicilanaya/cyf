package com.vicilanaya.cyf.utils;

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

} // end KeyProcessor class
