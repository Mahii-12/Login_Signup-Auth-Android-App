package com.example.myapplication;

public class User {

    private String id;
    private String Email;
    private String  Password;
    private String Phone;

    public User(){

    }

    public User(String id, String email, String password, String phone) {
        this.id = id;
        Email = email;
        Password = password;
        Phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }
}
