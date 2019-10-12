package com.msw.mydemo19.weatherModel;

//
//	Cond.java
//
//	Create by 莫 锹文 on 2018/01/06
//	Copyright © 2018. All rights reserved.


import org.json.*;
import org.litepal.crud.DataSupport;

import java.util.*;

import com.google.gson.annotations.SerializedName;


public class Cond extends DataSupport {

    @SerializedName("code_d")
    private String codeD;
    @SerializedName("code_n")
    private String codeN;
    @SerializedName("txt_d")
    private String txtD;
    @SerializedName("txt_n")
    private String txtN;
    @SerializedName("code")
    private String code;
    @SerializedName("txt")
    private String txt;

    public void setCodeD(String codeD) {
        this.codeD = codeD;
    }

    public String getCodeD() {
        return this.codeD;
    }

    public void setCodeN(String codeN) {
        this.codeN = codeN;
    }

    public String getCodeN() {
        return this.codeN;
    }

    public void setTxtD(String txtD) {
        this.txtD = txtD;
    }

    public String getTxtD() {
        return this.txtD;
    }

    public void setTxtN(String txtN) {
        this.txtN = txtN;
    }

    public String getTxtN() {
        return this.txtN;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return this.txt;
    }


}