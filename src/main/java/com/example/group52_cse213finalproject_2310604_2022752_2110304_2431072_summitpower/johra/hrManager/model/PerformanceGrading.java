package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model;

import java.io.Serializable;

public class PerformanceGrading implements Serializable {
    private String employeeId;
    private String totalDaysPresent, overtimeDays, efficiencyScore;

    public PerformanceGrading(String employeeId, String totalDaysPresent, String overtimeDays, String efficiencyScore) {
        this.employeeId = employeeId;
        this.totalDaysPresent = totalDaysPresent;
        this.overtimeDays = overtimeDays;
        this.efficiencyScore = efficiencyScore;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTotalDaysPresent() {
        return totalDaysPresent;
    }

    public void setTotalDaysPresent(String totalDaysPresent) {
        this.totalDaysPresent = totalDaysPresent;
    }

    public String getOvertimeDays() {
        return overtimeDays;
    }

    public void setOvertimeDays(String overtimeDays) {
        this.overtimeDays = overtimeDays;
    }

    public String getEfficiencyScore() {
        return efficiencyScore;
    }

    public void setEfficiencyScore(String efficiencyScore) {
        this.efficiencyScore = efficiencyScore;
    }

    @Override
    public String toString() {
        return "PerformanceGrading{" +
                "employeeId='" + employeeId + '\'' +
                ", totalDaysPresent='" + totalDaysPresent + '\'' +
                ", overtimeDays='" + overtimeDays + '\'' +
                ", efficiencyScore='" + efficiencyScore + '\'' +
                '}';
    }
}
