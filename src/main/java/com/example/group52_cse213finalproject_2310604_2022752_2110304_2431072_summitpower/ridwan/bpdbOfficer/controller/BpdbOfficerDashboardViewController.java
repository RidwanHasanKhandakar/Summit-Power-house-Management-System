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
    }

    @javafx.fxml.FXML
    public void handleAdditionalPowerButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleMonitorPowerSupplyButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSubmitPowerDemandButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleInvoiceButton(ActionEvent actionEvent) {
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
    }

    @javafx.fxml.FXML
    public void handleGenerateSupplyReportButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSubmitComplaintButton(ActionEvent actionEvent) {
    }
}