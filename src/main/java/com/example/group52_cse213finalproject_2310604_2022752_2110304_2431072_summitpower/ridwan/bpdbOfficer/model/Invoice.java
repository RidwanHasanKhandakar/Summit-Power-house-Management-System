package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Invoice implements Serializable {

    private String invoiceId;
    private String consumerName;
    private double amount;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private String paymentStatus;
    private String remarks;

    public Invoice(String invoiceId, String consumerName, double amount, LocalDate invoiceDate, LocalDate dueDate, LocalDate paymentDate, String paymentStatus, String remarks) {
        this.invoiceId = invoiceId;
        this.consumerName = consumerName;
        this.amount = amount;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
        this.remarks = remarks;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId='" + invoiceId + '\'' +
                ", consumerName='" + consumerName + '\'' +
                ", amount=" + amount +
                ", invoiceDate=" + invoiceDate +
                ", dueDate=" + dueDate +
                ", paymentDate=" + paymentDate +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
