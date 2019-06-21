package com.example.ambercrombie.ui.explore;

import com.example.ambercrombie.data.Explorative;
import com.example.ambercrombie.network.ApiService;
import com.example.ambercrombie.network.retrofit.RetrofitHelper;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

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
    ApiService service;

    @Mock
    ExploreContract.EView view;

    @InjectMocks ExplorePresenter presenter;

    @Test
    public void getCards(){
        presenter.getCards();
        Mockito.verify(service).requestData();
    }

}
