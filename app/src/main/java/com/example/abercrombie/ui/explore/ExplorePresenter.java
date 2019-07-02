package com.example.abercrombie.ui.explore;

import com.example.abercrombie.data.Explorative;
import com.example.abercrombie.network.ApiCallBack;
import com.example.abercrombie.network.ApiService;
import java.util.List;
import javax.inject.Inject;
import static com.example.abercrombie.ui.explore.ExploreContract.*;

public class ExplorePresenter implements EPresenter, ApiCallBack {

    private EView view;

    private ApiService service;


    public ExplorePresenter(EView view, ApiService service){
        this.view = view;
        this.service = service;
    }

    /**
     * Gets Abstract reference to the fragment it communicates to;
     * @param view
     */
    @Override
    public void attachView(EView view) {
        this.view = view;
        service.setCallBack(this);
    }

    @Override
    public void detachView() { this.view = null; }


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
