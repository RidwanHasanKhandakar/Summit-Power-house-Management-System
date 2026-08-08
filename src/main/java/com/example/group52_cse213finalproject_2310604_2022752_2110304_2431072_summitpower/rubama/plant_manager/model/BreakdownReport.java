package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class BreakdownReport implements Serializable {

    private static final long serialVersionUID = 1L;

    private String unitName;
    private String unitNo;
    private String status;
    private LocalDate date;

    public BreakdownReport(String unitName, String unitNo, String status, LocalDate date) {
        this.unitName = unitName;
        this.unitNo = unitNo;
        this.status = status;
        this.date = date;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BreakdownReport{" +
                "unitName='" + unitName + '\'' +
                ", unitNo='" + unitNo + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }


}
