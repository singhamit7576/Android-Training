package com.example.contentprovidertest.model;

import android.graphics.Bitmap;


public class ContactData {
    String name;
    String phoneNumber;
    Bitmap bitmap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public ContactData(String name, Bitmap uri,String phonenumber ) {
        this.name = name;
        this.bitmap =uri;
        this.phoneNumber =phonenumber;
    }
}
