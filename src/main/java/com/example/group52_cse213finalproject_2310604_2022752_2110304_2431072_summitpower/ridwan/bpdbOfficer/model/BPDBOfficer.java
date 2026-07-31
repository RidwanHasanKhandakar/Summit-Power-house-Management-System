package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.User;

import java.io.Serializable;
import java.time.LocalDate;

public class BPDBOfficer extends User implements Serializable {
    private String department;
    private String designation;

    public BPDBOfficer(String firstName, String lastName, String address, String phoneNumber, String gender, LocalDate dateOfBirth, String userId, String email, String password, String role, String department, String designation) {
        super(firstName, lastName, address, phoneNumber, gender, dateOfBirth, userId, email, password, role);
        this.department = department;
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "BPDBOfficer{" +
                "department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
