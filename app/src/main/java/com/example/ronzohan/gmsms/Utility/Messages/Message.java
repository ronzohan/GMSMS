package com.example.ronzohan.gmsms.Utility.Messages;

import com.example.ronzohan.gmsms.Utility.Recipients.Recipient;
import java.util.ArrayList;

public interface Message {
    String getMessage();
    void setMessage(String message);

    ArrayList<Recipient> getRecipients();

    void addRecipient(Recipient recipient);

    int SendMessage();
}
