package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class PlantManagerDashboardViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleGenerationUnits(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","plant_manager","unit-control-view.fxml","Unit Control");
    }

    @javafx.fxml.FXML
    public void handleRequestFuel(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","plant_manager","fuel-request-view.fxml","Fuel Request");
    }

    @javafx.fxml.FXML
    public void handleFuelLevelHistory(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","plant_manager","fuel-stock-view.fxml","Fuel Stock");
    }

    @javafx.fxml.FXML
    public void handleShiftReport(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","plant_manager","shift-report-view.fxml","Shift Report");
    }

    @javafx.fxml.FXML
    public void handleLogBreakdown(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","plant_manager","breakdown-report-view.fxml","Breakdown Report");
    }

    @javafx.fxml.FXML
    public void handleMaintenanceHistory(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","plant_manager","maintenance-history-view.fxml","Maintenance History");
    }

    @javafx.fxml.FXML
    public void handleMaintenanceSchedule(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","plant_manager","maintenance-schedule-view.fxml","Maintenance Schedule");
    }

    @javafx.fxml.FXML
    public void handlePowerGenerationHistory(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","plant_manager","power-generation-view.fxml","Power Generation");
    }

    @javafx.fxml.FXML
    public void handleLogOut(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","commonFiles","log-in-view.fxml","Log in!1");
    }
}