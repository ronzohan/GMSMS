package com.example.ronzohan.gmsms.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
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
    private static final String COLUMN_DAYS_FK = "days_FK";

    //SimAssigned Column Names
    private static final String COLUMN_SIMNAME = "simname";

    //Recipients Column Names
    private static final String COLUMN_CONTACTID = "contact_id";

    //Days Column Names
    private static final String COLUMN_MONDAY = "monday";
    private static final String COLUMN_TUESDAY = "tuesday";
    private static final String COLUMN_WEDNESDAY = "wednesday";
    private static final String COLUMN_THURSDAY = "thursday";
    private static final String COLUMN_FRIDAY = "friday";
    private static final String COLUMN_SATURDAY = "saturday";
    private static final String COLUMN_SUNDAY = "sunday";



    String CREATE_MESSAGEINFO_TABLE = "CREATE TABLE " +  TABLE_MESSAGEINFO + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_MESSAGE + " TEXT,"
            + COLUMN_TIME + " DATETIME," + COLUMN_DAYS_FK + " INTEGER, FOREIGN KEY ("
            + COLUMN_MESSAGEINFO_FK +") REFERENCES " + TABLE_DAYS
            + "(" + COLUMN_ID+ ")" + ");";

    String CREATE_SIMASSIGNED_TABLE = "CREATE TABLE " + TABLE_SIMASSIGNED + "("
            + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_SIMNAME + "TEXT,"
            + COLUMN_MESSAGEINFO_FK + "INTEGER, FOREIGN KEY ("+ COLUMN_MESSAGEINFO_FK
            +") REFERENCES " + TABLE_MESSAGEINFO + "(" + COLUMN_ID+ ")" + ");";

    String CREATE_RECIPIENTS_TABLE = "CREATE TABLE " + TABLE_RECIPIENTS + "("
            + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_CONTACTID + "INTEGER,"
            + COLUMN_MESSAGEINFO_FK + "INTEGER, FOREIGN KEY ("+ COLUMN_MESSAGEINFO_FK
            +") REFERENCES " + TABLE_MESSAGEINFO + "(" + COLUMN_ID+ ")" + ");";

    String CREATE_DAYS_TABLE = "CREATE TABLE" + TABLE_DAYS + "("
            + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_MONDAY + " INTEGER,"
            + COLUMN_TUESDAY + " INTEGER,"
            + COLUMN_WEDNESDAY + " INTEGER,"
            + COLUMN_THURSDAY + " INTEGER,"
            + COLUMN_FRIDAY + " INTEGER,"
            + COLUMN_SATURDAY + " INTEGER,"
            + COLUMN_SUNDAY + " INTEGER" + ");";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MESSAGEINFO_TABLE);
        db.execSQL(CREATE_DAYS_TABLE);
        db.execSQL(CREATE_RECIPIENTS_TABLE);
        db.execSQL(CREATE_SIMASSIGNED_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHandler.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGEINFO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DAYS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPIENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SIMASSIGNED);
        onCreate(db);
    }
}
