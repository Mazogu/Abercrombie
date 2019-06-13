package com.example.ambercrombie;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.Fragment;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void test(){
        MainActivity main = rule.launchActivity(new Intent());
        Fragment fragment = main.getSupportFragmentManager().findFragmentByTag("Explore");
        Assert.assertTrue(fragment != null);
    }

}
