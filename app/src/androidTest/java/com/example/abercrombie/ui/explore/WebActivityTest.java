package com.example.abercrombie.ui.explore;


import android.content.Intent;
import android.webkit.WebView;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.abercrombie.R;
import com.example.abercrombie.ui.webview.WebActivity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(AndroidJUnit4.class)
public class WebActivityTest {
    ActivityTestRule<WebActivity> rule = new ActivityTestRule<>(WebActivity.class);


    @Test
    public void googleIntentTest(){
        final String google = "https://www.google.com/";
        Intent intent = new Intent();
        intent.putExtra(WebActivity.WEB_INTENT, google);
        WebActivity webActivity = rule.launchActivity(intent);
        final WebView webView = webActivity.findViewById(R.id.webview);
        webActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Assert.assertEquals(google,webView.getUrl());
            }
        });
    }


    @Test
    public void nullIntentTest(){
        WebActivity webActivity = rule.launchActivity(null);
        final WebView webView = webActivity.findViewById(R.id.webview);
        webActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Assert.assertNull(webView.getUrl());
            }
        });
    }

    @Test
    public void emptyIntentTest(){
        WebActivity webActivity = rule.launchActivity(new Intent());
        final WebView webView = webActivity.findViewById(R.id.webview);
        webActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Assert.assertNull(webView.getUrl());
            }
        });
    }

    @Test
    public void emptyStringTest(){
        Intent intent = new Intent();
        intent.putExtra(WebActivity.WEB_INTENT, "");
        WebActivity webActivity = rule.launchActivity(intent);
        final WebView webView = webActivity.findViewById(R.id.webview);
        webActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Assert.assertEquals("about:blank",webView.getUrl());
            }
        });
    }
}
