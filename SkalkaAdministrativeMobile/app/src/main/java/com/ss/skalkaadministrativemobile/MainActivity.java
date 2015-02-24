package com.ss.skalkaadministrativemobile;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.ss.skalkaadministrativemobile.service.GoogleSheetSynchService;


public class MainActivity extends Activity {
    private final String TAG = getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, InitializeActivity.class);
        startActivity(intent);

    }
}
