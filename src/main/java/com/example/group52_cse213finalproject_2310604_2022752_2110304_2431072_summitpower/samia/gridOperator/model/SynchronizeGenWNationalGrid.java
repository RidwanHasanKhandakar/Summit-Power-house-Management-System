package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model;

import java.io.Serializable;
import java.time.LocalDate;

public class SynchronizeGenWNationalGrid implements Serializable {
    private String synchronizationId,generatorId,gridSection;
    private double generatorVoltage,gridVoltage;
    private String synchronizationStatus;
    private LocalDate synchronizationDate;

    public SynchronizeGenWNationalGrid() {
    }

    public SynchronizeGenWNationalGrid(String synchronizationId, String generatorId, String gridSection, double generatorVoltage, double gridVoltage, String synchronizationStatus, LocalDate synchronizationDate) {
        this.synchronizationId = synchronizationId;
        this.generatorId = generatorId;
        this.gridSection = gridSection;
        this.generatorVoltage = generatorVoltage;
        this.gridVoltage = gridVoltage;
        this.synchronizationStatus = synchronizationStatus;
        this.synchronizationDate = synchronizationDate;
    }

    public String getSynchronizationId() {
        return synchronizationId;
    }

    public void setSynchronizationId(String synchronizationId) {
        this.synchronizationId = synchronizationId;
    }

    public String getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
    }

    public String getGridSection() {
        return gridSection;
    }

    public void setGridSection(String gridSection) {
        this.gridSection = gridSection;
    }

    public double getGeneratorVoltage() {
        return generatorVoltage;
    }

    public void setGeneratorVoltage(double generatorVoltage) {
        this.generatorVoltage = generatorVoltage;
    }

    public double getGridVoltage() {
        return gridVoltage;
    }

    public void setGridVoltage(double gridVoltage) {
        this.gridVoltage = gridVoltage;
    }

    public String getSynchronizationStatus() {
        return synchronizationStatus;
    }

    public void setSynchronizationStatus(String synchronizationStatus) {
        this.synchronizationStatus = synchronizationStatus;
    }

    public LocalDate getSynchronizationDate() {
        return synchronizationDate;
    }

    public void setSynchronizationDate(LocalDate synchronizationDate) {
        this.synchronizationDate = synchronizationDate;
    }

    @Override
    public String toString() {
        return "SynchronizeGenWNationalGrid{" +
                "synchronizationId='" + synchronizationId + '\'' +
                ", generatorId='" + generatorId + '\'' +
                ", gridSection='" + gridSection + '\'' +
                ", generatorVoltage=" + generatorVoltage +
                ", gridVoltage=" + gridVoltage +
                ", synchronizationStatus='" + synchronizationStatus + '\'' +
                ", synchronizationDate=" + synchronizationDate +
                '}';
    }
}
