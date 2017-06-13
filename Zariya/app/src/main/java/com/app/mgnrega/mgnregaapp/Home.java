package com.app.mgnrega.mgnregaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by Anuj Munjal on 02-04-2017.
 */

public class Home extends Activity{
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_xml);
        b1 = (Button)findViewById(R.id.button7);
        b2 = (Button)findViewById(R.id.button8);
        b3 = (Button)findViewById(R.id.button9);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, WorkerApplicationForm.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, about.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, contact.class);
                startActivity(i);
            }
        });
    }
}