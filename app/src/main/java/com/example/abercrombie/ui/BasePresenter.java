package com.example.abercrombie.ui;

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void detachView();
}
