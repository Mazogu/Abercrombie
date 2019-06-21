package com.example.ambercrombie.dagger.components;

import com.example.ambercrombie.dagger.modules.ExploreModule;
import com.example.ambercrombie.dagger.modules.NetModule;
import com.example.ambercrombie.network.ApiService;
import com.example.ambercrombie.ui.explore.ExploreFragment;
import com.example.ambercrombie.ui.explore.ExplorePresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ExploreModule.class, NetModule.class})
public interface AppComponent {

    void inject(ExploreFragment fragment);

    void inject(ExplorePresenter presenter);

    void inject(ApiService service);

}
