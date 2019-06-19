package com.example.weatherforcast.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.weatherforcast.R;

public class SplashScreenActivity extends AppCompatActivity {

    public static final int SPLASH_DISPLAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(mIntent);
                finish();
            }
        }, SPLASH_DISPLAY);
    }
}
