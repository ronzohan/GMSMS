package com.example.ronzohan.gmsms.Screens.MessageList;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.ronzohan.gmsms.BuildConfig;
import com.example.ronzohan.gmsms.R;
import com.example.ronzohan.gmsms.Screens.MessageInfo.MessageInfoActivity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


import org.junit.runner.RunWith;

import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import static org.robolectric.Shadows.shadowOf;


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
        clickItem(messageListListView, 0);
        ShadowActivity shadowActivity = shadowOf(messageListActivity);

        Intent startedIntent = shadowActivity.getNextStartedActivity();
        assertEquals(startedIntent.getComponent().getClassName(),
                MessageInfoActivity.class.getName());
    }

    public static void clickItem(AbsListView listView, int position) {
        ListAdapter adapter = listView.getAdapter();
        View itemView = adapter.getView(position, null, listView);
        listView.performItemClick(itemView, position, adapter.getItemId(position));
    }
}

