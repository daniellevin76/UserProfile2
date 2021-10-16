package io.gritacademy.userprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class UserProfileDataInput extends AppCompatActivity {
    EditText editTextFirstName, editTextLastName, editTextDate, editTextEmailAddress, editTextPhoneNumber;
    Button insertBtn;
   // String firstNameStr, lastNameStr, birthDateStr, emailStr, phoneNumberStr;
    public static final String USER_KEY = "io.grit_academy.user_input_form.first_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_data_input);

        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextDate = findViewById(R.id.editTextDate);
        editTextEmailAddress = findViewById(R.id.editTextEmailAddress);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);

       String firstNameStr = editTextFirstName.getText().toString();



        insertBtn = findViewById(R.id.insertButton);


        insertBtn.setOnClickListener(v -> {

           switchActivities(userInputReadIn());

        });
    }




    public ArrayList<String> userInputReadIn(){
        ArrayList<String> userInputsArray = new ArrayList<String>();
        userInputsArray.add(0, editTextFirstName.getText().toString());
        userInputsArray.add(1, editTextLastName.getText().toString());
        userInputsArray.add(2, editTextDate.getText().toString());
        userInputsArray.add(3, editTextEmailAddress.getText().toString());
        userInputsArray.add(4, editTextPhoneNumber.getText().toString());

        return userInputsArray;
    }


    public boolean checkArrayEntries(ArrayList<String> inputArr){

        boolean isFull = false;
        int count = inputArr.size();
        for(String arr: inputArr){
            if (arr.length() != 0){
                count --;

            }
            if(count == 0){
            isFull = true;}
        }
          return isFull;
        }


    private void switchActivities(ArrayList<String> inputArr) {

            if(checkArrayEntries(inputArr)){
                //create a Bundle object
                Bundle bundle = new Bundle();

                //Adding key value pairs to this bundle
                bundle.putStringArrayList("USER_INFO",  inputArr);

                //create and initialize an intent
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            else{

                Context context = getApplicationContext();
                CharSequence text = "No entries should be empty";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

            }
        }


