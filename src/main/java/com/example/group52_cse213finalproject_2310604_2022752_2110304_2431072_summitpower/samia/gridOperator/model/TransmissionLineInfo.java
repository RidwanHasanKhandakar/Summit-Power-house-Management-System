package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model;

import java.io.Serializable;

public class TransmissionLineInfo implements Serializable {
    private String lineId,lineName,sourceStation,destinationStation;
    private double voltageLevel,lineLength;
    private String lineStatus;

    public TransmissionLineInfo() {
    }

    public TransmissionLineInfo(String lineId, String lineName, String sourceStation, String destinationStation, double voltageLevel, double lineLength, String lineStatus) {
        this.lineId = lineId;
        this.lineName = lineName;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.voltageLevel = voltageLevel;
        this.lineLength = lineLength;
        this.lineStatus = lineStatus;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(String sourceStation) {
        this.sourceStation = sourceStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public double getVoltageLevel() {
        return voltageLevel;
    }

    public void setVoltageLevel(double voltageLevel) {
        this.voltageLevel = voltageLevel;
    }

    public double getLineLength() {
        return lineLength;
    }

    public void setLineLength(double lineLength) {
        this.lineLength = lineLength;
    }

    public String getLineStatus() {
        return lineStatus;
    }

    public void setLineStatus(String lineStatus) {
        this.lineStatus = lineStatus;
    }

    @Override
    public String toString() {
        return "TransmissionLineInfo{" +
                "lineId='" + lineId + '\'' +
                ", lineName='" + lineName + '\'' +
                ", sourceStation='" + sourceStation + '\'' +
                ", destinationStation='" + destinationStation + '\'' +
                ", voltageLevel=" + voltageLevel +
                ", lineLength=" + lineLength +
                ", lineStatus='" + lineStatus + '\'' +
                '}';
    }
}
