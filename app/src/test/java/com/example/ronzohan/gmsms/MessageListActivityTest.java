package com.example.ronzohan.gmsms;

import android.app.Activity;
import android.view.View;
import android.widget.ListView;

import com.example.ronzohan.gmsms.Screens.MessageList.MessageListActivity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.runner.RunWith;

import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;



@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MessageListActivityTest {
    private Activity messageListActivity;
    private ListView messageListListView;

    @Before
    public void setUp() throws Exception{
        messageListActivity = new MessageListActivity();
        messageListActivity = Robolectric.setupActivity(MessageListActivity.class);
        messageListListView = (ListView)messageListActivity.findViewById(R.id.message_list);
    }

    @Test
    public void shouldDisplayTitle() throws Exception {
        assertEquals(messageListActivity.getTitle().toString(), "Home");
    }

    @Test
    public void listViewIsVisibleIfThereAreItems() throws Exception {
        assertEquals(messageListListView.getVisibility(), View.VISIBLE);
        assertNotEquals(messageListListView.getCount(), 0);
    }

    @Test
    public void shouldDisplayMessageInfoActivityWhenListViewItemIsClicked() throws Exception {

    }
    // TODO - Implement this scenario
    @Test
    public void shouldDisplayEmptyIfListViewIsEmpty() throws Exception {

    }
}

