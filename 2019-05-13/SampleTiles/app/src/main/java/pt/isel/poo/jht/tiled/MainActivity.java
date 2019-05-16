package pt.isel.poo.jht.tiled;

import androidx.appcompat.app.AppCompatActivity;
import pt.isel.poo.tile.OnTileTouchListener;
import pt.isel.poo.tile.Tile;
import pt.isel.poo.tile.TilePanel;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnTileTouchListener {

    private Paint paint = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TilePanel panel = (TilePanel) findViewById(R.id.panel);

        panel.setSize(7, 7);

        panel.setListener(new OnTileTouchListener() {
            @Override
            public boolean onClick(int xTile, int yTile) {
                Object me = this;
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onDrag(int xFrom, int yFrom, int xTo, int yTo) {
                return false;
            }

            @Override
            public void onDragEnd(int x, int y) {

            }

            @Override
            public void onDragCancel() {

            }
        });

        paint.setColor(getResources().getColor(android.R.color.holo_red_dark));

        for (int r = 0; r < panel.getHeightInTiles(); ++r) {
            for (int c = 0; c < panel.getWidthInTiles(); ++c) {
                final boolean isRed = ((r+c) % 2 == 1);
                panel.setTile(c, r, new Tile() {

                    @Override
                    public void draw(Canvas canvas, int side) {
                        if (isRed) {
                            canvas.drawRect(0f, 0f, side, side, paint);
                        }
                    }

                    @Override
                    public boolean setSelect(boolean selected) {
                        return false;
                    }
                });
            }
        }
    }

    @Override
    public boolean onClick(int xTile, int yTile) {
        Toast.makeText(this, "CLICK(" + xTile + ", " + yTile + ")", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onDrag(int xFrom, int yFrom, int xTo, int yTo) {
        return false;
    }

    @Override
    public void onDragEnd(int x, int y) {

    }

    @Override
    public void onDragCancel() {

    }
}
