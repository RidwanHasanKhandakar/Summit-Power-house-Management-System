package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class EmployeeAward implements Serializable {

    private String employeeId, employeeName, awardName, awardType;
    private LocalDate awardDate;

    public EmployeeAward(String employeeId, String employeeName, String awardName, String awardType, LocalDate awardDate) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.awardName = awardName;
        this.awardType = awardType;
        this.awardDate = awardDate;
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

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
    }

    public LocalDate getAwardDate() {
        return awardDate;
    }

    public void setAwardDate(LocalDate awardDate) {
        this.awardDate = awardDate;
    }

    @Override
    public String toString() {
        return "EmployeeAward{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", awardName='" + awardName + '\'' +
                ", awardType='" + awardType + '\'' +
                ", awardDate=" + awardDate +
                '}';
    }
}
