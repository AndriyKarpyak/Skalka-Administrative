package com.ss.skalkaadministrativemobile.google;

import android.util.Log;

import com.pras.SpreadSheet;
import com.pras.WorkSheet;
import com.pras.WorkSheetRow;
import com.ss.skalkaadministrativemobile.model.Order;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by kan on 15.01.2015.
 */
public class OrdersGoogleSheetReference implements GoogleSheetReference {

    private final static String TAG = OrdersGoogleSheetReference.class.getName();

    public final static String SHEET_NAME_PREFIX = "Orders";

    private final SpreadSheet sheet;

    public OrdersGoogleSheetReference(SpreadSheet sheet) {
        this.sheet = sheet;
    }

    public boolean isReferenceValid() {
        return sheet != null && getExpectedReferenceTitle().equals(getActualReferenceTitle());
    }

    public SpreadSheet getReference() {
        return sheet;
    }

    public String getActualReferenceTitle() {
        return sheet.getTitle();
    }

    public String getExpectedReferenceTitle() {
        StringBuilder strb = new StringBuilder();
        strb.append(SHEET_NAME_PREFIX);
        strb.append("-");
        strb.append((new SimpleDateFormat("MM-yyyy")).format(Calendar.getInstance().getTime()));
        return strb.toString();
    }

    public boolean addOrder(Order order) {
        WorkSheet orders = sheet.getAllWorkSheets(true).get(0);

        Log.d(TAG, "Adding to work sheet [" + orders.getTitle() + "] = " + order.toString() );
        WorkSheetRow row = orders.addListRow(order);
        if (row != null) {
            Log.i(TAG, "Successful added " + order.toString() + " to work sheet " + orders.getTitle());
            return true;
        } else {
            Log.w(TAG, "Fail to add " + order.toString() + " to work sheet " + orders.getTitle());
            return false;
        }
    }
}
