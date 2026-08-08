package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model;

public abstract class Report {
    protected String reportTitle;

    public Report(String reportTitle) {
        this.reportTitle = reportTitle;
    }
    public String getReportTitle() {
        return reportTitle;
    }
    public abstract void generateReport();
}
