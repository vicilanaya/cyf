package com.vicilanaya.cyf.components;

public class Cell implements Cloneable, Comparable<Cell> {

	private char character;
	private int row;
	private int column;
	private int cellNumber;
	public static final char DEFAULT_CHARACTER = '\u0000';
	public static final int DEFAULT_ROW = 0;
	public static final int DEFAULT_COLUMN = 0;
	public static final int DEFAULT_CELL_NUMBER = 0;

	public Cell(char character, int row, int column, int cellNumber) {
		this.character = DEFAULT_CHARACTER;
		this.row = DEFAULT_ROW;
		this.column = DEFAULT_COLUMN;
		this.cellNumber = DEFAULT_CELL_NUMBER;
		setCharacter(character);
		setRow(row);
		setColumn(column);
		setCellNumber(cellNumber);
	}

	public Cell() {
		this(DEFAULT_CHARACTER, DEFAULT_ROW, DEFAULT_COLUMN, DEFAULT_CELL_NUMBER);
	}

	public Cell(char character) {
		this(character, DEFAULT_ROW, DEFAULT_COLUMN, DEFAULT_CELL_NUMBER);
	}

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
//		return cellNumber - cell.cellNumber;
		if (cellNumber > cell.cellNumber)
			return 1;
		else if (cellNumber < cell.cellNumber)
			return -1;
		else
			return 0;
	}

	@Override
	public Object clone() { // DO I NEED THIS?
		try {
			return super.clone();
		} catch (CloneNotSupportedException exception7) {
			exception7.printStackTrace();
			return null;
		}
	} // end clone method

	public String printCharacter() {
		if (character == 'I' || character == 'J') // DO I NEED THIS?
			return '\u0132' + ""; // IJ
		return character + "";
	}

	@Override
	public String toString() {
//		return "Cell [character=" + character + ", row=" + row + ", column=" + column + ", cellNumber=" + cellNumber + "]";	// default toString
		return "Cell " + cellNumber + " [character=" + character + ", row=" + row + ", column=" + column + "]";
	}

} // end Cell class
