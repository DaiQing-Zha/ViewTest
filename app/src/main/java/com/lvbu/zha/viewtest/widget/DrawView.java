package com.lvbu.zha.viewtest.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by DaiQing.Zha on 2016/12/20 0020.
 */
public class DrawView extends View {

    private GradientDrawable gradientDrawable;

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private static final int[] SHADOWS_COLORS = new int[] { 0x88ff0000, 0x00ffffff, 0x8800ff00 };
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Paint paint = new Paint();
//        paint.setColor(Color.parseColor("#00FF00"));
//        RectF rectF = new RectF(0,0,500,500);
//        canvas.drawArc(rectF,0,90,false,paint);
        canvas.translate(200,200);
        gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP,SHADOWS_COLORS);
        gradientDrawable.setBounds(0,0,250,250);
        gradientDrawable.setShape(GradientDrawable.OVAL);
        gradientDrawable.draw(canvas);
    }
}
