package com.ui.demo;

/**
 * Create class Employee
 * and make getter and setter method.
 */
public class Employee {
    String name;
    String place;
    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    int type;
//    public Employee(String name, String place) {
//        this.name = name;
//        this.place = place;
//    }

    public String getPlace() {

        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
