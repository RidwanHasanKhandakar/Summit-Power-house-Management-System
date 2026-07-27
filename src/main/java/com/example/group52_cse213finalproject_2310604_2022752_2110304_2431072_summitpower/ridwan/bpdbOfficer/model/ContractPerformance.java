package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model;

import java.io.Serializable;
import java.time.LocalDate;

public class ContractPerformance implements Serializable {

    private static final long serialVersionUID = 1L;

    private String contractID;
    private String consumerName;
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private double contractedCapacity;
    private double suppliedCapacity;
    private double fulfillmentPercentage;
    private String status;

    public ContractPerformance(String contractID, String consumerName, LocalDate contractStartDate, LocalDate contractEndDate, double contractedCapacity, double suppliedCapacity, double fulfillmentPercentage, String status) {
        this.contractID = contractID;
        this.consumerName = consumerName;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractedCapacity = contractedCapacity;
        this.suppliedCapacity = suppliedCapacity;
        this.fulfillmentPercentage = fulfillmentPercentage;
        this.status = status;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public LocalDate getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(LocalDate contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public double getContractedCapacity() {
        return contractedCapacity;
    }

    public void setContractedCapacity(double contractedCapacity) {
        this.contractedCapacity = contractedCapacity;
    }

    public double getSuppliedCapacity() {
        return suppliedCapacity;
    }

    public void setSuppliedCapacity(double suppliedCapacity) {
        this.suppliedCapacity = suppliedCapacity;
    }

    public double getFulfillmentPercentage() {
        return fulfillmentPercentage;
    }

    public void setFulfillmentPercentage(double fulfillmentPercentage) {
        this.fulfillmentPercentage = fulfillmentPercentage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ContractPerformance{" +
                "contractID='" + contractID + '\'' +
                ", consumerName='" + consumerName + '\'' +
                ", contractStartDate=" + contractStartDate +
                ", contractEndDate=" + contractEndDate +
                ", contractedCapacity=" + contractedCapacity +
                ", suppliedCapacity=" + suppliedCapacity +
                ", fulfillmentPercentage=" + fulfillmentPercentage +
                ", status='" + status + '\'' +
                '}';
    }
}
