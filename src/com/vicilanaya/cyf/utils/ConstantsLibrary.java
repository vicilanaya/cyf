package com.vicilanaya.cyf.utils;

public class ConstantsLibrary {

	private static final char A = 'A';
	private static final char B = 'B';
	private static final char C = 'C';
	private static final char D = 'D';
	private static final char E = 'E';
	private static final char F = 'F';
	private static final char G = 'G';
	private static final char H = 'H';
	private static final char IJ = '\u0132';
//	private static final char IJu = '\u0132';
//	private static final char IJ = IJu;
	private static final char K = 'K';
	private static final char L = 'L';
	private static final char M = 'M';
	private static final char N = 'N';
	private static final char O = 'O';
	private static final char P = 'P';
	private static final char Q = 'Q';
	private static final char R = 'R';
	private static final char S = 'S';
	private static final char T = 'T';
	private static final char U = 'U';
	private static final char V = 'V';
	private static final char W = 'W';
	private static final char X = 'X';
	private static final char Y = 'Y';
	private static final char Z = 'Z';

	public static final char[] ALPHABET = { A, B, C, D, E, F, G, H, IJ, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y,
			Z };

	private static final String INTRO = "*******Welcome to CyF*******\n"
			+ "CyF is a cryptographic engine created by Florence Vicil Anaya. (Copyright 2020)\n"
			+ "This application enciphers and deciphers messages by using a key. You receive\n"
			+ "the enciphered or deciphered message and the cipher square created from the key.\n"
			+ "This engine is currently limited to processing the following characters:\n"
			+ "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.\n"
			+ "Numbers, punctuation, and symbols will be ignored.\n"
			+ "The characters I and J will be treated as equals.\n";

	private static final String CYF_HISTORY = "History of the CyF project:\n"
			+ "When I was little, I used to read the Encyclopedia Britannica.\n"
			+ "I used to look up information about brownies, the human body,\n"
			+ "and number theory. One time I stumbled upon cryptography.\n"
			+ "Cryptography was fascinating because I learned I could create\n"
			+ "secret messages. More than anything, I was learning and doing\n" + "no other kids my age did.\n\n"
			+ "As a programmer, I needed to create projects with the skills I\n"
			+ "was learning. The I remembered a cryptography square in the\n"
			+ "encyclopedia and how much I enjoyed working with it back then.\n\n" + "This is how CyF was born.";

	public static char[] getAlphabet() {
		return ALPHABET;
	}

	public static String getIntro() {
		return INTRO;
	}

	public static String getCyfHistory() {
		return CYF_HISTORY;
	}

	public static void main(String[] args) {
		System.out.println(getAlphabet());
		System.out.println(getIntro());
		System.out.println(String.valueOf(getCyfHistory()));

		// sample output
//		ABCDEFGH?KLMNOPQRSTUVWXYZ
//		*******Welcome to CyF*******
//		CyF is a cryptographic engine created by Florence Vicil Anaya. (Copyright 2020)
//		This application enciphers and deciphers messages by using a key. You receive
//		the enciphered or deciphered message and the cipher square created from the key.
//		This engine is currently limited to processing the following characters:
//		ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.
//		Numbers, punctuation, and symbols will be ignored.
//		The characters I and J will be treated as equals.
//
//		History of the CyF project:
//		When I was little, I used to read the Encyclopedia Britannica.
//		I used to look up information about brownies, the human body,
//		and number theory. One time I stumbled upon cryptography.
//		Cryptography was fascinating because I learned I could create
//		secret messages. More than anything, I was learning and doing
//		no other kids my age did.
//
//		As a programmer, I needed to create projects with the skills I
//		was learning. The I remembered a cryptography square in the
//		encyclopedia and how much I enjoyed working with it back then.
//
//		This is how CyF was born.
	}

} // end Constants class
