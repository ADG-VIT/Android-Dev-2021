package com.example.task3.App.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.task3.R;

public class MainActivity extends AppCompatActivity {

    Button emailLogin, emailRegister, googleLogin, facebookLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("QUIZ!");

        emailLogin= findViewById(R.id.email_login);
        emailRegister= findViewById(R.id.email_register);
        googleLogin= findViewById(R.id.google_login);
        facebookLogin= findViewById(R.id.facebook_login);

        emailLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EmailLogin.class));
            }
        });
        emailRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EmailRegister.class));
            }
        });
        googleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GoogleLogin.class));
            }
        });
        facebookLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FacebookLogin.class));
            }
        });
    }
}