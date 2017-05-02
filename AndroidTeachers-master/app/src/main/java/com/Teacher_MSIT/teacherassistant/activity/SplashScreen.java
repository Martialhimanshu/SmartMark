package com.Teacher_MSIT.teacherassistant.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.Teacher_MSIT.teacherassistant.LoginActivity;
import com.Teacher_MSIT.teacherassistant.R;

public class SplashScreen extends AppCompatActivity {

    ProgressBar p;
    int SPLASH_TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        p=(ProgressBar)findViewById(R.id.progressBar1);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);




            }


}
