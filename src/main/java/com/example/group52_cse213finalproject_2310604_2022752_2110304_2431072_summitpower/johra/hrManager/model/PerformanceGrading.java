package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model;

import java.io.Serializable;

public class PerformanceGrading implements Serializable {
    private String employeeId, evaluationStartMonth, evaluationEndMonth, evaluationYear, attendanceScore, teamworkScore, efficiencyScore, finalRating;

    public PerformanceGrading(String employeeId, String evaluationStartMonth, String evaluationEndMonth, String evaluationYear, String attendanceScore, String teamworkScore, String efficiencyScore, String finalRating) {
        this.employeeId = employeeId;
        this.evaluationStartMonth = evaluationStartMonth;
        this.evaluationEndMonth = evaluationEndMonth;
        this.evaluationYear = evaluationYear;
        this.attendanceScore = attendanceScore;
        this.teamworkScore = teamworkScore;
        this.efficiencyScore = efficiencyScore;
        this.finalRating = finalRating;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEvaluationStartMonth() {
        return evaluationStartMonth;
    }

    public void setEvaluationStartMonth(String evaluationStartMonth) {
        this.evaluationStartMonth = evaluationStartMonth;
    }

    public String getEvaluationEndMonth() {
        return evaluationEndMonth;
    }

    public void setEvaluationEndMonth(String evaluationEndMonth) {
        this.evaluationEndMonth = evaluationEndMonth;
    }

    public String getEvaluationYear() {
        return evaluationYear;
    }

    public void setEvaluationYear(String evaluationYear) {
        this.evaluationYear = evaluationYear;
    }

    public String getAttendanceScore() {
        return attendanceScore;
    }

    public void setAttendanceScore(String attendanceScore) {
        this.attendanceScore = attendanceScore;
    }

    public String getTeamworkScore() {
        return teamworkScore;
    }

    public void setTeamworkScore(String teamworkScore) {
        this.teamworkScore = teamworkScore;
    }

    public String getEfficiencyScore() {
        return efficiencyScore;
    }

    public void setEfficiencyScore(String efficiencyScore) {
        this.efficiencyScore = efficiencyScore;
    }

    public String getFinalRating() {
        return finalRating;
    }

    public void setFinalRating(String finalRating) {
        this.finalRating = finalRating;
    }

    @Override
    public String toString() {
        return "PerformanceGrading{" +
                "employeeId='" + employeeId + '\'' +
                ", evaluationStartMonth='" + evaluationStartMonth + '\'' +
                ", evaluationEndMonth='" + evaluationEndMonth + '\'' +
                ", evaluationYear='" + evaluationYear + '\'' +
                ", attendanceScore='" + attendanceScore + '\'' +
                ", teamworkScore='" + teamworkScore + '\'' +
                ", efficiencyScore='" + efficiencyScore + '\'' +
                ", finalRating='" + finalRating + '\'' +
                '}';
    }
}
