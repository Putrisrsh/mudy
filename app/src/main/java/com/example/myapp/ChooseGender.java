package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChooseGender extends AppCompatActivity {

    Button buttonFemale;
    Button buttonMale;

    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosegender);
        initViews();
        isFemale();
        isMale();
    }

    private void initViews(){
        buttonFemale = (Button) findViewById(R.id.buttonFemale);
        buttonMale = (Button) findViewById(R.id.buttonMale);
    }

    private String isMale(){
        buttonMale.setOnClickListener(new View.OnClickListener() {
            String gender;
            @Override
            public void onClick(View view) {
                gender = "Male";
                this.gender = gender;
                Intent intent = new Intent(getBaseContext(), Hobbies.class);
                startActivity(intent);
                //buat ngetes aja variabelnya bener
                Toast.makeText(ChooseGender.this, "You are " + this.gender, Toast.LENGTH_SHORT).show();
            }
        });
        return this.gender;
    }

    private String isFemale(){
        buttonFemale.setOnClickListener(new View.OnClickListener() {
            String gender;
            @Override
            public void onClick(View view) {
                gender = "Female";
                this.gender = gender;
                Intent intent = new Intent(getBaseContext(), Hobbies.class);
                startActivity(intent);
                Toast.makeText(ChooseGender.this, "You are " + this.gender, Toast.LENGTH_SHORT).show();
            }
        });
        return this.gender;
    }

    public String getGender() {
        return this.gender;
    }

}
