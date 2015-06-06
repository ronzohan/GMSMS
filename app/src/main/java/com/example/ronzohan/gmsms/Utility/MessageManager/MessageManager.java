package com.example.ronzohan.gmsms.Utility.MessageManager;

import android.telephony.SmsManager;

import com.example.ronzohan.gmsms.Utility.Messages.SMSMessage;

public class MessageManager {
    private  SMSMessage mSMSMessage;
    SmsManager smsManager = SmsManager.getDefault();

    public MessageManager(SMSMessage smsMessage) {
        this.mSMSMessage = smsMessage;
    }

    public void sendMessage() {
        int recipientCount = mSMSMessage.getRecipients().size();
        String message = mSMSMessage.getMessage();

        for (int i=0;i<recipientCount;i++) {
            smsManager.sendTextMessage(mSMSMessage.getRecipients().get(i).getContactNo(),
                    null, message , null, null);
        }
    }
}
