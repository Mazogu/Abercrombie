package com.example.abercrombie.ui.explore;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.abercrombie.R;

public class ExploreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment = new ExploreFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment,"Explore").commit();
    }
}
