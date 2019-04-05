package view;

import isel.leic.pg.Console;
import isel.poo.console.tile.Tile;

public class CellTile extends Tile {
    public static final int SIDE = 7;

    private boolean mark = false;

    @Override
    public void clear() {
        if (mark) printBox(0, 0, height, width, Console.BLUE);
        else super.clear();
    }

    public void setMark(boolean value) {
        mark = value;
        repaint();
    }

}
