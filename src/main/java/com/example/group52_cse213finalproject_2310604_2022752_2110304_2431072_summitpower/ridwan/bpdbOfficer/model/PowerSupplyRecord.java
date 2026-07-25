package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model;

import java.io.Serializable;
import java.time.LocalDate;

public class PowerSupplyRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private String recordId;
    private String consumerName;
    private String region;
    private double capacity;
    private LocalDate supplyDate;
    private String status;
    private String remarks;

    public PowerSupplyRecord(){

    }

    public PowerSupplyRecord(String recordId, String consumerName, String region, double capacity, LocalDate supplyDate, String status, String remarks) {
        this.recordId = recordId;
        this.consumerName = consumerName;
        this.region = region;
        this.capacity = capacity;
        this.supplyDate = supplyDate;
        this.status = status;
        this.remarks = remarks;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public LocalDate getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(LocalDate supplyDate) {
        this.supplyDate = supplyDate;
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
        return "PowerSupplyRecord{" +
                "recordId='" + recordId + '\'' +
                ", consumerName='" + consumerName + '\'' +
                ", region='" + region + '\'' +
                ", capacity=" + capacity +
                ", supplyDate=" + supplyDate +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
