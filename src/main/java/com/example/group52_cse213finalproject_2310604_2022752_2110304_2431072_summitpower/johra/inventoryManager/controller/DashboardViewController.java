package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.CurrentUser;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.User;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class DashboardViewController
{
    @javafx.fxml.FXML
    private Label inventoryManagerOfficerNameLabel;
    @javafx.fxml.FXML
    private Label officerNameLabel;
    @javafx.fxml.FXML
    private Label addNameLabel;

    @javafx.fxml.FXML
    public void initialize() {

        User user = CurrentUser.getUser();

        if (user!=null){
            inventoryManagerOfficerNameLabel.setText(CurrentUser.getUser().getFirstName()+" "+CurrentUser.getUser().getLastName());
        }
    }

    @javafx.fxml.FXML
    public void viewInventoryReportButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "viewInventoryReport-view.fxml", "View Inventory Report");

    }

    @javafx.fxml.FXML
    public void vendorManagementButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "vendorManagement-view.fxml", "Vendor Management");

    }

    @javafx.fxml.FXML
    public void addEquipmentButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "addEquipment-view.fxml", "Add Equipment");
    }

    @javafx.fxml.FXML
    public void logoutButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "commonFiles", "log-in-view.fxml", "Login");

    }

    @javafx.fxml.FXML
    public void partsIssuanceButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "partsIssuance-view.fxml", "Parts Issuance");

    }

    @javafx.fxml.FXML
    public void offerTenderButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "offerTender-view.fxml", "Offer Tender");
    }

    @javafx.fxml.FXML
    public void inventoryReportButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "inventoryReport-view.fxml", "Inventory Report");

    }

    @javafx.fxml.FXML
    public void ProfileButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "commonFiles", "profile-view.fxml", "Profile");
    }

    @javafx.fxml.FXML
    public void equipmentMaintenanceHistoryButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "equipmentMaintenanceHistory-view.fxml", "Profile");
    }

    @javafx.fxml.FXML
    public void fuelConsumptionButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "fuelConsumptionTracking-view.fxml", "Fuel Consumption");
    }
}