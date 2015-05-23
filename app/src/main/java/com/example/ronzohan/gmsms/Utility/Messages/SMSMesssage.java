package com.example.ronzohan.gmsms.Utility.Messages;

import com.example.ronzohan.gmsms.Utility.Recipients.Recipient;

/**
 * Created by ronzohan on 5/24/15.
 */
public class SMSMesssage implements Message {
    private Recipient[] messageRecipeints;

    public Recipient[] getMessageRecipeints() {
        return messageRecipeints;
    }

    public void setMessageRecipeints(Recipient[] messageRecipeints) {
        this.messageRecipeints = messageRecipeints;
    }

    @Override
    public int SendMessage() {
        return 0;
    }

}
