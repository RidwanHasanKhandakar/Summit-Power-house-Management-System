package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model;

import java.io.Serializable;
import java.time.LocalDate;

public class TrackFuel implements Serializable {

    private int expenseId;
    private String category;
    private double amount;
    private String description;
    private LocalDate expenseDate;

    public TrackFuel() {
    }

    public TrackFuel(int expenseId, String category, double amount, String description, LocalDate expenseDate) {
        this.expenseId = expenseId;
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.expenseDate = expenseDate;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    @Override
    public String toString() {
        return "TrackFuel{" +
                "expenseId=" + expenseId +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", expenseDate=" + expenseDate +
                '}';
    }
}
