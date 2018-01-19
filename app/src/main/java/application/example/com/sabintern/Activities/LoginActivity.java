package application.example.com.sabintern.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import application.example.com.sabintern.R;

/**
 * Created by Dell on 03-12-2017.
 */

public class LoginActivity extends AppCompatActivity {
    Button generateOtp;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        generateOtp = findViewById(R.id.OTP);

        generateOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }
}
