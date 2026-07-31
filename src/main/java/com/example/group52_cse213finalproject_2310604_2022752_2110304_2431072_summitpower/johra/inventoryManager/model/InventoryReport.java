package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class InventoryReport implements Serializable {
    private LocalDate reportDate;
    private String equipmentOrFuelCategory, reportType;
    private Boolean stockAvailable, stoxkNotAvailable;

    public InventoryReport(LocalDate reportDate, String equipmentOrFuelCategory, String reportType, Boolean stockAvailable, Boolean stoxkNotAvailable) {
        this.reportDate = reportDate;
        this.equipmentOrFuelCategory = equipmentOrFuelCategory;
        this.reportType = reportType;
        this.stockAvailable = stockAvailable;
        this.stoxkNotAvailable = stoxkNotAvailable;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public String getEquipmentOrFuelCategory() {
        return equipmentOrFuelCategory;
    }

    public void setEquipmentOrFuelCategory(String equipmentOrFuelCategory) {
        this.equipmentOrFuelCategory = equipmentOrFuelCategory;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public Boolean getStockAvailable() {
        return stockAvailable;
    }

    public void setStockAvailable(Boolean stockAvailable) {
        this.stockAvailable = stockAvailable;
    }

    public Boolean getStoxkNotAvailable() {
        return stoxkNotAvailable;
    }

    public void setStoxkNotAvailable(Boolean stoxkNotAvailable) {
        this.stoxkNotAvailable = stoxkNotAvailable;
    }

    @Override
    public String toString() {
        return "InventoryReport{" +
                "reportDate=" + reportDate +
                ", equipmentOrFuelCategory='" + equipmentOrFuelCategory + '\'' +
                ", reportType='" + reportType + '\'' +
                ", stockAvailable=" + stockAvailable +
                ", stoxkNotAvailable=" + stoxkNotAvailable +
                '}';
    }
}
