package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Notice implements Serializable {
    private String noticeId, subject, content, createdBy;
    private LocalDate publishDate, expiryDate;

    public Notice(String noticeId, String subject, String content, String createdBy, LocalDate publishDate, LocalDate expiryDate) {
        this.noticeId = noticeId;
        this.subject = subject;
        this.content = content;
        this.createdBy = createdBy;
        this.publishDate = publishDate;
        this.expiryDate = expiryDate;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId='" + noticeId + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", publishDate=" + publishDate +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
