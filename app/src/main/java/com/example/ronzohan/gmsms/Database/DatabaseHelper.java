package com.example.ronzohan.gmsms.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ronzohan.gmsms.Utility.DaySchedule.DaySchedule;
import com.example.ronzohan.gmsms.Utility.Messages.SMSMessage;
import com.example.ronzohan.gmsms.Utility.Recipients.Recipient;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "GMSMS";

    //Table Name
    private static final String TABLE_MESSAGEINFO = "messageinfo";
    private static final String TABLE_SIMASSIGNED =  "simassigned";
    private static final String TABLE_RECIPIENTS = "recipients";
    private static final String TABLE_DAYS = "days";

    //MessageInfo Column Names
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_MESSAGE = "message";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_MESSAGEINFO_FK = "messageinfo_FK";

    //SimAssigned Column Names
    private static final String COLUMN_SIMNAME = "simname";

    //Recipients Column Names
    private static final String COLUMN_CONTACTID = "contact_id";
    private static final String COLUMN_CONTACTNAME = "name";
    private static final String COLUMN_CONTACTADDRESS = "address";
    private static final String COLUMN_CONTACTNO = "contact_no";

    //Days Column Names
    private static final String COLUMN_MONDAY = "monday";
    private static final String COLUMN_TUESDAY = "tuesday";
    private static final String COLUMN_WEDNESDAY = "wednesday";
    private static final String COLUMN_THURSDAY = "thursday";
    private static final String COLUMN_FRIDAY = "friday";
    private static final String COLUMN_SATURDAY = "saturday";
    private static final String COLUMN_SUNDAY = "sunday";



    private static final String CREATE_MESSAGEINFO_TABLE = "CREATE TABLE " +  TABLE_MESSAGEINFO + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_MESSAGE + " TEXT,"
            + COLUMN_TIME + " DATETIME" + ");";

    private static final String CREATE_SIMASSIGNED_TABLE = "CREATE TABLE " + TABLE_SIMASSIGNED + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_SIMNAME + " TEXT,"
            + COLUMN_MESSAGEINFO_FK + " INTEGER, FOREIGN KEY ("+ COLUMN_MESSAGEINFO_FK
            +") REFERENCES " + TABLE_MESSAGEINFO + "(" + COLUMN_ID+ ")" + ");";

    private static final String CREATE_RECIPIENTS_TABLE = "CREATE TABLE " + TABLE_RECIPIENTS + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_CONTACTID + " INTEGER,"
            + COLUMN_CONTACTNAME + " TEXT," + COLUMN_CONTACTADDRESS + " TEXT, "
            + COLUMN_MESSAGEINFO_FK + " INTEGER, FOREIGN KEY ("+ COLUMN_MESSAGEINFO_FK
            +") REFERENCES " + TABLE_MESSAGEINFO + "(" + COLUMN_ID+ ")" + ");";

    private static final String CREATE_DAYS_TABLE = "CREATE TABLE " + TABLE_DAYS + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_MONDAY + " INTEGER,"
            + COLUMN_TUESDAY + " INTEGER,"
            + COLUMN_WEDNESDAY + " INTEGER,"
            + COLUMN_THURSDAY + " INTEGER,"
            + COLUMN_FRIDAY + " INTEGER,"
            + COLUMN_SATURDAY + " INTEGER,"
            + COLUMN_SUNDAY + " INTEGER,"
            + COLUMN_MESSAGEINFO_FK + " INTEGER, FOREIGN KEY ("+ COLUMN_MESSAGEINFO_FK
            +") REFERENCES " + TABLE_MESSAGEINFO + "(" + COLUMN_ID+ ")" + ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DAYS_TABLE);
        db.execSQL(CREATE_MESSAGEINFO_TABLE);
        db.execSQL(CREATE_RECIPIENTS_TABLE);
        db.execSQL(CREATE_SIMASSIGNED_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGEINFO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DAYS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPIENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SIMASSIGNED);
        onCreate(db);
    }

    public long insertMessageInfo(SMSMessage smsMessage) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_MESSAGE, smsMessage.getMessage());
        values.put(COLUMN_TIME, smsMessage.getTime().toString());

        return getWritableDatabase().insert(
                TABLE_MESSAGEINFO,
                null,
                values);
    }

//    public SMSMessage getSMSMessage(int smsMessageID) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String selectQuery = "SELECT  * FROM " + TABLE_MESSAGEINFO + " WHERE "
//                + COLUMN_ID + " = " + smsMessageID;
//
//        Cursor c = db.rawQuery(selectQuery, null);
//        if (c != null)
//            c.moveToFirst();
//
//        SMSMessage smsMessage = new SMSMessage()
//    }
    public long insertDaySchedule(int messageInfoID, DaySchedule daySchedule) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_MONDAY, daySchedule.getMONDAY());
        values.put(COLUMN_TUESDAY, daySchedule.getTUESDAY());
        values.put(COLUMN_WEDNESDAY, daySchedule.getWEDNESDAY());
        values.put(COLUMN_THURSDAY, daySchedule.getTHURSDAY());
        values.put(COLUMN_FRIDAY, daySchedule.getFRIDAY());
        values.put(COLUMN_SATURDAY, daySchedule.getSATURDAY());
        values.put(COLUMN_SUNDAY, daySchedule.getSUNDAY());
        values.put(COLUMN_MESSAGEINFO_FK, messageInfoID);

        return getWritableDatabase().insert(TABLE_DAYS, null, values);
    }

    public DaySchedule getDaySchedule(long dayScheduleID) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_DAYS + " WHERE "
                + COLUMN_ID + " = " + dayScheduleID;

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null)
            cursor.moveToFirst();


        DaySchedule daySchedule = new DaySchedule();
        daySchedule.setId(cursor.getInt(0));
        daySchedule.setMONDAY(cursor.getInt(1));
        daySchedule.setTUESDAY(cursor.getInt(2));
        daySchedule.setWEDNESDAY(cursor.getInt(3));
        daySchedule.setTHURSDAY(cursor.getInt(4));
        daySchedule.setFRIDAY(cursor.getInt(5));
        daySchedule.setSATURDAY(cursor.getInt(6));
        daySchedule.setSUNDAY(cursor.getInt(7));
        daySchedule.setMessageInfoID(cursor.getInt(8));

        return daySchedule;
    }

    public long insertRecipients(int messageInfoID, Recipient recipient) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_CONTACTID, recipient.getmContactID());
        values.put(COLUMN_CONTACTNAME, recipient.getName());
        values.put(COLUMN_CONTACTADDRESS, recipient.getAddress());

        return getWritableDatabase().insert(TABLE_RECIPIENTS, null, values);
    }

    public Recipient getRecipient(long recipientID) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_RECIPIENTS + " WHERE "
                + COLUMN_ID + " = " + recipientID;

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null)
            cursor.moveToFirst();

        long recpientIDFromDB = cursor.getInt(0);
        String recipientName = cursor.getString(1);
        String recipientContactNo = cursor.getString(2);
        long recipientContactID = cursor.getInt(3);

        Recipient recipient = new Recipient(recpientIDFromDB, recipientName, recipientContactNo, recipientContactID);

        return recipient;
    }

}
