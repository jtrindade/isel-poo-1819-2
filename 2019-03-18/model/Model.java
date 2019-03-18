package model;

public class Model {
	private static final int MAX_PLAYS = 9;
	
	private final Player players[] = new Player[] { 
		new Player(CellValue.X),
		new Player(CellValue.O)
	};
	
	private final CellValue board[][] = new CellValue[][] {
		new CellValue[] { CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY },
		new CellValue[] { CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY },
		new CellValue[] { CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY }
	};
	
	private boolean gameOver = false;
	
	private int playCounter = 0;
	
	private int currentPlayerIndex = 0;
	
	private ModelListener modelListener = null;
	
	public void setModelListener(ModelListener modelListener) {
		this.modelListener = modelListener;
	}
	
	public boolean isGameOver() {
		return gameOver;
	} 
	
	public Player getCurrentPlayer() {
		return players[currentPlayerIndex];
	}
	
	public void newPlayRequest(Player player, int col, int row) {
		if (player != getCurrentPlayer()) {
			throw new IllegalArgumentException("Incorrect player");
		}
		if (board[col][row] != CellValue.EMPTY) {
			throw new IllegalArgumentException("Trying to play on a non-empty cell.");
		}

		board[col][row] = player.getCellValue();
		if (modelListener != null) {
			modelListener.onNewPlay(board[col][row], col, row);
		}

		// TO DO : Validar se ha vitoria de um dos jogadores

		playCounter += 1;
		if (playCounter == MAX_PLAYS) {
			gameOver = true;
		}
		
		currentPlayerIndex ^= 1;
	}
}
