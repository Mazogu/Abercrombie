package com.example.ambercrombie.explore;

import com.example.ambercrombie.data.Explorative;
import com.example.ambercrombie.retrofit.RetrofitHelper;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class ExplorePresenterTest {
    @Mock
    RetrofitHelper.RetrofitService service;

    @Mock
    ExploreContract.EView view;

    @InjectMocks ExplorePresenter presenter;

    @BeforeClass
    public static void setUp(){
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(Callable<Scheduler> __) throws Exception {
                return Schedulers.trampoline();
            }
        });
    }

    @Test
    public void getCards(){
        presenter.getCards();
        Mockito.verify(service).getExploratives();
    }

    @Test
    public void testEmptyEmission(){
        Mockito.when(service.getExploratives()).thenReturn(Observable.just(Collections.<Explorative>emptyList()));
        presenter.getCards();
        Mockito.verify(view).sendResult(Collections.<Explorative>emptyList());
    }

    @Test
    public void listEmission(){
        List<Explorative> list =  Mockito.mock(List.class);
        Mockito.when(service.getExploratives()).thenReturn(Observable.just(list));
        presenter.getCards();
        Mockito.verify(view).sendResult(list);
    }

}
