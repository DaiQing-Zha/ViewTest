package com.lvbu.zha.viewtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by DaiQing.Zha on 2017/4/11 0011.
 */
public class AddViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_view);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_layout);
        LinearLayout view = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.layout_bottom_view,null);
        linearLayout.addView(view);
    }


}
