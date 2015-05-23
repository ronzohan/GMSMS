package com.example.ronzohan.gmsms.Utility.Messages;

import com.example.ronzohan.gmsms.Utility.Recipients.Recipient;
import java.util.ArrayList;

/**
 * Created by ronzohan on 5/24/15.
 */
public interface Message {
    String getMessage();
    void setMessage(String message);

    ArrayList<Recipient> getRecipients();

    void addRecipient(Recipient recipient);

    int SendMessage();
}
