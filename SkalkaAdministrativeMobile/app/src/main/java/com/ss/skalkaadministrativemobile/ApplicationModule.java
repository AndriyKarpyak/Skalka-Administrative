package com.ss.skalkaadministrativemobile;

import android.content.Context;

import com.ss.skalkaadministrativemobile.google.GoogleModule;

import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by kan on 26.01.2015.
 */
@dagger.Module(
        complete = true,
        library = true,
        injects = {SkalkaApplication.class, InitializeActivity.class},
        includes = {
                    GoogleModule.class
                   }
)
public class ApplicationModule {

    private SkalkaApplication app;

    public ApplicationModule(SkalkaApplication app) {
        this.app = app;
    }

    @Provides @Singleton public Context provideApplicationContext() {
        return app;
    }
}
