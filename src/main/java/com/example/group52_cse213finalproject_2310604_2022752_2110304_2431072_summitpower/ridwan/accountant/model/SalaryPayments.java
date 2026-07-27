package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model;

import java.io.Serializable;
import java.time.LocalDate;

public class SalaryPayments implements Serializable {

    private int paymentID;
    private int employeeID;
    private String employeeName;
    private String department;
    private double salary;
    private String paymentMethod;
    private LocalDate paymentDate;
    private String paymentStatus;
    private String month;

    public SalaryPayments() {
    }

    public SalaryPayments(int paymentID, int employeeID, String employeeName, String department, double salary, String paymentMethod, LocalDate paymentDate, String paymentStatus, String month) {
        this.paymentID = paymentID;
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
        this.month = month;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "SalaryPayments{" +
                "paymentID=" + paymentID +
                ", employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDate=" + paymentDate +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
