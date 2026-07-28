package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model;

import java.io.Serializable;
import java.time.LocalDate;

public class TaxAudit implements Serializable {

    private int recordId;
    private String recordType;
    private String title;
    private String year;
    private LocalDate createdDate;
    private String status;
    private String details;

    public  TaxAudit() {
    }

    public TaxAudit(int recordId, String recordType, String title, String year, LocalDate createdDate, String status, String details) {
        this.recordId = recordId;
        this.recordType = recordType;
        this.title = title;
        this.year = year;
        this.createdDate = createdDate;
        this.status = status;
        this.details = details;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "TaxAudit{" +
                "recordId=" + recordId +
                ", recordType='" + recordType + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", createdDate=" + createdDate +
                ", status='" + status + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
