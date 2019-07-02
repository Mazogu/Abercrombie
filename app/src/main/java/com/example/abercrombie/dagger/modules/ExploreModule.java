package com.example.abercrombie.dagger.modules;

import com.example.abercrombie.dagger.scope.ExploreScope;
import com.example.abercrombie.network.ApiService;
import com.example.abercrombie.ui.explore.ExploreContract;
import com.example.abercrombie.ui.explore.ExplorePresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ExploreModule {

    ExploreContract.EView view;

    public ExploreModule(ExploreContract.EView view){
        this.view = view;
    }

    @Provides
    @ExploreScope
    ExploreContract.EPresenter providesPresenter(ApiService service){
        return new ExplorePresenter(view,service);
    }
}
