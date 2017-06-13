package com.app.mgnrega.mgnregaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Display_Application_Data extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private String mUserID;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_application__data);
        textView = (TextView) findViewById(R.id.retrt);
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://mgnrega-app-ff600.firebaseio.com/application_forms/");
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {

                textView.setText("");


                String settext="";


                for( DataSnapshot snapshot : dataSnapshot.getChildren() ) {

                    ApplicationFormDetails appli=(snapshot.getValue(ApplicationFormDetails.class));
                    settext+=appli.getApplicant_name() + "\n";
                    ApplicationFormDetails appli_area=(snapshot.getValue(ApplicationFormDetails.class));
                    settext+=appli.getApplicant_area() + "\n";
                    ApplicationFormDetails appli_from=(snapshot.getValue(ApplicationFormDetails.class));
                    settext+=appli.getApplicant_from_date() + "\n";
                    ApplicationFormDetails appli_to=(snapshot.getValue(ApplicationFormDetails.class));
                    settext+=appli.getApplicant_to_date() + "\n";

                    ApplicationFormDetails appli_mob=(snapshot.getValue(ApplicationFormDetails.class));
                    settext+=appli.getMob() + "\n";

                }

                textView.setText(settext);

            }

            @Override

            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }
}