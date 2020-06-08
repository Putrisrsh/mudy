package com.example.myapp.model;

import com.example.myapp.R;

import java.util.ArrayList;

public class characterData {
    private static String [] namaCharacter = {
    "Kelinci","Harimau","Monyet","Jerapah"
    };

    private static String [] detailCharacter = {
      "Hewan kecil berbulu halus ini mewakili karakter ramah, penuh dengan ide, tanggap namun mudah panik dan akan menjadi pendiam di tempat asing",
            "Hewan berjenis karnivora ini mewakili karakter kuat, elegan, berwibawa, aktif namun penuh dengan misteri dan suka menyendiri",
            "Hewan yang lincah ini mewakili karakter pintar, percaya diri, humoris, namun tidak ingin bersusah-susah dan memilih 'jalan pintas'",
            "Hewan yang khas dengan leher panjangnya ini mewakili karakter mudah berbaur dengan lingkungan baru, percaya diri, berpenampilan menarik, kreatif, namun memiliki sifat angkuh dan sulit menentukan pilihan karena terlalu dipertimbangkan"
    };

    private static int [] imageCharacter = {
            R.drawable.rabbit,R.drawable.tiger,R.drawable.monkey,R.drawable.jerapah
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
