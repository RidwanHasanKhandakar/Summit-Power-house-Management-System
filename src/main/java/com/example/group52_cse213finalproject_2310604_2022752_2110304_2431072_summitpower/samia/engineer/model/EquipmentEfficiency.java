package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model;

import java.io.Serializable;
import java.time.LocalDate;

public class EquipmentEfficiency implements Serializable {
    private String equipmentId,generatorId;
    private double powerOutput,fuelConsumption,efficiencyPercentage;
    private LocalDate analysisDate;

    public EquipmentEfficiency() {
    }

    public EquipmentEfficiency(String equipmentId, String generatorId, double powerOutput, double fuelConsumption, double efficiencyPercentage, LocalDate analysisDate) {
        this.equipmentId = equipmentId;
        this.generatorId = generatorId;
        this.powerOutput = powerOutput;
        this.fuelConsumption = fuelConsumption;
        this.efficiencyPercentage = efficiencyPercentage;
        this.analysisDate = analysisDate;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
    }

    public double getPowerOutput() {
        return powerOutput;
    }

    public void setPowerOutput(double powerOutput) {
        this.powerOutput = powerOutput;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getEfficiencyPercentage() {
        return efficiencyPercentage;
    }

    public void setEfficiencyPercentage(double efficiencyPercentage) {
        this.efficiencyPercentage = efficiencyPercentage;
    }

    public LocalDate getAnalysisDate() {
        return analysisDate;
    }

    public void setAnalysisDate(LocalDate analysisDate) {
        this.analysisDate = analysisDate;
    }

    @Override
    public String toString() {
        return "EquipmentEfficiency{" +
                "equipmentId='" + equipmentId + '\'' +
                ", generatorId='" + generatorId + '\'' +
                ", powerOutput=" + powerOutput +
                ", fuelConsumption=" + fuelConsumption +
                ", efficiencyPercentage=" + efficiencyPercentage +
                ", analysisDate=" + analysisDate +
                '}';
    }
}
