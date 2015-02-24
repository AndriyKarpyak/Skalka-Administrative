package com.ss.skalkaadministrativemobile;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pras.SpreadSheetFactory;
import com.ss.skalkaadministrativemobile.auth.AndroidAuthenticator;
import com.ss.skalkaadministrativemobile.google.GoogleSheetManager;

import javax.inject.Inject;

public class InitializeActivity extends Activity {

    private final String TAG = getClass().getName();

    ProgressBar spinner;
    TextView message;

    @Inject
    GoogleSheetManager sheetManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialize);

        Log.d(TAG, String.format("Initialize injections to %s.", TAG));
        ((SkalkaApplication) getApplication()).inject(this);

        Log.d(TAG, String.format("Starting initialization of %s.", TAG));
        spinner = (ProgressBar) findViewById(R.id.act_initialize_progressBar);
        message = (TextView) findViewById(R.id.act_initialize_progressText);
    }

    @Override
    protected void onStart() {
        super.onStart();

        connect();
    }

    public void connect() {
        // Init and Read SpreadSheet list from Google Server
        runOnUiThread(new Runnable() {
            public void run() {
                (new AsyncTask() {

                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();

                        spinner.setVisibility(View.VISIBLE);

                        message.setText(getString(R.string.act_main_lbl_connecting));
                        Log.d(TAG, "Connecting to Google storage. ...");
                    }

                    int i = 0;

                    @Override
                    protected Object doInBackground(Object[] params) {
                        // Read Spread Sheet list from the server.
                        Looper.myLooper().prepare();
                        try {
                            sheetManager.init(SpreadSheetFactory.getInstance(new AndroidAuthenticator(InitializeActivity.this)));

                            publishProgress(i++);

                            if (sheetManager.isInitialized()) {
                                if (sheetManager.isAllReferencesValid()) {
                                    Looper.myLooper().quit();
                                } else {
                                    sheetManager.validateReferences();
                                    Looper.myLooper().loop();
                                }
                            } else {
                                Looper.myLooper().loop();
                            }
                            Log.d(TAG, "Connected to [" + sheetManager.ordersSheet.getActualReferenceTitle() + "] Google sheet.");

                        } catch (IllegalAccessException e) {
                            Log.e(TAG, e.getMessage(), e);
                            Looper.myLooper().quit();
                        }
                        return null;
                    }

                    @Override
                    protected void onProgressUpdate(Object[] values) {
                        super.onProgressUpdate(values);
                        if (values != null)
                            message.setText(values[0].toString());
                    }

                    @Override
                    protected void onPostExecute(Object o) {
                        super.onPostExecute(o);

                        spinner.setVisibility(View.GONE);

                        if (!sheetManager.ordersSheet.isReferenceValid()) {
                            message.setText(getString(R.string.act_main_lbl_cant_find_files));
                        } else {
                            startActivity(new Intent(InitializeActivity.this, MainMenuActivity.class));
                        }
                    }
                }).execute();
            }
        });
    }
}
