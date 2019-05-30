package pt.isel.poo.jht.tictactoe.ctrl;

import pt.isel.poo.jht.tictactoe.model.CellValue;
import pt.isel.poo.jht.tictactoe.model.Model;
import pt.isel.poo.jht.tictactoe.model.ModelListener;
import pt.isel.poo.jht.tictactoe.model.Player;
import pt.isel.poo.jht.tictactoe.view.TView;
import pt.isel.poo.jht.tictactoe.view.TViewListener;

public class Ctrl implements TViewListener, ModelListener {
	private final Model model;
	private final TView  view;
	
	public Ctrl(Model model, TView view) {
		this.model = model;
		this.view = view;
	}
	
	public void start() {
		model.setModelListener(this);
		view.setViewListener(this);

		//view.clearCells();
		for (int c = 0; c < 3; ++c) {
			for (int r = 0; r < 3; ++r) {
				view.setCellValue(c, r, model.getCellValue(c, r));
			}
		}
		view.showCount(model.getCounter());

		if (model.isGameOver()) {
			view.showGameOver();
		} else {
			view.requestPlayFor(model.getCurrentPlayer());
		}
	}
	
	public void onNewPlayRequest(Player player, int col, int row) {
		model.newPlayRequest(player, col, row);
		if (!model.isGameOver()) {
			view.requestPlayFor(model.getCurrentPlayer());
		} else {
			view.showGameOver();
			view.close();
		}
	}
	
	public void onNewPlay(CellValue value, int col, int row) {
		view.showNewPlay(value, col, row);
		view.showCount(model.getCounter());
	}
}
