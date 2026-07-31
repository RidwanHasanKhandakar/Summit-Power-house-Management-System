package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class GridOperatorDashboardViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void monitorLoadDemandButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","monitor-load-demand-view.fxml"," Monitor Load Demand");
    }

    @javafx.fxml.FXML
    public void recordGridOperationButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","record-grid-operation-log-view.fxml","Record Grid Operation Log");
    }

    @javafx.fxml.FXML
    public void transmissionLineInfoButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","transmission-line-info-view.fxml","Search Transmission Line Information");
    }

    @javafx.fxml.FXML
    public void respondToGridFaultButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","respond-to-grid-fault-view.fxml","Respond to Grid Fault");
    }

    @javafx.fxml.FXML
    public void loadDistributionButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","load-distribution-view.fxml","Schedule Load Distribution");
    }

    @javafx.fxml.FXML
    public void logoutButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","commonFiles","log-in-view.fxml","Log in");
    }

    @javafx.fxml.FXML
    public void profileButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","commonFiles","profile-view.fxml","Profile");
    }

    @javafx.fxml.FXML
    public void viewGridPerformanceButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","view-grid-performance-report-view.fxml","View Grid Performance Report");
    }

    @javafx.fxml.FXML
    public void synchronizeGridButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","synchronize-gen-w-national-grid-view.fxml","Synchronize Generator with National Grid");
    }

    @javafx.fxml.FXML
    public void monitorGridStatusButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","monitor-grid-status-view.fxml","Monitor Grid Status");
    }
}