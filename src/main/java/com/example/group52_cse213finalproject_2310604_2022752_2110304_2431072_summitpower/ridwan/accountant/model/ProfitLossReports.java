package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model;

import java.io.Serializable;

public class ProfitLossReports implements Serializable {

    private String month;
    private int year;

    private double salesIncome;
    private double expenses;
    private double salaryCost;
    private double fuelCost;

    private double netProfit;

    public ProfitLossReports() {
    }

    public ProfitLossReports(String month, int year, double salesIncome, double expenses, double salaryCost, double fuelCost, double netProfit) {
        this.month = month;
        this.year = year;
        this.salesIncome = salesIncome;
        this.expenses = expenses;
        this.salaryCost = salaryCost;
        this.fuelCost = fuelCost;
        this.netProfit = netProfit;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getSalesIncome() {
        return salesIncome;
    }

    public void setSalesIncome(double salesIncome) {
        this.salesIncome = salesIncome;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getSalaryCost() {
        return salaryCost;
    }

    public void setSalaryCost(double salaryCost) {
        this.salaryCost = salaryCost;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }

    @Override
    public String toString() {
        return "ProfitLossReports{" +
                "month='" + month + '\'' +
                ", year=" + year +
                ", salesIncome=" + salesIncome +
                ", expenses=" + expenses +
                ", salaryCost=" + salaryCost +
                ", fuelCost=" + fuelCost +
                ", netProfit=" + netProfit +
                '}';
    }
}
