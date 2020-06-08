package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageHelper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.myapp.model.characterData;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapp.model.character;

import java.util.ArrayList;
import java.util.Random;


public class Hobbies extends AppCompatActivity {

    Button buttonNext;

    ImageView imageViewStudy;
    ImageView imageViewSport;
    ImageView imageViewCycling;
    ImageView imageViewPet;
    ImageView imageViewMusic;
    ImageView imageViewGame;
    ImageView imageViewJogging;
    ImageView imageViewCook;
    ImageView imageViewFishing;

    private int minimumChoice = 0;

    public ArrayList<character> characters = new ArrayList<>();
    public ArrayList<character> getListcharacter(){
        return characters;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);

        initViews();

        buttonStudy();
        buttonSport();
        buttonCycling();
        buttonPet();
        buttonMusic();
        buttonGame();
        buttonJogging();
        buttonCook();
        buttonFishing();

        characters.addAll(characterData.getListData());

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (minimumChoice >= 3){

                    int randomIndex = (int)(Math.random() * characters.size());
                    character c = getListcharacter().get(randomIndex);
                    Intent intent =new Intent(Hobbies.this,characterActivity.class);
                    intent.putExtra(characterActivity.EXTRA_NAME_C, c.getNama_character());
                    intent.putExtra(characterActivity.EXTRA_DETAIL_C, c.getDetail_character());
                    intent.putExtra(characterActivity.EXTRA_IMAGE_C, c.getImage_character());
                    startActivity(intent);
                } else {
                    Toast.makeText(Hobbies.this, "Pilih minimal 3.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initViews(){
        buttonNext = (Button) findViewById(R.id.buttonNext);
        imageViewStudy = (ImageView) findViewById(R.id.study);
        imageViewSport = (ImageView) findViewById(R.id.sport);
        imageViewCycling = (ImageView) findViewById(R.id.cycling);
        imageViewPet = (ImageView) findViewById(R.id.pet);
        imageViewMusic = (ImageView) findViewById(R.id.music);
        imageViewGame = (ImageView) findViewById(R.id.game);
        imageViewJogging = (ImageView) findViewById(R.id.jogging);
        imageViewCook = (ImageView) findViewById(R.id.cook);
        imageViewFishing = (ImageView) findViewById(R.id.fishing);
    }

    private void buttonStudy(){
        imageViewStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minimumChoice++;
            }
        });
    }

    private void buttonSport(){
        imageViewSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minimumChoice++;
            }
        });
    }

    private void buttonCycling(){
        imageViewCycling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minimumChoice++;
            }
        });
    }

    private void buttonPet(){
        imageViewPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minimumChoice++;
            }
        });
    }

    private void buttonMusic(){
        imageViewMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minimumChoice++;
            }
        });
    }

    private void buttonGame(){
        imageViewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minimumChoice++;
            }
        });
    }

    private void buttonJogging(){
        imageViewJogging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minimumChoice++;
            }
        });
    }

    private void buttonCook(){
        imageViewCook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minimumChoice++;
            }
        });
    }

    private void buttonFishing(){
        imageViewFishing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minimumChoice++;
            }
        });
    }



}
