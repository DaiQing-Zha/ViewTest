package com.lvbu.zha.viewtest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private LinearLayout layout;
    private Button btn_scrollTo,btn_scrollBy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout) findViewById(R.id.layout);
        btn_scrollTo = (Button) findViewById(R.id.btn_scrollTo);
        btn_scrollBy = (Button) findViewById(R.id.btn_scrollBy);

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
    }
}
