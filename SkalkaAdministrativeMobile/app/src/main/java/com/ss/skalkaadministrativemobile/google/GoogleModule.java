package com.ss.skalkaadministrativemobile.google;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kan on 26.01.2015.
 */
@dagger.Module(
        complete = true,
        library = true
)
public class GoogleModule {

    @Provides
    @Singleton
    public GoogleSheetManager providesGoogleSheetManager() {
        return new GoogleSheetManager();
    }
}
