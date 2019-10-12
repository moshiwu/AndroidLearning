package com.msw.mydemo19.weatherModel;

//
//	RootClass.java
//
//	Create by 莫 锹文 on 2018/01/06
//	Copyright © 2018. All rights reserved.


import org.json.*;
import org.litepal.crud.DataSupport;

import java.util.*;

import com.google.gson.annotations.SerializedName;


public class RootClass extends DataSupport {

    @SerializedName("HeWeather")
    private HeWeather[] heWeather;

    public void setHeWeather(HeWeather[] heWeather) {
        this.heWeather = heWeather;
    }

    public HeWeather[] getHeWeather() {
        return this.heWeather;
    }


}