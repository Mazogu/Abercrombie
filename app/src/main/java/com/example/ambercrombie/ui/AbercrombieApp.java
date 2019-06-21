package com.example.ambercrombie.ui;

import android.app.Application;

import com.example.ambercrombie.dagger.components.AppComponent;
import com.example.ambercrombie.dagger.components.DaggerAppComponent;
import com.example.ambercrombie.dagger.modules.ExploreModule;
import com.example.ambercrombie.dagger.modules.NetModule;

public class AbercrombieApp extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().exploreModule(new ExploreModule())
                .netModule(new NetModule("https://www.abercrombie.com/"))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
