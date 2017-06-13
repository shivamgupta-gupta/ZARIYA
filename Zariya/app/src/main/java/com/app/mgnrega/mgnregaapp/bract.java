package com.app.mgnrega.mgnregaapp; /**
 * Created by Anuj Munjal on 02-04-2017.
 */

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class bract extends AppCompatActivity {
        EditText ed1,ed2;
        BroadcastReceiver brsent,brdel;
        Intent intsent,intdel;
        PendingIntent plsent,pldel;
        IntentFilter infsent,infdel;
        String sms_sent="Message sent";
        String sms_del="Message delivered";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ed1=(EditText)findViewById(R.id.editText);
            ed2=(EditText)findViewById(R.id.editText2);
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

        }
        protected void onResume(){
            super.onResume();
            registerReceiver(brsent,infsent);
            registerReceiver(brdel,infdel);
        }
        protected void onPause(){
            super.onPause();
            unregisterReceiver(brsent);
            unregisterReceiver(brdel);
        }
        public void sendsms(View v){
            String n=ed1.getText().toString();
            String m=ed2.getText().toString();
            SmsManager sms=SmsManager.getDefault();
            sms.sendTextMessage(n,null,m,plsent,null);
        }
    }


