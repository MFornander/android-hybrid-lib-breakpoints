package com.example.hybridlib;


public class LibUtil {
    public String helloJava() {
        // TODO: Java library breakpoint here
        return "libJava" + (BuildConfig.DEBUG ? "-D" : "");
    }

    public native String helloCpp();

    static {
        System.loadLibrary("hybridlib");
    }
}
