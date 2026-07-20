package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model;

import java.time.LocalDate;

public class SupplyAgreement {

    private String agreementId;
    private String consumerName;
    private String agreementType;
    private double capacity;
    private LocalDate startDate;
    private LocalDate endDate;
    private String Status;

    public SupplyAgreement(String agreementId, String consumerName, String agreementType, double capacity, LocalDate startDate, LocalDate endDate, String status) {
        this.agreementId = agreementId;
        this.consumerName = consumerName;
        this.agreementType = agreementType;
        this.capacity = capacity;
        this.startDate = startDate;
        this.endDate = endDate;
        Status = status;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(String agreementType) {
        this.agreementType = agreementType;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "SupplyAgreement{" +
                "agreementId='" + agreementId + '\'' +
                ", consumerName='" + consumerName + '\'' +
                ", agreementType='" + agreementType + '\'' +
                ", capacity=" + capacity +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", Status='" + Status + '\'' +
                '}';
    }
}
