package pt.isel.poo.jht.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtValue;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("sample", "Main/onCreate");

        count = 0;
        edtValue = (EditText) findViewById(R.id.edtValue);
        // final Button butGo = (Button) findViewById(R.id.butGo);

        /*
        butGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edtValue.getText().toString();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
            }
        });
        */


    }

    public void onGo(View view) {
        /*
        String text = "" + count++ + ": " + edtValue.getText().toString();
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
        */
        String text = edtValue.getText().toString();
        if (text.startsWith("http")) {
            Uri uri = Uri.parse(text);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else if (text.equals("about")) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("sample", "Main/onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("sample", "Main/onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("sample", "Main/onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("sample", "Main/onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("sample", "Main/onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("sample", "Main/onSaveInstanceState");
        outState.putInt("counter", count);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("sample", "Main/onRestoreInstanceState");
        count = savedInstanceState.getInt("counter");
    }
}
