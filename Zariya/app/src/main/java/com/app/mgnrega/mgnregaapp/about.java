package com.app.mgnrega.mgnregaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class about extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        tv = (TextView)findViewById(R.id.textView);


    }
}
