package com.ui.ListviewCheckbox;

/**
 * Created by user on 16/3/17.
 */
public class Student {


    private String name;//name
    private  String textSet;//set result
    boolean check;//for button accept
    boolean selected;//for checkbox

    public String getTextSet() {
        return textSet;
    }

    public void setTextSet(String textSet) {
        this.textSet = textSet;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
