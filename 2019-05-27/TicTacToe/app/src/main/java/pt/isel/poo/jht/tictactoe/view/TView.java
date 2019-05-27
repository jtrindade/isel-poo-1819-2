package pt.isel.poo.jht.tictactoe.view;

import pt.isel.poo.jht.tictactoe.model.Player;
import pt.isel.poo.jht.tictactoe.model.CellValue;

public abstract class TView {

	protected static final int SIZE = 3;

	protected final CellValue board[][] = new CellValue[][] {
		new CellValue[] { CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY },
		new CellValue[] { CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY },
		new CellValue[] { CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY }
	};
	
	private TViewListener viewListener = null;
	
	public void setViewListener(TViewListener viewListener) {
		this.viewListener = viewListener;
	}

	public void clearCells() {
		for (int r = 0; r < SIZE; ++r)
			for (int c = 0; c < SIZE; ++c)
				clearCell(r, c);
	}

	public abstract void requestPlayFor(Player player);

	public void showNewPlay(CellValue value, int col, int row) {
		// TO DO: validar
		board[col][row] = value;
	}

	public abstract void showGameOver();

	public void close() { }

	protected void clearCell(int r, int c) {
		board[c][r] = CellValue.EMPTY;
	}

	protected void play(Player player, int cellCol, int cellRow) {
		if (viewListener != null) {
			viewListener.onNewPlayRequest(player, cellCol, cellRow);
		}
	}
}
