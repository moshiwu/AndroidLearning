package com.msw.mydemo18;

import java.io.Serializable;

/**
 * Created by moqiaowen on 2018/1/4.
 */

public class Fruit implements Serializable {

    private String name;
    private int imageId;

    public Fruit(String name, int imageId) {
        super();
        this.name = name;
        this.imageId = imageId;


    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
