package com.myapp.ui.marshalling.Serialization;

import java.io.Serializable;

/**
 *create class Person
 * which implemenst Serializable interface.

 */
public class Student implements Serializable {
    private  String name;
    private String address;

    /**
     * make getter and
     * setter method of
     * Name,Address
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
}
