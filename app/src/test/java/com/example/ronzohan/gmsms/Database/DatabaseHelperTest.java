package com.example.ronzohan.gmsms.Database;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

import com.example.ronzohan.gmsms.BuildConfig;
import com.example.ronzohan.gmsms.Utility.DaySchedule.DaySchedule;
import com.example.ronzohan.gmsms.Utility.Recipients.Recipient;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class DatabaseHelperTest {
    private DatabaseHelper databaseHelper;
    private int messageInfoDoesNotExist = -1;
    @Before
    public void setUp() throws Exception{
        String dbName = "/GMSMS";
        String filePath = getClass().getResource(dbName).toURI().getPath();

        databaseHelper = new DatabaseHelper(RuntimeEnvironment.application);
    }

    @Test
    public void shouldInsertAndRetrieveDaySchedule() {
        DaySchedule daySchedule = new DaySchedule(0,0,0,0,0,0,0);
        long dayScheduleID = databaseHelper.insertDaySchedule(messageInfoDoesNotExist, daySchedule);

        daySchedule.setId(dayScheduleID);
        DaySchedule dayScheduleFromDB = databaseHelper.getDaySchedule(dayScheduleID);

        assertEquals(daySchedule.getId(), dayScheduleFromDB.getId());
        assertEquals(daySchedule.getMONDAY(), dayScheduleFromDB.getMONDAY());
        assertEquals(daySchedule.getTUESDAY(), dayScheduleFromDB.getTUESDAY());
        assertEquals(daySchedule.getWEDNESDAY(), dayScheduleFromDB.getWEDNESDAY());
        assertEquals(daySchedule.getTHURSDAY(), dayScheduleFromDB.getTHURSDAY());
        assertEquals(daySchedule.getFRIDAY(), dayScheduleFromDB.getFRIDAY());
        assertEquals(daySchedule.getSATURDAY(), dayScheduleFromDB.getSATURDAY());
        assertEquals(daySchedule.getSUNDAY(), dayScheduleFromDB.getSUNDAY());
        assertEquals(daySchedule.getMessageInfoID(), dayScheduleFromDB.getMessageInfoID());
    }

    public void shouldInsertAndRetrieveRecipient() {
        Recipient recipient = new Recipient("Ron Magno", "09169777569");
        long recipientIDFromDB = databaseHelper.insertRecipients(messageInfoDoesNotExist, recipient);

        Recipient recipientFromDB = databaseHelper.getRecipient(recipientIDFromDB);

        assertEquals(recipient.getAddress(), recipientFromDB.getAddress());
        assertEquals(recipient.getContactNo(), recipientFromDB.getContactNo());
        assertEquals(recipient.getmContactID(), recipientFromDB.getmContactID());
        assertEquals(recipient.getName(), recipientFromDB.getName());
    }


}
