package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.PurchaseRequest;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

public class PurchaseRequestViewController
{
    @javafx.fxml.FXML
    private Label estCostLabel;
    @javafx.fxml.FXML
    private TableColumn departmentCol;
    @javafx.fxml.FXML
    private TableColumn requestDateCol;
    @javafx.fxml.FXML
    private TableColumn requestByCol;
    @javafx.fxml.FXML
    private ComboBox <String> departmentComboBox;
    @javafx.fxml.FXML
    private TableColumn costCol;
    @javafx.fxml.FXML
    private Label departmentLabel;
    @javafx.fxml.FXML
    private TableView <PurchaseRequest> purchaseAppTableView;
    @javafx.fxml.FXML
    private TableColumn reqIDCol;
    @javafx.fxml.FXML
    private TableColumn statusCol;
    @javafx.fxml.FXML
    private ComboBox <String> statusComboBox;
    @javafx.fxml.FXML
    private Label requestByLabel;
    @javafx.fxml.FXML
    private Label requestIDLabel;
    @javafx.fxml.FXML
    private TextField minimumAmountTextField;

    @javafx.fxml.FXML
    public void initialize() {

        departmentComboBox.getItems().addAll(
                "All",
                "Operations",
                "Customer Service",
                "Engineering",
                "Grid Management",
                "Human Resources",
                "Inventory Management",
                "plant Management"
        );

        statusComboBox.getItems().addAll(
                "All",
                "Pending",
                "Approved",
                "Rejected"
        );

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "accountant", "accountant-dashboard-view.fxml","Accountant Dashboard");

    }

    @javafx.fxml.FXML
    public void handleRejectButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleLoadRequestButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleApproveButton(ActionEvent actionEvent) {
    }
}