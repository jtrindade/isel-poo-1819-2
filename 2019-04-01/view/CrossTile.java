package view;

import isel.leic.pg.Console;

public class CrossTile extends CellTile {
    @Override
    public void paint() {
        Console.color(Console.WHITE, Console.GREEN);
        for (int i = 1; i < SIDE - 1; ++i) {
            print(i, i, "X");
            print(i, SIDE - 1 - i, "X");
        }
    }
}
