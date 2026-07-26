package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model;

import java.io.Serializable;
import java.time.LocalDate;

public class EngineeringPerformance implements Serializable {
    private String reportId,generatorId;
    private LocalDate reportDate;
    private double powerOutput,efficiencyPercentage;
    private String performanceStatus;

    public EngineeringPerformance() {
    }

    public EngineeringPerformance(String reportId, String generatorId, LocalDate reportDate, double powerOutput, double efficiencyPercentage, String performanceStatus) {
        this.reportId = reportId;
        this.generatorId = generatorId;
        this.reportDate = reportDate;
        this.powerOutput = powerOutput;
        this.efficiencyPercentage = efficiencyPercentage;
        this.performanceStatus = performanceStatus;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public double getPowerOutput() {
        return powerOutput;
    }

    public void setPowerOutput(double powerOutput) {
        this.powerOutput = powerOutput;
    }

    public double getEfficiencyPercentage() {
        return efficiencyPercentage;
    }

    public void setEfficiencyPercentage(double efficiencyPercentage) {
        this.efficiencyPercentage = efficiencyPercentage;
    }

    public String getPerformanceStatus() {
        return performanceStatus;
    }

    public void setPerformanceStatus(String performanceStatus) {
        this.performanceStatus = performanceStatus;
    }

    @Override
    public String toString() {
        return "EngineeringPerformance{" +
                "reportId='" + reportId + '\'' +
                ", generatorId='" + generatorId + '\'' +
                ", reportDate=" + reportDate +
                ", powerOutput=" + powerOutput +
                ", efficiencyPercentage=" + efficiencyPercentage +
                ", performanceStatus='" + performanceStatus + '\'' +
                '}';
    }
}
