package com.example.ambercrombie.dagger.modules;

import com.example.ambercrombie.ui.explore.ExploreContract;
import com.example.ambercrombie.ui.explore.ExplorePresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ExploreModule {

    @Provides
    @Singleton
    ExploreContract.EPresenter providesPresenter(){
        return new ExplorePresenter();
    }
}
