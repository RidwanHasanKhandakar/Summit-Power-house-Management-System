package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model;

import java.time.LocalDate;

public class AdditionalPowerRequest {

    private String requestId;
    private double requestedCapacity;
    private String justification;
    private LocalDate requestDate;
    private String status;

    public AdditionalPowerRequest(String requestId, double requestedCapacity, String justification, LocalDate requestDate, String status) {
        this.requestId = requestId;
        this.requestedCapacity = requestedCapacity;
        this.justification = justification;
        this.requestDate = requestDate;
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public double getRequestedCapacity() {
        return requestedCapacity;
    }

    public void setRequestedCapacity(double requestedCapacity) {
        this.requestedCapacity = requestedCapacity;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AdditionalPowerRequest{" +
                "requestId='" + requestId + '\'' +
                ", requestedCapacity=" + requestedCapacity +
                ", justification='" + justification + '\'' +
                ", requestDate=" + requestDate +
                ", status='" + status + '\'' +
                '}';
    }
}
