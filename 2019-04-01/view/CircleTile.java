package view;

import isel.leic.pg.Console;

public class CircleTile extends CellTile {
    @Override
    public void paint() {
        Console.color(Console.WHITE, Console.RED);
        for (int i = 2; i < SIDE - 2; i++) {
            print(1, i, 'O');
            print(SIDE - 2, i, 'O');
            print(i, 1, 'O');
            print(i, SIDE - 2, 'O');
        }
    }
}
