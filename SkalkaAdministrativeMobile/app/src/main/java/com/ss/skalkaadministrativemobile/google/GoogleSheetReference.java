package com.ss.skalkaadministrativemobile.google;

import com.pras.SpreadSheet;

/**
 * Created by kan on 23.01.2015.
 */
public interface GoogleSheetReference {

    SpreadSheet getReference();

    boolean isReferenceValid();

    String getExpectedReferenceTitle();

    String getActualReferenceTitle();
}
