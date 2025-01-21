package com.longthien.lesson.passdata;

public class Singleton {
    private static Singleton single_instance = null;
    public String email;
    public String password;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (single_instance == null) {
            single_instance = new Singleton();
        }
        return single_instance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;

    }
}