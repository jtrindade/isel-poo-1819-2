package view;

import model.CellValue;
import model.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandLineView extends View {
    private final Scanner scanner = new Scanner(System.in);

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
                play(player, cellCol, cellRow);
            }
        } catch (InputMismatchException e) {
            System.out.println("   ERROR: Invalid input.");
            scanner.nextLine();
        }
    }

    public void showNewPlay(CellValue value, int col, int row) {
        super.showNewPlay(value, col, row);
        printBoard();
    }

    public void showGameOver() {
        System.out.println(".:: GAME OVER ::.");
    }

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
