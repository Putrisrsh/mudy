package com.example.myapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Register extends AppCompatActivity {

    EditText editTextUserName;
    EditText editTextName;
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextPhoneNumber;
    Button buttonRegister;

    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sqliteHelper = new SqliteHelper(this);
//        initTextViewLogin();
        initViews();
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String UserName = editTextUserName.getText().toString();
                    String Name = editTextName.getText().toString();
                    String Email = editTextEmail.getText().toString();
                    String Password = editTextPassword.getText().toString();
                    String PhoneNumber = editTextPhoneNumber.getText().toString();

                    if (!sqliteHelper.isEmailExists(Email)) {

                        sqliteHelper.addUser(new User(null, UserName, Name, PhoneNumber, Email, Password));
                        Toast.makeText(Register.this, "User created successfully! Please Sign In.", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finish();
                            }
                        }, Snackbar.LENGTH_LONG);
                    }else {
                        Toast.makeText(Register.this, "User already exist with same email", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    //this method used to set Login TextView click event
//    private void initTextViewLogin() {
//        TextView textViewLogin = (TextView) findViewById(R.id.textViewLogin);
//        textViewLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
//    }

    private void initViews() {
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextUserName = (EditText) findViewById(R.id.editTextUsername);
        editTextName = (EditText) findViewById(R.id.editTextName);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        editTextPhoneNumber = (EditText) findViewById(R.id.editTextPhoneNumber);
    }

    public boolean validate() {
        boolean valid = false;

        String UserName = editTextUserName.getText().toString();
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

        if (UserName.isEmpty()) {
            valid = false;
        } else {
            if (UserName.length() > 5) {
                valid = true;
            } else {
                valid = false;
            }
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
        } else {
            valid = true;
        }

        if (Password.isEmpty()) {
            valid = false;
        } else {
            if (Password.length() > 5) {
                valid = true;
            } else {
                valid = false;
            }
        }
        return valid;
    }
}
