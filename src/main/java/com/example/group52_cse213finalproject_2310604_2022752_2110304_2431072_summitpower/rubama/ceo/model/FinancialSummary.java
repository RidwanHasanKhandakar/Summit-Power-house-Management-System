package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model;

import java.time.LocalDate;

public class FinancialSummary {
    private String revenue;
    private int fuelCost,operationalCost;
    private LocalDate fromDate,toDate;

    public FinancialSummary(String revenue, int fuelCost, int operationalCost, LocalDate fromDate, LocalDate toDate) {
        this.revenue = revenue;
        this.fuelCost = fuelCost;
        this.operationalCost = operationalCost;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public int getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(int fuelCost) {
        this.fuelCost = fuelCost;
    }

    public int getOperationalCost() {
        return operationalCost;
    }

    public void setOperationalCost(int operationalCost) {
        this.operationalCost = operationalCost;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "FinancialSummary{" +
                "revenue='" + revenue + '\'' +
                ", fuelCost=" + fuelCost +
                ", operationalCost=" + operationalCost +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
