package com.example.sven.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.annotation.Nullable;
import android.util.Log;

public class ServiceD extends Service {

    private static final String TAG = "ServiceD";

    private ServiceDHandler mHandler;

    class ServiceDHandler extends Handler {
        public ServiceDHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.i(TAG, msg.toString());
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        HandlerThread thread = new HandlerThread("ServiceD_Bg_Service",
                Process.THREAD_PRIORITY_BACKGROUND);
        mHandler = new ServiceDHandler(thread.getLooper());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Message msg = Message.obtain();
        msg.obj = intent;
        msg.arg1 = flags;
        msg.arg2 = startId;

        mHandler.sendMessage(msg);
        return super.onStartCommand(intent, flags, startId);
    }
}
