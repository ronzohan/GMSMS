package com.example.ronzohan.gmsms.Utility.MessageManager;

import com.example.ronzohan.gmsms.BuildConfig;
import com.example.ronzohan.gmsms.Utility.Messages.SMSMessage;
import com.example.ronzohan.gmsms.Utility.Recipients.Recipient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import static org.robolectric.Shadows.shadowOf;
import org.robolectric.shadows.ShadowSmsManager;
import java.util.ArrayList;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MessageManagerTest {
    SMSMessage smsMessageWithRecipients, smsMessageNoRecipient;

    @Before
    public void setUp() {
        Recipient recipient = new Recipient("Clandine Salvedia","09355477233");

        ArrayList<Recipient> recipientArrayList = new ArrayList<>();
        recipientArrayList.add(recipient);

        smsMessageNoRecipient = new SMSMessage("What are you doing");
        smsMessageWithRecipients = new SMSMessage("Whut u doin?", recipientArrayList);
    }

    @Test
    public void shouldSendMessage() {
        MessageManager messageManager = new MessageManager(smsMessageWithRecipients);
        messageManager.sendMessage();
        ShadowSmsManager.TextSmsParams params =
                shadowOf(messageManager.smsManager).getLastSentTextMessageParams();

        assertEquals(params.getDestinationAddress(), "09355477233");

        smsMessageWithRecipients.addRecipient(new Recipient("Ron Magno", "09169777569"));
        messageManager.sendMessage();
        ShadowSmsManager.TextSmsParams params2 =
                shadowOf(messageManager.smsManager).getLastSentTextMessageParams();

        assertEquals(params2.getDestinationAddress(), "09169777569");
        assertEquals(params2.getText(), "Whut u doin?");

    }
}
