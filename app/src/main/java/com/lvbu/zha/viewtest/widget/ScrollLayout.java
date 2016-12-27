package com.lvbu.zha.viewtest.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by DaiQing.Zha on 2016/12/13 0013.
 */
public class ScrollLayout extends ViewGroup {

    /**
     * 用于完成滚动操作的实例
     */
    private Scroller mScroller;
    /**
     * 判定为拖动的最小移动像素
     */
    private int mTouchSlop;
    /**
     * 手机按下时的屏幕坐标
     */
    private float mXDown;
    /**
     * 手机当时所处的屏幕坐标
     */
    private float mXMove;
    /**
     * 上次触发ACTION_MOVE事件时的X坐标
     */
    private float mXLastMove;
    /**
     * 界面可滚动的左坐标
     */
    private int mLeftBorder;
    /**
     * 界面可滚动的右坐标
     */
    private int mRightBorder;
    public ScrollLayout(Context context, AttributeSet attrs) {
        super(context,attrs);
        mScroller = new Scroller(context);  //创建scroll实例
        ViewConfiguration configuration = ViewConfiguration.get(context);
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);   //获取touchSlop的值
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int childCount = getChildCount();
        Log.e("mainScrollView","widthMeasureSpec = " + widthMeasureSpec + " heightMeasureSpec = " + heightMeasureSpec + " childCount = " + childCount + " mTouchSlop = " + mTouchSlop);
        for (int i = 0;i < childCount; i ++){

            View child = getChildAt(i);
            measureChild(child,widthMeasureSpec,heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        if (changed){

            int childCount = getChildCount();
            for (int i = 0; i < childCount; i ++){

                View childView = getChildAt(i);
                childView.layout(i * childView.getMeasuredWidth(),0,(i + 1) * childView.getMeasuredWidth(),childView.getMeasuredHeight());
                Log.e("mainScrollView","childView.getMeasureWidth() = " + childView.getMeasuredWidth() + " childView.getMeasuredHeight() = " + childView.getMeasuredHeight());
            }
            mLeftBorder = getChildAt(0).getLeft();
            mRightBorder = getChildAt(getChildCount() - 1).getRight();
            Log.e("mainScrollView","mLeftBorder = " + mLeftBorder + " mRightBorder = " + mRightBorder);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){

            case MotionEvent.ACTION_DOWN:
                mXDown = ev.getRawX();
                Log.e("mainScrollView","down -------------------------" + mXDown);
                mXLastMove = mXDown;
                break;
            case MotionEvent.ACTION_MOVE:
                mXMove = ev.getRawX();
                Log.e("mainScrollView","move -------------------------" + mXMove);
                float diff = Math.abs(mXMove - mXDown);
                mXLastMove = mXMove;
                if (diff > mTouchSlop){

                    Log.e("mainScrollView","move -------------------------" + "mXMove = " + mXMove + " diff = " + diff);
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction()){

            case MotionEvent.ACTION_MOVE:

                mXMove = event.getRawX();
                int scrolledX = (int) (mXLastMove - mXMove);
                Log.e("mainScrollView","getScrollX() = " + getScrollX() + " scrolledX = " + scrolledX);

                if (getScrollX() + scrolledX < mLeftBorder){
                    Log.e("mainScrollView","===================");
                    scrollTo(mLeftBorder,0);
                    return true;
                }else if (getScrollX() + scrolledX + getWidth() > mRightBorder){
                    scrollTo(mRightBorder - getWidth(),0);
                    return true;
                }
                scrollBy(scrolledX,0);
                mXLastMove = mXMove;
                break;
            case MotionEvent.ACTION_UP:
                int targetIndex = (getScrollX() + getWidth() / 2) / getWidth();
                int dx = getWidth() * targetIndex - getScrollX();
                mScroller.startScroll(getScrollX(),0,dx,0);
                invalidate();
                break;

        }
        return super.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        //重写 computeScroll()方法，在其内部完成平滑滚动逻辑
        if (mScroller.computeScrollOffset()){
            scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e("mainVBN","----------------------");
    }
}
