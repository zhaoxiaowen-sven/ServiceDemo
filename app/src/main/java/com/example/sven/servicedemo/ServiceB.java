
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
        Notification.Builder builder = new Notification.Builder(this);
        Notification notification = builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("this is a notify")
                .setContentTitle("notify!!!").setTicker("notify")
                .setContentIntent(PendingIntent.
                        getActivity(ServiceB.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT))
                .build();
        // builder.addAction(new PendingIntent())

        // PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
        // notificationIntent, 0);
        // notification.setLatestEventInfo(this, "这是通知的标题", "这是通知的内容",
        // pendingIntent);
        startForeground(1, notification);
    }
}
