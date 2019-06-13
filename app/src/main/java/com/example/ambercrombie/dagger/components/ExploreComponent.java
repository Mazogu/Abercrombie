package com.example.ambercrombie.dagger.components;

import com.example.ambercrombie.dagger.modules.ExploreModule;
import com.example.ambercrombie.dagger.modules.NetModule;
import com.example.ambercrombie.explore.ExploreFragment;
import com.example.ambercrombie.explore.ExplorePresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ExploreModule.class, NetModule.class})
public interface ExploreComponent {

    void inject(ExploreFragment fragment);

    void inject(ExplorePresenter presenter);

}
