package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model;

import java.io.Serializable;
import java.time.LocalDate;

public class ManageSparePartsReq implements Serializable {
    private String requestId,partName;
    private int quantity;
    private String supplierName;
    private LocalDate requestDate;
    private String requestStatus;

    public ManageSparePartsReq() {
    }

    public ManageSparePartsReq(String requestId, String partName, int quantity, String supplierName, LocalDate requestDate, String requestStatus) {
        this.requestId = requestId;
        this.partName = partName;
        this.quantity = quantity;
        this.supplierName = supplierName;
        this.requestDate = requestDate;
        this.requestStatus = requestStatus;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    @Override
    public String toString() {
        return "ManageSparePartsReq{" +
                "requestId='" + requestId + '\'' +
                ", partName='" + partName + '\'' +
                ", quantity=" + quantity +
                ", supplierName='" + supplierName + '\'' +
                ", requestDate=" + requestDate +
                ", requestStatus='" + requestStatus + '\'' +
                '}';
    }
}
