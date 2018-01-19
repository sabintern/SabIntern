package application.example.com.sabintern.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import application.example.com.sabintern.R;

/**
 * Created by Dell on 08-12-2017.
 */

public class AfterSplashActivity extends AppCompatActivity {
    Button btLogin, btRegister;
    TextView newUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_splash);
        btLogin = findViewById(R.id.bt_login);
        btRegister = findViewById(R.id.bt_register);
        newUser = findViewById(R.id.new_user);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(AfterSplashActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(AfterSplashActivity.this, SignUpActivity.class);
                startActivity(registerIntent);

            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(AfterSplashActivity.this, SignUpActivity.class);
                startActivity(newIntent);
            }
        });
    }
}
