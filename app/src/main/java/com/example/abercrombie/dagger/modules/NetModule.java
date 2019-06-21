package com.example.abercrombie.dagger.modules;

import com.example.abercrombie.network.ApiService;
import com.example.abercrombie.network.retrofit.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetModule {

    String baseUrl;

    public NetModule(String baseUrl){
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    RetrofitHelper.RetrofitService providesService(){
       return RetrofitHelper.getService(baseUrl);
    }

    @Provides
    @Singleton
    ApiService providesApiService(){return new ApiService();}
}
