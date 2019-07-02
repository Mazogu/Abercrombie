package com.example.abercrombie.ui.explore;

import com.example.abercrombie.data.Explorative;
import com.example.abercrombie.network.ApiService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;



@RunWith(MockitoJUnitRunner.class)
public class ExplorePresenterTest {
    @Mock
    ApiService service;

    @Mock
    ExploreContract.EView view;

    @InjectMocks ExplorePresenter presenter;

    /**
     * Verify that ApiService's "requestData" is called.
     */
    @Test
    public void getCards(){
        presenter.getCards();
        Mockito.verify(service).requestData();
    }

    /**
     * Verify that the view's "sendResult" is called.
     */
    @Test
    public void sendResult(){
        List<Explorative> list = Mockito.mock(List.class);
        presenter.sendData(list);
        verify(view).sendResult(list);
    }

    /**
     * Attempts to send a null result.
     */
    @Test
    public void sendNullResult(){
        List<Explorative> list = null;
        presenter.sendData(list);
        verify(view).sendResult(list);
    }

}
