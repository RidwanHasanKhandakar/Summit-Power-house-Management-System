package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model;

import java.io.Serializable;
import java.time.LocalDate;

public class AdditionalPowerRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String requestId;
    private double additionalPowerCapacity;
    private LocalDate startDate;
    private LocalDate endDate;
    private String justification;
    private String status;

    public AdditionalPowerRequest() {
    }

    public AdditionalPowerRequest(String requestId, double additionalPowerCapacity, LocalDate startDate, LocalDate endDate, String justification, String status) {
        this.requestId = requestId;
        this.additionalPowerCapacity = additionalPowerCapacity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.justification = justification;
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public double getAdditionalPowerCapacity() {
        return additionalPowerCapacity;
    }

    public void setAdditionalPowerCapacity(double additionalPowerCapacity) {
        this.additionalPowerCapacity = additionalPowerCapacity;
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

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
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
                ", additionalPowerCapacity=" + additionalPowerCapacity +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", justification='" + justification + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
