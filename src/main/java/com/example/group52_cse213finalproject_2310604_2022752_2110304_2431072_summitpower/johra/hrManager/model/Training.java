package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model;

public class Training {

    private String employeeId, employeeName, trainingName, trainerName;
    private Boolean trainingStatusDone, trainingStatusNotDone;

    public Training(String employeeId, String employeeName, String trainingName, String trainerName, Boolean trainingStatusDone, Boolean trainingStatusNotDone) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.trainingName = trainingName;
        this.trainerName = trainerName;
        this.trainingStatusDone = trainingStatusDone;
        this.trainingStatusNotDone = trainingStatusNotDone;
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

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public Boolean getTrainingStatusDone() {
        return trainingStatusDone;
    }

    public void setTrainingStatusDone(Boolean trainingStatusDone) {
        this.trainingStatusDone = trainingStatusDone;
    }

    public Boolean getTrainingStatusNotDone() {
        return trainingStatusNotDone;
    }

    public void setTrainingStatusNotDone(Boolean trainingStatusNotDone) {
        this.trainingStatusNotDone = trainingStatusNotDone;
    }

    @Override
    public String toString() {
        return "Training{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", trainingName='" + trainingName + '\'' +
                ", trainerName='" + trainerName + '\'' +
                ", trainingStatusDone=" + trainingStatusDone +
                ", trainingStatusNotDone=" + trainingStatusNotDone +
                '}';
    }
}
