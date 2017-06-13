package com.app.mgnrega.mgnregaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class worksite extends AppCompatActivity {

    EditText et_area,et_no;
    Button bt,applist;
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worksite);
        Login_official obj = new Login_official();
        applist=(Button)findViewById(R.id.button2);
        applist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(worksite.this, AllotWork.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        et_area = (EditText) findViewById(R.id.editText3);
        et_no = (EditText) findViewById(R.id.editText4);
        bt = (Button) findViewById(R.id.button2);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("Employer/");
        final String worksite_id = mDatabase.push().getKey();
    }
}
