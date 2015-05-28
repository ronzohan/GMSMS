package com.example.ronzohan.gmsms.Utility.Recipients;

public class Recipient {
    private String mName;
    private String mAddress;
    private String mContactNo;


    public Recipient(String mName, String contactNo) {
        this.mName = mName;
        this.mContactNo = contactNo;
        this.mAddress = "";
    }

    public Recipient(String name, String contactNo, String address) {
        this.mName = name;
        this.mContactNo = contactNo;
        this.mAddress = address;
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




}
