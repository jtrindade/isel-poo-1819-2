package pt.isel.poo.jht.tictactoe.view;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import pt.isel.poo.jht.tictactoe.R;
import pt.isel.poo.jht.tictactoe.model.CellValue;
import pt.isel.poo.jht.tictactoe.model.Player;
import pt.isel.poo.tile.OnTileTouchListener;
import pt.isel.poo.tile.TilePanel;

public class AndroidView extends TView {

    private final Context context;

    private final TextView txtState;
    private final TilePanel panel;

    private Player currentPlayer;

    public AndroidView(Activity activity) {
        context = activity;

        txtState = activity.findViewById(R.id.txtState);
        panel = activity.findViewById(R.id.panel);

        panel.setListener(new OnTileTouchListener() {
            @Override
            public boolean onClick(int xTile, int yTile) {
                play(currentPlayer, xTile, yTile);
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
    }

    @Override
    public void requestPlayFor(Player player) {
        currentPlayer = player;
        txtState.setText("Player " + player.getCellValue());
    }

    @Override
    public void showGameOver() {
        txtState.setText(".:: GAME OVER ::.");
    }

    @Override
    protected void clearCell(int row, int col) {
        super.clearCell(row, col);
        panel.setTile(col, row, new CellTile());
    }

    @Override
    public void showNewPlay(CellValue value, int col, int row) {
        super.showNewPlay(value, col, row);
        panel.setTile(
                col, row,
                value == CellValue.X ?
                        new CrossTile() :
                        new CircleImgTile(context, R.drawable.green_circle)
        );
    }
}
