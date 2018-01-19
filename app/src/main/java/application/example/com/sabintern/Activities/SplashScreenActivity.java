package application.example.com.sabintern.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

import application.example.com.sabintern.R;

/**
 * Created by Dell on 03-12-2017.
 */

public class SplashScreenActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        TimerTask tt=new TimerTask() {
            @Override
            public void run() {
                Intent i=new Intent(SplashScreenActivity.this,AfterSplashActivity.class);
                startActivity(i);


            }
        };
        Timer t= new Timer();
        t.schedule(tt,3000);
    }
    }

