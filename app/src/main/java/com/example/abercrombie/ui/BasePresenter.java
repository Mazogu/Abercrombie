package com.example.abercrombie.ui;

public interface BasePresenter<V extends BaseView> {
    /**
     * Acquires an instance of the view.
     * @param view
     */
    void attachView(V view);

    /**
     * Removes instance of view.
     */
    void detachView();
}
