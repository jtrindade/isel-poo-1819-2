package pt.isel.poo.jht.tictactoe.view;

import android.graphics.Canvas;

import pt.isel.poo.tile.Tile;

class CellTile implements Tile {

    @Override
    public void draw(Canvas canvas, int side) {

    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}
