package com.example.ronzohan.gmsms.Screens.MessageList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.ListFragment;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ronzohan.gmsms.Helper.MessageListAdapter;
import com.example.ronzohan.gmsms.R;
import com.example.ronzohan.gmsms.Utility.Messages.SMSMessage;

import java.util.ArrayList;

public class MessageListFragment extends ListFragment{
    private ArrayList<SMSMessage> smsMessageArrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_message_list, container, false);

        ListView listView = (ListView)view.findViewById(R.id.message_list);
        SMSMessage smsMessage = new SMSMessage("Hello there");
        SMSMessage smsMessage2 = new SMSMessage("Hello there2");
        smsMessageArrayList = new ArrayList<>();
        smsMessageArrayList.add(smsMessage);
        smsMessageArrayList.add(smsMessage2);

        MessageListAdapter messageListAdapter = new MessageListAdapter(getActivity(), smsMessageArrayList);
        listView.setAdapter(messageListAdapter);
        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(), smsMessageArrayList.get(position).getMessage() ,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}
