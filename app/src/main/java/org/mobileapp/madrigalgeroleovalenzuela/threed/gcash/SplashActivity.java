package org.mobileapp.madrigalgeroleovalenzuela.threed.gcash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread mythread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    Intent myIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(myIntent);
                    finish();
                }catch (Exception e){

                }
            }
        };

        mythread.start();
    }
}