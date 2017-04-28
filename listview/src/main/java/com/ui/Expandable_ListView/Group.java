package com.ui.Expandable_ListView;

import java.util.ArrayList;

/**
 * Created by user on 8/3/17.
 */
public class Group {
    public String name;

    public Group(String name) {
        this.name = name;
    }

     ArrayList<child> items = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<child> getItems() {
        return items;
    }

    public void setItems(ArrayList<child> items) {
        this.items = items;
    }
}
