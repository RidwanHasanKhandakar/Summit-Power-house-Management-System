package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model;

import java.io.Serializable;
import java.time.LocalDate;

public class LoadDistribution implements Serializable {
    private String distributionId,gridSection;
    private double loadMW;
    private String distributionStatus;
    private LocalDate distributionDate;
    private String remarks;

    public LoadDistribution() {
    }

    public LoadDistribution(String distributionId, String gridSection, double loadMW, String distributionStatus, LocalDate distributionDate, String remarks) {
        this.distributionId = distributionId;
        this.gridSection = gridSection;
        this.loadMW = loadMW;
        this.distributionStatus = distributionStatus;
        this.distributionDate = distributionDate;
        this.remarks = remarks;
    }

    public String getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(String distributionId) {
        this.distributionId = distributionId;
    }

    public String getGridSection() {
        return gridSection;
    }

    public void setGridSection(String gridSection) {
        this.gridSection = gridSection;
    }

    public double getLoadMW() {
        return loadMW;
    }

    public void setLoadMW(double loadMW) {
        this.loadMW = loadMW;
    }

    public String getDistributionStatus() {
        return distributionStatus;
    }

    public void setDistributionStatus(String distributionStatus) {
        this.distributionStatus = distributionStatus;
    }

    public LocalDate getDistributionDate() {
        return distributionDate;
    }

    public void setDistributionDate(LocalDate distributionDate) {
        this.distributionDate = distributionDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "LoadDistribution{" +
                "distributionId='" + distributionId + '\'' +
                ", gridSection='" + gridSection + '\'' +
                ", loadMW=" + loadMW +
                ", distributionStatus='" + distributionStatus + '\'' +
                ", distributionDate=" + distributionDate +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
