package com.example.ronzohan.gmsms.Helper;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ronzohan.gmsms.R;
import com.example.ronzohan.gmsms.Utility.Messages.SMSMessage;

import java.util.ArrayList;
import java.util.List;

public class MessageListAdapter extends ArrayAdapter {
    ArrayList<SMSMessage> arrayListSMSMessages;
    private Context context;

    public MessageListAdapter(Context context, List items) {
        //set messages here
        super(context, R.layout.fragment_message_list_detail, items);
        this.context = context;
        this.arrayListSMSMessages = (ArrayList<SMSMessage>)items;
    }

    @Override
    public int getCount() {
        return arrayListSMSMessages.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater = (LayoutInflater)context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        SMSMessage smsMessage = (SMSMessage)getItem(position);

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.fragment_message_list_detail, parent, false);
        }

        //TODO Set text for recipients
        TextView message_list_detail_recipients = (TextView)convertView
                .findViewById(R.id.message_list_detail_recipients);

        TextView message_list_detail_message = (TextView)convertView
                .findViewById(R.id.message_list_detail_message);

        message_list_detail_message.setText(smsMessage.getMessage());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return this.arrayListSMSMessages.get(position);
    }
}
