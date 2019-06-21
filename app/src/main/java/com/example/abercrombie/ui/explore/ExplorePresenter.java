package com.example.abercrombie.ui.explore;

import com.example.abercrombie.data.Explorative;
import com.example.abercrombie.network.ApiCallBack;
import com.example.abercrombie.network.ApiService;
import java.util.List;
import javax.inject.Inject;
import static com.example.abercrombie.ui.explore.ExploreContract.*;

public class ExplorePresenter implements EPresenter, ApiCallBack {

    private EView view;

    @Inject
    ApiService service;


    public ExplorePresenter(){

    }

    /**
     * Gets Abstract reference to the fragment it communicates to;
     * @param view
     */
    @Override
    public void attachView(EView view) {
        this.view = view;
        view.getAppComponent().inject(this);
        service.setCallBack(this,view.getAppComponent());
    }

    @Override
    public void detachView() { this.view = null; }

    /**
     * Uses an observer to get emitted list to display and returns it to the fragment.
     */
    @Override
    public void getCards() {
        if(service == null)
            return;
        service.requestData();
    }

    @Override
    public void sendData(List<Explorative> list) {
        view.sendResult(list);
    }
}
