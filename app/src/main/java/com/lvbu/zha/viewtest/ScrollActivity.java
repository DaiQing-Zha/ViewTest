package com.lvbu.zha.viewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by DaiQing.Zha on 2016/12/27 0027.
 */
public class ScrollActivity extends AppCompatActivity {

    private LinearLayout layout;
    private Button btn_scrollTo,btn_scrollBy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview);
    }
}
