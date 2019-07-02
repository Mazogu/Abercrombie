package com.example.abercrombie.dagger.components;

import com.example.abercrombie.dagger.modules.ExploreModule;
import com.example.abercrombie.dagger.modules.NetModule;
import com.example.abercrombie.network.ApiService;
import com.example.abercrombie.ui.AbercrombieApp;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetModule.class})
public interface AppComponent {

    void inject(AbercrombieApp app);
    ExploreComponent newExploreComponent(ExploreModule exploreModule);

}
