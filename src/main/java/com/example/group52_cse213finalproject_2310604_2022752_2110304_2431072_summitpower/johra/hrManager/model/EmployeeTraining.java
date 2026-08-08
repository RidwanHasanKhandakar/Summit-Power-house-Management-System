package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model;

import java.io.Serializable;

public class EmployeeTraining implements Serializable {

    private String employeeId, employeeName, trainingId, trainerName, trainingStatus;

    public EmployeeTraining(String employeeId, String employeeName, String trainingId, String trainerName, String trainingStatus) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.trainingId = trainingId;
        this.trainerName = trainerName;
        this.trainingStatus = trainingStatus;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainingStatus() {
        return trainingStatus;
    }

    public void setTrainingStatus(String trainingStatus) {
        this.trainingStatus = trainingStatus;
    }

    @Override
    public String toString() {
        return "EmployeeTraining{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", trainingId='" + trainingId + '\'' +
                ", trainerName='" + trainerName + '\'' +
                ", trainingStatus='" + trainingStatus + '\'' +
                '}';
    }
}
