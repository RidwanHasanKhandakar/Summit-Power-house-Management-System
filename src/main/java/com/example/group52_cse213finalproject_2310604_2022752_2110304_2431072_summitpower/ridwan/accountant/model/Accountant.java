package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.User;

import java.io.Serializable;

public class Accountant extends User implements Serializable {

    public Accountant(String firstName, String lastName, String address, int phoneNumber, String gender, String userId, String email, String password) {
        super(firstName, lastName, address, phoneNumber, gender, userId, email, password);
    }

    @Override
    public String toString() {
        return "Accountant{}";
    }
}
