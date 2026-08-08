package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model;

import java.time.LocalDate;

public abstract class GridOperation {
    protected String operationId;
    protected LocalDate operationDate;
    protected String gridSection;

    public GridOperation(String operationId, LocalDate operationDate, String gridSection) {
        this.operationId = operationId;
        this.operationDate = operationDate;
        this.gridSection = gridSection;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
    }

    public String getGridSection() {
        return gridSection;
    }

    public void setGridSection(String gridSection) {
        this.gridSection = gridSection;
    }
    public abstract String executeOperation();

    @Override
    public String toString() {
        return "GridOperation{" +
                "operationId='" + operationId + '\'' +
                ", operationDate=" + operationDate +
                ", gridSection='" + gridSection + '\'' +
                '}';
    }
}
