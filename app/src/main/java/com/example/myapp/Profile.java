package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {

    TextView textViewIsiEmail;
    TextView textViewIsiUsername;
    TextView textViewIsiNomer;
    TextView textViewIsiGender;
    TextView textViewNamaGede;
    TextView textViewUsernameAtas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initViews();
        retrieveData();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set home select
        bottomNavigationView.setSelectedItemId(R.id.about);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(), Notes.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Timeline.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.about:
                        return true;
                }
                return false;
            }
        });
    }

    private void initViews(){
        textViewIsiEmail = (TextView) findViewById(R.id.isiEmail);
        textViewIsiUsername = (TextView) findViewById(R.id.isiUsername);
        textViewIsiNomer = (TextView) findViewById(R.id.isiNomer);
        textViewIsiGender = (TextView) findViewById(R.id.isiGender);
        textViewNamaGede = (TextView) findViewById(R.id.namaGede);
        textViewUsernameAtas = (TextView) findViewById(R.id.usernameAtas);
    }

    private void retrieveData(){
        SqliteHelper sqliteHelper = new SqliteHelper(this);

        ChooseGender gender = new ChooseGender();
        String jk = gender.getGender();
//        textViewIsiGender.setText(gender.getGender());

        Cursor res = sqliteHelper.getUserData();
        if (res.getCount() == 0){
            Toast.makeText(Profile.this, "No data found.", Toast.LENGTH_SHORT).show();
        }

        while (res.moveToNext()){
            textViewIsiUsername.setText(res.getString(1));
            textViewUsernameAtas.setText(res.getString(1));
            textViewNamaGede.setText(res.getString(2));
            textViewIsiNomer.setText(res.getString(3));
            textViewIsiEmail.setText(res.getString(4));

            ChooseGender g = new ChooseGender();


        }

        Toast.makeText(getBaseContext(), "GENDER NYA " + jk, Toast.LENGTH_SHORT).show();
    }


}
