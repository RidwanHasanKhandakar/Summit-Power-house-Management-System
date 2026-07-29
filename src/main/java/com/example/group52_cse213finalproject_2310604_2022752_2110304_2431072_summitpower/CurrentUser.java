package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower;

public class CurrentUser {

    private static User currentUser;

    public static void setUser(User user){
        currentUser = user;
    }
    public static User getUser(){
        return currentUser;
    }

    public static void logout() {
        currentUser=null;
    }
}
