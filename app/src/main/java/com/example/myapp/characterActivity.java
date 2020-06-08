package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;


public class characterActivity extends AppCompatActivity {

    public static String EXTRA_NAME_C ="EXTRA_NAME_C";
    public static String EXTRA_DETAIL_C ="EXTRA_DETAIL_C";
    public static String EXTRA_IMAGE_C =  "EXTRA_IMAGE_C" ;

    TextView textCharacter;
    TextView characterDetail;
    ImageView characterImage;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        initViews();

        String name = getIntent().getStringExtra(EXTRA_NAME_C);
        String details = getIntent().getStringExtra(EXTRA_DETAIL_C);
        int imgPhoto = getIntent().getIntExtra(EXTRA_IMAGE_C, 0);

        textCharacter.setText(name);
        characterDetail.setText(details);

        Glide.with(characterActivity.this).load(ContextCompat.getDrawable(this, imgPhoto)).into(characterImage);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Profile.class);
                startActivity(intent);
            }
        });
    }

    private void initViews(){
        textCharacter = (TextView) findViewById(R.id.btn_character);
        characterDetail = (TextView) findViewById(R.id.detail_character);
        characterImage = (ImageView) findViewById(R.id.img_item_character);
        buttonNext = (Button) findViewById(R.id.buttonNext);
    }

}
