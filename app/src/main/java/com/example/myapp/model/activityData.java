package com.example.myapp.model;

import com.example.myapp.R;

import java.util.ArrayList;

public class activityData {
    private  static String [] activity_name = {
            "Membaca", "Olahraga", "Berkebun", "Memasak", "Menonton Film"," "

    };

    private static String [] activity_detail = {
            "Yuk membaca buku agar pikiran lebih tenang dan rileks","Jaga kesehatan dengan olahraga ringan agar badan lebih segar",
            "Rawat tanaman dikebun agar tanaman terawat dengan baik", "Membuat kue atau makanan kesukaan agar mood semakin baik",
            "Tonton film dengan genre favorit"," "
    };

    private static int[] acitvity_image = {
            R.drawable.membaca,R.drawable.olahraga,R.drawable.bertanam,R.drawable.memasak1,R.drawable.movie,R.drawable.memasak1
    };

    public static ArrayList<activity> getListData(){
        ArrayList<activity> list = new ArrayList<>();
        for (int position = 0 ; position<activity_name.length;position++){
            activity  activity = new activity();
            activity.setAktivitas(activity_name[position]);
            activity.setDetailActivity(activity_detail[position]);
            activity.setImageActivity(acitvity_image[position]);
            list.add(activity);
        }
        return list;
    }
}
