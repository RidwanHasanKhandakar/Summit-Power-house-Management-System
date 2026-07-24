package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model;

import java.io.Serializable;
import java.time.LocalDate;

public class ReportEquipmentFaults implements Serializable {
    private String faultId,equipmentId,generatorId,faultCategory,faultSeverity;
    private LocalDate reportDate;
    private String faultDescription;

    public ReportEquipmentFaults() {
    }

    public ReportEquipmentFaults(String faultId, String equipmentId, String generatorId, String faultCategory, String faultSeverity, LocalDate reportDate, String faultDescription) {
        this.faultId = faultId;
        this.equipmentId = equipmentId;
        this.generatorId = generatorId;
        this.faultCategory = faultCategory;
        this.faultSeverity = faultSeverity;
        this.reportDate = reportDate;
        this.faultDescription = faultDescription;
    }

    public String getFaultId() {
        return faultId;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public String getGeneratorId() {
        return generatorId;
    }

    public String getFaultCategory() {
        return faultCategory;
    }

    public String getFaultSeverity() {
        return faultSeverity;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public String getFaultDescription() {
        return faultDescription;
    }

    public void setFaultId(String faultId) {
        this.faultId = faultId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
    }

    public void setFaultCategory(String faultCategory) {
        this.faultCategory = faultCategory;
    }

    public void setFaultSeverity(String faultSeverity) {
        this.faultSeverity = faultSeverity;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public void setFaultDescription(String faultDescription) {
        this.faultDescription = faultDescription;
    }

    @Override
    public String toString() {
        return "ReportEquipmentFaults{" +
                "faultId='" + faultId + '\'' +
                ", equipmentId='" + equipmentId + '\'' +
                ", generatorId='" + generatorId + '\'' +
                ", faultCategory='" + faultCategory + '\'' +
                ", faultSeverity='" + faultSeverity + '\'' +
                ", reportDate=" + reportDate +
                ", faultDescription='" + faultDescription + '\'' +
                '}';
    }
}
