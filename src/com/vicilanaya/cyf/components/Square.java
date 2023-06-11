package com.vicilanaya.cyf.components;

import static com.vicilanaya.cyf.utils.ConstantsLibrary.ALPHABET;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Square {

	private static final int NUMBER_OF_CELLS = 25; // 5 x 5 grid
	private char[] cipherKey = null;
	private Set<Cell> cellsSet = null;

	public Square(char[] newCipherKey) {
		setCipherKey(newCipherKey);
		setCellsSet();
	}

	public char[] getCipherKey() {
		return cipherKey;
	}

	public void setCipherKey(char[] newCipherKey) {
		this.cipherKey = newCipherKey;
	}

	public Set<Cell> getCellsSet() {
		return cellsSet;
	}

	public void setCellsSet() {

		cellsSet = new LinkedHashSet<>(NUMBER_OF_CELLS);

		if (this.cipherKey == null) {
			// default cells set for key-less square
			addCellsToCellsSet(ALPHABET);
		} else {
			// cells set for keyed square
			char[] allCharacters = new char[this.cipherKey.length + ALPHABET.length];

			// System.arraycopy(sourceArray, srcPos, targetArray, tarPos, length);
			System.arraycopy(this.cipherKey, 0, allCharacters, 0, this.cipherKey.length);
			System.arraycopy(ALPHABET, 0, allCharacters, this.cipherKey.length, ALPHABET.length);

			addCellsToCellsSet(allCharacters);
		}
	}

	private void addCellsToCellsSet(char[] charsForNewCells) {
		// characters only
		for (int i = 0; i < charsForNewCells.length; i++) {
			this.cellsSet.add(new Cell(0, 0, 0, charsForNewCells[i]));
		}

		// positions, rows, columns
		int i = 0, row = 0, column = 0;
		for (Cell cell : this.cellsSet) {
			if (column == 5) { // row is full
				column = 0; // reset column number
				row++;
			}
			cell.setPosition(i);
			cell.setRow(row);
			cell.setColumn(column);
			i++;
			column++;
		}
	} // end addCellsToCellsSet method

	public void printSquare() {
		// TODO
	}

	@Override
	public String toString() {
		return "Square [cipherKey=" + Arrays.toString(cipherKey) + ", cellsSet=" + cellsSet + "]";
	}

	public static void main(String[] args) {
		Square defaultSquare = new Square(null);
		System.out.println(defaultSquare.toString());

		Square customSquare = new Square("FLORENCE".toCharArray());
		System.out.println(customSquare.toString());
		
		defaultSquare.printSquare();
		customSquare.printSquare();

		// sample output
//		Square [cipherKey=null, cellsSet=[
//		Cell [position=0, character=A, row=0, column=0], 
//		Cell [position=1, character=B, row=0, column=1], 
//		Cell [position=2, character=C, row=0, column=2], 
//		Cell [position=3, character=D, row=0, column=3], 
//		Cell [position=4, character=E, row=0, column=4], 
//		Cell [position=5, character=F, row=1, column=0], 
//		Cell [position=6, character=G, row=1, column=1], 
//		Cell [position=7, character=H, row=1, column=2], 
//		Cell [position=8, character=?, row=1, column=3], 
//		Cell [position=9, character=K, row=1, column=4], 
//		Cell [position=10, character=L, row=2, column=0], 
//		Cell [position=11, character=M, row=2, column=1], 
//		Cell [position=12, character=N, row=2, column=2], 
//		Cell [position=13, character=O, row=2, column=3], 
//		Cell [position=14, character=P, row=2, column=4], 
//		Cell [position=15, character=Q, row=3, column=0], 
//		Cell [position=16, character=R, row=3, column=1], 
//		Cell [position=17, character=S, row=3, column=2], 
//		Cell [position=18, character=T, row=3, column=3], 
//		Cell [position=19, character=U, row=3, column=4], 
//		Cell [position=20, character=V, row=4, column=0], 
//		Cell [position=21, character=W, row=4, column=1], 
//		Cell [position=22, character=X, row=4, column=2], 
//		Cell [position=23, character=Y, row=4, column=3], 
//		Cell [position=24, character=Z, row=4, column=4]]]
//		Square [cipherKey=[F, L, O, R, E, N, C, E], cellsSet=[
//		Cell [position=0, character=F, row=0, column=0], 
//		Cell [position=1, character=L, row=0, column=1], 
//		Cell [position=2, character=O, row=0, column=2], 
//		Cell [position=3, character=R, row=0, column=3], 
//		Cell [position=4, character=E, row=0, column=4], 
//		Cell [position=5, character=N, row=1, column=0], 
//		Cell [position=6, character=C, row=1, column=1], 
//		Cell [position=7, character=A, row=1, column=2], 
//		Cell [position=8, character=B, row=1, column=3], 
//		Cell [position=9, character=D, row=1, column=4], 
//		Cell [position=10, character=G, row=2, column=0], 
//		Cell [position=11, character=H, row=2, column=1], 
//		Cell [position=12, character=?, row=2, column=2], 
//		Cell [position=13, character=K, row=2, column=3], 
//		Cell [position=14, character=M, row=2, column=4], 
//		Cell [position=15, character=P, row=3, column=0], 
//		Cell [position=16, character=Q, row=3, column=1], 
//		Cell [position=17, character=S, row=3, column=2], 
//		Cell [position=18, character=T, row=3, column=3], 
//		Cell [position=19, character=U, row=3, column=4], 
//		Cell [position=20, character=V, row=4, column=0], 
//		Cell [position=21, character=W, row=4, column=1], 
//		Cell [position=22, character=X, row=4, column=2], 
//		Cell [position=23, character=Y, row=4, column=3], 
//		Cell [position=24, character=Z, row=4, column=4]]]
	}

} // end Square class