package view;

import model.Player;

public interface ViewListener {
	
	void onNewPlayRequest(Player player, int col, int row);
	
}
