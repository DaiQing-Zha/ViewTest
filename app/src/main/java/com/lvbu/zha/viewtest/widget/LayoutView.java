package com.lvbu.zha.viewtest.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by DaiQing.Zha on 2017/6/9 0009.
 */
public class LayoutView extends ViewGroup {
    public LayoutView(Context context) {
        super(context);
    }

    public LayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //(viewWidth + padding) * num - padding = screenWidth;
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        int screenWidth = wm.getDefaultDisplay().getWidth();
        int padding = 20;
        int childViewNum = getChildCount();
        int viewWidth = (screenWidth + padding) / (childViewNum) - padding;
        for (int i = 0; i < getChildCount(); i ++){
            View view = getChildAt(i);
            if (i == getChildCount() - 1){
                view.layout(l,t,screenWidth,t + viewWidth);
            }else{
                view.layout(l,t,l + viewWidth,t + viewWidth);
            }
            l += viewWidth + padding;
        }
    }
}
