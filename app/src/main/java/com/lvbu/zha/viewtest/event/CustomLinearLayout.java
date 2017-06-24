package com.lvbu.zha.viewtest.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by DaiQing.Zha on 2017/1/13 0013.
 */
public class CustomLinearLayout extends LinearLayout {

    private float lastX = 0;
    private float lastY = 0;
    private boolean intercepted;
    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        switch (ev.getAction()){

            case MotionEvent.ACTION_DOWN:
                lastX = ev.getRawX();
                lastY = ev.getRawY();
                intercepted = true;
                break;
            case MotionEvent.ACTION_MOVE:
                float currentX = ev.getRawX();
                float currentY = ev.getRawY();
                if (Math.abs(Math.abs(lastX) - Math.abs(currentX)) > 40 || Math.abs(Math.abs(lastY) - Math.abs(currentY)) > 400){
                    intercepted = false;
                }else{

                    Log.e("event","------------------------");
                    intercepted = true;
                }
                lastX = currentX;
                lastY = currentY;
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        if (!intercepted){
            Log.e("eventB","---cLine intercepted---" + intercepted);
            return intercepted;
        }else{
            Log.e("eventB","---cLine intercepted---" + intercepted);
            return super.dispatchTouchEvent(ev);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("event","---cLine onInterceptTouchEvent---");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("event","---cLine onTouchEvent---");
        return super.onTouchEvent(event);
    }
}
