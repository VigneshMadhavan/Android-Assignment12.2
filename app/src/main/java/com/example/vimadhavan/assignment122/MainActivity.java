package com.example.vimadhavan.assignment122;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Listener {

    public static final String CUSTOM_ACTION="com.example.vimadhavan.assignment122.CUSTOM_ACTION";
    private CustomBroadcastReceiver receiver;
    private EditText txt;
    private Button broadCastBtn;
    private Toast msgToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt= (EditText) findViewById(R.id.txt);
        broadCastBtn=(Button) findViewById(R.id.broadcastBtn);
        broadCastBtn.setOnClickListener(this);
        txt.setText(getString(R.string.defaultMsg));

        receiver=new CustomBroadcastReceiver(this);

    }

    @Override
    protected void onStart() {
        //register the receiver
        registerReceiver(receiver, new IntentFilter(MainActivity.CUSTOM_ACTION));

        super.onStart();
    }

    @Override
    protected void onStop() {
        //unregister the receiver
        unregisterReceiver(receiver);
        super.onStop();
    }

    @Override
    public void onClick(View v) {
        //broadcast the CUSTOM_ACTION
        Intent intnet = new Intent(MainActivity.CUSTOM_ACTION);
        intnet.putExtra(CustomBroadcastReceiver.MSG_KEY,txt.getText().toString());
        sendBroadcast(intnet);
    }

    @Override
    public void onRecievedCustomBroadCast(String msg) {

        if (msgToast!=null){
            msgToast.cancel();
        }
        msgToast=Toast.makeText(this,"Received: "+msg,Toast.LENGTH_LONG);
        msgToast.show();

    }
}
