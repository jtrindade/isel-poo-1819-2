package ctrl;

import model.CellValue;
import model.Model;
import model.ModelListener;
import model.Player;
import view.View;
import view.ViewListener;

public class Ctrl implements ViewListener, ModelListener {
	private final Model model;
	private final View  view;
	
	public Ctrl(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void run() {
		model.setModelListener(this);
		view.setViewListener(this);

		view.clearCells();
		while (!model.isGameOver()) {
			view.requestPlayFor(model.getCurrentPlayer());
		}
		view.showGameOver();

		view.close();
	}
	
	public void onNewPlayRequest(Player player, int col, int row) {
		model.newPlayRequest(player, col, row);
	}
	
	public void onNewPlay(CellValue value, int col, int row) {
		view.showNewPlay(value, col, row);
	}
}
