package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;

    private String complaintId;
    private String complaintCategory;
    private String complaintDescription;
    private LocalDate affectedSupplyDate;
    private LocalDate submissionDate;
    private String status;

    public Complaint(String complaintId, String complaintCategory, String complaintDescription, LocalDate affectedSupplyDate, LocalDate submissionDate, String status) {
        this.complaintId = complaintId;
        this.complaintCategory = complaintCategory;
        this.complaintDescription = complaintDescription;
        this.affectedSupplyDate = affectedSupplyDate;
        this.submissionDate = submissionDate;
        this.status = status;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplaintCategory() {
        return complaintCategory;
    }

    public void setComplaintCategory(String complaintCategory) {
        this.complaintCategory = complaintCategory;
    }

    public String getComplaintDescription() {
        return complaintDescription;
    }

    public void setComplaintDescription(String complaintDescription) {
        this.complaintDescription = complaintDescription;
    }

    public LocalDate getAffectedSupplyDate() {
        return affectedSupplyDate;
    }

    public void setAffectedSupplyDate(LocalDate affectedSupplyDate) {
        this.affectedSupplyDate = affectedSupplyDate;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
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
                ", complaintCategory='" + complaintCategory + '\'' +
                ", complaintDescription='" + complaintDescription + '\'' +
                ", affectedSupplyDate=" + affectedSupplyDate +
                ", submissionDate=" + submissionDate +
                ", status='" + status + '\'' +
                '}';
    }
}
