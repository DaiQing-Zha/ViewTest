package com.lvbu.zha.viewtest.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lvbu.zha.viewtest.R;

/**
 * Created by DaiQing.Zha on 2016/9/8 0008.
 */
public class BaseView extends RelativeLayout{
    public BaseView(Context context) {
        super(context);
        ImageView imageView = new ImageView(context);
        imageView.setBackgroundColor(Color.parseColor("#FF0000"));
        addView(imageView, new ViewGroup.LayoutParams(500, 100));

    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ImageView imageView = new ImageView(context);
        imageView.setBackgroundColor(Color.parseColor("#FF0000"));
        addView(imageView, new ViewGroup.LayoutParams(500, 100));
    }

    public BaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
