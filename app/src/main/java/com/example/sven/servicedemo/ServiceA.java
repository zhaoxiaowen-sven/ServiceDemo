
package com.example.sven.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class ServiceA extends Service {

    private static final String TAG = "ServiceA";

    private Binder mBinder = new ABinder();

    class ABinder extends Binder {
        public void stopService(int id) {
            Log.i(TAG, "ServiceA stopService " + id);
            ServiceA.this.stopSelf();
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind...");
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate...");
        long id = Thread.currentThread().getId();
        Log.i(TAG, "id = "+id);
//        try {
//            Thread.sleep(60 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand...");
        // return super.onStartCommand(intent, flags, startId);
        Log.i(TAG, "intent = " + intent.toString());
        return START_STICKY;
        // return START_REDELIVER_INTENT;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind...");
//        return super.onUnbind(intent);
        return true;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i(TAG, "onRebind...");
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy...");
        super.onDestroy();
    }
}
