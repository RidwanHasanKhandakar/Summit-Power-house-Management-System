package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model;

import java.io.Serializable;
import java.time.LocalDate;

public class FinancialStatement implements Serializable {

    private int statementId;
    private String statementType;
    private LocalDate fromDate;
    private LocalDate toDate;

    private double totalRevenue;
    private double totalExpenses;
    private double netProfit;

    public FinancialStatement() {
    }

    public FinancialStatement(int statementId, String statementType, LocalDate fromDate, LocalDate toDate, double totalRevenue, double totalExpenses, double netProfit) {
        this.statementId = statementId;
        this.statementType = statementType;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.totalRevenue = totalRevenue;
        this.totalExpenses = totalExpenses;
        this.netProfit = netProfit;
    }

    public int getStatementId() {
        return statementId;
    }

    public void setStatementId(int statementId) {
        this.statementId = statementId;
    }

    public String getStatementType() {
        return statementType;
    }

    public void setStatementType(String statementType) {
        this.statementType = statementType;
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

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }

    @Override
    public String toString() {
        return "FinancialStatement{" +
                "statementId=" + statementId +
                ", statementType='" + statementType + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", totalRevenue=" + totalRevenue +
                ", totalExpenses=" + totalExpenses +
                ", netProfit=" + netProfit +
                '}';
    }
}
