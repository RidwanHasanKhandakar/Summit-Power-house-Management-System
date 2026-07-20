package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SupplyAgreementsViewController
{
    @javafx.fxml.FXML
    private TextField searchAgreementsTextField;
    @javafx.fxml.FXML
    private TableView supplyAgreementTableView;
    @javafx.fxml.FXML
    private TableColumn idCol;
    @javafx.fxml.FXML
    private TableColumn startDateCol;
    @javafx.fxml.FXML
    private TableColumn statusCol;
    @javafx.fxml.FXML
    private TableColumn agreeTypeCol;
    @javafx.fxml.FXML
    private ComboBox <String> filterByStatusComboBox;
    @javafx.fxml.FXML
    private ComboBox <String> filterByAgreementTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn conNameCol;
    @javafx.fxml.FXML
    private TableColumn capacityCol;
    @javafx.fxml.FXML
    private TableColumn EndDateCol;

    @javafx.fxml.FXML
    public void initialize() {

        filterByStatusComboBox.getItems().addAll(
                "All",
                "Active",
                "Pending",
                "Expired",
                "Cancelled");
        filterByAgreementTypeComboBox.getItems().addAll(
                "Residential",
                "Commercial",
                "Industrial",
                "Government",
                "All");

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"bpdbOfficer","bpdbOfficer-dashboard-view.fxml", "BPDB Officer Dashboard!");
    }

    @javafx.fxml.FXML
    public void handleSearchButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {

        searchAgreementsTextField.clear();
        filterByAgreementTypeComboBox.setValue(null);
        filterByStatusComboBox.setValue(null);

    }
}