package io.gritacademy.userprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button loginBtn;
    private EditText userNameEditText, passWordEditText;
    private String userNameStr, passWordStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        // initialise variables
        loginBtn = findViewById(R.id.loginButton);
         userNameEditText = findViewById(R.id.editTextUserName);
         passWordEditText = findViewById(R.id.editTextPassWord);

        loginBtn.setOnClickListener(v -> {
           if(userNameEditText.getText().length()>0 && passWordEditText.getText().length() >0){
               switchActivities(UserProfileDataInput.class);
           }

        });
    }




 /*

    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("USER_NAME",userNameStr);
        editor.putString("PASS_WORD",passWordStr );
        editor.apply();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE);
        userNameStr = sharedPreferences.getString("USER_NAME","");
        passWordStr = sharedPreferences.getString("PASS_WORD", "");
    }

*/

    private void switchActivities(Class nextClass) {

        Intent intent = new Intent(this, nextClass);
        startActivity(intent);


    }

}