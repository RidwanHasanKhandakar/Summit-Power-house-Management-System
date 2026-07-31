package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model;

import java.io.Serializable;

public class Vendor implements Serializable {
    private String vendorId, vendorName, email, suppliedEquipment;

    public Vendor(String vendorId, String vendorName, String email, String suppliedEquipment) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.email = email;
        this.suppliedEquipment = suppliedEquipment;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSuppliedEquipment() {
        return suppliedEquipment;
    }

    public void setSuppliedEquipment(String suppliedEquipment) {
        this.suppliedEquipment = suppliedEquipment;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vendorId='" + vendorId + '\'' +
                ", vendorName='" + vendorName + '\'' +
                ", email='" + email + '\'' +
                ", suppliedEquipment='" + suppliedEquipment + '\'' +
                '}';
    }
}
