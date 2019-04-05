package view;

import isel.leic.pg.Console;
import isel.poo.console.Window;
import isel.poo.console.tile.TilePanel;
import model.CellValue;
import model.Player;

import static java.awt.event.KeyEvent.*;

public class ConsolePGView extends View {

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

    private int lin, col;
    private boolean marked = false;

    public ConsolePGView() {
        view.center(BOARD_SPACE, BOARD_SPACE);
    }

    @Override
    public void clearCells() {
        super.clearCells();
        lin = col = (SIZE - 1) / 2;
    }

    public void requestPlayFor(Player player) {
        window.state("Player " + player.getCellValue());

        marked = !marked;

        CellTile curTile = (CellTile)view.getTile(lin, col);
        curTile.setMark(marked);

        int key = Console.waitKeyPressed(100);

        if (key == Console.NO_KEY) {
            Console.sleep(100);
        } else {
            Console.waitKeyReleased(key);
            switch (key) {
                case VK_DOWN:   if (lin < SIZE - 1) ++lin; unmarkTile(curTile); break;
                case VK_UP:     if (lin > 0)        --lin; unmarkTile(curTile); break;
                case VK_RIGHT:  if (col < SIZE - 1) ++col; unmarkTile(curTile); break;
                case VK_LEFT:   if (col > 0)        --col; unmarkTile(curTile); break;
                case VK_ENTER:
                case VK_SPACE:  play(player, col, lin); break;
            }
        }
    }

    public void showNewPlay(CellValue value, int col, int row) {
        super.showNewPlay(value, col, row);
        view.setTile(
                row, col,
                value == CellValue.X ?
                        new CrossTile() :
                        new CircleTile()
        );
    }

    public void showGameOver() {
        window.state(".:: GAME OVER ::.");
        Console.sleep(3000);
    }

    public void close() {
        window.close();
    }

    protected void clearCell(int row, int col) {
        super.clearCell(row, col);
        view.setTile(row, col, new CellTile());
    }

    private void unmarkTile(CellTile tile) {
        marked = false;
        tile.setMark(marked);
    }
}
