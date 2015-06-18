package com.example.ronzohan.gmsms.Screens.MessageList;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.widget.ListView;

import com.example.ronzohan.gmsms.BuildConfig;
import com.example.ronzohan.gmsms.R;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.util.FragmentTestUtil;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MessageListFragmentTest {
    private MessageListFragment messageListFragment;
    private ListView messageListView;

    @Before
    public void setUp() {
        messageListFragment = new MessageListFragment();
        FragmentTestUtil.startFragment(messageListFragment);
        messageListView = (ListView)messageListFragment.getView().findViewById(R.id.message_list);
    }

    @Test
    public void shouldNotBeNullMessageList() {
        junit.framework.Assert.assertNotNull(messageListView);
    }
    @Test
    public void shouldNotBeNullFragment() {
        junit.framework.Assert.assertNotNull(messageListFragment);
    }

}
