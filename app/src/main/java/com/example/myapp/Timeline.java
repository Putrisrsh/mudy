package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapp.model.activity;
import com.example.myapp.model.activityData;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Timeline extends AppCompatActivity {

    private RecyclerView rvActivity;
    private ArrayList<activity> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);


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
                        rvActivity = findViewById(R.id.rv_activity);
                        rvActivity.setHasFixedSize(true);
                        list.addAll(activityData.getListData());
                        showRecyclerCardView();
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


}
