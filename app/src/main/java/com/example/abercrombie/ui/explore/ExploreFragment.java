package com.example.abercrombie.ui.explore;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.abercrombie.R;
import com.example.abercrombie.dagger.components.AppComponent;
import com.example.abercrombie.data.Explorative;
import com.example.abercrombie.ui.AbercrombieApp;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExploreFragment extends Fragment implements ExploreContract.EView {

    @BindView(R.id.exploreList)
    RecyclerView recyclerView;

    @Inject
    ExploreContract.EPresenter presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAppComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        ButterKnife.bind(this,view);
        if(presenter != null){
            presenter.attachView(this);
            presenter.getCards();
        }
        return view;
    }

    @Override
    public void onDestroy() {
        if(presenter != null)
            presenter.detachView();
        super.onDestroy();
    }

    /**
     * Called from presenter shows sent string.
     * @param s Message to show.
     */
    @Override
    public void showError(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public AppComponent getAppComponent() {
        return ((AbercrombieApp)getActivity().getApplication()).getAppComponent();
    }

    /**
     * Gets the list of elements from GET response.
     * @param list List of pojo elements from JSON string
     */
    @Override
    public void sendResult(List<Explorative> list) {
        if(recyclerView == null)
            return;
        ExploreAdapter adapter = new ExploreAdapter(list,getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }
}
