package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.CurrentUser;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;

import java.util.Optional;

public class EngineerDashboardViewController
{

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void manageSparePartsReqButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","manage-spare-parts-req-view.fxml","Manage spare parts requirements");
    }

    @javafx.fxml.FXML
    public void monitorFuelConsumptionButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","monitor-fuel-consumption-view.fxml","Monitor fuel consumption");
    }

    @javafx.fxml.FXML
    public void equipmentEfficiencyButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","equipment-efficiency-view.fxml","Analyze equipment efficiency");
    }

    @javafx.fxml.FXML
    public void monitorGeneratorStatusButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","monitor-generator-status-view.fxml","Monitor Generator Status");
    }

    @javafx.fxml.FXML
    public void preventiveMaintenanceButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","preventive-maintenance-view.fxml","Schedule Preventive Maintenance");
    }

    @javafx.fxml.FXML
    public void updateMaintenanceStatusButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","update-maintenance-status-view.fxml","Update Maintenance Status");
    }

    @javafx.fxml.FXML
    public void logoutButton(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout!");
        alert.setHeaderText("Confirm Logout!");
        alert.setContentText("Are you sure you want to logout >?");
        Optional<ButtonType> res = alert.showAndWait();
        if (res.isPresent()&&res.get()==ButtonType.OK){
            CurrentUser.logout();
            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","commonFiles", "log-in-view.fxml","Log in!");
        }
    }

    @javafx.fxml.FXML
    public void profileButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","commonFiles","profile-view.fxml","Profile");
    }

    @javafx.fxml.FXML
    public void reportEquipmentFaultsButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","report-equipment-faults-view.fxml","Report equipment faults");
    }

    @javafx.fxml.FXML
    public void engineeringPerformanceButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","engineering-performance-view.fxml","Generate engineering performance reports");
    }

    @javafx.fxml.FXML
    public void maintenancePerformanceReportButton(ActionEvent actionEvent) {
    }
}