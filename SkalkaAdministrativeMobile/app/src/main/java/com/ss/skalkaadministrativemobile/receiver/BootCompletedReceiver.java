package com.ss.skalkaadministrativemobile.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.ss.skalkaadministrativemobile.service.GoogleSheetSynchService;

/**
 * Created by kan on 28.01.2015.
 */
public class BootCompletedReceiver  extends BroadcastReceiver {

    private static final String TAG = BootCompletedReceiver.class.getName();

    @Override
    public void onReceive(final Context ctx, final Intent intent) {
        Log.i(TAG, "onReceive");

        ctx.startService(new Intent(ctx, GoogleSheetSynchService.class));
    }
}
