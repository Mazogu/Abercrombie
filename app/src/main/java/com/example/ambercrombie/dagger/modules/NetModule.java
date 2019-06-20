package com.example.ambercrombie.dagger.modules;

import com.example.ambercrombie.network.retrofit.RetrofitHelper;

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
}
