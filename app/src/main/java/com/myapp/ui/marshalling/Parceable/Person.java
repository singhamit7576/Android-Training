package com.myapp.ui.marshalling.Parceable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *create class Person
 * which implemenst Parcelable interface.
 * for passing object references to activities

 */
public class Person implements Parcelable {

    /**
     * make an constructor of
     * class and
     * make getter and setter method.
     */
    private String name;
    private int age;
    public Person(){}

    public void setName(String name){
        this.name   =   name;
    }
    public String getName(){
        return name;
    }


    public void setAge(int age){
        this.age    =   age;
    }
    public int getAge(){
        return age;
    }

    protected Person(Parcel in) {
        name    =   in.readString();
        age     =   in.readInt();
    }


    /**
     * override methods of parceable.
     * Creator creates instances of  your parceble class
     * from Parceable
     */
    public static final Creator<Person> CREATOR  = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {

            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }
}
