
package com.example.sven.servicedemo;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class ServiceB extends Service {

    private static final String TAG = "ServiceB";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate...");
        Intent intent = new Intent(this, MainActivity.class);
        // 需要让Activity运行在新的任务栈中
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Notification.Builder builder = new Notification.Builder(this);
        Notification notification = builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("this is a notify")
                .setContentTitle("notify!!!").setTicker("notify")
                .setContentIntent(PendingIntent.
                        getActivity(ServiceB.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT))
                .build();
        startForeground(1, notification);

    }
}
