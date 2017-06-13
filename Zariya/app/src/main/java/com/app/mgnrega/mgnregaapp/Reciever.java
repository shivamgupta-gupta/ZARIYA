package com.app.mgnrega.mgnregaapp;

/**
 * Created by Anuj Munjal on 02-04-2017.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Reciever {


    /**
     * Created by Dell on 6/24/2016.
     */
    public class Receiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context,Intent intent){
            Toast.makeText(context,"Aeroplane mode", Toast.LENGTH_SHORT).show();
        }

    }

}