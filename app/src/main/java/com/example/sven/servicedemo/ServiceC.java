package com.example.sven.servicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class ServiceC extends IntentService {

    private static final String TAG = "ServiceC";

    private int count = 0;

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
    public void onCreate() {
        Log.i(TAG, "onCreate ...");
        super.onCreate();
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand ...");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String name = intent.getStringExtra("name");
        Log.i(TAG, name + (count++));
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.i(TAG, "onHandleIntent end");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy ...");
    }
}
