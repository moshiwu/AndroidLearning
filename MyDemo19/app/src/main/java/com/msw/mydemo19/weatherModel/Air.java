package com.msw.mydemo19.weatherModel;

//
//	Air.java
//
//	Create by 莫 锹文 on 2018/01/06
//	Copyright © 2018. All rights reserved.


import org.json.*;
import org.litepal.crud.DataSupport;

import com.google.gson.annotations.SerializedName;


public class Air extends DataSupport {

    @SerializedName("brf")
    private String shortTips;
    @SerializedName("txt")
    private String txt;

    public void setShortTips(String shortTips) {
        this.shortTips = shortTips;
    }

    public String getShortTips() {
        return this.shortTips;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return this.txt;
    }


}