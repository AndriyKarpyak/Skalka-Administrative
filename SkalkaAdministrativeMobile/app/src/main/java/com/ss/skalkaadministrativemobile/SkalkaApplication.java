package com.ss.skalkaadministrativemobile;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by kan on 26.01.2015.
 */
public class SkalkaApplication extends Application {

    private final String TAG = getClass().getName();

    private ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();

        graph = ObjectGraph.create(getModules().toArray());
    }

    protected List<Object> getModules() {
        return Arrays.<Object>asList(
                new ApplicationModule(SkalkaApplication.this)
        );
    }

    public void inject(Object object) {
        graph.inject(object);
    }
}
