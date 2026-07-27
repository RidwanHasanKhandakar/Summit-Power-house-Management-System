package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model;

import java.io.Serializable;
import java.time.LocalDate;

public class SupplyReport implements Serializable {

    private static final long serialVersionUID = 1L;

    private String reportId;
    private String reportType;
    private LocalDate generatedDate;
    private double generatedPower;
    private double suppliedPower;
    private double transmissionLoss;
    private String remarks;

    public SupplyReport() {
    }

    public SupplyReport(String reportId, String reportType, LocalDate generatedDate, double generatedPower, double suppliedPower, double transmissionLoss, String remarks) {
        this.reportId = reportId;
        this.reportType = reportType;
        this.generatedDate = generatedDate;
        this.generatedPower = generatedPower;
        this.suppliedPower = suppliedPower;
        this.transmissionLoss = transmissionLoss;
        this.remarks = remarks;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public LocalDate getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDate generatedDate) {
        this.generatedDate = generatedDate;
    }

    public double getGeneratedPower() {
        return generatedPower;
    }

    public void setGeneratedPower(double generatedPower) {
        this.generatedPower = generatedPower;
    }

    public double getSuppliedPower() {
        return suppliedPower;
    }

    public void setSuppliedPower(double suppliedPower) {
        this.suppliedPower = suppliedPower;
    }

    public double getTransmissionLoss() {
        return transmissionLoss;
    }

    public void setTransmissionLoss(double transmissionLoss) {
        this.transmissionLoss = transmissionLoss;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "SupplyReport{" +
                "reportId='" + reportId + '\'' +
                ", reportType='" + reportType + '\'' +
                ", generatedDate=" + generatedDate +
                ", generatedPower=" + generatedPower +
                ", suppliedPower=" + suppliedPower +
                ", transmissionLoss=" + transmissionLoss +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
