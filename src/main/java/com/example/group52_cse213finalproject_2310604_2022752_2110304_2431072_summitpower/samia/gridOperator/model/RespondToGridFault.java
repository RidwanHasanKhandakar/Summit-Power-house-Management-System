package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model;

import java.io.Serializable;
import java.time.LocalDate;

public class RespondToGridFault implements Serializable {

    private String faultId,gridSection,faultType;
    private LocalDate faultDate;
    private String responseAction,faultStatus;

    public RespondToGridFault() {
    }

    public RespondToGridFault(String faultId, String gridSection, String faultType, LocalDate faultDate, String responseAction, String faultStatus) {
        this.faultId = faultId;
        this.gridSection = gridSection;
        this.faultType = faultType;
        this.faultDate = faultDate;
        this.responseAction = responseAction;
        this.faultStatus = faultStatus;
    }

    public String getFaultId() {
        return faultId;
    }

    public void setFaultId(String faultId) {
        this.faultId = faultId;
    }

    public String getGridSection() {
        return gridSection;
    }

    public void setGridSection(String gridSection) {
        this.gridSection = gridSection;
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType;
    }

    public LocalDate getFaultDate() {
        return faultDate;
    }

    public void setFaultDate(LocalDate faultDate) {
        this.faultDate = faultDate;
    }

    public String getResponseAction() {
        return responseAction;
    }

    public void setResponseAction(String responseAction) {
        this.responseAction = responseAction;
    }

    public String getFaultStatus() {
        return faultStatus;
    }

    public void setFaultStatus(String faultStatus) {
        this.faultStatus = faultStatus;
    }

    @Override
    public String toString() {
        return "RespondToGridFault{" +
                "faultId='" + faultId + '\'' +
                ", gridSection='" + gridSection + '\'' +
                ", faultType='" + faultType + '\'' +
                ", faultDate=" + faultDate +
                ", responseAction='" + responseAction + '\'' +
                ", faultStatus='" + faultStatus + '\'' +
                '}';
    }
}
