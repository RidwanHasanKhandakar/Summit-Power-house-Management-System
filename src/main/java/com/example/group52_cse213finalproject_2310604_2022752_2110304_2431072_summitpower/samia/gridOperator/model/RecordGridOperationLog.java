package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model;

import java.io.Serializable;
import java.time.LocalDate;

public class RecordGridOperationLog implements Serializable {
    private String operationId;
    private String gridId;
    private String gridSection;
    private String operationType;
    private String gridStatus;
    private LocalDate operationDate;
    private double voltage;
    private double frequency;
    private String operatorName;
    private String remarks;

    public RecordGridOperationLog() {
    }

    public RecordGridOperationLog(String operationId, String gridId, String gridSection, String operationType, String gridStatus, LocalDate operationDate, double voltage, double frequency, String operatorName, String remarks) {
        this.operationId = operationId;
        this.gridId = gridId;
        this.gridSection = gridSection;
        this.operationType = operationType;
        this.gridStatus = gridStatus;
        this.operationDate = operationDate;
        this.voltage = voltage;
        this.frequency = frequency;
        this.operatorName = operatorName;
        this.remarks = remarks;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getGridId() {
        return gridId;
    }

    public void setGridId(String gridId) {
        this.gridId = gridId;
    }

    public String getGridSection() {
        return gridSection;
    }

    public void setGridSection(String gridSection) {
        this.gridSection = gridSection;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getGridStatus() {
        return gridStatus;
    }

    public void setGridStatus(String gridStatus) {
        this.gridStatus = gridStatus;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "RecordGridOperationLog{" +
                "operationId='" + operationId + '\'' +
                ", gridId='" + gridId + '\'' +
                ", gridSection='" + gridSection + '\'' +
                ", operationType='" + operationType + '\'' +
                ", gridStatus='" + gridStatus + '\'' +
                ", operationDate=" + operationDate +
                ", voltage=" + voltage +
                ", frequency=" + frequency +
                ", operatorName='" + operatorName + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
