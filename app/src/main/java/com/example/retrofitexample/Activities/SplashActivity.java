package com.example.retrofitexample.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofitexample.R;
import com.example.retrofitexample.SharedPrefManager;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPrefManager sharedPrefManager = new SharedPrefManager(getApplicationContext());

        getSupportActionBar().hide();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (sharedPrefManager.isLoggedIn()) {
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }

            }
        }, 4000);
    }
}