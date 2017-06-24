package com.lvbu.zha.viewtest.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by DaiQing.Zha on 2017/6/23 0023.
 * 模仿51talk客户端多屏ViewGroup
 * http://blog.csdn.net/jwzhangjie/article/details/38894379
 */
public class Imitate51MCViewGroup extends ViewGroup{

    private static final int SNAP_VELOCITY = 600; //x轴速度基值，大于该值则进行移动
    private VelocityTracker mVelocityTracker;
    private Scroller mScroller;
    private int mCurrScreen;
    private int mDefaultScreen = 0;
    private int mLastMotionX;
    private int mDeltaX;

    public Imitate51MCViewGroup(Context context) {
        super(context);
        initViewGroup();
    }

    public Imitate51MCViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViewGroup();
    }

    public Imitate51MCViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViewGroup();
    }

    private void initViewGroup(){
        mScroller = new Scroller(getContext());
        mCurrScreen = mDefaultScreen;
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()){
            scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            postInvalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int childCounts = getChildCount();
        for (int i = 0; i < childCounts; i ++){
            View view = getChildAt(i);
            measureChild(view,widthMeasureSpec,heightMeasureSpec);
            view.measure(widthMeasureSpec,heightMeasureSpec);
        }
        scrollTo(mCurrScreen * width,0);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int marginLeft = 0;
        int childCounts = getChildCount();
        for (int i = 0; i < childCounts; i ++){
            View view = getChildAt(i);
            if (view.getVisibility() != View.GONE){
                int width = view.getMeasuredWidth();
                view.layout(marginLeft,0,marginLeft + width,view.getMeasuredHeight());
                marginLeft = marginLeft + width;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return super.onTouchEvent(event);
    }
}
