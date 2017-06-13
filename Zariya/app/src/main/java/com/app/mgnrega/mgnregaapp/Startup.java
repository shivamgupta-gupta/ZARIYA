package com.app.mgnrega.mgnregaapp;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;


/**
 * Created by jains on 05-02-2017.
 */


public class Startup extends AppCompatActivity {

    protected EditText emailEditText;
    protected EditText passwordEditText;
    TextToSpeech tta;
    protected Button logInButton,fin;
    protected TextView signUpTextView;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup);



        mFirebaseAuth = FirebaseAuth.getInstance();
        signUpTextView = (TextView) findViewById(R.id.signup);
        emailEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);
        logInButton = (Button) findViewById(R.id.login);
        fin = (Button) findViewById(R.id.fps);
        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Startup.this, Signup.class);
                startActivity(intent);
            }
        });
        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Startup.this, FingerprintActivity.class);
                startActivity(i1);
            }});

                logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString()+"@gmail.com";
                String password = passwordEditText.getText().toString();

                email = email.trim();
                password = password.trim();
                if (email.isEmpty() || password.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Startup.this);
                    builder.setMessage("Hello")
                            .setTitle("Hello")
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else {
                    mFirebaseAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Startup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(Startup.this, Home.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                    } else {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(Startup.this);
                                        builder.setMessage(task.getException().getMessage())
                                                .setTitle("Hello")
                                                .setPositiveButton(android.R.string.ok, null);
                                        AlertDialog dialog = builder.create();
                                        dialog.show();
                                    }
                                }
                            });
                }
            }
        });
        tta = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status)
            {
                if(tta!=null)
                {
                    tta.setLanguage(Locale.ENGLISH);
                    tta.setSpeechRate(1);
                    tta.setPitch((float)1);
                }
                else
                {

                    Toast.makeText(getApplicationContext(),"No Device",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void speakOut(View view){
        tta.speak(emailEditText.getHint().toString(),TextToSpeech.QUEUE_FLUSH,null);
    }
    public void speakOut1(View view){
        tta.speak(passwordEditText.getHint().toString(),TextToSpeech.QUEUE_FLUSH,null);
    }
}
