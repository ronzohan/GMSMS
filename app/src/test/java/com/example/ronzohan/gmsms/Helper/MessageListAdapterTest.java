package com.example.ronzohan.gmsms.Helper;

import android.test.AndroidTestCase;

import com.example.ronzohan.gmsms.BuildConfig;
import com.example.ronzohan.gmsms.Utility.Messages.SMSMessage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MessageListAdapterTest extends AndroidTestCase {
    private SMSMessage sampleSMSMessage1, sampleSMSMessage2;
    private MessageListAdapter messageListAdapter;

    @Before
    public void setUp() {
        ArrayList<SMSMessage> smsMessageArrayList = new ArrayList<>();

        sampleSMSMessage1 = new SMSMessage("How are you");
        sampleSMSMessage2  = new SMSMessage("How are you there");
        smsMessageArrayList.add(sampleSMSMessage1);
        smsMessageArrayList.add(sampleSMSMessage2);

        messageListAdapter = new MessageListAdapter(RuntimeEnvironment.application, smsMessageArrayList);
    }

    @Test
    public void shouldHaveTwoEntries() {
        assertEquals(messageListAdapter.getCount(), 2);
    }

    // TODO add more test cases
}
