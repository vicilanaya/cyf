package com.vicilanaya.cyf.utils;

import java.util.ArrayList;

import com.vicilanaya.cyf.components.Cell;

public class MessageProcessor {

	
	
	
	private static boolean isSameRow(Cell cell0, Cell cell1) {
		if (cell0.getRow() == cell1.getRow())
			return true;
		return false;
	}
	
	private static boolean isSameColumn(Cell cell0, Cell cell1) {
		if (cell0.getColumn() == cell1.getColumn())
			return true;
		return false;
	}
	
	
//	private static ArrayList<Character> prepMessage(String validMessage) {
//		char[] a = validMessage.toCharArray();
//		char alternate = 'Z';
//		
//		ArrayList<Character> b = new ArrayList<>();	// this is returned
//		for (char character : a) {
//			b.add(character);
//		}	// end for each loop
//		
//		/* complete last pair */
//		b.trimToSize();
//		if (b.size() % 2 != 0) {	// if size is not even number
//			if (b.get(b.size() - 1) == alternate) {	// use X as alternate if character equals Z
//				alternate = 'X';
//			}
//			b.add(alternate);	// complete last pair by adding alternate
//			alternate = 'Z';	// reset alternate to Z
//		}
//		System.out.println("b.size() = even number is " + (b.size() % 2 == 0));	// TEST
//		
//		/* eliminate pairs of duplicates */
//		for (int i = 0, j = 1; i < b.size(); ) {
//			if (b.get(i) == b.get(j)) {	// split duplicates
//				if (b.get(i) == alternate) {	// use X as alternate if the duplicates equal Z
//					alternate = 'X';
//				}
//				b.add(j, alternate);	// insert Z if duplicate character is Z
//				b.add(j + 2, alternate);
//				i = i + 4;	// skip new split pair and alternates, go to next pair
//				j = i + 1;
//				alternate = 'Z';	// reset alternate to Z
//			}
//			else {	// no duplicates
//				i = i + 2;	// go to next pair
//				j = j + 2;
//			}	// end if else
//		}	// end for loop
//		
//		return b;	// ArrayList<Character> prepped message ready to be enciphered/deciphered
//	}	// end prepMessage method
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
