package com.ss.skalkaadministrativemobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainMenuActivity extends Activity {

    private static final String TAG = MainMenuActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void createOrder(View source) {
        startActivity(new Intent(this, CreateOrderActivity.class));
    }
}
