package pt.isel.poo.jht.basicview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        final LinearLayout.LayoutParams redLineLayoutParams =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );

        final RedLineView redLine = new RedLineView(this);
        redLine.setLayoutParams(redLineLayoutParams);

        final LinearLayout.LayoutParams edtValueLayoutParams =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
        edtValueLayoutParams.weight = 1.0f;

        final EditText edtValue = new EditText(this);
        edtValue.setLayoutParams(edtValueLayoutParams);
        edtValue.setInputType(InputType.TYPE_CLASS_NUMBER);
        edtValue.setGravity(Gravity.END);
        edtValue.setText("0");

        final Button butMinus = new Button(this);
        butMinus.setText("DEC");
        // butMinus.setOnClickListener(new MinusClickListener(this));
        butMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "MINUS", Toast.LENGTH_LONG).show();
                value -= 1;
                edtValue.setText(Integer.toString(value));
                redLine.setOffset(value);
            }
        });

        final Button butPlus = new Button(this);
        butPlus.setText("INC");
        // butPlus.setOnClickListener(new PlusClickListener(this));
        butPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "PLUS", Toast.LENGTH_LONG).show();
                value += 1;
                edtValue.setText(Integer.toString(value));
                redLine.setOffset(value);
            }
        });

        final LinearLayout commandsLayout = new LinearLayout(this);
        commandsLayout.addView(butMinus);
        commandsLayout.addView(edtValue);
        commandsLayout.addView(butPlus);

        final LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );

        final LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(layoutParams);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(commandsLayout);
        layout.addView(redLine);

        setContentView(layout);


    }
}

/*
class MinusClickListener implements View.OnClickListener {

    private final MainActivity activity;

    public MinusClickListener(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(activity, "MINUS", Toast.LENGTH_LONG).show();
    }
}
*/

/*
class PlusClickListener implements View.OnClickListener {

    private final MainActivity activity;

    public PlusClickListener(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(activity, "PLUS", Toast.LENGTH_LONG).show();
    }
}
*/
