package com.app.mgnrega.mgnregaapp;

/**
 * Created by jains on 15-02-2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    protected EditText NaregaIdEditText;
    protected EditText AadharNoEditText;
    protected EditText MobileNoEditText;
    protected EditText NameEditText;
    protected EditText passwordEditText;
    protected EditText emailEditText;
    protected Button signUpButton;
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabase;
    private ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        passwordEditText = (EditText)findViewById(R.id.password);
        emailEditText = (EditText)findViewById(R.id.username);
        signUpButton = (Button)findViewById(R.id.signup);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("worker_table");
        final String worker_id = mDatabase.push().getKey();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordEditText.getText().toString();
                String email = emailEditText.getText().toString() + "@gmail.com";
                password = password.trim();
                email = email.trim();

                worker worker_person = new worker(
                        passwordEditText.getText().toString(),
                        emailEditText.getText().toString()

                );

                mDatabase.child(worker_id).setValue(worker_person);

                if (password.isEmpty() || email.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Signup.this);
                    builder.setMessage("Hello")
                            .setTitle("Hello")
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(Signup.this, Startup.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                    } else {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(Signup.this);
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

    }

}
