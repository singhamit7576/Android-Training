package com.example.database.InsertData;

/**
 * Created by user on 17/4/17.
 */
public class ContactModel {


    private int ID;
    private String firstName, lastName;

    public ContactModel(){}



//    public ContactModel(int ID, String firstName, String lastName) {
//        this.ID = ID;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
