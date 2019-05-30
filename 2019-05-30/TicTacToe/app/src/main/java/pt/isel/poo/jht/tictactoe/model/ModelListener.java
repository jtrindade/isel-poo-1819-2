package pt.isel.poo.jht.tictactoe.model;


public interface ModelListener {
	
	void onNewPlay(CellValue value, int col, int row);
	
}