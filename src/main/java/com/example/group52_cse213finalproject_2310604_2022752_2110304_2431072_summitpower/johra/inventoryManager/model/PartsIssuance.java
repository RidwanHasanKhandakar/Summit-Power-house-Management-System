package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class PartsIssuance implements Serializable {
    private String employeeId, quantity, equipmentId;
    private LocalDate issueDate;

    public PartsIssuance(String employeeId, String quantity, String equipmentId, LocalDate issueDate) {
        this.employeeId = employeeId;
        this.quantity = quantity;
        this.equipmentId = equipmentId;
        this.issueDate = issueDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "PartsIssuance{" +
                "employeeId='" + employeeId + '\'' +
                ", quantity='" + quantity + '\'' +
                ", equipmentId='" + equipmentId + '\'' +
                ", issueDate=" + issueDate +
                '}';
    }
}
