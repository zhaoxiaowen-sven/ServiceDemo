package com.example.sven.servicedemo;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class ServiceC extends IntentService {

    private static final String TAG = "ServiceC";

    public ServiceC(){
        super("Service");
    }
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public ServiceC(String name) {
        super(name);
        Log.i(TAG, "name = " + name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String name = intent.getStringExtra("name");
        Log.i(TAG, name);
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.i(TAG, "onHandleIntent end");
    }
}
