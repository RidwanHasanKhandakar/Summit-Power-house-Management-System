package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class EmployeeLeave implements Serializable {

    private String leaveId, employeeId, leaveType, totalDaysPresent, reason;
    LocalDate startDate, endDate;

    public EmployeeLeave(String leaveId, String employeeId, String leaveType, String totalDaysPresent, String reason, LocalDate startDate, LocalDate endDate) {
        this.leaveId = leaveId;
        this.employeeId = employeeId;
        this.leaveType = leaveType;
        this.totalDaysPresent = totalDaysPresent;
        this.reason = reason;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(String leaveId) {
        this.leaveId = leaveId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getTotalDaysPresent() {
        return totalDaysPresent;
    }

    public void setTotalDaysPresent(String totalDaysPresent) {
        this.totalDaysPresent = totalDaysPresent;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "EmployeeLeave{" +
                "leaveId='" + leaveId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", leaveType='" + leaveType + '\'' +
                ", totalDaysPresent='" + totalDaysPresent + '\'' +
                ", reason='" + reason + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
