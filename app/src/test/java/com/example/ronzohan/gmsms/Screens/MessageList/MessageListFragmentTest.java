package com.example.ronzohan.gmsms.Screens.MessageList;

import android.app.Fragment;

import com.example.ronzohan.gmsms.BuildConfig;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.FragmentTestUtil;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MessageListFragmentTest {
    private MessageListFragment messageListFragment;

    @Before
    public void setUp() {
        messageListFragment = new MessageListFragment();
        FragmentTestUtil.startFragment(messageListFragment);
    }

    @Test
    public void shouldNotBeNull() {
        junit.framework.Assert.assertNotNull(messageListFragment);
    }

}
