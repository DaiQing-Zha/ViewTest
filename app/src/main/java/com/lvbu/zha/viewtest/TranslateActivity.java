package com.lvbu.zha.viewtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by DaiQing.Zha on 2016/12/27 0027.
 */
public class TranslateActivity extends AppCompatActivity {


    private LinearLayout ll_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        ll_test = (LinearLayout) findViewById(R.id.ll_test);

        final Button btnAdd = new Button(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnAdd.setLayoutParams(layoutParams);
        btnAdd.setText("HH");
        final Button btnReduce = new Button(this);
        btnReduce.setText("KK\nMM\nBB\nVV\nFF\nAA\nSS\nVBN");
        ll_test.addView(btnAdd);
        ll_test.addView(btnReduce);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = new TranslateAnimation(0,0,10f,300f);
                animation.setFillAfter(false);
                animation.setDuration(3000);
                animation.setInterpolator(new OvershootInterpolator());
                btnReduce.startAnimation(animation);
            }
        });
    }
}
