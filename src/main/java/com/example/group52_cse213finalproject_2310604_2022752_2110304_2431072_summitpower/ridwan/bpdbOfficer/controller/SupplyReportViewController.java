package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.SupplyReport;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.bpdbOfficer.SupplyReportFileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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

        reportTypeComboBox.setValue("All");

        reportIDCol.setCellValueFactory(new PropertyValueFactory<>("reportID"));
        reportTypeCol.setCellValueFactory(new PropertyValueFactory<>("reportType"));
        reportDateCol.setCellValueFactory(new PropertyValueFactory<>("generatedDate"));
        genPowerCol.setCellValueFactory(new PropertyValueFactory<>("generatedPower"));
        suppliedPowerCol.setCellValueFactory(new PropertyValueFactory<>("suppliedPower"));
        LossCol.setCellValueFactory(new PropertyValueFactory<>("transmissionLoss"));

        loadTable();

    }

    private void loadTable() {
        supplyReportTableView.setItems(SupplyReportFileHandler.readAll());
    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","bpdbOfficer","bpdbOfficer-dashboard-view.fxml","BPDB Officer Dashboard");

    }

    @javafx.fxml.FXML
    public void handleViewSummaryButton(ActionEvent actionEvent) {

        SupplyReport report = supplyReportTableView.getSelectionModel().getSelectedItem();

        if (report==null){
            showError("Please select a report.");
            return;
        }

        viewSummaryTextArea.setText(
                "Report ID : " + report.getReportId() + "\n" +
                        "Type : " + report.getReportType() + "\n" +
                        "Report Date : " + report.getGeneratedDate() + "\n" +
                        "Generated Power : " + report.getGeneratedPower() + " MW\n" +
                        "Supplied Power : " + report.getSuppliedPower() + " MW\n" +
                        "Transmission Loss : " + report.getTransmissionLoss() + " MW\n" +
                        "Remarks : " + report.getRemarks()
        );

    }

    @javafx.fxml.FXML
    public void handleSearchButton(ActionEvent actionEvent) {

        ObservableList<SupplyReport> all = SupplyReportFileHandler.readAll();
        ObservableList<SupplyReport> filtered = FXCollections.observableArrayList();

        String type = reportTypeComboBox.getValue();
        LocalDate date = reportDateDatePicker.getValue();

        for (SupplyReport report : all){
            boolean matcheType = type == null || type.equals("All") || report.getReportType().equalsIgnoreCase(type);
            boolean matchDate = date == null || report.getGeneratedDate().equals(date);
            if (matcheType && matchDate){
                filtered.add(report);
            }
        }

        supplyReportTableView.setItems(filtered);

    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {

        reportTypeComboBox.setValue("All");
        reportDateDatePicker.setValue(null);

        viewSummaryTextArea.clear();

        loadTable();

    }

    public void showError(String txt){

        Alert alert = new Alert((Alert.AlertType.ERROR));
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();

    }

}