package com.example.ronzohan.gmsms.Screens;

import android.app.Fragment;
import android.os.Bundle;
import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

import com.example.ronzohan.gmsms.R;

/**
 * Created by ronzohan on 5/21/15.
 */
public class MessageListActivity extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_message_list);

        FragmentManager fm = getFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.fragment_container_message_list);
        if (fragment == null) {
            fragment = new MessageListFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container_message_list, fragment)
                    .commit();
        }
    }
}
