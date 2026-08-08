package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model;

import java.io.Serializable;
import java.time.LocalDate;

public class WeeklyReport implements Serializable {

    private static final long serialVersionUID = 1L;

    private String totalGeneration;
    private String totalPowerLoss;
    private String performanceStatus;
    private LocalDate startingDate;
    private LocalDate endingDate;

    public WeeklyReport(String totalGeneration,
                        String totalPowerLoss,
                        String performanceStatus,
                        LocalDate startingDate,
                        LocalDate endingDate) {

        this.totalGeneration = totalGeneration;
        this.totalPowerLoss = totalPowerLoss;
        this.performanceStatus = performanceStatus;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
    }

    public String getTotalGeneration() {
        return totalGeneration;
    }

    public void setTotalGeneration(String totalGeneration) {
        this.totalGeneration = totalGeneration;
    }

    public String getTotalPowerLoss() {
        return totalPowerLoss;
    }

    public void setTotalPowerLoss(String totalPowerLoss) {
        this.totalPowerLoss = totalPowerLoss;
    }

    public String getPerformanceStatus() {
        return performanceStatus;
    }

    public void setPerformanceStatus(String performanceStatus) {
        this.performanceStatus = performanceStatus;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    @Override
    public String toString() {
        return "WeeklyReport{" +
                "totalGeneration='" + totalGeneration + '\'' +
                ", totalPowerLoss='" + totalPowerLoss + '\'' +
                ", performanceStatus='" + performanceStatus + '\'' +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                '}';
    }
}

