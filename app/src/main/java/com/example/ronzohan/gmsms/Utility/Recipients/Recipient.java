package com.example.ronzohan.gmsms.Utility.Recipients;

public class Recipient {
    private String mName;
    private String mAddress;
    private String mContactNo;
    private long mContactID;
    private long id;

    public Recipient(String mName, String contactNo) {
        this.id = -1;
        this.mName = mName;
        this.mContactNo = contactNo;
        this.mAddress = "";
        this.mContactID = -1;
    }

    public Recipient(long id,String mName, String contactNo) {
        this.id = id;
        this.mName = mName;
        this.mContactNo = contactNo;
        this.mAddress = "";
        this.mContactID = -1;
    }

    public Recipient(long id,String mName, String contactNo, long mContactID) {
        this.id = id;
        this.mName = mName;
        this.mContactNo = contactNo;
        this.mAddress = "";
        this.mContactID = mContactID;
    }

    public Recipient(long id,String name, String contactNo, String address) {
        this.id = id;
        this.mName = name;
        this.mContactNo = contactNo;
        this.mAddress = address;
        this.mContactID = -1;
    }
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        this.mAddress = address;
    }

    public String getContactNo() {
        return mContactNo;
    }

    public void setContactNo(String contactNo) {
        this.mContactNo = contactNo;
    }

    public long getmContactID() {
        return mContactID;
    }

    public void setmContactID(long mContactID) {
        this.mContactID = mContactID;
    }
}
