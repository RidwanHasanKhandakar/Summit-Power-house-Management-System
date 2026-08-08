package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.WeeklyReport;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.ceo.WeeklyReportFileHandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class WeeklyReportViewController {

    @javafx.fxml.FXML
    private TableColumn<WeeklyReport, String> totalGenerationCol;

    @javafx.fxml.FXML
    private TableView<WeeklyReport> performanceTableView;

    @javafx.fxml.FXML
    private TableColumn<WeeklyReport, LocalDate> startingDateCol;

    @javafx.fxml.FXML
    private TableColumn<WeeklyReport, String> totalPowerLossCol;

    @javafx.fxml.FXML
    private DatePicker startingDateDatePicker;

    @javafx.fxml.FXML
    private TableColumn<WeeklyReport, LocalDate> endingDateCol;

    @javafx.fxml.FXML
    private Label weeklyReportLabel;

    @javafx.fxml.FXML
    private DatePicker endingDateDatePicker;

    @javafx.fxml.FXML
    private TableColumn<WeeklyReport, String> performanceStatusCol;


    @javafx.fxml.FXML
    public void initialize() {

        performanceStatusCol.setCellValueFactory(
                new PropertyValueFactory<>("performanceStatus")
        );

        totalGenerationCol.setCellValueFactory(
                new PropertyValueFactory<>("totalGeneration")
        );

        totalPowerLossCol.setCellValueFactory(
                new PropertyValueFactory<>("totalPowerLoss")
        );

        startingDateCol.setCellValueFactory(
                new PropertyValueFactory<>("startingDate")
        );

        endingDateCol.setCellValueFactory(
                new PropertyValueFactory<>("endingDate")
        );


        // Load saved weekly reports
        loadTable();
    }


    private void loadTable() {

        performanceTableView.setItems(
                WeeklyReportFileHandler.readAll()
        );

        performanceTableView.refresh();
    }


    @javafx.fxml.FXML
    public void handleShowPerformance(ActionEvent actionEvent) {

        LocalDate start = startingDateDatePicker.getValue();
        LocalDate end = endingDateDatePicker.getValue();


        if (start != null && end != null && start.isAfter(end)) {

            showError("Starting date cannot be after ending date.");

            return;
        }


        ObservableList<WeeklyReport> allReports =
                WeeklyReportFileHandler.readAll();

        ObservableList<WeeklyReport> filtered =
                FXCollections.observableArrayList();


        for (WeeklyReport report : allReports) {

            boolean match = true;


            if (start != null &&
                    report.getStartingDate().isBefore(start)) {

                match = false;
            }


            if (end != null &&
                    report.getEndingDate().isAfter(end)) {

                match = false;
            }


            if (match) {
                filtered.add(report);
            }
        }


        performanceTableView.setItems(filtered);

        performanceTableView.refresh();


        if (filtered.isEmpty()) {

            weeklyReportLabel.setText(
                    "Weekly Report: No data found."
            );

        } else {

            weeklyReportLabel.setText(
                    "Weekly Report: " +
                            filtered.size() +
                            " record(s) found."
            );
        }
    }


    @javafx.fxml.FXML
    public void handleGenerateWeeklyReport(ActionEvent actionEvent) {

        ObservableList<WeeklyReport> displayed =
                performanceTableView.getItems();


        if (displayed == null || displayed.isEmpty()) {

            weeklyReportLabel.setText(
                    "Weekly Report: No data."
            );

            return;
        }


        double totalGen = 0;
        double totalLoss = 0;


        for (WeeklyReport report : displayed) {

            totalGen += parseNumber(
                    report.getTotalGeneration()
            );

            totalLoss += parseNumber(
                    report.getTotalPowerLoss()
            );
        }


        double efficiency;

        if (totalGen == 0) {
            efficiency = 0;
        } else {
            efficiency =
                    (totalGen - totalLoss)
                            / totalGen * 100;
        }


        double averageGeneration =
                totalGen / displayed.size();

        double averageLoss =
                totalLoss / displayed.size();


        weeklyReportLabel.setText(
                String.format(
                        "Records: %d | Gen: %.1f | Avg: %.1f | Loss: %.1f | Eff: %.1f%%",
                        displayed.size(),
                        totalGen,
                        averageGeneration,
                        averageLoss,
                        efficiency
                )
        );
    }


    private double parseNumber(String value) {

        if (value == null || value.trim().isEmpty()) {
            return 0;
        }


        String cleaned = value
                .replaceAll("[^0-9.\\-]", "");


        if (cleaned.isEmpty() ||
                cleaned.equals("-") ||
                cleaned.equals(".")) {

            return 0;
        }


        try {

            return Double.parseDouble(cleaned);

        } catch (NumberFormatException e) {

            return 0;
        }
    }


    private void showError(String message) {

        Alert alert =
                new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }


    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene(
                (Node) actionEvent.getSource(),
                "rubama",
                "ceo",
                "ceo-dashboard-view.fxml",
                "CEO Dashboard"
        );
    }
}
