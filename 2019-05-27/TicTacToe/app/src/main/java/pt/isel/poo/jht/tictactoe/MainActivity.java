package pt.isel.poo.jht.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pt.isel.poo.jht.tictactoe.ctrl.Ctrl;
import pt.isel.poo.jht.tictactoe.model.Model;
import pt.isel.poo.jht.tictactoe.view.AndroidView;
import pt.isel.poo.jht.tictactoe.view.TView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Model model = new Model();
        final TView view  = new AndroidView(this);

        final Ctrl ctrl = new Ctrl(model, view);
        ctrl.start();
    }
}
