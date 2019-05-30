package pt.isel.poo.jht.tictactoe.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import pt.isel.poo.tile.Tile;

class CircleTile implements Tile {

    private static final Paint paint = new Paint();

    static {
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void draw(Canvas canvas, int side) {
        canvas.drawCircle(side/2,side/2,side/2, paint);
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}
