package com.lvbu.zha.viewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

import com.lvbu.zha.viewtest.widget.DrawView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;
    private Button btn_scrollTo,btn_scrollBy;
    private DrawView drawView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout) findViewById(R.id.layout);
        btn_scrollTo = (Button) findViewById(R.id.btn_scrollTo);
        btn_scrollBy = (Button) findViewById(R.id.btn_scrollBy);
        drawView = (DrawView) findViewById(R.id.draw);
        btn_scrollTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layout.scrollTo(-300,-300);
            }
        });
        btn_scrollBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layout.scrollBy(-25,-25);   //从左向右滑动，view边界 - view内容边界0.
            }
        });

        final Animation rotateAnimation = new
                RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setInterpolator(new BounceInterpolator());
        rotateAnimation.setDuration(6000);              //持续时间
        drawView.setAnimation(rotateAnimation);
        rotateAnimation.startNow();
    }
}
