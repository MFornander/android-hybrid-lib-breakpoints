package com.example.hybridapp;


public class AppUtil {
    public String helloJava() {
        // TODO: Java app breakpoint here
        return "appJava" + (BuildConfig.DEBUG ? "-D" : "");
    }

    public native String helloCpp();

    static {
        System.loadLibrary("hybridapp");
    }
}
