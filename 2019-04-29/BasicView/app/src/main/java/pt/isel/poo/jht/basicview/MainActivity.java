package pt.isel.poo.jht.basicview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

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

        redLine.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final float x = event.getX();
                final float y = event.getY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Toast.makeText(MainActivity.this, "DOWN (" + x + ", " + y + ")", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Toast.makeText(MainActivity.this, "MOVE (" + x + ", " + y + ")", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_UP:
                        Toast.makeText(MainActivity.this, "UP (" + x + ", " + y + ")", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        try {
            final FileOutputStream outputStream =
                    this.openFileOutput("fich.txt", MODE_PRIVATE);

            final PrintStream printStream
                    = new PrintStream(outputStream);

            printStream.println("Hello world!");
            printStream.print(2019);
            printStream.print(' ');
            printStream.println("ISEL");
            printStream.println("упйпангйупангуа");

        } catch (FileNotFoundException ex) {
            Toast.makeText(this, "File not found.", Toast.LENGTH_SHORT).show();
        }

        try {
            final FileInputStream inputStream =
                    this.openFileInput("fich.txt");

            final InputStreamReader reader =
                    new InputStreamReader(inputStream);

            final BufferedReader lineReader =
                    new BufferedReader(reader);

            Toast.makeText(this, lineReader.readLine(), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, lineReader.readLine(), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, lineReader.readLine(), Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException ex) {
            Toast.makeText(this, "File not found for reading.", Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {
            Toast.makeText(this, "Failed to read file.", Toast.LENGTH_SHORT).show();
        }
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
