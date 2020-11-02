package com.example.pashu;

import android.app.Application;

import com.parse.Parse;
import com.parse.google.ParseGoogleUtils;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();



        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("myappID")
                .clientKey("XP5tBl6VPHSm")
                .server("http://ec2-13-233-194-116.ap-south-1.compute.amazonaws.com/parse/")
                .build()
        );

        ParseGoogleUtils.initialize(getString(R.string.client_id));
    }
}
