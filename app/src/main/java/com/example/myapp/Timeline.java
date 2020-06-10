package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.model.activity;
import com.example.myapp.model.activityData;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Random;

public class Timeline extends AppCompatActivity {

    private RecyclerView rvActivity;
    private ArrayList<activity> list = new ArrayList<>();
    TextView tvquote,tvsapaan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        tvquote = findViewById(R.id.tv_quote);
        tvsapaan = findViewById(R.id.sapaan);

        final String quote[] = { "Our greatest weakness lies in giving up.The most certain way to succed is always to try just one more time",
                "Failure is simply an opportunity to begin again, this time more intelligently",
                "When you feel like giving up, remember why you held on for so long in the first place",
                "Courage doesn't always roar, Sometime courage is the quiet voice at the end of the days saying I will try again tomorrow",
                "Don't give up because you had a bad day, forgive your self and do better tomorrow"};

        Random r = new Random();
        int index = r.nextInt(quote.length - 0) + 0;
        tvquote.setText(quote[index]);

        retrieveData();

        rvActivity = findViewById(R.id.rv_activity);
        rvActivity.setHasFixedSize(true);
        list.addAll(activityData.getListData());
        showRecyclerCardView();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //set home select
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(), Notes.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        Random r = new Random();
                        int index = r.nextInt(quote.length - 0) + 0;
                        tvquote.setText(quote[index]);
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
    private void showRecyclerCardView(){
        rvActivity.setLayoutManager(new LinearLayoutManager(this));
        CardViewTimelineAdapter CardViewTimelineAdapter = new CardViewTimelineAdapter(list);
        rvActivity.setAdapter(CardViewTimelineAdapter);
    }

    private void retrieveData(){
        SqliteHelper sqliteHelper = new SqliteHelper(this);
        Cursor res = sqliteHelper.getUserData();


        while (res.moveToNext()){
            tvsapaan.setText("Hai "+res.getString(2));

        }

    }


}
