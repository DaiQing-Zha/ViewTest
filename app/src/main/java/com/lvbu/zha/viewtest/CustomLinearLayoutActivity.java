package com.lvbu.zha.viewtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lvbu.zha.viewtest.widget.CustomLinearLayout;

/**
 * Created by DaiQing.Zha on 2017/1/18 0018.
 */
public class CustomLinearLayoutActivity extends AppCompatActivity {

    private CustomLinearLayout ll_view;
    private Button btn_btn1,btn_btn2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_linearlayout);

        ll_view = (CustomLinearLayout) findViewById(R.id.ll_view);
        btn_btn1 = (Button) findViewById(R.id.btn_btn1);
        btn_btn2 = (Button) findViewById(R.id.btn_btn2);

        ll_view.setmSetOnSlideListener(new CustomLinearLayout.setOnSlideListener() {
            @Override
            public void onLeftToRightSlide(float moveDistance) {

            }

            @Override
            public void onRightToLeftSlide(float moveDistance) {

            }

            @Override
            public void onTopToBottomSlide(float moveDistance) {

            }

            @Override
            public void onBottomToTopSlide(float moveDistance) {

            }

            @Override
            public void onActionDown(float locationX, float locationY) {

            }

            @Override
            public void onActionUp(float finalDistanceX, float finalDistanceY) {

            }
        });
        btn_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(CustomLinearLayoutActivity.this,"B1",Toast.LENGTH_SHORT).show();
            }
        });
        btn_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomLinearLayoutActivity.this,"B2",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
