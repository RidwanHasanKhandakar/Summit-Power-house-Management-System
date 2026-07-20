package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model;

import java.time.LocalDate;

public class SupplyReport {

    private String reportId;
    private String reportType;
    private LocalDate generateDate;
    private String reportingPeriod;

    public SupplyReport(String reportId, String reportType, LocalDate generateDate, String reportingPeriod) {
        this.reportId = reportId;
        this.reportType = reportType;
        this.generateDate = generateDate;
        this.reportingPeriod = reportingPeriod;
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

    public LocalDate getGenerateDate() {
        return generateDate;
    }

    public void setGenerateDate(LocalDate generateDate) {
        this.generateDate = generateDate;
    }

    public String getReportingPeriod() {
        return reportingPeriod;
    }

    public void setReportingPeriod(String reportingPeriod) {
        this.reportingPeriod = reportingPeriod;
    }

    @Override
    public String toString() {
        return "SupplyReport{" +
                "reportId='" + reportId + '\'' +
                ", reportType='" + reportType + '\'' +
                ", generateDate=" + generateDate +
                ", reportingPeriod='" + reportingPeriod + '\'' +
                '}';
    }
}
