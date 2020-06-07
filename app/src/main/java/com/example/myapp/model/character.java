package com.example.myapp.model;

public class character {
    public String getNama_character() {
        return nama_character;
    }

    public void setNama_character(String nama_character) {
        this.nama_character = nama_character;
    }

    public String getDetail_character() {
        return detail_character;
    }

    public void setDetail_character(String detail_character) {
        this.detail_character = detail_character;
    }

    public int getImage_character() {
        return image_character;
    }

    public void setImage_character(int image_character) {
        this.image_character = image_character;
    }

    private String nama_character;
    private  String detail_character;
    private  int image_character;
}
