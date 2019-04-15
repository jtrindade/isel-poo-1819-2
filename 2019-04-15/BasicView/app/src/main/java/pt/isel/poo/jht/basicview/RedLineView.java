package pt.isel.poo.jht.basicview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class RedLineView extends View {

    private final Paint paint;
    private int offset;

    public RedLineView(Context context) {
        super(context);
        offset = 0;
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < 3; ++i) {
            final float y = offset + i;
            canvas.drawLine(0f, y, getWidth() - 1, y, paint);
        }
    }

    public void setOffset(int offset) {
        this.offset = offset;
        invalidate();
    }
}
