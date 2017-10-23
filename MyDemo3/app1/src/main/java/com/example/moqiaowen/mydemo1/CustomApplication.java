package com.example.moqiaowen.mydemo1;

import android.app.Application;
import android.content.res.Configuration;

/**
 * Created by moqiaowen on 2017/10/21.
 */

public class CustomApplication extends Application {

    public String getSaveString() {
        return saveString;
    }

    public void setSaveString(String saveString) {
        this.saveString = saveString;
    }

    private String saveString = "default";

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("application create");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        System.out.println("application terminate");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        System.out.println("application configuration changed");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.out.println("application low memory");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        System.out.println("application on trim memory");
    }
}
