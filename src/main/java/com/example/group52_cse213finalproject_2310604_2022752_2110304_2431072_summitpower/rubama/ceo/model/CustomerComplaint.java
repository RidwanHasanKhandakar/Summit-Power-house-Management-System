package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model;

import java.io.Serializable;
import java.time.LocalDate;

public class CustomerComplaint implements Serializable {
    private String complaintId,status,category;
    private LocalDate dateOfComplaint;

    public CustomerComplaint(String complaintId, String status, String category, LocalDate dateOfComplaint) {
        this.complaintId = complaintId;
        this.status = status;
        this.category = category;
        this.dateOfComplaint = dateOfComplaint;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDateOfComplaint() {
        return dateOfComplaint;
    }

    public void setDateOfComplaint(LocalDate dateOfComplaint) {
        this.dateOfComplaint = dateOfComplaint;
    }

    @Override
    public String toString() {
        return "CustomerComplaint{" +
                "complaintId='" + complaintId + '\'' +
                ", status='" + status + '\'' +
                ", category='" + category + '\'' +
                ", dateOfComplaint=" + dateOfComplaint +
                '}';
    }
}
