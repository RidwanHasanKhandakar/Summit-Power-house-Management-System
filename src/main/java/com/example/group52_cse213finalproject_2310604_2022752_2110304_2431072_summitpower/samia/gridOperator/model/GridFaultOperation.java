package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model;

import java.time.LocalDate;

public class GridFaultOperation extends GridOperation {

    private String faultType;

    public GridFaultOperation(String operationId,
                              LocalDate operationDate,
                              String gridSection,
                              String faultType) {

        super(operationId, operationDate, gridSection);
        this.faultType = faultType;
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType;
    }

    @Override
    public String executeOperation() {
        return "Grid fault operation executed for "
                + faultType
                + " in "
                + gridSection;
    }

    @Override
    public String toString() {
        return "GridFaultOperation{" +
                "operationId='" + operationId + '\'' +
                ", operationDate=" + operationDate +
                ", gridSection='" + gridSection + '\'' +
                ", faultType='" + faultType + '\'' +
                '}';
    }
}
