package com.example.abercrombie.ui;

import android.app.Application;

import com.example.abercrombie.dagger.components.AppComponent;
import com.example.abercrombie.dagger.components.DaggerAppComponent;
import com.example.abercrombie.dagger.modules.ExploreModule;
import com.example.abercrombie.dagger.modules.NetModule;

public class AbercrombieApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().netModule(new NetModule("https://www.abercrombie.com/")).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
