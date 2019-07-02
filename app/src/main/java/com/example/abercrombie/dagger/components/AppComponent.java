package com.example.abercrombie.dagger.components;

import com.example.abercrombie.dagger.modules.ExploreModule;
import com.example.abercrombie.dagger.modules.NetModule;
import com.example.abercrombie.network.ApiService;
import com.example.abercrombie.ui.AbercrombieApp;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Component for main application scope.
 */
@Singleton
@Component(modules = {NetModule.class})
public interface AppComponent {


    /**
     * Provides injection to application.
     * @param app
     */
    void inject(AbercrombieApp app);

    /**
     * Creates the Explore Subcomponent.
     * @param exploreModule
     * @return
     */
    ExploreComponent newExploreComponent(ExploreModule exploreModule);

}
