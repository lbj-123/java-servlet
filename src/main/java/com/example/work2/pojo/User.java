package com.example.work2.pojo;

public class User {
    private String username;//用户名
    private String password;//口令

    public User() {
        this.username="";
        this.password="";
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
