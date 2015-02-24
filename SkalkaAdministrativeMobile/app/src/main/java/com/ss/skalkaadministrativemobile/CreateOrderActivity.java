package com.ss.skalkaadministrativemobile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;

import com.ss.skalkaadministrativemobile.model.Order;
import com.ss.skalkaadministrativemobile.google.GoogleSheetManager;


public class CreateOrderActivity extends ActionBarActivity {

    private static final String TAG = CreateOrderActivity.class.getName();

    private EditText orderPriceET;
    private DatePicker planedDeliveryDP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        orderPriceET = (EditText) findViewById(R.id.orderPriceET);
        planedDeliveryDP = (DatePicker) findViewById(R.id.planedDeliveryDP);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_order, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_accept) {

            final Order order = new Order();
            order.setPrice(orderPriceET.getText().toString());

            runOnUiThread(new Runnable() {
                public void run() {
                    (new AsyncTask() {

                        @Override
                        protected Object doInBackground(Object[] params) {

                           /*try {
                                return Boolean.valueOf(GoogleSheetManager.get().ordersSheet.addOrder(order));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }*/

                            return null;
                        }

                        @Override
                        protected void onPostExecute(Object o) {
                            if (o != null && (Boolean) o) {
                                    Log.i(TAG, "Added record to work sheet.");
                            }

                            super.onPostExecute(o);


                        }
                    }).execute();
                }
            });
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
