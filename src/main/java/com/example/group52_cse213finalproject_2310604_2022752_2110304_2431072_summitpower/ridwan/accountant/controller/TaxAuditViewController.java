package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.TaxAudit;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

public class TaxAuditViewController
{
    @javafx.fxml.FXML
    private ComboBox <String> yearComboBox;
    @javafx.fxml.FXML
    private TableColumn titleCol;
    @javafx.fxml.FXML
    private Label titleLabel;
    @javafx.fxml.FXML
    private TableView <TaxAudit> taxAndAuditTableView;
    @javafx.fxml.FXML
    private Label createdDateLabel;
    @javafx.fxml.FXML
    private TextField searchTextField;
    @javafx.fxml.FXML
    private Label recordTypeLabel;
    @javafx.fxml.FXML
    private TableColumn recordIDCol;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private ComboBox recordTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn recordTypeCol;
    @javafx.fxml.FXML
    private TableColumn yearCol;
    @javafx.fxml.FXML
    private TableColumn dateCol;
    @javafx.fxml.FXML
    private TableColumn statusCol;
    @javafx.fxml.FXML
    private Label recordIDLabel;

    @javafx.fxml.FXML
    public void initialize() {

        recordTypeComboBox.getItems().addAll(
                "All",
                "Tax Record",
                "Audit Record"
        );

        yearComboBox.getItems().addAll(
                "All",
                "2020",
                "2021",
                "2022",
                "2023",
                "2024"
        );

    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "accountant", "accountant-dashboard-view.fxml","Accountant Dashboard");

    }

    @javafx.fxml.FXML
    public void handleLoadRecordsButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleViewDetailsButton(ActionEvent actionEvent) {
    }
}