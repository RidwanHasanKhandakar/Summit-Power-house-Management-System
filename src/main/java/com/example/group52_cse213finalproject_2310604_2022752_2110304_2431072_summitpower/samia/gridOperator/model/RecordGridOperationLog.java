package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model;

import java.io.Serializable;
import java.time.LocalDate;

public class RecordGridOperationLog implements Serializable {
    private String operationId,gridSection,operationType;
    private LocalDate operationDate;
    private String operatorName,remarks;

    public RecordGridOperationLog() {
    }

    public RecordGridOperationLog(String operationId, String gridSection, String operationType, LocalDate operationDate, String operatorName, String remarks) {
        this.operationId = operationId;
        this.gridSection = gridSection;
        this.operationType = operationType;
        this.operationDate = operationDate;
        this.operatorName = operatorName;
        this.remarks = remarks;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
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

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
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
                ", gridSection='" + gridSection + '\'' +
                ", operationType='" + operationType + '\'' +
                ", operationDate=" + operationDate +
                ", operatorName='" + operatorName + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
