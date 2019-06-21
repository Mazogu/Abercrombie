package com.example.abercrombie.dagger.modules;

import com.example.abercrombie.ui.explore.ExploreContract;
import com.example.abercrombie.ui.explore.ExplorePresenter;

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
