package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model;

public class FuelPurchaseApproval {
    private String requests,approvalStatus;

    public FuelPurchaseApproval(String requests, String approvalStatus) {
        this.requests = requests;
        this.approvalStatus = approvalStatus;
    }

    public String getRequests() {
        return requests;
    }

    public void setRequests(String requests) {
        this.requests = requests;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @Override
    public String toString() {
        return "FuelPurchaseApproval{" +
                "requests='" + requests + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                '}';
    }
}
