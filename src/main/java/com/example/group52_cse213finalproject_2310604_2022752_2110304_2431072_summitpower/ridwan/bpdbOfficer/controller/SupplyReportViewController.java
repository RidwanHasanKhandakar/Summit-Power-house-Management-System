package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.SupplyReport;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.Locale;

public class SupplyReportViewController
{
    @javafx.fxml.FXML
    private TableColumn <SupplyReport, String> reportIDCol;
    @javafx.fxml.FXML
    private TableColumn <SupplyReport,Double> genPowerCol;
    @javafx.fxml.FXML
    private TableColumn <SupplyReport,Double> LossCol;
    @javafx.fxml.FXML
    private TableView <SupplyReport> supplyReportTableView;
    @javafx.fxml.FXML
    private TableColumn <SupplyReport,String> reportTypeCol;
    @javafx.fxml.FXML
    private TableColumn <SupplyReport, LocalDate> reportDateCol;
    @javafx.fxml.FXML
    private TextArea viewSummaryTextArea;
    @javafx.fxml.FXML
    private ComboBox <String> reportTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn <SupplyReport,Double> suppliedPowerCol;
    @javafx.fxml.FXML
    private DatePicker reportDateDatePicker;

    @javafx.fxml.FXML
    public void initialize() {

        reportTypeComboBox.getItems().addAll(
                "All",
                "Daily",
                "Weekly",
                "Monthly",
                "Quarterly",
                "Yearly"
        );

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","bpdbOfficer","bpdbOfficer-dashboard-view","BPDB Officer Dashboard");

    }

    @javafx.fxml.FXML
    public void handleViewSummaryButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSearchButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {
    }
}