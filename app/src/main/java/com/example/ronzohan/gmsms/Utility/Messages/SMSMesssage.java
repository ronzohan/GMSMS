package com.example.ronzohan.gmsms.Utility.Messages;

import com.example.ronzohan.gmsms.Utility.Recipients.Recipient;

import java.util.ArrayList;

/**
 * Created by ronzohan on 5/24/15.
 */
public class SMSMesssage implements Message {
    private ArrayList<Recipient> messageRecipients;
    private String message;

    public SMSMesssage(String message) {
        this.message = message;
    }

    public SMSMesssage(String message, ArrayList<Recipient> messageRecipients) {
        this.message = message;
        this.messageRecipients = messageRecipients;
    }

    public ArrayList<Recipient> getRecipients() {
        return messageRecipients;
    }

    public void addRecipient(Recipient recipient) {
        messageRecipients.add(recipient);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public int SendMessage() {
        return 0;
    }

}
