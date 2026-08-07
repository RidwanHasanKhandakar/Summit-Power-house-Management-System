package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class FuelConsumption implements Serializable {

    private String consumptionId, fuelType, quantityUsed, plantUnit;
    private LocalDate consumptionDate;

    public FuelConsumption(String consumptionId, String fuelType, String quantityUsed, String plantUnit, LocalDate consumptionDate) {
        this.consumptionId = consumptionId;
        this.fuelType = fuelType;
        this.quantityUsed = quantityUsed;
        this.plantUnit = plantUnit;
        this.consumptionDate = consumptionDate;
    }

    public String getConsumptionId() {
        return consumptionId;
    }

    public void setConsumptionId(String consumptionId) {
        this.consumptionId = consumptionId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(String quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    public String getPlantUnit() {
        return plantUnit;
    }

    public void setPlantUnit(String plantUnit) {
        this.plantUnit = plantUnit;
    }

    public LocalDate getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(LocalDate consumptionDate) {
        this.consumptionDate = consumptionDate;
    }

    @Override
    public String toString() {
        return "FuelConsumption{" +
                "consumptionId='" + consumptionId + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", quantityUsed='" + quantityUsed + '\'' +
                ", plantUnit='" + plantUnit + '\'' +
                ", consumptionDate=" + consumptionDate +
                '}';
    }
}
