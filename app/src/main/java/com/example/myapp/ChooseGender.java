package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseGender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosegender);
    }

    public void toHobbies(View view) {
        Intent intent = new Intent(getBaseContext(), Hobbies.class);
        startActivity(intent);
    }
}
