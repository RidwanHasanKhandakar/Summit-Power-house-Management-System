package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model;

import java.time.LocalDate;

public class Complaint {

    private String complaintId;
    private String category;
    private String description;
    private LocalDate complaintDate;
    private String status;

    public Complaint(String complaintId, String category, String description, LocalDate complaintDate, String status) {
        this.complaintId = complaintId;
        this.category = category;
        this.description = description;
        this.complaintDate = complaintDate;
        this.status = status;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(LocalDate complaintDate) {
        this.complaintDate = complaintDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintId='" + complaintId + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", complaintDate=" + complaintDate +
                ", status='" + status + '\'' +
                '}';
    }
}
