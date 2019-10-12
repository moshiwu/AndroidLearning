package com.msw.mydemo19.weatherModel;

//
//	Update.java
//
//	Create by 莫 锹文 on 2018/01/06
//	Copyright © 2018. All rights reserved.


import org.json.*;
import org.litepal.crud.DataSupport;

import java.util.*;

import com.google.gson.annotations.SerializedName;


public class Update extends DataSupport {

    @SerializedName("loc")
    private String loc;
    @SerializedName("utc")
    private String utc;

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getLoc() {
        return this.loc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }

    public String getUtc() {
        return this.utc;
    }


}