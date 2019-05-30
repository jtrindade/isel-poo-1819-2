package pt.isel.poo.jht.tictactoe.view;

import pt.isel.poo.jht.tictactoe.model.Player;

public interface TViewListener {
	
	void onNewPlayRequest(Player player, int col, int row);
	
}
