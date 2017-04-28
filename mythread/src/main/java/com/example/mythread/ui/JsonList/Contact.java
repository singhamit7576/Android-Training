package com.example.mythread.ui.JsonList;

import java.io.Serializable;

/**
 * Created by user on 7/4/17.
 */
public class Contact  {

    String area;
    String city;

    public Contact(String area, String city) {
        this.area = area;
        this.city = city;
    }


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
