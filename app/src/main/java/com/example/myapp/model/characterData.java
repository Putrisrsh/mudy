package com.example.myapp.model;

import com.example.myapp.R;

import java.util.ArrayList;

public class characterData {
    private static String [] namaCharacter = {
    "Kelinci","Harimau"
    };

    private static String [] detailCharacter = {
      "Cekatan,blaaablaa","cepatt bla"
    };

    private static int [] imageCharacter = {
            R.drawable.rabbit,R.drawable.tiger
    };

    public static ArrayList<character>getListData(){
        ArrayList<character> list = new ArrayList<>();
        for (int position = 0 ; position<namaCharacter.length;position++){
            character  character = new character();
            character.setNama_character(namaCharacter[position]);
            character.setDetail_character(detailCharacter[position]);
            character.setImage_character(imageCharacter[position]);
            ;list.add(character);
        }
        return list;
    }
 }
