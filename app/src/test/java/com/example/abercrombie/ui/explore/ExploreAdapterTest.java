package com.example.abercrombie.ui.explore;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.test.core.app.ApplicationProvider;

import com.example.abercrombie.data.Content;
import com.example.abercrombie.data.Explorative;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
public class ExploreAdapterTest {

    private Context context;

    @Before
    public void setup(){
        context = ApplicationProvider.getApplicationContext();

    }

    /**
     * Attempts to call onBind on a single Explorative.
     */
    @Test
    public void singleEntryOnBindTest(){
        ExploreAdapter.ExploreHolder viewHolder = mock(ExploreAdapter.ExploreHolder.class);
        String titleString = "Super Mushroom";
        TextView title = spy(new TextView(context));
        ImageView imageView = spy(new ImageView(context));
        setDummyData(viewHolder);
        viewHolder.image = imageView;
        viewHolder.title = title;
        Explorative explorative = new Explorative();
        explorative.setBackgroundImage("https://en.wikipedia.org/wiki/Super_Mario#/media/File:Supermushroom.png");
        explorative.setTitle(titleString);
        List<Explorative> list = new ArrayList<>();
        list.add(explorative);
        ExploreAdapter testAdapter = new ExploreAdapter(list,context);
        testAdapter.onBindViewHolder(viewHolder,0);
        verify(title).setVisibility(View.VISIBLE);
        verify(title).setText(titleString);
        Assert.assertEquals("Super Mushroom",title.getText().toString());

    }

    /**
     * Calls onBind for multiple Exploratives.
     */
    @Test
    public void multipleExplorativesTest(){
        String titleOne = "Taco";
        String bottomDescOne = "Tacos are supreme";
        String promoTwo = "Free Burritos";
        String topDescThree = "I want pizza";
        Content contentA = new Content();
        Content contentB = new Content();
        contentA.setElementType("testlink");
        contentA.setTarget("https://www.google.com/");
        contentA.setTitle("First Content");
        contentB.setElementType("testlink");
        contentB.setTarget("https://www.yahoo.com/");
        contentB.setTitle("Second Content");
        List<Content> contents = new ArrayList<>();
        contents.add(contentA);
        contents.add(contentB);
        Explorative one = new Explorative();
        one.setTitle(titleOne);
        one.setBottomDescription(bottomDescOne);
        Explorative two = new Explorative();
        two.setPromoMessage(promoTwo);
        Explorative three = new Explorative();
        three.setTopDescription(topDescThree);
        three.setContent(contents);

        List<Explorative> data = new ArrayList<>();
        data.add(one);
        data.add(two);
        data.add(three);

        ExploreAdapter adapter = new ExploreAdapter(data, context);

        TextView titleText = spy(new TextView(context));
        TextView bottomDescText = spy(new TextView(context));
        TextView promoText = spy(new TextView(context));
        TextView topDescText = spy(new TextView(context));
        LinearLayout contentView = spy(new LinearLayout(context));
        ExploreAdapter.ExploreHolder viewHolder1 = mock(ExploreAdapter.ExploreHolder.class);
        ExploreAdapter.ExploreHolder viewHolder2 = mock(ExploreAdapter.ExploreHolder.class);
        ExploreAdapter.ExploreHolder viewHolder3 = mock(ExploreAdapter.ExploreHolder.class);
        setDummyData(viewHolder1);
        setDummyData(viewHolder2);
        setDummyData(viewHolder3);

        viewHolder1.title = titleText;
        viewHolder1.bottomDescription = bottomDescText;
        viewHolder2.promo = promoText;
        viewHolder3.topDescription = topDescText;
        viewHolder3.content = contentView;

        List<ExploreAdapter.ExploreHolder> holders = new ArrayList<>();
        holders.add(viewHolder1);
        holders.add(viewHolder2);
        holders.add(viewHolder3);

        for (int i = 0; i < data.size(); i++) {
            adapter.onBindViewHolder(holders.get(i),i);
        }

        verify(titleText).setText(titleOne);
        verify(bottomDescText).setText(bottomDescOne);
        verify(promoText).setText(promoTwo);
        verify(topDescText).setText(topDescThree);
        verify(contentView).setVisibility(View.VISIBLE);

        Assert.assertEquals(titleOne,titleText.getText().toString());
        Assert.assertEquals(bottomDescOne,bottomDescText.getText().toString());
        Assert.assertEquals(promoTwo,promoText.getText().toString());
        Assert.assertEquals(topDescThree,topDescText.getText().toString());
    }

    private void setDummyData(ExploreAdapter.ExploreHolder holder){
        TextView textView = mock(TextView.class);
        ImageView imageView = mock(ImageView.class);
        LinearLayout layout = mock(LinearLayout.class);
        holder.image = imageView;
        holder.topDescription = textView;
        holder.title = textView;
        holder.bottomDescription = textView;
        holder.promo = textView;
        holder.content = layout;
    }
}
