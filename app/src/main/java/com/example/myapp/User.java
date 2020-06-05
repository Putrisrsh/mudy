package com.example.myapp;

public class User {
    public String id;
    public String userName;
    public String name;
    public String email;
    public String password;
    public String phoneNumber;

    public User(String id, String userName, String name, String phoneNumber,  String email, String password) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

}
