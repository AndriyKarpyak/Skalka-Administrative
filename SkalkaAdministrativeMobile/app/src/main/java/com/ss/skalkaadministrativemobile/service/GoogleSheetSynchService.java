package com.ss.skalkaadministrativemobile.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.ss.skalkaadministrativemobile.R;

/**
 * Created by kan on 28.01.2015.
 */
public class GoogleSheetSynchService extends Service {

    private static final String TAG = GoogleSheetSynchService.class.getName();
    private static final int NOTIFICATION_ID = 12345;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        Log.d(TAG, "onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.ic_stat_editor_attach_money);
        mBuilder.setContentTitle(getResources().getString(R.string.notification_synchronization_service_title));
        mBuilder.setContentText(getResources().getString(R.string.notification_synchronization_service_text));

        startForeground(NOTIFICATION_ID, mBuilder.build());

        return START_STICKY;
    }
}
