package com.example.ambercrombie.ui;

import com.example.ambercrombie.dagger.components.AppComponent;

public interface BaseView {
    void showError(String s);
    AppComponent getAppComponent();
}
