package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model;

import java.io.Serializable;
import java.time.LocalDate;

public class FuelInventory implements Serializable {

    private int fuelId;
    private String fuelType;
    private double quantity;
    private double unitCost;
    private double totalValue;
    private LocalDate lastUpdated;

    public FuelInventory() {
    }

    public FuelInventory(int fuelId, String fuelType, double quantity, double unitCost, double totalValue, LocalDate lastUpdated) {
        this.fuelId = fuelId;
        this.fuelType = fuelType;
        this.quantity = quantity;
        this.unitCost = unitCost;
        this.totalValue = totalValue;
        this.lastUpdated = lastUpdated;
    }

    public int getFuelId() {
        return fuelId;
    }

    public void setFuelId(int fuelId) {
        this.fuelId = fuelId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "FuelInventory{" +
                "fuelId=" + fuelId +
                ", fuelType='" + fuelType + '\'' +
                ", quantity=" + quantity +
                ", unitCost=" + unitCost +
                ", totalValue=" + totalValue +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
