package com.lvbu.zha.viewtest.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;

/**
 * Created by DaiQing.Zha on 2017/1/13 0013.
 */
public class CustomLinearLayout extends LinearLayout {

    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private boolean mScrolling;  //用于标示 当前是否是滑动，true：表示滑动；false：表示点击
    private float touchDownX;   //手指按下时X轴的位置
    private float touchDownY; //手指按下时Y轴的位置
    private float currentMoveDistanceX;    //当前X轴移动的距离[当前位置距离手指按下地方的X轴方向距离]
    private float currentMoveDistanceY;   //当前Y轴移动的距离[当前位置距离手指按下地方的Y轴方向距离]
    private float lastMoveDistanceX;     //上一次X轴移动的距离[上一次位置距离手指按下地方的X轴方向距离]
    private float lastMoveDistanceY;   //上一次Y轴移动的距离[上一次位置距离手指按下地方的Y轴方向距离]
    private float finalMoveDistanceX;    //最终X轴移动的距离[最终位置距离手指按下地方的X轴方向距离]
    private float finalMoveDistanceY;  //最终Y轴移动的距离[最终位置距离手指按下地方的Y轴方向距离]
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){


            case MotionEvent.ACTION_DOWN:
                touchDownX = ev.getX();
                touchDownY = ev.getY();
                mScrolling = false;
                break;
            case MotionEvent.ACTION_MOVE:

                if (Math.abs(touchDownX - ev.getX()) >= ViewConfiguration.get(getContext()).getScaledTouchSlop()
                        || Math.abs(touchDownY - ev.getY()) >= ViewConfiguration.get(getContext()).getScaledTouchSlop()){
                    mScrolling = true;
                }else{
                    mScrolling = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                mScrolling = false;
                break;
        }
        Log.e("mainCVBHJM","touchDownX = " + touchDownX + " ev.getX() = " + ev.getX() + " Slop = " + ViewConfiguration.get(getContext()).getScaledTouchSlop());
        return mScrolling;
    }

    float x1 = 0;
    float y1 = 0;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                if(mSetOnSlideListener!=null){
                    mSetOnSlideListener.onActionDown(event.getX(),event.getY());
                }
                return true;

            case MotionEvent.ACTION_MOVE:
                x1 = event.getX();
                y1 = event.getY();
                currentMoveDistanceX = touchDownX - x1;
                currentMoveDistanceY = touchDownY - y1;
                if (currentMoveDistanceX > dp2px(getContext(),40)) {
                    if(mSetOnSlideListener!=null){

                        if (currentMoveDistanceX - lastMoveDistanceX > 0){
                            mSetOnSlideListener.onRightToLeftSlide(touchDownX,touchDownY, currentMoveDistanceX,currentMoveDistanceX - lastMoveDistanceX);
                        }else{
                            mSetOnSlideListener.onLeftToRightSlide(touchDownX,touchDownY,currentMoveDistanceX,currentMoveDistanceX - lastMoveDistanceX);
                        }
                        Log.e("mainCVBHJ","onRightToLeftSlide" + (currentMoveDistanceX - lastMoveDistanceX));
                    }
                }else{
                    if (currentMoveDistanceY < - dp2px(getContext(),40)){
                        if (mSetOnSlideListener != null){
                            if (currentMoveDistanceY - lastMoveDistanceY < 0){
                                mSetOnSlideListener.onTopToBottomSlide(touchDownX,touchDownY,currentMoveDistanceY,currentMoveDistanceY - lastMoveDistanceY);
                            }else{
                                mSetOnSlideListener.onBottomToTopSlide(touchDownX,touchDownY,currentMoveDistanceY,currentMoveDistanceY - lastMoveDistanceY);
                            }
                            Log.e("mainCVBHJ","onTopToBottomSlide" + (currentMoveDistanceY - lastMoveDistanceY));
                        }
                    }
                }
                if (currentMoveDistanceX < - dp2px(getContext(), 40)) {
                    if(mSetOnSlideListener!=null){
                        if (currentMoveDistanceX - lastMoveDistanceX < 0){
                            mSetOnSlideListener.onLeftToRightSlide(touchDownX,touchDownY,currentMoveDistanceX,currentMoveDistanceX - lastMoveDistanceX);
                        }else{
                            mSetOnSlideListener.onRightToLeftSlide(touchDownX,touchDownY, currentMoveDistanceX,currentMoveDistanceX - lastMoveDistanceX);
                        }
                        Log.e("mainCVBHJ","onLeftToRightSlide" + (currentMoveDistanceX - lastMoveDistanceX));
                    }
                }else if (currentMoveDistanceY > dp2px(getContext(),40)){
                    if (mSetOnSlideListener != null){
                        if (currentMoveDistanceY - lastMoveDistanceY > 0){
                            mSetOnSlideListener.onBottomToTopSlide(touchDownX,touchDownY,currentMoveDistanceY,currentMoveDistanceY - lastMoveDistanceY);
                        }else{
                            mSetOnSlideListener.onTopToBottomSlide(touchDownX,touchDownY,currentMoveDistanceY,currentMoveDistanceY - lastMoveDistanceY);
                        }
                        Log.e("mainCVBHJ","onBottomToTopSlide");
                    }
                }
                finalMoveDistanceX = touchDownX - x1;
                finalMoveDistanceY = touchDownY - y1;
                lastMoveDistanceX = touchDownX - x1;
                lastMoveDistanceY = touchDownY - y1;
                break;
            case MotionEvent.ACTION_UP:
                if (mSetOnSlideListener != null){
                    mSetOnSlideListener.onActionUp(finalMoveDistanceX,finalMoveDistanceY);
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private setOnSlideListener mSetOnSlideListener;

    public setOnSlideListener getmSetOnSlideListener() {
        return mSetOnSlideListener;
    }

    public void setmSetOnSlideListener(setOnSlideListener mSetOnSlideListener) {
        this.mSetOnSlideListener = mSetOnSlideListener;
    }

    /**
     * 滑动监听
     */
    public interface setOnSlideListener{
        void onLeftToRightSlide(float touchDownX, float touchDownY, float distance, float moveDistance);
        void onRightToLeftSlide(float touchDownX, float touchDownY, float distance, float moveDistance);
        void onTopToBottomSlide(float touchDownX, float touchDownY, float distance, float moveDistance);
        void onBottomToTopSlide(float touchDownX, float touchDownY, float distance, float moveDistance);
        void onActionDown(float locationX, float locationY);
        void onActionUp(float finalDistanceX, float finalDistanceY);
    }


    /**
     * dp转px
     * @param context
     * @param dpVal
     * @return
     */
    public static float dp2px(Context context, float dpVal) {
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int)(dpVal*scale+0.5f);
    }
}
