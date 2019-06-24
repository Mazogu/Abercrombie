package com.example.abercrombie.ui.explore;

import android.content.Intent;
import android.support.v4.app.Fragment;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.abercrombie.ui.explore.ExploreActivity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ExploreActivityTest {
    ActivityTestRule<ExploreActivity> rule = new ActivityTestRule<>(ExploreActivity.class);


    @Test
    public void test(){
        ExploreActivity main = rule.launchActivity(new Intent());
        Fragment fragment = main.getSupportFragmentManager().findFragmentByTag("Explore");
        Assert.assertTrue(fragment != null);
    }

}
