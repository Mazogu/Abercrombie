package com.example.abercrombie.ui.explore;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.abercrombie.R;
import com.example.abercrombie.dagger.components.DaggerAppComponent;
import com.example.abercrombie.data.Content;
import com.example.abercrombie.data.Explorative;
import com.example.abercrombie.ui.explore.ExploreActivity;
import com.example.abercrombie.ui.explore.ExploreFragment;
import com.example.abercrombie.ui.explore.ExplorePresenter;
import com.example.abercrombie.ui.webview.WebActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class ExploreFragmentTest {

    ActivityTestRule<ExploreActivity> rule = new ActivityTestRule<>(ExploreActivity.class);
    ExploreActivity activity;

    ExploreFragment fragment;

    @Before
    public void setup(){
        Intents.init();
        activity = rule.launchActivity(null);
        fragment = spy(new ExploreFragment());
        doNothing().when(fragment).makeRestCall();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
    }

    /**
     * Tests if the specified title is shown.
     */
    @Test
    public void testTitle(){
        String title = "Potatoes";
        Explorative explorative = new Explorative();
        explorative.setTitle(title);
        final List<Explorative> list = new ArrayList<>();
        list.add(explorative);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                fragment.sendResult(list);
            }
        });
        onView(withId(R.id.title)).check(matches(isDisplayed()));
        onView(withId(R.id.picture)).check(matches(not(isDisplayed())));
        onView(withId(R.id.bottomDescription)).check(matches(not(isDisplayed())));
        onView(withId(R.id.promo)).check(matches(not(isDisplayed())));
        onView(withId(R.id.topDescription)).check(matches(not(isDisplayed())));
        onView(withId(R.id.moreContent)).check(matches(not(isDisplayed())));
    }

    /**
     * Test if all of the elements of the content list appear.
     */
    @Test
    public void testContent(){
        Explorative explorative = new Explorative();
        Content content = new Content();
        String url = "https://www.tacobell.com/";
        content.setTitle("Tacos");
        content.setElementType("hyperlink");
        content.setTarget(url);
        List<Content> contentList = new ArrayList<>();
        contentList.add(content);
        explorative.setContent(contentList);
        final List<Explorative> list = new ArrayList<>();
        list.add(explorative);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                fragment.sendResult(list);
            }
        });
        onView(withId(R.id.moreContent)).check(matches(isDisplayed()));
        onView(withText("Tacos")).perform(click());
        Intents.intended(hasComponent(WebActivity.class.getName()));
        Espresso.pressBack();
        Intents.intended(hasComponent(ExploreActivity.class.getName()));
    }

    @After
    public void cleanup(){
        Intents.release();
    }
}
