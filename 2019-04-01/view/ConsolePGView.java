package view;

import isel.leic.pg.Console;
import isel.poo.console.Window;
import isel.poo.console.tile.TilePanel;
import model.CellValue;
import model.Player;

public class ConsolePGView extends View {

    private static final int SIZE = 3;

    private static final int BOARD_SIZE = SIZE * CellTile.SIDE;

    private static final int BOARD_SPACE = BOARD_SIZE + 2;

    private static final int WINDOW_HEIGHT = BOARD_SPACE;
    private static final int WINDOW_WIDTH = BOARD_SPACE;

    private final Window window =
            new Window(
                    "Galo",
                    WINDOW_HEIGHT, 
                    WINDOW_WIDTH
            );

    private final TilePanel view =
            new TilePanel(SIZE, SIZE, CellTile.SIDE);   // View of cells

    public ConsolePGView() {
        view.center(BOARD_SPACE, BOARD_SPACE);
    }

    public void clearCells() {
        for (int r = 0; r < SIZE; ++r)
            for (int c = 0; c < SIZE; ++c)
                view.setTile(r, c, new CellTile());
    }

    public void requestPlayFor(Player player) {
        window.state("Player " + player.getCellValue());
        super.requestPlayFor(player);
    }

    public void showNewPlay(CellValue value, int col, int row) {
        view.setTile(
                row, col,
                value == CellValue.X ?
                        new CrossTile() :
                        new CircleTile()
        );
        super.showNewPlay(value, col, row);
    }

    public void showGameOver() {
        super.showGameOver();
        window.state(".:: GAME OVER ::.");
        Console.sleep(3000);
    }

    public void close() {
        window.close();
    }
}
