package com.example.ambercrombie.ui.explore;

import com.example.ambercrombie.ui.BasePresenter;
import com.example.ambercrombie.ui.BaseView;
import com.example.ambercrombie.data.Explorative;

import java.util.List;

public interface ExploreContract {
    interface EView extends BaseView{
        void sendResult(List<Explorative> list);
    }
    interface EPresenter extends BasePresenter<EView>{
        void getCards();
    }
}
