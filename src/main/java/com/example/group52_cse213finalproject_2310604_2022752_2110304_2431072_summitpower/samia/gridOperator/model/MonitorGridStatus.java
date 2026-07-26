package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model;

import java.io.Serializable;
import java.time.LocalDate;

public class MonitorGridStatus implements Serializable {
    private String gridId,gridSection,gridStatus;
    private double voltage,frequency;
    private LocalDate monitoringDate;

    public MonitorGridStatus() {
    }

    public MonitorGridStatus(String gridId, String gridSection, String gridStatus, double voltage, double frequency, LocalDate monitoringDate) {
        this.gridId = gridId;
        this.gridSection = gridSection;
        this.gridStatus = gridStatus;
        this.voltage = voltage;
        this.frequency = frequency;
        this.monitoringDate = monitoringDate;
    }

    public String getGridId() {
        return gridId;
    }

    public void setGridId(String gridId) {
        this.gridId = gridId;
    }

    public String getGridSection() {
        return gridSection;
    }

    public void setGridSection(String gridSection) {
        this.gridSection = gridSection;
    }

    public String getGridStatus() {
        return gridStatus;
    }

    public void setGridStatus(String gridStatus) {
        this.gridStatus = gridStatus;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public LocalDate getMonitoringDate() {
        return monitoringDate;
    }

    public void setMonitoringDate(LocalDate monitoringDate) {
        this.monitoringDate = monitoringDate;
    }

    @Override
    public String toString() {
        return "MonitorGridStatus{" +
                "gridId='" + gridId + '\'' +
                ", gridSection='" + gridSection + '\'' +
                ", gridStatus='" + gridStatus + '\'' +
                ", voltage=" + voltage +
                ", frequency=" + frequency +
                ", monitoringDate=" + monitoringDate +
                '}';
    }
}
