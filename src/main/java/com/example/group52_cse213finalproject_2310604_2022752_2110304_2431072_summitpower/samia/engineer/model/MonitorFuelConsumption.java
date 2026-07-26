package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model;

import java.io.Serializable;
import java.time.LocalDate;

public class MonitorFuelConsumption implements Serializable {
    private String generatorId,fuelType;
    private double fuelConsumed,operatingHours;
    private LocalDate monitoringDate;
    private String remarks;

    public MonitorFuelConsumption() {
    }

    public MonitorFuelConsumption(String generatorId, String fuelType, double fuelConsumed, double operatingHours, LocalDate monitoringDate, String remarks) {
        this.generatorId = generatorId;
        this.fuelType = fuelType;
        this.fuelConsumed = fuelConsumed;
        this.operatingHours = operatingHours;
        this.monitoringDate = monitoringDate;
        this.remarks = remarks;
    }

    public String getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getFuelConsumed() {
        return fuelConsumed;
    }

    public void setFuelConsumed(double fuelConsumed) {
        this.fuelConsumed = fuelConsumed;
    }

    public double getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(double operatingHours) {
        this.operatingHours = operatingHours;
    }

    public LocalDate getMonitoringDate() {
        return monitoringDate;
    }

    public void setMonitoringDate(LocalDate monitoringDate) {
        this.monitoringDate = monitoringDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "MonitorFuelConsumption{" +
                "generatorId='" + generatorId + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", fuelConsumed=" + fuelConsumed +
                ", operatingHours=" + operatingHours +
                ", monitoringDate=" + monitoringDate +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
