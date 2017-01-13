package com.lvbu.zha.viewtest.event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.lvbu.zha.viewtest.R;

/**
 * Created by DaiQing.Zha on 2017/1/13 0013.
 */
public class EventActivity extends AppCompatActivity {

    private GestureDetector gestureDetector;    //手势检测
    private OnSlideGestureListener onSlideGestureListener;    //左右手势滑动检测监听器
    private CustomLinearLayout ll_view;
    /**
     * 左右手势滑动监听器
     */
    private class OnSlideGestureListener implements GestureDetector.OnGestureListener{
        @Override
        public boolean onDown(MotionEvent e) {
            Log.e("even","---eActivity onDown---");

            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            Log.e("even","---eActivity onShowPress---");

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.e("even","---eActivity onSingleTapUp---");
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.e("even","---eActivity onScroll---");
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.e("even","---eActivity onLongPress---");
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.e("event","---eActivity onFling---");
            Toast.makeText(EventActivity.this,"Fling",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ll_view = (CustomLinearLayout) findViewById(R.id.ll_view);
        onSlideGestureListener = new OnSlideGestureListener();
        gestureDetector = new GestureDetector(this,onSlideGestureListener);
        ll_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EventActivity.this,"Click Button",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("event","---eActivity dispatchTouchEvent---");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("event","---eActivity onTouchEvent---");
        return gestureDetector.onTouchEvent(event);
    }
}
