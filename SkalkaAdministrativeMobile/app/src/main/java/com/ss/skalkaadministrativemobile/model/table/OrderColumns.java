package com.ss.skalkaadministrativemobile.model.table;

import java.lang.annotation.ElementType;

/**
 * Created by kan on 23.01.2015.
 */
public enum OrderColumns {

    NUMBER,
    ORDER_DATE,
    EXPECTED_DELIVERY_DATE,
    ACTUAL_DELIVERY_DATE,
    PRICE;

    public static String[] columns() {
        String[] cols = new String[values().length];
        for (int i = 0; i < values().length; i++) {
            cols[i] = values()[i].name().replace("_", "").toLowerCase();
        }
        return cols;
    }

    public String cname() {
        return name().replace("_", "").toLowerCase();
    }
}
