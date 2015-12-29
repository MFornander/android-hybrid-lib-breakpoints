package com.example.hybridlib;


public class LibUtil {
    public String helloJava() {
        return "libJava" + (BuildConfig.DEBUG ? "-D" : "");
    }

    public native String helloCpp();

    static {
        System.loadLibrary("hybridlib");
    }
}
