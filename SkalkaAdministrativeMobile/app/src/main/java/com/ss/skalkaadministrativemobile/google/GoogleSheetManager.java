package com.ss.skalkaadministrativemobile.google;

import android.util.Log;

import com.pras.SpreadSheet;
import com.pras.SpreadSheetFactory;
import com.ss.skalkaadministrativemobile.model.Order;

import java.util.ArrayList;

/**
 * Created by kan on 16.01.2015.
 */
public class GoogleSheetManager {

    private final static String TAG = GoogleSheetManager.class.getName();

    private SpreadSheetFactory sheetFactory;

    public OrdersGoogleSheetReference ordersSheet;

    GoogleSheetManager() { }

    public void init(SpreadSheetFactory sheetFactory) throws IllegalAccessException {

        this.sheetFactory = sheetFactory;

        ordersSheet = new OrdersGoogleSheetReference(getSheet(OrdersGoogleSheetReference.SHEET_NAME_PREFIX));
    }

    public boolean isInitialized() {
        return sheetFactory != null && ordersSheet != null;
    }

    public boolean isAllReferencesValid() {
        return ordersSheet.isReferenceValid();
    }

    public void validateReferences() {
        validateOrdersReference();
    }

    private SpreadSheet getSheet(String name) {
        ArrayList<SpreadSheet> spreadSheets = sheetFactory.getSpreadSheet(name, false);
        return spreadSheets.get(0);
    }

    private void createSheet(String name) {
        sheetFactory.createSpreadSheet(name);
    }

    private void validateOrdersReference() {
        if (!ordersSheet.isReferenceValid()) {
            createSheet(ordersSheet.getExpectedReferenceTitle());
            ordersSheet = new OrdersGoogleSheetReference(getSheet(OrdersGoogleSheetReference.SHEET_NAME_PREFIX));
            Log.i(TAG, "Created new sheet for orders: " + ordersSheet.getReference().getTitle());
            ordersSheet.getReference().addListWorkSheet(OrdersGoogleSheetReference.SHEET_NAME_PREFIX, 100, Order.COLUMN_NAMES);
            ordersSheet.getReference().getAllWorkSheets(true).get(0).delete();
        }
    }
}
