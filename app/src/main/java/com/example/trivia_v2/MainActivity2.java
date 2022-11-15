package com.example.trivia_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;


public class MainActivity2<relativeLayout> extends AppCompatActivity {
    private Switch sw_change_color;
    private View relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sw_change_color = findViewById(R.id.changeColorSwitch);
        relativeLayout = findViewById(R.id.r_background);

        sw_change_color.setOnClickListener(view -> {
            if(sw_change_color.isChecked()){
                relativeLayout.setBackgroundResource(R.color.cool);
            }else{
                relativeLayout.setBackgroundResource(R.color.warm);
            }
        });

    }
}