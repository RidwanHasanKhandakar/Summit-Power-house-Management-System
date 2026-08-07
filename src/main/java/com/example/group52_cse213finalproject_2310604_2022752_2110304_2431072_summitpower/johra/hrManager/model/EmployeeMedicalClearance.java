package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class EmployeeMedicalClearance implements Serializable {

    private String medicalRecordId, employeeId, employeeName, doctorName, fitnessStatus;
    private LocalDate checkupDate;

    public EmployeeMedicalClearance(String medicalRecordId, String employeeId, String employeeName, String doctorName, String fitnessStatus, LocalDate checkupDate) {
        this.medicalRecordId = medicalRecordId;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.doctorName = doctorName;
        this.fitnessStatus = fitnessStatus;
        this.checkupDate = checkupDate;
    }

    public String getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(String medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getFitnessStatus() {
        return fitnessStatus;
    }

    public void setFitnessStatus(String fitnessStatus) {
        this.fitnessStatus = fitnessStatus;
    }

    public LocalDate getCheckupDate() {
        return checkupDate;
    }

    public void setCheckupDate(LocalDate checkupDate) {
        this.checkupDate = checkupDate;
    }

    @Override
    public String toString() {
        return "EmployeeMedicalClearance{" +
                "medicalRecordId='" + medicalRecordId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", fitnessStatus='" + fitnessStatus + '\'' +
                ", checkupDate=" + checkupDate +
                '}';
    }
}
