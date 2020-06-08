package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.security.Principal;

public class MainActivity extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextPassword;
    Button buttonLogin;
    Button buttonRegister;

    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initViews();
        createAccount();

        sqliteHelper = new SqliteHelper(this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String Email = editTextEmail.getText().toString();
                    String Password = editTextPassword.getText().toString();

                    User currentUser = sqliteHelper.Authenticate(new User(null,null,null,null, Email, Password));
                    if (currentUser != null) {

                        SessionManagement sessionManagement = new SessionManagement(MainActivity.this);
                        sessionManagement.saveSession(currentUser);

                        Intent intent = new Intent(MainActivity.this, ChooseGender.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "Successfully Logged In!", Toast.LENGTH_SHORT).show();

                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "Failed to log in. Please try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkSession();
    }

    private void checkSession() {
        SessionManagement sessionManagement = new SessionManagement(MainActivity.this);
        int userID = sessionManagement.getSession();

        if (userID != -1){
            Intent intent = new Intent(getBaseContext(), Profile.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    private void createAccount() {
       buttonRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, Register.class);
               startActivity(intent);
           }
       });
    }

    private void initViews() {
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
    }

    public boolean validate() {
        boolean valid = false;

        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

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
