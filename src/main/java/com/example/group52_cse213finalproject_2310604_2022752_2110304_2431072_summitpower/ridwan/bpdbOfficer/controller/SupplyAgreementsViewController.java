package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.SupplyAgreement;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class SupplyAgreementsViewController
{
    @javafx.fxml.FXML
    private TableView <SupplyAgreement> supplyAgreementTableView;
    @javafx.fxml.FXML
    private TableColumn <SupplyAgreement,String> idCol;
    @javafx.fxml.FXML
    private TableColumn <SupplyAgreement, LocalDate> startDateCol;
    @javafx.fxml.FXML
    private TableColumn <SupplyAgreement,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn <SupplyAgreement,String> agreeTypeCol;
    @javafx.fxml.FXML
    private ComboBox <String> filterByStatusComboBox;
    @javafx.fxml.FXML
    private ComboBox <String> filterByAgreementTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn <SupplyAgreement,String> conNameCol;
    @javafx.fxml.FXML
    private TableColumn <SupplyAgreement,Double> capacityCol;
    @javafx.fxml.FXML
    private TableColumn <SupplyAgreement,LocalDate> EndDateCol;
    @javafx.fxml.FXML
    private TextField consumerNameTextField;
    @javafx.fxml.FXML
    private TextField agreementIdTextField;

    @javafx.fxml.FXML
    public void initialize() {

        filterByStatusComboBox.getItems().addAll(
                "All",
                "Active",
                "Pending",
                "Expired",
                "Cancelled");
        filterByAgreementTypeComboBox.getItems().addAll(
                "All"
                ,"Residential",
                "Commercial",
                "Industrial",
                "Government");

        filterByStatusComboBox.setValue("All");
        filterByAgreementTypeComboBox.setValue("All");

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"bpdbOfficer","bpdbOfficer-dashboard-view.fxml", "BPDB Officer Dashboard!");
    }

    @javafx.fxml.FXML
    public void handleSearchButton(ActionEvent actionEvent) {
        String agreementId = agreementIdTextField.getText().trim().toLowerCase();
        String consumerName = consumerNameTextField.getText().trim().toLowerCase();

        String status = filterByStatusComboBox.getValue();
        String type = filterByAgreementTypeComboBox.getValue();
    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {

        agreementIdTextField.clear();
        consumerNameTextField.clear();
        filterByAgreementTypeComboBox.setValue("All");
        filterByStatusComboBox.setValue("All");

    }
}