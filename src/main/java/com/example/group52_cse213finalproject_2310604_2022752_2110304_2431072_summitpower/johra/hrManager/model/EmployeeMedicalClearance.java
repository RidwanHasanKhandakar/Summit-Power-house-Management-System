package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class EmployeeMedicalClearance implements Serializable {

    private String clearanceId, employeeId, employeeName, doctorName, medicalStatus;
    private LocalDate checkupDate;

    public EmployeeMedicalClearance(String clearanceId, String employeeId, String employeeName, String doctorName, String medicalStatus, LocalDate checkupDate) {
        this.clearanceId = clearanceId;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.doctorName = doctorName;
        this.medicalStatus = medicalStatus;
        this.checkupDate = checkupDate;
    }

    public String getClearanceId() {
        return clearanceId;
    }

    public void setClearanceId(String clearanceId) {
        this.clearanceId = clearanceId;
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

    public String getMedicalStatus() {
        return medicalStatus;
    }

    public void setMedicalStatus(String medicalStatus) {
        this.medicalStatus = medicalStatus;
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
                "clearanceId='" + clearanceId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", medicalStatus='" + medicalStatus + '\'' +
                ", checkupDate=" + checkupDate +
                '}';
    }
}
