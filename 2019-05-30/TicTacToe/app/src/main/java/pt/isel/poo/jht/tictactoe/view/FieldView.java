package pt.isel.poo.jht.tictactoe.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import pt.isel.poo.jht.tictactoe.R;

public class FieldView extends LinearLayout {

    private TextView label;
    private TextView value;

    public FieldView(Context context) {
        super(context);
        init(context);
    }

    public FieldView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

        final TypedArray attrsArray = context.obtainStyledAttributes(attrs, R.styleable.FieldView);
        try {

            final String labelText = attrsArray.getString(R.styleable.FieldView_label);
            if (labelText != null) {
                setLabel(labelText);
            }

            final int initialValue = attrsArray.getInt(R.styleable.FieldView_value, 0);
            setValue(initialValue);

        } finally {
            attrsArray.recycle();
        }
    }

    private void init(Context context) {
        LayoutInflater li = LayoutInflater.from(context);
        li.inflate(R.layout.field_layout, this);
        label = findViewById(R.id.label);
        value = findViewById(R.id.value);
    }

    public void setLabel(String text) {
        label.setText(text);
    }

    public void setValue(int val) {
        value.setText(Integer.toString(val));
    }
}
