package io.gritacademy.userprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Declare variables
    Button logoutBtn;
    TextView firstNameTextView, lastNameTextView, birthDateTextView, emailAddressTextView, phoneNumberTextView;
    private SharedPreferences.Editor  editor;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameTextView = findViewById(R.id.firstNameTextView);
        lastNameTextView = findViewById(R.id.lastNameTextView);
        birthDateTextView = findViewById(R.id.birthDateTextView);
        emailAddressTextView = findViewById(R.id.emailAddressTextView);
        phoneNumberTextView = findViewById(R.id.phoneNumberTextView);
        logoutBtn = findViewById(R.id.logoutButton);

        saveDate();
        updateUserData();


        logoutBtn.setOnClickListener(v -> {
            switchActivity();
        });
    }

    private void switchActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        // intent.putExtra("LOGGED_OUT", loggedOut);
        startActivity(intent);
    }


    private void updateUserData() {
        sharedPreferences = getSharedPreferences("USER_INFO", MODE_PRIVATE);
        firstNameTextView.setText(sharedPreferences.getString("FIRST_NAME", ""));
        lastNameTextView.setText(sharedPreferences.getString("LAST_NAME", ""));
        birthDateTextView.setText(sharedPreferences.getString("BIRTH_DATE", ""));
        emailAddressTextView.setText(sharedPreferences.getString("EMAIL",""));
        phoneNumberTextView.setText(sharedPreferences.getString("PHONE", ""));
    }

    private void saveDate() {
        sharedPreferences = getSharedPreferences("USER_INFO", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        Bundle bundle = getIntent().getExtras();
        if(bundle != null && bundle.isEmpty()){
            String[] list = bundle.getStringArray("USER_INFO");

        editor.putString("FIRST_NAME",list[0]);
        editor.putString("LAST_NAME",list[1]);
        editor.putString("BIRTH_DATE", list[2]);
        editor.putString("EMAIL",list[3]);
        editor.putString("PHONE", list[4]);
        editor.apply();
    }else{
            switchActivity();
        }}


}