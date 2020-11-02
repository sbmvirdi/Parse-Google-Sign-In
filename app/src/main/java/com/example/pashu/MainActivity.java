package com.example.pashu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.google.ParseGoogleUtils;

public class MainActivity extends AppCompatActivity {

    private Button signUp;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUp = findViewById(R.id.signUp);
        activity  = MainActivity.this;

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseGoogleUtils.logIn(activity, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user == null) {
                            Log.e("MyApp", "Uh oh. The user cancelled the Google login.");
                            Log.e("MyApp", e.getMessage()+"");
                        } else if (user.isNew()) {
                            Log.e("MyApp", "User signed up and logged in through Google!");
                        } else {
                            Log.e("MyApp", "User logged in through Google!");
                        }
                    }
                });
            }
        });


        ParseUser user =  ParseUser.getCurrentUser();
        if (user!=null){
            Log.e("MyApp","logged in as "+user.getUsername());
        }else{
            Log.e("MyApp","Not logged in");
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ParseGoogleUtils.onActivityResult(requestCode, resultCode, data);
    }

}