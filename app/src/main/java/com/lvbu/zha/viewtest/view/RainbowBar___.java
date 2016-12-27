package com.lvbu.zha.viewtest.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.lvbu.zha.viewtest.R;
import com.lvbu.zha.viewtest.utils.Util;

/**
 * Created by DaiQing.Zha on 2016/9/7 0007.
 */
public class RainbowBar___ extends View {

    private int barColor = Color.parseColor("#FF0000");
    private int hSpace = Util.dpToPx(getResources(),80);
    private int vSpace = Util.dpToPx(getResources(),4);
    private int space = Util.dpToPx(getResources(),10);
    private float startX = 0;
    private float delta = 10f;
    Paint mPaint;

    public RainbowBar___(Context context) {
        super(context);
    }

    public RainbowBar___(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public RainbowBar___(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.rainbowbar,0,0);
        hSpace = typedArray.getDimensionPixelSize(R.styleable.rainbowbar_rainbowbar_hspace,hSpace);
        vSpace = typedArray.getDimensionPixelSize(R.styleable.rainbowbar_rainbowbar_vspace,vSpace);
        barColor = typedArray.getColor(R.styleable.rainbowbar_rainbowbar_color,barColor);
        typedArray.recycle();
        mPaint = new Paint();
        mPaint.setColor(barColor);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(vSpace);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float sw = this.getMeasuredWidth();
        if (startX >= sw + (hSpace + space) - (sw % (hSpace + space))) {

            startX = 0;
        }else{

            startX += delta;
        }
        float start = startX;
//        canvas.drawLine(start,5,start + hSpace,5,mPaint);
//        start += (hSpace + space);
        while (start < sw){

            canvas.drawLine(start,5,start + hSpace,5,mPaint);
            start += (hSpace + space);
        }
//        start = startX - hSpace - space;
//        canvas.drawLine(start,5,start + hSpace,5,mPaint);
//        start -= (hSpace + space);
//        invalidate();
        invalidate();
    }
}
