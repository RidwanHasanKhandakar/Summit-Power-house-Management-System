package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model;

import java.io.Serializable;
import java.time.LocalDate;

public class UpdateMaintenanceStatus implements Serializable {
    private String maintenanceId,generatorId;
    private LocalDate maintenanceDate;
    private String maintenanceStatus,updatedBy,remarks;

    public UpdateMaintenanceStatus() {
    }

    public UpdateMaintenanceStatus(String maintenanceId, String generatorId, LocalDate maintenanceDate, String maintenanceStatus, String updatedBy, String remarks) {
        this.maintenanceId = maintenanceId;
        this.generatorId = generatorId;
        this.maintenanceDate = maintenanceDate;
        this.maintenanceStatus = maintenanceStatus;
        this.updatedBy = updatedBy;
        this.remarks = remarks;
    }

    public String getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(String maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
    }

    public LocalDate getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(LocalDate maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(String maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "UpdateMaintenanceStatus{" +
                "maintenanceId='" + maintenanceId + '\'' +
                ", generatorId='" + generatorId + '\'' +
                ", maintenanceDate=" + maintenanceDate +
                ", maintenanceStatus='" + maintenanceStatus + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
