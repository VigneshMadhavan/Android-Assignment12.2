package com.example.vimadhavan.assignment122;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

/**
 * Created by vimadhavan on 5/3/2017.
 */

public class CustomBroadcastReceiver extends BroadcastReceiver {

    private Listener myListener;
    public static final String MSG_KEY="msg_key";

    public CustomBroadcastReceiver(Listener myListener) {

        this.myListener = myListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //will trigger once the CUSTOM_ACTION broadcasted
        if (intent.getAction().equals(MainActivity.CUSTOM_ACTION)) {
            this.myListener.onRecievedCustomBroadCast(intent.getStringExtra(MSG_KEY));
        }



    }
}
