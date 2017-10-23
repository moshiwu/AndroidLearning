// IMyAidlInterface.aidl
package com.example.moqiaowen.mydemo4;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);


    void sendMessage(String value);
    void sharePhoto(String url);
}
