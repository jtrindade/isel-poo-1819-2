package model;

public class Player {
	private final CellValue value;
	
	public Player(CellValue value) {
		this.value = value;
	}
	
	public CellValue getCellValue() {
		return value;
	}
}
