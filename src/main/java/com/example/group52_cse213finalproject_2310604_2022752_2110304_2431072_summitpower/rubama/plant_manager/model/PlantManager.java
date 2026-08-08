package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.model;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.User;

import java.io.Serializable;
import java.time.LocalDate;

public class PlantManager extends User implements Serializable {
    public PlantManager(String firstName, String lastName, String address, String phoneNumber, String gender, LocalDate dateOfBirth, String userId, String email, String password, String role) {
        super(firstName, lastName, address, phoneNumber, gender, dateOfBirth, userId, email, password, role);
    }

    @Override
    public String toString() {
        return "PlantManager{}";
    }
}
