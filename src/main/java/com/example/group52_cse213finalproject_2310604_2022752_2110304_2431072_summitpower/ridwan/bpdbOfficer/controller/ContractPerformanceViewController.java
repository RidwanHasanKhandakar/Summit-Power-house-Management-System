package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.ContractPerformance;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.Locale;

public class ContractPerformanceViewController
{
    @javafx.fxml.FXML
    private TableColumn <ContractPerformance,Double> suppliedCapCol;
    @javafx.fxml.FXML
    private TextField contractIDTextField;
    @javafx.fxml.FXML
    private TextArea viewPerformanceTextArea;
    @javafx.fxml.FXML
    private TextField consumerNameTextField;
    @javafx.fxml.FXML
    private TableColumn <ContractPerformance, LocalDate> startDateCol;
    @javafx.fxml.FXML
    private TableColumn <ContractPerformance,String> statusCol;
    @javafx.fxml.FXML
    private ComboBox <String> statusComboBox;
    @javafx.fxml.FXML
    private TableColumn <ContractPerformance,String> consumerNameCol;
    @javafx.fxml.FXML
    private TableColumn <ContractPerformance,Double> contractedCapCol;
    @javafx.fxml.FXML
    private TableColumn <ContractPerformance,String> contractIDCol;
    @javafx.fxml.FXML
    private TableView <ContractPerformance> contractPerformanceTableView;
    @javafx.fxml.FXML
    private TableColumn <ContractPerformance,LocalDate> EndDateCol;

    @javafx.fxml.FXML
    public void initialize() {

        statusComboBox.getItems().addAll(
                "All",
                "Active",
                "Inactive",
                "Terminated"
        );

        contractIDCol.setCellValueFactory(new PropertyValueFactory<>("contractID"));
        consumerNameCol.setCellValueFactory(new PropertyValueFactory<>("consumerName"));
        contractedCapCol.setCellValueFactory(new PropertyValueFactory<>("contractedCapacity"));
        suppliedCapCol.setCellValueFactory(new PropertyValueFactory<>("suppliedCapacity"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("contractedStartDate"));
        EndDateCol.setCellValueFactory(new PropertyValueFactory<>("contractedEndDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "bpdbOfficer", "bpdbOfficer-dashboard-view","BPDB Officer Dashboard");

    }

    @javafx.fxml.FXML
    public void handleViewPerformanceButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSearchButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {
    }
}