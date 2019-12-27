package com.example.demo.entity;

public class UserLoginRequestModel {
    private String Email;
    private String Password;

    public UserLoginRequestModel() {
    }

    public UserLoginRequestModel(String email, String password) {
        Email = email;
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
