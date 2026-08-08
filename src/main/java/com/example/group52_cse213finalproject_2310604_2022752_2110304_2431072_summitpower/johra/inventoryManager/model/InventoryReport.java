package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class InventoryReport implements Serializable {
    private LocalDate reportDate;
    private String category, reportType, reportId, item, quantity;

    public InventoryReport(LocalDate reportDate, String category, String reportType, String reportId, String item, String quantity) {
        this.reportDate = reportDate;
        this.category = category;
        this.reportType = reportType;
        this.reportId = reportId;
        this.item = item;
        this.quantity = quantity;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "InventoryReport{" +
                "reportDate=" + reportDate +
                ", category='" + category + '\'' +
                ", reportType='" + reportType + '\'' +
                ", reportId='" + reportId + '\'' +
                ", item='" + item + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
