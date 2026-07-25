package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model;

import java.io.Serializable;
import java.time.LocalDate;

public class PreventiveMaintenance implements Serializable {
    private String maintenanceId,generatorId,plantUnit,maintenanceType;
    private LocalDate scheduledDate;
    private String engineerName,priority,maintenanceStatus,remarks;

    public PreventiveMaintenance() {
    }

    public PreventiveMaintenance(String maintenanceId, String generatorId, String plantUnit, String maintenanceType, LocalDate scheduledDate, String engineerName, String priority, String maintenanceStatus, String remarks) {
        this.maintenanceId = maintenanceId;
        this.generatorId = generatorId;
        this.plantUnit = plantUnit;
        this.maintenanceType = maintenanceType;
        this.scheduledDate = scheduledDate;
        this.engineerName = engineerName;
        this.priority = priority;
        this.maintenanceStatus = maintenanceStatus;
        this.remarks = remarks;
    }

    public String getMaintenanceId() {
        return maintenanceId;
    }

    public String getGeneratorId() {
        return generatorId;
    }

    public String getPlantUnit() {
        return plantUnit;
    }

    public String getMaintenanceType() {
        return maintenanceType;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public String getEngineerName() {
        return engineerName;
    }

    public String getPriority() {
        return priority;
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setMaintenanceType(String maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setMaintenanceStatus(String maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "PreventiveMaintenance{" +
                "maintenanceId='" + maintenanceId + '\'' +
                ", generatorId='" + generatorId + '\'' +
                ", plantUnit='" + plantUnit + '\'' +
                ", maintenanceType='" + maintenanceType + '\'' +
                ", scheduledDate=" + scheduledDate +
                ", engineerName='" + engineerName + '\'' +
                ", priority='" + priority + '\'' +
                ", maintenanceStatus='" + maintenanceStatus + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
