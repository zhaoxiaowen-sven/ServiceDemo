
package com.example.sven.servicedemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ServiceA.ABinder mBinder;

    private ServiceConnection mConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected...");
            mBinder = (ServiceA.ABinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected...");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startServiceA(View v) {
        Intent intent = new Intent(this, ServiceA.class);
        startService(intent);
    }

    public void stopServiceA(View v) {
        Intent intent = new Intent(this, ServiceA.class);
        stopService(intent);
    }

    public void bindServiceA(View v) {
        Intent intent = new Intent(this, ServiceA.class);
        bindService(intent, mConn, Context.BIND_AUTO_CREATE);
    }

    public void unbindServiceA(View v) {
        unbindService(mConn);
    }

    public void stopSelfServiceA(View v) {
        mBinder.stopService(0);
    }

    public void startServiceB(View v) {
        Intent intent = new Intent(this, ServiceB.class);
        bindService(intent, mConn, Context.BIND_AUTO_CREATE);
    }
}
