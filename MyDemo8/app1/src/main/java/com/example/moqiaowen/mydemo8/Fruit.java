package com.example.moqiaowen.mydemo8;

/**
 * Created by moqiaowen on 2017/11/2.
 */

public class Fruit {

    private String name;
    private int imageId;
    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
