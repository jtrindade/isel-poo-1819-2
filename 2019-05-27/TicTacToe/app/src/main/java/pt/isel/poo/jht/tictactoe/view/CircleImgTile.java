package pt.isel.poo.jht.tictactoe.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import pt.isel.poo.tile.Img;
import pt.isel.poo.tile.Tile;

public class CircleImgTile implements Tile {

    private static final Paint paint = new Paint();

    private final Img img;

    public CircleImgTile(Context context, int id) {
        img = new Img(context, id);
    }

    @Override
    public void draw(Canvas canvas, int side) {
        img.draw(canvas, side, side, paint);
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}
