package com.example.abercrombie.network;

import com.example.abercrombie.data.Explorative;
import com.example.abercrombie.network.retrofit.RetrofitHelper;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

@RunWith(MockitoJUnitRunner.class)
public class ApiServiceTest {

    @Mock
    ApiCallBack callBack;

    @Mock
    RetrofitHelper.RetrofitService service;

    ApiService apiService;

    @BeforeClass
    public static void setUp(){
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(Callable<Scheduler> __) throws Exception {
                return Schedulers.trampoline();
            }
        });
    }

    @Before
    public void setMocks(){
        MockitoAnnotations.initMocks(this);
        apiService = new ApiService(service);
        apiService.setCallBack(callBack);
    }


    /**
     * Tests the emission of an empty list.
     */
    @Test
    public void testEmptyEmission(){
        Mockito.when(service.getExploratives()).thenReturn(Observable.just(Collections.<Explorative>emptyList()));
        apiService.requestData();
        Mockito.verify(callBack).sendData(Collections.<Explorative>emptyList());
    }

    /**
     * Test the emission of a list with things in it.
     */
    @Test
    public void listEmission(){
        List<Explorative> list =  Mockito.mock(List.class);
        Mockito.when(service.getExploratives()).thenReturn(Observable.just(list));
        apiService.requestData();
        Mockito.verify(callBack).sendData(list);
    }
}
