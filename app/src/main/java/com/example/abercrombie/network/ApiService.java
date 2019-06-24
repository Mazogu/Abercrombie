package com.example.abercrombie.network;

import com.example.abercrombie.dagger.components.AppComponent;
import com.example.abercrombie.data.Explorative;
import com.example.abercrombie.network.retrofit.RetrofitHelper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ApiService {

    @Inject
    RetrofitHelper.RetrofitService service;

    ApiCallBack callBack;

    public void setCallBack(ApiCallBack source, AppComponent component){
        callBack = source;
        component.inject(this);
    }


    /**
     * Uses an observer to get emitted list to display and returns it to the fragment.
     */
    public void requestData(){
        service.getExploratives().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Explorative>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Explorative> exploratives) {
                        if(callBack != null)
                            callBack.sendData(exploratives);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
