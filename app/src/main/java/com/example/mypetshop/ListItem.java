package com.example.mypetshop;

public class ListItem {
    private final String name;
    private final int imageResourceId;

    public ListItem(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
