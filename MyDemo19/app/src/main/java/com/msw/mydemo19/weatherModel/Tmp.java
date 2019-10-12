package com.msw.mydemo19.weatherModel;

//
//	Tmp.java
//
//	Create by 莫 锹文 on 2018/01/06
//	Copyright © 2018. All rights reserved.


import org.json.*;
import org.litepal.crud.DataSupport;

import java.util.*;

import com.google.gson.annotations.SerializedName;


public class Tmp extends DataSupport {

    @SerializedName("max")
    private String max;
    @SerializedName("min")
    private String min;

    public void setMax(String max) {
        this.max = max;
    }

    public String getMax() {
        return this.max;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMin() {
        return this.min;
    }


}