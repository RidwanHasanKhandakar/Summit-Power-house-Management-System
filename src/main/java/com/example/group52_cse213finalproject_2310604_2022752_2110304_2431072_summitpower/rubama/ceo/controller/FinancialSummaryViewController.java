package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.FinancialSummary;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.ceo.FinancialSummaryFileHandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class FinancialSummaryViewController {

    @FXML
    private TableView<FinancialSummary> financialSummaryTableView;

    @FXML
    private DatePicker fromDatePicker;

    @FXML
    private TableColumn<FinancialSummary, Integer> operationalCostCol;

    @FXML
    private DatePicker toDatePicker;

    @FXML
    private TableColumn<FinancialSummary, Integer> fuelCostCol;

    @FXML
    private TableColumn<FinancialSummary, String> revenueCol;

    @FXML
    private TableColumn<FinancialSummary, LocalDate> toDateCol;

    @FXML
    private TableColumn<FinancialSummary, LocalDate> fromDateCol;


    @FXML
    public void initialize() {

        fromDateCol.setCellValueFactory(
                new PropertyValueFactory<>("fromDate")
        );

        toDateCol.setCellValueFactory(
                new PropertyValueFactory<>("toDate")
        );

        revenueCol.setCellValueFactory(
                new PropertyValueFactory<>("revenue")
        );

        operationalCostCol.setCellValueFactory(
                new PropertyValueFactory<>("operationalCost")
        );

        fuelCostCol.setCellValueFactory(
                new PropertyValueFactory<>("fuelCost")
        );


        /*
         * Load all saved financial summaries
         * when the page opens.
         */
        loadAllFinancialSummaries();
    }


    private void loadAllFinancialSummaries() {

        ObservableList<FinancialSummary> summaries =
                FinancialSummaryFileHandler.readAll();

        financialSummaryTableView.setItems(
                summaries
        );

        financialSummaryTableView.refresh();
    }


    @FXML
    public void handleLoadFinancialSummary(
            ActionEvent actionEvent) {

        LocalDate from =
                fromDatePicker.getValue();

        LocalDate to =
                toDatePicker.getValue();


        /*
         * At least one date should be selected.
         */
        if (from == null && to == null) {

            showError(
                    "Please select at least one date."
            );

            return;
        }


        /*
         * Validate the date range.
         */
        if (from != null &&
                to != null &&
                from.isAfter(to)) {

            showError(
                    "From date cannot be after To date."
            );

            return;
        }


        ObservableList<FinancialSummary> allSummaries =
                FinancialSummaryFileHandler.readAll();

        ObservableList<FinancialSummary> filtered =
                FXCollections.observableArrayList();


        /*
         * Filter financial summaries.
         */
        for (FinancialSummary financialSummary :
                allSummaries) {

            LocalDate summaryFrom =
                    financialSummary.getFromDate();

            LocalDate summaryTo =
                    financialSummary.getToDate();


            if (summaryFrom == null ||
                    summaryTo == null) {

                continue;
            }


            boolean matches = true;


            /*
             * If From date is selected,
             * summary must not end before From.
             */
            if (from != null &&
                    summaryTo.isBefore(from)) {

                matches = false;
            }


            /*
             * If To date is selected,
             * summary must not start after To.
             */
            if (to != null &&
                    summaryFrom.isAfter(to)) {

                matches = false;
            }


            if (matches) {

                filtered.add(
                        financialSummary
                );
            }
        }


        financialSummaryTableView.setItems(
                filtered
        );

        financialSummaryTableView.refresh();


        if (filtered.isEmpty()) {

            showInformation(
                    "No financial summary found " +
                            "for the selected date range."
            );
        }
    }


    @FXML
    public void handleReturn(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene(
                (Node) actionEvent.getSource(),
                "rubama",
                "ceo",
                "ceo-dashboard-view.fxml",
                "CEO Dashboard"
        );
    }


    private void showError(String message) {

        Alert alert =
                new Alert(
                        Alert.AlertType.ERROR
                );

        alert.setTitle("Error");

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();
    }


    private void showInformation(String message) {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setTitle("Financial Summary");

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();
    }
}
