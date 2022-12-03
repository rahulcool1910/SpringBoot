package com.example.springbasics.user_controller.dto;

public class userPasswordModel {
    private String password;
    private String email;

    public userPasswordModel(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "userPasswordModel{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}