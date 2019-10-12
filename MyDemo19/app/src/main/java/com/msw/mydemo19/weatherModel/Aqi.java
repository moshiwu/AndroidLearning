package com.msw.mydemo19.weatherModel;

//
//	Aqi.java
//
//	Create by 莫 锹文 on 2018/01/06
//	Copyright © 2018. All rights reserved.


import org.json.*;
import org.litepal.crud.DataSupport;

import java.util.*;

import com.google.gson.annotations.SerializedName;


public class Aqi extends DataSupport {

    @SerializedName("city")
    private City city;

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return this.city;
    }
}