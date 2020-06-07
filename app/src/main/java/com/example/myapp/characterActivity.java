package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;


public class characterActivity extends AppCompatActivity {

    public static String EXTRA_NAME_C ="EXTRA_NAME_C";
    public static String EXTRA_DETAIL_C ="EXTRA_DETAIL_C";
    public static String EXTRA_IMAGE_C =  "EXTRA_IMAGE_C" ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        Button characterName = findViewById(R.id.btn_character);
        TextView characterDetail = findViewById(R.id.detail_character);
        ImageView characterImage = findViewById(R.id.img_item_character);

        String name = getIntent().getStringExtra(EXTRA_NAME_C);
        String details = getIntent().getStringExtra(EXTRA_DETAIL_C);
        int imgPhoto = getIntent().getIntExtra(EXTRA_IMAGE_C, 0);

        characterName.setText(name);
        characterDetail.setText(details);

        Glide.with(characterActivity.this).load(ContextCompat.getDrawable(this, imgPhoto)).into(characterImage);

    }


    public void toProfile(){
        Intent intent = new Intent(getBaseContext(), Profile.class);
        startActivity(intent);
    }



}
