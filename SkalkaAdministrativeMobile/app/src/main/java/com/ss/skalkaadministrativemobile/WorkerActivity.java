package com.ss.skalkaadministrativemobile;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pras.SpreadSheetFactory;
import com.ss.skalkaadministrativemobile.auth.AndroidAuthenticator;
import com.ss.skalkaadministrativemobile.google.GoogleSheetManager;


public class WorkerActivity extends Activity {

    private final String TAG = getClass().getName();

    private ProgressBar spinner;
    private TextView message;
    private Button tryAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);

        spinner = (ProgressBar) findViewById(R.id.progressBar);
        message = (TextView) findViewById(R.id.progressText);
        tryAgain = (Button) findViewById(R.id.tryAgain);
    }

    @Override
    protected void onStart() {
        super.onStart();

        tryAgain.setVisibility(View.GONE);
        spinner.setVisibility(View.GONE);

        runOnUiThread(new Runnable() {
            public void run() {
                (new AsyncTask() {


                    @Override
                    protected Object doInBackground(Object[] params) {

                        Looper.myLooper().prepare();

                        return null;
                    }

                }).execute();
            }
        });
    }

    public void reConnect(View source) {
           }
}
