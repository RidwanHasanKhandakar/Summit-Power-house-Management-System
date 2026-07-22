package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower;

public class User extends Person {
    private String userId;
    private String email;
    private String password;

    public User(String firstName, String lastName, String address, int phoneNumber, String gender, String userId, String email, String password) {
        super(firstName, lastName, address, phoneNumber, gender);
        this.userId = userId;
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void login(){

    }

    public void logout(){

    }

    public void changePassword(){

    }
}
