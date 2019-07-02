package com.example.abercrombie.ui.explore;

import com.example.abercrombie.ui.BasePresenter;
import com.example.abercrombie.ui.BaseView;
import com.example.abercrombie.data.Explorative;

import java.util.List;

public interface ExploreContract {
    interface EView extends BaseView{
        /**
         * Sends list of Exploratives to the view.
         * @param list
         */
        void sendResult(List<Explorative> list);
    }
    interface EPresenter extends BasePresenter<EView>{
        /**
         * Starts api call.
         */
        void getCards();
    }
}
