package com.example.ronzohan.gmsms.Utility.DaySchedule;

import java.util.Objects;

public class DaySchedule {
    int MONDAY = 0;
    int TUESDAY = 0;
    int WEDNESDAY = 0;
    int THURSDAY = 0;
    int FRIDAY = 0;
    int SATURDAY = 0;
    int SUNDAY = 0;
    int messageInfoID;

    private long id;

    public DaySchedule() {}

    public DaySchedule(int monday, int tuesday, int wednesday, int thursday, int friday,
                       int saturday, int sunday) {
        this.MONDAY = monday;
        this.TUESDAY = tuesday;
        this.WEDNESDAY = wednesday;
        this.THURSDAY = thursday;
        this.FRIDAY = friday;
        this.SATURDAY = saturday;
        this.SUNDAY = sunday;
        this.messageInfoID = -1;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMONDAY() {
        return MONDAY;
    }

    public void setMONDAY(int MONDAY) {
        this.MONDAY = MONDAY;
    }

    public int getTUESDAY() {
        return TUESDAY;
    }

    public void setTUESDAY(int TUESDAY) {
        this.TUESDAY = TUESDAY;
    }

    public int getWEDNESDAY() {
        return WEDNESDAY;
    }

    public void setWEDNESDAY(int WEDNESDAY) {
        this.WEDNESDAY = WEDNESDAY;
    }

    public int getTHURSDAY() {
        return THURSDAY;
    }

    public void setTHURSDAY(int THURSDAY) {
        this.THURSDAY = THURSDAY;
    }

    public int getFRIDAY() {
        return FRIDAY;
    }

    public void setFRIDAY(int FRIDAY) {
        this.FRIDAY = FRIDAY;
    }

    public int getSATURDAY() {
        return SATURDAY;
    }

    public void setSATURDAY(int SATURDAY) {
        this.SATURDAY = SATURDAY;
    }

    public int getSUNDAY() {
        return SUNDAY;
    }

    public void setSUNDAY(int SUNDAY) {
        this.SUNDAY = SUNDAY;
    }

    public int getMessageInfoID() {
        return messageInfoID;
    }

    public void setMessageInfoID(int messageInfoID) {
        this.messageInfoID = messageInfoID;
    }

}
