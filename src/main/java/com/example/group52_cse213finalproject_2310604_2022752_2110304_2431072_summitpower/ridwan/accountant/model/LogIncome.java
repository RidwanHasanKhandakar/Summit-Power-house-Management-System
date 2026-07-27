package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model;

import java.io.Serializable;
import java.time.LocalDate;

public class LogIncome implements Serializable {

    private int saleID;
    private String clientName;
    private double unitsSold;
    private double revenueAmount;
    private LocalDate transactionDate;

    public LogIncome() {
    }

    public LogIncome(int saleID, String clientName, double unitsSold, double revenueAmount, LocalDate transactionDate) {
        this.saleID = saleID;
        this.clientName = clientName;
        this.unitsSold = unitsSold;
        this.revenueAmount = revenueAmount;
        this.transactionDate = transactionDate;
    }

    public int getSaleID() {
        return saleID;
    }

    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(double unitsSold) {
        this.unitsSold = unitsSold;
    }

    public double getRevenueAmount() {
        return revenueAmount;
    }

    public void setRevenueAmount(double revenueAmount) {
        this.revenueAmount = revenueAmount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "LogIncome{" +
                "saleID=" + saleID +
                ", clientName='" + clientName + '\'' +
                ", unitsSold=" + unitsSold +
                ", revenueAmount=" + revenueAmount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
