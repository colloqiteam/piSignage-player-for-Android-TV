package com.pisignage.pisignageforandroidtv;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
//import android.util.Log;
//import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Toast.makeText(context.getApplicationContext(), "Notifying On Receive event", Toast.LENGTH_LONG).show();
        if (intent.getAction() != null && intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            // Toast.makeText(context, "Notifying on Boot complete event", Toast.LENGTH_LONG).show();
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
