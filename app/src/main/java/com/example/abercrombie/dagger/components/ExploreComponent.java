package com.example.abercrombie.dagger.components;


import com.example.abercrombie.dagger.modules.ExploreModule;
import com.example.abercrombie.dagger.scope.ExploreScope;
import com.example.abercrombie.ui.explore.ExploreFragment;
import com.example.abercrombie.ui.explore.ExplorePresenter;

import dagger.Subcomponent;

/**
 * Component for the ExploreFragment scope.
 */
@ExploreScope
@Subcomponent(modules = {ExploreModule.class})
public interface ExploreComponent {
    /**
     * Sends provides to the fragment. 
     * @param fragment
     */
    void inject(ExploreFragment fragment);
}
