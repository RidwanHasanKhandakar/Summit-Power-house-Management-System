package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model;

import java.io.Serializable;
import java.time.LocalDate;

public class PowerSupplyRecord implements Serializable {

    private String recordId;
    private String location;
    private double suppliedPower;
    private LocalDate supplyDate;
    private String remarks;

    public PowerSupplyRecord(String recordId, String location, double suppliedPower, LocalDate supplyDate, String remarks) {
        this.recordId = recordId;
        this.location = location;
        this.suppliedPower = suppliedPower;
        this.supplyDate = supplyDate;
        this.remarks = remarks;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSuppliedPower() {
        return suppliedPower;
    }

    public void setSuppliedPower(double suppliedPower) {
        this.suppliedPower = suppliedPower;
    }

    public LocalDate getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(LocalDate supplyDate) {
        this.supplyDate = supplyDate;
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
                ", location='" + location + '\'' +
                ", suppliedPower=" + suppliedPower +
                ", supplyDate=" + supplyDate +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
