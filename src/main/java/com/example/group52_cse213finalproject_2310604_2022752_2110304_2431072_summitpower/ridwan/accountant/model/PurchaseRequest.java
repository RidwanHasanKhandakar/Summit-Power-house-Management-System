package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model;

import java.io.Serializable;
import java.time.LocalDate;

public class PurchaseRequest implements Serializable {

    private int requestId;
    private String department;
    private String description;
    private String requestedBy;
    private double cost;
    private LocalDate requestDate;
    private String status;
    private String remarks;

    public PurchaseRequest() {
    }

    public PurchaseRequest(int requestId, String department, String description, String requestedBy, double cost, LocalDate requestDate, String status, String remarks) {
        this.requestId = requestId;
        this.department = department;
        this.description = description;
        this.requestedBy = requestedBy;
        this.cost = cost;
        this.requestDate = requestDate;
        this.status = status;
        this.remarks = remarks;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "PurchaseRequest{" +
                "requestId=" + requestId +
                ", department='" + department + '\'' +
                ", description='" + description + '\'' +
                ", requestedBy='" + requestedBy + '\'' +
                ", cost=" + cost +
                ", requestDate=" + requestDate +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
