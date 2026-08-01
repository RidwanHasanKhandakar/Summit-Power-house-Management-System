package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model;

import java.io.Serializable;

public class Candidate implements Serializable {
    private String candidateId, candidateName, appliedPosition, qualification, experience, interviewScore, email;
    private Boolean isSelectedCandidate, isNotSelectCandidate, isPendingCandidate;

    public Candidate(String candidateId, String candidateName, String appliedPosition, String qualification, String experience, String interviewScore, String email, Boolean isSelectedCandidate, Boolean isNotSelectCandidate, Boolean isPendingCandidate) {
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.appliedPosition = appliedPosition;
        this.qualification = qualification;
        this.experience = experience;
        this.interviewScore = interviewScore;
        this.email = email;
        this.isSelectedCandidate = isSelectedCandidate;
        this.isNotSelectCandidate = isNotSelectCandidate;
        this.isPendingCandidate = isPendingCandidate;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getAppliedPosition() {
        return appliedPosition;
    }

    public void setAppliedPosition(String appliedPosition) {
        this.appliedPosition = appliedPosition;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getInterviewScore() {
        return interviewScore;
    }

    public void setInterviewScore(String interviewScore) {
        this.interviewScore = interviewScore;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSelectedCandidate() {
        return isSelectedCandidate;
    }

    public void setSelectedCandidate(Boolean selectedCandidate) {
        isSelectedCandidate = selectedCandidate;
    }

    public Boolean getNotSelectCandidate() {
        return isNotSelectCandidate;
    }

    public void setNotSelectCandidate(Boolean notSelectCandidate) {
        isNotSelectCandidate = notSelectCandidate;
    }

    public Boolean getPendingCandidate() {
        return isPendingCandidate;
    }

    public void setPendingCandidate(Boolean pendingCandidate) {
        isPendingCandidate = pendingCandidate;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateId='" + candidateId + '\'' +
                ", candidateName='" + candidateName + '\'' +
                ", appliedPosition='" + appliedPosition + '\'' +
                ", qualification='" + qualification + '\'' +
                ", experience='" + experience + '\'' +
                ", interviewScore='" + interviewScore + '\'' +
                ", email='" + email + '\'' +
                ", isSelectedCandidate=" + isSelectedCandidate +
                ", isNotSelectCandidate=" + isNotSelectCandidate +
                ", isPendingCandidate=" + isPendingCandidate +
                '}';
    }
}
