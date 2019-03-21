package test.model;

import model.*;

import test.Tests;
import static test.Tests.check;
import static test.Tests.fail;

public class ModelTests {
	
	public static void runAllTests() {
		//try {
			gameShouldNotStartWithGameOver();
			firstPlayerIsX();
			playerShouldAlternateAfterEachPlay();
			cannotPlayOnNonEmptyCell();
			threeXInARowShouldTerminateTheGame();
		//} catch (IllegalArgumentException ex) {
			//System.out.println("Exception caught at runAllTests" + ex);
		//}
	}
	
	private static void gameShouldNotStartWithGameOver() {
		final Model model = new Model();
		
		final boolean isGameOver = model.isGameOver();
		
		check(isGameOver == false, "Model.gameShouldNotStartWithGameOver", "Game should not start with Game Over"); 
	}
	
	private static void firstPlayerIsX() {
		final Model model = new Model();
		
		final Player firstPlayer = model.getCurrentPlayer();
		
		check(firstPlayer.getCellValue() == CellValue.X, "Model.firstPlayerIsX", "First player should be X"); 
	}
	
	private static void playerShouldAlternateAfterEachPlay() {
		final Model model = new Model();
		
		final Player firstPlayer = model.getCurrentPlayer();
		model.newPlayRequest(firstPlayer, 0, 0);
		final Player secondPlayer = model.getCurrentPlayer();
		
		check(secondPlayer.getCellValue() == CellValue.O, "Model.playerShouldAlternateAfterEachPlay", "After X plays, the current player should be O"); 
	}
	
	private static void cannotPlayOnNonEmptyCell() {
		final Model model = new Model();
		
		final Player firstPlayer = model.getCurrentPlayer();
		model.newPlayRequest(firstPlayer, 0, 0);

		final Player secondPlayer = model.getCurrentPlayer();
		//try {
			model.newPlayRequest(secondPlayer, 0, 0);
			
			fail("Model.cannotPlayOnNonEmptyCell", "Playing on a non-empty cell is illegal");
		//} catch (IllegalArgumentException exception) {
			// expected behaviour
		//}
	}
	
	private static void threeXInARowShouldTerminateTheGame() {
		final Model model = new Model();

		final Player xPlayer = model.getCurrentPlayer();
		model.newPlayRequest(xPlayer, 0, 0);
		final Player oPlayer = model.getCurrentPlayer();
		model.newPlayRequest(oPlayer, 0, 1);
		model.newPlayRequest(xPlayer, 1, 0);
		model.newPlayRequest(oPlayer, 1, 1);
		model.newPlayRequest(xPlayer, 2, 0);
		
		final boolean isGameOver = model.isGameOver();
		
		check(isGameOver == true, "Model.threeXInARowShouldTerminateTheGame", "Three X in row 0 should terminate the game"); 		
	}
}
