package pt.isel.poo.jht.tictactoe.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import pt.isel.poo.tile.Tile;

class CrossTile implements Tile {

    private static final Paint paint = new Paint();

    static {
        paint.setColor(Color.RED);
    }

    @Override
    public void draw(Canvas canvas, int side) {
        canvas.drawLine(0f, 0f, side, side, paint);
        canvas.drawLine(side, 0f, 0, side, paint);
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}
