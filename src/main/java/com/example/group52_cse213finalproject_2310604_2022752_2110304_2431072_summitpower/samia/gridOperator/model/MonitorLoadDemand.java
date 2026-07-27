package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model;

import java.io.Serializable;
import java.time.LocalDate;

public class MonitorLoadDemand implements Serializable {
    private String demandId,gridSection;
    private double currentLoadMW,availableCapacityMW;
    private String demandStatus;
    private LocalDate monitoringDate;

    public MonitorLoadDemand() {
    }

    public MonitorLoadDemand(String demandId, String gridSection, double currentLoadMW, double availableCapacityMW, String demandStatus, LocalDate monitoringDate) {
        this.demandId = demandId;
        this.gridSection = gridSection;
        this.currentLoadMW = currentLoadMW;
        this.availableCapacityMW = availableCapacityMW;
        this.demandStatus = demandStatus;
        this.monitoringDate = monitoringDate;
    }

    public String getDemandId() {
        return demandId;
    }

    public void setDemandId(String demandId) {
        this.demandId = demandId;
    }

    public String getGridSection() {
        return gridSection;
    }

    public void setGridSection(String gridSection) {
        this.gridSection = gridSection;
    }

    public double getCurrentLoadMW() {
        return currentLoadMW;
    }

    public void setCurrentLoadMW(double currentLoadMW) {
        this.currentLoadMW = currentLoadMW;
    }

    public double getAvailableCapacityMW() {
        return availableCapacityMW;
    }

    public void setAvailableCapacityMW(double availableCapacityMW) {
        this.availableCapacityMW = availableCapacityMW;
    }

    public String getDemandStatus() {
        return demandStatus;
    }

    public void setDemandStatus(String demandStatus) {
        this.demandStatus = demandStatus;
    }

    public LocalDate getMonitoringDate() {
        return monitoringDate;
    }

    public void setMonitoringDate(LocalDate monitoringDate) {
        this.monitoringDate = monitoringDate;
    }

    @Override
    public String toString() {
        return "MonitorLoadDemand{" +
                "demandId='" + demandId + '\'' +
                ", gridSection='" + gridSection + '\'' +
                ", currentLoadMW=" + currentLoadMW +
                ", availableCapacityMW=" + availableCapacityMW +
                ", demandStatus='" + demandStatus + '\'' +
                ", monitoringDate=" + monitoringDate +
                '}';
    }
}
