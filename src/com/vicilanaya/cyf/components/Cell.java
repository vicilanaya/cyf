package com.vicilanaya.cyf.components;

import java.util.Objects;

public class Cell implements Cloneable, Comparable<Cell> {

	private int position;
	private int row;
	private int column;
	private char character;
	public static final int DEFAULT_POSITION = 0;
	public static final int DEFAULT_ROW = 0;
	public static final int DEFAULT_COLUMN = 0;
	public static final char DEFAULT_CHARACTER = '\u0000';

	public Cell() {
		this(DEFAULT_POSITION, DEFAULT_ROW, DEFAULT_COLUMN, DEFAULT_CHARACTER);
	}

	public Cell(int position, int row, int column, char character) {
		this.position = DEFAULT_POSITION;
		this.row = DEFAULT_ROW;
		this.column = DEFAULT_COLUMN;
		this.character = DEFAULT_CHARACTER;
		setPosition(position);
		setRow(row);
		setColumn(column);
		setCharacter(character);
	}

	public int getPosition() {
		return position;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char newCharacter) {
		this.character = newCharacter;
	}

	public void setRow(int newRow) {
		this.row = newRow;
	}

	public void setColumn(int newColumn) {
		this.column = newColumn;
	}

	public void setPosition(int newPosition) {
		this.position = newPosition;
	}

	@Override
	public int compareTo(Cell cell) {
//		return this.position - cell.position;
		if (this.position > cell.position)
			return 1;
		else if (this.position < cell.position)
			return -1;
		else
			return 0;
	}

	@Override
	public int hashCode() {
//		return Objects.hash(character, column, position, row);//original
		return Objects.hash(character);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (((Character) this.character).hashCode() == obj.hashCode())
			return true;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		return this.character == other.character;

		// original
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Cell other = (Cell) obj;
//		return character == other.character && column == other.column && position == other.position && row == other.row;
	}

	public String printCell() {
		return character + "";
	}

	@Override
	public String toString() {
		return "\nCell [position=" + position + ", character=" + character + ", row=" + row + ", column=" + column
				+ "]";
	}

	public static void main(String[] args) {
		Cell defaultCell = new Cell();
		System.out.println(defaultCell.toString());

		Cell customCell = new Cell(7, 7, 7, 'F');
		System.out.println(customCell.toString());

		// sample output
//		Cell [position=0, character=, row=0, column=0]
//		Cell [position=7, character=F, row=7, column=7]
	}

} // end Cell class
