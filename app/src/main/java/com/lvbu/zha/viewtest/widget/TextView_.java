package com.lvbu.zha.viewtest.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by DaiQing.Zha on 2016/12/30 0030.
 */
public class TextView_ extends View {

    private Paint paint;
    private int num = 0;
    private String text = "";
    private float mXLastMove,mYLastMove;
    private float mXMove,mYMove;
    public TextView_(Context context) {
        super(context);

    }

    public TextView_(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.parseColor("#ffffff"));
        paint.setTextSize(40);
        paint.setStrokeWidth(3);
        paint.setAntiAlias(true);
    }

    public TextView_(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect bounds = new Rect();
        text = "I love you " + num;
        paint.getTextBounds(text,0,text.length(),bounds);
        canvas.drawText(text,getMeasuredWidth() / 2 - bounds.width() / 2,getMeasuredHeight() / 2 + bounds.height() / 2,paint);
        Log.e("mainVBN","XStart = " + (getMeasuredWidth() / 2 - bounds.width()) / 2 + " YStart = " + (getMeasuredHeight() / 2 + bounds.height() / 2) + " height = " + getMeasuredHeight());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int wSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int wSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int hSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int hSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (wSpecMode == MeasureSpec.AT_MOST && hSpecMode == MeasureSpec.AT_MOST){

            setMeasuredDimension(300,300);
        }
        if (wSpecMode == MeasureSpec.AT_MOST){

            setMeasuredDimension(300,hSpecSize);
        }
        if (hSpecMode == MeasureSpec.AT_MOST){

            setMeasuredDimension(wSpecSize,300);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mXMove = event.getRawX();
                mYMove = event.getRawY();
                mXLastMove = mXMove;
                mYLastMove = mYMove;
               break;
            case MotionEvent.ACTION_MOVE:
                mXMove = event.getRawX();
                mYMove = event.getRawY();
                break;
            case MotionEvent.ACTION_UP:

                if (Math.abs(mXMove - mXLastMove) - Math.abs(mYMove - mYLastMove) > 0 && Math.abs(mXMove - mXLastMove) > 50){

                    num ++;
                }
                if (Math.abs(mYMove - mYLastMove) - Math.abs(mXMove - mXLastMove) > 0 && Math.abs(mYMove - mYLastMove) > 50){

                    num --;
                }
                invalidate();
                break;
        }
        return true;
    }
}
