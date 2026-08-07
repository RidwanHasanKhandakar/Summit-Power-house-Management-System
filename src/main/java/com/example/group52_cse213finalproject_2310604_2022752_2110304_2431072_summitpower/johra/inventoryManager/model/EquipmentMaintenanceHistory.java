package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class EquipmentMaintenanceHistory implements Serializable {

    private String maintenanceId, equipmentId, sparePartsUsed, quantityUsed, technician;
    private LocalDate maintenanceDate;

    public EquipmentMaintenanceHistory(String maintenanceId, String equipmentId, String sparePartsUsed, String quantityUsed, String technician, LocalDate maintenanceDate) {
        this.maintenanceId = maintenanceId;
        this.equipmentId = equipmentId;
        this.sparePartsUsed = sparePartsUsed;
        this.quantityUsed = quantityUsed;
        this.technician = technician;
        this.maintenanceDate = maintenanceDate;
    }

    public String getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(String maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getSparePartsUsed() {
        return sparePartsUsed;
    }

    public void setSparePartsUsed(String sparePartsUsed) {
        this.sparePartsUsed = sparePartsUsed;
    }

    public String getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(String quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    public String getTechnician() {
        return technician;
    }

    public void setTechnician(String technician) {
        this.technician = technician;
    }

    public LocalDate getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(LocalDate maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    @Override
    public String toString() {
        return "EquipmentMaintenanceInventory{" +
                "maintenanceId='" + maintenanceId + '\'' +
                ", equipmentId='" + equipmentId + '\'' +
                ", sparePartsUsed='" + sparePartsUsed + '\'' +
                ", quantityUsed='" + quantityUsed + '\'' +
                ", technician='" + technician + '\'' +
                ", maintenanceDate=" + maintenanceDate +
                '}';
    }
}
