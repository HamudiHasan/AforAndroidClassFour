package com.tesseractbd.aforandroidclassfour;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String USER_NAME = "user_name";
    public static final String USER_PASSWORD = "user_password";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_GENDER = "user_gender";
    public static final String USER_PREFS = "user_prefs";
    private EditText etName;
    private EditText etPassword;
    private EditText etEmail;
    private RadioGroup rgGender;
    private RadioButton rbGender;
    private Button btnRegister;
    private RecyclerView rvCon;
    private String strGender;
    private Spinner spCountry;
    private List<String> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryList = new ArrayList<>();
        addCountries();
//        etName = (EditText) findViewById(R.id.et_name);
//        etEmail = (EditText) findViewById(R.id.et_email);
//        etPassword = (EditText) findViewById(R.id.et_password);
//        rgGender = (RadioGroup) findViewById(R.id.rg_gender);
//        btnRegister = (Button) findViewById(R.id.btn_register);
//        spCountry = (Spinner) findViewById(R.id.sp_country);
        rvCon = (RecyclerView) findViewById(R.id.rv_countries);

        rvCon.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
        rvCon.setAdapter(new CountryAdapter(countryList,getApplicationContext()));

        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.layout_spinner_item, countryList);

//        spCountry.setAdapter(adapter);

//        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//               rbGender = (RadioButton) findViewById(group.getCheckedRadioButtonId());
//               strGender = rbGender.getText().toString();
//            }
//        });

//        btnRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                registerUser();
//                startActivity(new Intent(MainActivity.this, LoginActivity.class));
//            }
//        });

//        spCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),countryList.get(position)
//                ,Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }

    private void addCountries() {
        countryList.add("Bangladesh");
        countryList.add("India");
    }

    private void registerUser() {
        SharedPreferences preferences = getSharedPreferences(USER_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USER_NAME, etName.getText().toString());
        editor.putString(USER_PASSWORD, etPassword.getText().toString());
        editor.putString(USER_EMAIL, etEmail.getText().toString());
        editor.putString(USER_GENDER, strGender);
        editor.commit();
    }

}
