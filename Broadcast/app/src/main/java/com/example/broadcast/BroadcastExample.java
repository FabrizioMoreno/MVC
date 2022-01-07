package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastExample extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Boolean isPlaneMode = intent.getBooleanExtra("state",false);
        if(isPlaneMode){
            Toast.makeText(context, "El dispositivo esta en modo avion", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "El dispositivo no esta en modo avion", Toast.LENGTH_SHORT).show();
        }
    }
}
