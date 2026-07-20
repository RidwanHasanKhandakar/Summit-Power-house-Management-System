package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;

import java.util.Optional;

public class BpdbOfficerDashboardViewController
{
    @javafx.fxml.FXML
    private Text officerNameText;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSupplyAgreementButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"bpdbOfficer","Supply-Agreements-view.fxml", "Supply Agreements!");
    }

    @javafx.fxml.FXML
    public void handleAdditionalPowerButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"bpdbOfficer","Additional-Power-Request-view.fxml", "Additional Power Request!");
    }

    @javafx.fxml.FXML
    public void handleMonitorPowerSupplyButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"bpdbOfficer","Power-Supply-Monitoring-view.fxml", "Power Supply Monitoring!");
    }

    @javafx.fxml.FXML
    public void handleSubmitPowerDemandButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"bpdbOfficer","Power-Demand-Request-view.fxml", "Power Demand Request!");
    }

    @javafx.fxml.FXML
    public void handleInvoiceButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"bpdbOfficer","Invoices-view.fxml", "Invoices!");
    }

    @javafx.fxml.FXML
    public void handleLogoutButton(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout!");
        alert.setHeaderText("Confirm Logout!");
        alert.setContentText("Are you sure you want to logout >?");
        Optional<ButtonType> res = alert.showAndWait();
        if (res.get()==ButtonType.OK){
            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"commonFiles","log-in-view.fxml", "Log in!");
        }
    }

    @javafx.fxml.FXML
    public void handleProfileButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleReviewContractPerformanceButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"bpdbOfficer","Contract-Performance-view.fxml", "Contract Performance!");
    }

    @javafx.fxml.FXML
    public void handleGenerateSupplyReportButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"bpdbOfficer","Supply-Report-view.fxml", "Supply Report!");
    }

    @javafx.fxml.FXML
    public void handleSubmitComplaintButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"bpdbOfficer","Complaint-Submission-view.fxml", "Complaint Submission!");
    }
}