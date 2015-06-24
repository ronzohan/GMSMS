package com.example.ronzohan.gmsms.Utility.Messages;

import com.example.ronzohan.gmsms.Utility.Recipients.Recipient;

import java.util.ArrayList;
import java.util.Date;

public class SMSMessage implements Message {
    private ArrayList<Recipient> messageRecipients;
    private String message;
    private Date time;


    public SMSMessage(String message) {
        this.message = message;
    }

    public SMSMessage(String message, ArrayList<Recipient> messageRecipients) {
        this.message = message;
        this.messageRecipients = messageRecipients;
    }

    public ArrayList<Recipient> getRecipients() {
        return messageRecipients;
    }

    public void addRecipient(Recipient recipient) {
        if (!messageRecipients.contains(recipient))
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
