package com.msw.mydemo19.weatherModel;

//
//	Astro.java
//
//	Create by 莫 锹文 on 2018/01/06
//	Copyright © 2018. All rights reserved.


import org.json.*;
import org.litepal.crud.DataSupport;

import java.util.*;

import com.google.gson.annotations.SerializedName;


public class Astro extends DataSupport {

    @SerializedName("mr")
    private String mr;
    @SerializedName("ms")
    private String ms;
    @SerializedName("sr")
    private String sr;
    @SerializedName("ss")
    private String ss;

    public void setMr(String mr) {
        this.mr = mr;
    }

    public String getMr() {
        return this.mr;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public String getMs() {
        return this.ms;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public String getSr() {
        return this.sr;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getSs() {
        return this.ss;
    }

}