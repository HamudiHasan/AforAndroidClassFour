package com.tesseractbd.aforandroidclassfour;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by hhson on 8/6/2016.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText etPassword;
    private EditText etEmail;
    private Button btnLogin;
    private SharedPreferences sharedPreferences;
    private String storedEmail;
    private String storedPass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        sharedPreferences = getSharedPreferences(MainActivity.USER_PREFS, MODE_PRIVATE);
        readValues();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void readValues() {
        storedEmail = sharedPreferences.getString(MainActivity.USER_EMAIL, "");
        storedPass = sharedPreferences.getString(MainActivity.USER_PASSWORD, "");
    }
}
