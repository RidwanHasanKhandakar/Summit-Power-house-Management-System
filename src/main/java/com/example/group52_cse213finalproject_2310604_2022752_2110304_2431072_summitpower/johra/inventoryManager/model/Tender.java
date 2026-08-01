package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Tender implements Serializable {
    private String tenderId, tenderTitle, equipmentName;
    private String estimatedBudget;
    private LocalDate closingDate;

    public Tender(String tenderId, String tenderTitle, String equipmentName, LocalDate closingDate) {
        this.tenderId = tenderId;
        this.tenderTitle = tenderTitle;
        this.equipmentName = equipmentName;
        this.closingDate = closingDate;
    }

    public String getTenderId() {
        return tenderId;
    }

    public void setTenderId(String tenderId) {
        this.tenderId = tenderId;
    }

    public String getTenderTitle() {
        return tenderTitle;
    }

    public void setTenderTitle(String tenderTitle) {
        this.tenderTitle = tenderTitle;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    @Override
    public String toString() {
        return "Tender{" +
                "tenderId='" + tenderId + '\'' +
                ", tenderTitle='" + tenderTitle + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", closingDate=" + closingDate +
                '}';
    }
}
