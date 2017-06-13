package com.app.mgnrega.mgnregaapp;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class WorkerApplicationForm extends AppCompatActivity {

    Button submit;
    TextToSpeech tta;
    EditText editText_area,editText_from_date,editText_to_date,mob;
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabase;
    private ChildEventListener mChildEventListener;
    public String checkbox_detail;
    String Aadhaar;
    TextView tv1,tv2,tv3,tv4,tv5,tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_application_form);
        tv1=(TextView)findViewById(R.id.txt1);
        tv2=(TextView)findViewById(R.id.txt2);
        tv3=(TextView)findViewById(R.id.txt3);
        tv4=(TextView)findViewById(R.id.textView3);
        tv5=(TextView)findViewById(R.id.textView4);
        tv6=(TextView)findViewById(R.id.textView5);
        mob=(EditText)findViewById(R.id.mobn);

        try {

            Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
            startActivityForResult(intent, 0);

        } catch (Exception e) {

            Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
            Intent marketIntent = new Intent(Intent.ACTION_VIEW,marketUri);
            startActivity(marketIntent);

        }
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
        tta.speak(editText_area.getHint().toString(),TextToSpeech.QUEUE_FLUSH,null);
    }
    public void speakOut1(View view){
        tta.speak(editText_to_date.getHint().toString(),TextToSpeech.QUEUE_FLUSH,null);
    }public void speakOut2(View view){
        tta.speak(editText_from_date.getHint().toString(),TextToSpeech.QUEUE_FLUSH,null);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {

            if (resultCode == RESULT_OK) {
                Aadhaar = data.getStringExtra("SCAN_RESULT");
                String[] Key = new String[13];
                String[] Value = new String[13];
                int keyIndex = 0, valueIndex = 0;
                String json = Aadhaar;
                for (int i = 0; i < json.length(); i++) {
                    String ch1 = String.valueOf(json.charAt(i));
                    if (ch1.equals(" ")) {
                        for (int j = i + 1; j < json.length(); j++) {
                            String ch2 = String.valueOf(json.charAt(j));
                            if (ch2.equals("=")) {
                                Key[keyIndex++] = json.substring(i + 1, j);
                                break;
                            }
                            if (ch2.equals(" ")) {
                                break;
                            }
                        }
                    }
                }
                for (int i = 0; i < json.length(); i++) {
                    String ch1 = String.valueOf(json.charAt(i));
                    if (ch1.equals("=")) {
                        for (int j = i + 2; j < json.length() - 1; j++) {
                            String ch2 = String.valueOf(json.charAt(j)) + String.valueOf(json.charAt(j + 1));
                            if (ch2.equals("\" ") || ch2.equals("\"/") || ch2.equals("\"?")) {
                                Value[valueIndex++] = json.substring(i + 2, j);
                                break;
                            }
                        }
                    }
                }
                String Address = "";
                int addressExistsCount = 0;
                for (int i = 0; i < Key.length; i++) {
                    if (Key[i].equals("name")) {
                        tv2.setText(Value[i]);
                    } else if (Key[i].equals("gender")) {
                        tv3.setText(Value[i]);
                    } else if (Key[i].equals("uid")) {
                        tv1.setText(Value[i]);
                    }
                }
            }

            submit = (Button)findViewById(R.id.button);
        editText_area = (EditText)findViewById(R.id.et_area);
        editText_from_date = (EditText)findViewById(R.id.et_from_date);
        editText_to_date = (EditText)findViewById(R.id.et_to_date);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("application_forms");
        final String application_id = mDatabase.push().getKey();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String worker_name = tv2.getText().toString().trim();
                String worker_id = tv1.getText().toString().trim();
                String worker_area = editText_area.getText().toString().trim();
                String from_date = editText_from_date.getText().toString().trim();
                String to_date = editText_to_date.getText().toString().trim();
                String m=mob.getText().toString().trim();
                ApplicationFormDetails details = new ApplicationFormDetails(worker_name,worker_id,worker_area,from_date,to_date,m);
                mDatabase.child(application_id).setValue(details);
                Intent i = new Intent(WorkerApplicationForm.this,Display_Application_Data.class);
                startActivity(i);
            }
        });

    }
}}