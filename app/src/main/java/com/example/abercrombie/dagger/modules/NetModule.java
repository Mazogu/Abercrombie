package com.example.abercrombie.dagger.modules;

import com.example.abercrombie.network.ApiService;
import com.example.abercrombie.network.retrofit.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provides classes for making the RESTful call.
 */
@Module
public class NetModule {

    String baseUrl;

    public NetModule(String baseUrl){
        this.baseUrl = baseUrl;
    }

    /**
     * Creates a Retrofit services from provided url.
     * @return Retrofit Service from factory.
     */
    @Provides
    @Singleton
    RetrofitHelper.RetrofitService providesService(){
       return RetrofitHelper.getService(baseUrl);
    }

    /**
     * Injects Retrofit Service and creates a wrapper for the get call.
     * @param service
     * @return
     */
    @Provides
    @Singleton
    ApiService providesApiService(RetrofitHelper.RetrofitService service){return new ApiService(service);}
}
