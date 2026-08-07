package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model;

import java.time.LocalDate;

public class ComplaintSummary {
    private String status,complaintId,description;
    private LocalDate complaintDate;

    public ComplaintSummary(String status, String complaintId, String description, LocalDate complaintDate) {
        this.status = status;
        this.complaintId = complaintId;
        this.description = description;
        this.complaintDate = complaintDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
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

    @Override
    public String toString() {
        return "ComplaintSummary{" +
                "status='" + status + '\'' +
                ", complaintId='" + complaintId + '\'' +
                ", description='" + description + '\'' +
                ", complaintDate=" + complaintDate +
                '}';
    }
}
