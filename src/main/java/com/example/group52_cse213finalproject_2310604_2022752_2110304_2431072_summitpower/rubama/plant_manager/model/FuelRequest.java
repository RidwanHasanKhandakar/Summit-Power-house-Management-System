package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class FuelRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String unitName;
    private String fuelType;
    private String status;
    private LocalDate date;

    public FuelRequest(String unitName, String fuelType, String status, LocalDate date) {
        this.unitName = unitName;
        this.fuelType = fuelType;
        this.status = status;
        this.date = date;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FuelRequest{" +
                "unitName='" + unitName + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }

}
