package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model;

import java.io.Serializable;
import java.time.LocalDate;

public class MonitorGeneratorStatus implements Serializable {
    private String generatorId,plantUnit,runningStatus;
    private double powerOutput,voltage,frequency,fuelLevel,engineTemperature;
    private int runningHours;
    private LocalDate lastMaintenanceDate;

    public MonitorGeneratorStatus() {
    }

    public MonitorGeneratorStatus(String generatorId, String plantUnit, String runningStatus, double powerOutput, double voltage, double frequency, double fuelLevel, double engineTemperature, int runningHours, LocalDate lastMaintenanceDate) {
        this.generatorId = generatorId;
        this.plantUnit = plantUnit;
        this.runningStatus = runningStatus;
        this.powerOutput = powerOutput;
        this.voltage = voltage;
        this.frequency = frequency;
        this.fuelLevel = fuelLevel;
        this.engineTemperature = engineTemperature;
        this.runningHours = runningHours;
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public String getGeneratorId() {
        return generatorId;
    }

    public String getPlantUnit() {
        return plantUnit;
    }

    public String getRunningStatus() {
        return runningStatus;
    }

    public double getPowerOutput() {
        return powerOutput;
    }

    public double getVoltage() {
        return voltage;
    }

    public double getFrequency() {
        return frequency;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public double getEngineTemperature() {
        return engineTemperature;
    }

    public int getRunningHours() {
        return runningHours;
    }

    public LocalDate getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setRunningStatus(String runningStatus) {
        this.runningStatus = runningStatus;
    }

    public void setPowerOutput(double powerOutput) {
        this.powerOutput = powerOutput;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void setEngineTemperature(double engineTemperature) {
        this.engineTemperature = engineTemperature;
    }

    public void setRunningHours(int runningHours) {
        this.runningHours = runningHours;
    }

    public void setLastMaintenanceDate(LocalDate lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    @Override
    public String toString() {
        return "MonitorGeneratorStatus{" +
                "generatorId='" + generatorId + '\'' +
                ", plantUnit='" + plantUnit + '\'' +
                ", runningStatus='" + runningStatus + '\'' +
                ", powerOutput=" + powerOutput +
                ", voltage=" + voltage +
                ", frequency=" + frequency +
                ", fuelLevel=" + fuelLevel +
                ", engineTemperature=" + engineTemperature +
                ", runningHours=" + runningHours +
                ", lastMaintenanceDate=" + lastMaintenanceDate +
                '}';
    }
}
