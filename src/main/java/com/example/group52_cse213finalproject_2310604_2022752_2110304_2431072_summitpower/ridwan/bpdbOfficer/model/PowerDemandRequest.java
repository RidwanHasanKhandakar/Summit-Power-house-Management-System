package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model;

import java.time.LocalDate;

public class PowerDemandRequest {
    private String requestId;
    private double reqCapacity;
    private LocalDate startDate;
    private LocalDate endDate;
    private String priorityLevel;
    private String purpose;
    private String remarks;

    public PowerDemandRequest(String requestId, double reqCapacity, LocalDate startDate, LocalDate endDate, String priorityLevel, String purpose, String remarks) {
        this.requestId = requestId;
        this.reqCapacity = reqCapacity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priorityLevel = priorityLevel;
        this.purpose = purpose;
        this.remarks = remarks;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public double getReqCapacity() {
        return reqCapacity;
    }

    public void setReqCapacity(double reqCapacity) {
        this.reqCapacity = reqCapacity;
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

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "PowerDemandRequest{" +
                "requestId='" + requestId + '\'' +
                ", reqCapacity=" + reqCapacity +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priorityLevel='" + priorityLevel + '\'' +
                ", purpose='" + purpose + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
