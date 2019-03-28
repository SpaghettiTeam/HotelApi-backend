package com.spaghettiteam.hotelapi.dto;

public class UserToLogin {

    private String username;
    private String password;

    public UserToLogin() {
    }

    public UserToLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
