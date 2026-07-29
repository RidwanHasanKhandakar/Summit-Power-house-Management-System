package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower;

import java.time.LocalDate;

public class User extends Person {
    private String userId;
    private String email;
    private String password;
    private String role;

    public User(String firstName, String lastName, String address, int phoneNumber, String gender, LocalDate dateOfBirth, String userId, String email, String password, String role) {
        super(firstName, lastName, address, phoneNumber, gender, dateOfBirth);
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public void login(){

    }

    public void logout(){

    }

    public void changePassword(){

    }
}
