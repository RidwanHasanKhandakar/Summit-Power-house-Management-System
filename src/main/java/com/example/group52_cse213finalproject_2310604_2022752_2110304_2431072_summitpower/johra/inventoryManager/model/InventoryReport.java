package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class InventoryReport implements Serializable {
    private LocalDate reportDate;
    private String equipmentOrFuelCategory, reportType, reportId;
    private Boolean stockAvailable, stockNotAvailable;

    public InventoryReport(LocalDate reportDate, String equipmentOrFuelCategory, String reportType, String reportId, Boolean stockAvailable, Boolean stockNotAvailable) {
        this.reportDate = reportDate;
        this.equipmentOrFuelCategory = equipmentOrFuelCategory;
        this.reportType = reportType;
        this.reportId = reportId;
        this.stockAvailable = stockAvailable;
        this.stockNotAvailable = stockNotAvailable;
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

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public Boolean getStockAvailable() {
        return stockAvailable;
    }

    public void setStockAvailable(Boolean stockAvailable) {
        this.stockAvailable = stockAvailable;
    }

    public Boolean getStockNotAvailable() {
        return stockNotAvailable;
    }

    public void setStockNotAvailable(Boolean stockNotAvailable) {
        this.stockNotAvailable = stockNotAvailable;
    }

    public String getStockStatus(){
        if(stockAvailable){
            return "Available";
        }
        else{
            return "Not Available";
        }
    }

    @Override
    public String toString() {
        return "InventoryReport{" +
                "reportDate=" + reportDate +
                ", equipmentOrFuelCategory='" + equipmentOrFuelCategory + '\'' +
                ", reportType='" + reportType + '\'' +
                ", reportId='" + reportId + '\'' +
                ", stockAvailable=" + stockAvailable +
                ", stockNotAvailable=" + stockNotAvailable +
                '}';
    }
}
