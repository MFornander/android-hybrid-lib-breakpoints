package com.example.hybridapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.TextView;

import com.example.hybridlib.LibUtil;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView hello = (TextView) findViewById(R.id.hello);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppUtil appUtil = new AppUtil();
                String appJava = appUtil.helloJava();
                String appCpp = appUtil.helloCpp();

                LibUtil libUtil = new LibUtil();
                String libJava = libUtil.helloJava();
                String libCpp = libUtil.helloCpp();

                String message =
                        appJava + '\n' + appCpp + '\n' +
                        libJava + '\n' + libCpp;

                hello.setText(message);
            }
        });
    }
}
