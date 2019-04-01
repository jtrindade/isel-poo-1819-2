package view;

import model.Player;
import model.CellValue;

import java.util.Scanner;
import java.util.InputMismatchException;

public class View {
	private final Scanner scanner = new Scanner(System.in);
	
	private final CellValue board[][] = new CellValue[][] {
		new CellValue[] { CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY },
		new CellValue[] { CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY },
		new CellValue[] { CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY }
	};
	
	private ViewListener viewListener = null;
	
	public void setViewListener(ViewListener viewListener) {
		this.viewListener = viewListener;
	}

	public void clearCells() { }

	public void requestPlayFor(Player player) {
		System.out.print("Next cell for " + player.getCellValue() + ": ");
		try {
			int cellCode = scanner.nextInt();
			int cellCol = (cellCode / 10) - 1;
			int cellRow = (cellCode % 10) - 1;

			if (!isValidCoordinate(cellCol) || !isValidCoordinate(cellRow)) {
				System.out.println("   ERROR: Invalid cell.");
			} else if (board[cellCol][cellRow] != CellValue.EMPTY) {
				System.out.println("   ERROR: Cell not free.");
			} else {
				System.out.println("   X requested for (" + cellCol + ", " + cellRow + ")");
				if (viewListener != null) {
					viewListener.onNewPlayRequest(player, cellCol, cellRow);
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("   ERROR: Invalid input.");
			scanner.nextLine();
		}
	}

	public void showNewPlay(CellValue value, int col, int row) {
		// TO DO: validar

		board[col][row] = value;

		printBoard();
	}

	public void showGameOver() {
		System.out.println(".:: GAME OVER ::.");
	}

	public void close() { }

	private boolean isValidCoordinate(int val) {
		return val >= 0 && val <= 2;
	}

	private void printBoard() {
		printRow(0);
		printSep();
		printRow(1);
		printSep();
		printRow(2);
	}

	private void printRow(int row) {
		System.out.println(
			"" +
			getCellChar(board[0][row]) +
			"|" +
			getCellChar(board[1][row]) +
			"|" +
			getCellChar(board[2][row])
		);
	}

	private char getCellChar(CellValue value) {
		switch (value) {
			case X:  return 'X';
 			case O:  return 'O';
			default: return ' ';
		}
	}

	private void printSep() {
		System.out.println("-+-+-");
	}
}
