package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model;

import java.time.LocalDate;

public class Notice {
    private LocalDate publishDate;
    private String subject, content;

    public Notice(LocalDate publishDate, String subject, String content) {
        this.publishDate = publishDate;
        this.subject = subject;
        this.content = content;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
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

    @Override
    public String toString() {
        return "Notice{" +
                "publishDate=" + publishDate +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
