package com.example.ronzohan.gmsms.Utility.Messages;

import com.example.ronzohan.gmsms.Utility.Recipients.Recipient;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class SMSMessageTest {
    SMSMessage smsMessageNoRecipient;
    SMSMessage smsMessageWithRecipients;
    int recipientCount = 0;

    @Before
    public void setUp() {
        Recipient firstRecipient = new Recipient(1,"Ron Magno","09169777569");
        recipientCount++;
        Recipient secondRecipient = new Recipient(1,"Clandine Salvedia","09355477233");
        recipientCount++;

        ArrayList<Recipient> recipientArrayList = new ArrayList<>();
        recipientArrayList.add(firstRecipient);
        recipientArrayList.add(secondRecipient);

        smsMessageNoRecipient = new SMSMessage("What are you doing");
        smsMessageWithRecipients = new SMSMessage("Whut u doin?", recipientArrayList);
    }

    @Test
    public void addRecipientToSMSMessage() throws Exception {
        Recipient firstRecipient = new Recipient(1,"Zohan","09169777769");
        smsMessageWithRecipients.addRecipient(firstRecipient);
        recipientCount++;
        assertEquals(smsMessageWithRecipients.getRecipients().size(), recipientCount);
    }

    @Test
    public void shouldNotAddRecipientWithSameContactNo() throws Exception {
        Recipient firstRecipient = new Recipient(1,"Zohan", "09169777769");
        ArrayList<Recipient> recipientArrayList = new ArrayList<>();
        SMSMessage smsMessageWithNoMultipleRecipients = new SMSMessage("Whut", recipientArrayList);

        smsMessageWithNoMultipleRecipients.addRecipient(firstRecipient);
        smsMessageWithNoMultipleRecipients.addRecipient(firstRecipient);
        assertEquals(smsMessageWithNoMultipleRecipients.getRecipients().size(), 1);
    }
}
