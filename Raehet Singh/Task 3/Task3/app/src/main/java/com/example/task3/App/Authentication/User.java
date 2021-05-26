package com.example.task3.App.Authentication;

public class User {
    String email;
    String password;
    String name;
    String score;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public User(String email, String password, String name, String score) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.score = score;
    }
}
