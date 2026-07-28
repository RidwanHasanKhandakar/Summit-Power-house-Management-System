package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model;

import java.io.Serializable;
import java.time.LocalDate;

public class ViewGridPerformanceReport implements Serializable {

    private String reportId,gridSection;
    private double totalLoadMW,availableCapacityMW,gridEfficiency;
    private String performanceStatus;
    private LocalDate reportDate;

    public ViewGridPerformanceReport() {
    }

    public ViewGridPerformanceReport(String reportId, String gridSection, double totalLoadMW, double availableCapacityMW, double gridEfficiency, String performanceStatus, LocalDate reportDate) {
        this.reportId = reportId;
        this.gridSection = gridSection;
        this.totalLoadMW = totalLoadMW;
        this.availableCapacityMW = availableCapacityMW;
        this.gridEfficiency = gridEfficiency;
        this.performanceStatus = performanceStatus;
        this.reportDate = reportDate;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getGridSection() {
        return gridSection;
    }

    public void setGridSection(String gridSection) {
        this.gridSection = gridSection;
    }

    public double getTotalLoadMW() {
        return totalLoadMW;
    }

    public void setTotalLoadMW(double totalLoadMW) {
        this.totalLoadMW = totalLoadMW;
    }

    public double getAvailableCapacityMW() {
        return availableCapacityMW;
    }

    public void setAvailableCapacityMW(double availableCapacityMW) {
        this.availableCapacityMW = availableCapacityMW;
    }

    public double getGridEfficiency() {
        return gridEfficiency;
    }

    public void setGridEfficiency(double gridEfficiency) {
        this.gridEfficiency = gridEfficiency;
    }

    public String getPerformanceStatus() {
        return performanceStatus;
    }

    public void setPerformanceStatus(String performanceStatus) {
        this.performanceStatus = performanceStatus;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    @Override
    public String toString() {
        return "ViewGridPerformanceReport{" +
                "reportId='" + reportId + '\'' +
                ", gridSection='" + gridSection + '\'' +
                ", totalLoadMW=" + totalLoadMW +
                ", availableCapacityMW=" + availableCapacityMW +
                ", gridEfficiency=" + gridEfficiency +
                ", performanceStatus='" + performanceStatus + '\'' +
                ", reportDate=" + reportDate +
                '}';
    }
}
