package com.app.mgnrega.mgnregaapp;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class StartActivity extends AppCompatActivity {
    Button b_applicant,b_official;
    Button retr;
    TextView retrt;
    private DatabaseReference mDatabase;
    private FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        b_applicant = (Button) findViewById(R.id.button_applicant);
        b_official = (Button) findViewById(R.id.button_official);

        b_applicant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartActivity.this, Startup.class);
                startActivity(i);
            }
        });

        b_official.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartActivity.this, Login_official.class);
                startActivity(i);
            }
        });
    }
}
