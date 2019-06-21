package com.example.abercrombie.dagger.components;

import com.example.abercrombie.dagger.modules.ExploreModule;
import com.example.abercrombie.dagger.modules.NetModule;
import com.example.abercrombie.network.ApiService;
import com.example.abercrombie.ui.explore.ExploreFragment;
import com.example.abercrombie.ui.explore.ExplorePresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ExploreModule.class, NetModule.class})
public interface AppComponent {

    void inject(ExploreFragment fragment);

    void inject(ExplorePresenter presenter);

    void inject(ApiService service);

}
