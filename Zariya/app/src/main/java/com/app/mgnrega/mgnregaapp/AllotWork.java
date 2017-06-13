package com.app.mgnrega.mgnregaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AllotWork extends AppCompatActivity {

    LinearLayout list;
    private ArrayAdapter<Button> adapter;
    private ArrayList<Button> arrayList;
    String mob;
    BroadcastReceiver brsent,brdel;
    Intent intsent,intdel;
    PendingIntent plsent,pldel;
    IntentFilter infsent,infdel;
    String sms_sent="Message sent";
    String sms_del="Message delivered";
    View vel;
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allot_work);

        b1=(Button)findViewById(R.id.button6);
        b2=(Button)findViewById(R.id.button10);
        b3=(Button)findViewById(R.id.button11);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendsms(getCurrentFocus(),"9868921607");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendsms(getCurrentFocus(),"9868921607");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendsms(getCurrentFocus(),"9868921607");
            }
        });
/*

        intsent=new Intent(sms_sent);
        plsent=PendingIntent.getBroadcast(getApplicationContext(),0,intsent,0);
        infsent=new IntentFilter(sms_sent);
        brsent=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch(getResultCode()){
                    case RESULT_OK:
                        Toast.makeText(getApplicationContext(),"SMS Sent",Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE :
                        break;
                    default:
                        break;
                }
            }
        };
        intdel=new Intent(sms_del);
        pldel=PendingIntent.getBroadcast(getApplicationContext(),0,intdel,0);
        infdel=new IntentFilter(sms_del);
        brdel=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch(getResultCode()){
                    case RESULT_OK:
                        Toast.makeText(getApplicationContext(),"SMS Delivered",Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE :
                        break;
                    default:
                        break;
                }
            }
        };





        list=(LinearLayout)findViewById(R.id.aulaa);



                arrayList = new ArrayList<Button>();
                adapter = new ArrayAdapter<Button>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);



                DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://mgnrega-app-ff600.firebaseio.com/application_forms/");
                databaseRef.addValueEventListener(new ValueEventListener() {
                    @Override

                    public void onDataChange(DataSnapshot dataSnapshot) {



                        Button b=(Button)vel;

                        String settext="";


                        for( DataSnapshot snapshot : dataSnapshot.getChildren() ) {

                            ApplicationFormDetails appli=(snapshot.getValue(ApplicationFormDetails.class));
                            settext+=appli.getApplicant_name()+":";
                            settext+=appli.getApplicant_area();
                               mob=appli.getMob();

                        }

                        b.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                v.setVisibility(View.GONE);
                                sendsms(v);

                            }
                        });
                        b.setText(settext);
                        arrayList.add(b);

                        list.addView(b);


                    }

                    @Override

                    public void onCancelled(DatabaseError databaseError) {

                    }

                });



*/



            }




            public void sendsms(View v,String mn){


                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(mn,null,"You are selected.",plsent,null);
            }

}


