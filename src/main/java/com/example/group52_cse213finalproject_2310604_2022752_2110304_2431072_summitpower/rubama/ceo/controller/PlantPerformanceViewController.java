package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.PlantPerformance;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.ceo.PlantPerformanceFileHandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class PlantPerformanceViewController {

    @javafx.fxml.FXML
    private TableColumn<PlantPerformance, String> totalGenerationCol;

    @javafx.fxml.FXML
    private TableColumn<PlantPerformance, LocalDate> startingDateCol;

    @javafx.fxml.FXML
    private TableColumn<PlantPerformance, String> totalPowerLossCol;

    @javafx.fxml.FXML
    private DatePicker startingDateDatePicker;

    @javafx.fxml.FXML
    private TableColumn<PlantPerformance, LocalDate> endingDateCol;

    @javafx.fxml.FXML
    private DatePicker endingDateDatePicker;

    @javafx.fxml.FXML
    private TableView<PlantPerformance> plantPerformanceTableView;

    @javafx.fxml.FXML
    private TableColumn<PlantPerformance, String> performanceStatusCol;

    private ObservableList<PlantPerformance> allPerformances =
            FXCollections.observableArrayList();

    private ObservableList<PlantPerformance> filteredPerformances =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        startingDateCol.setCellValueFactory(
                new PropertyValueFactory<>("startingDate"));

        endingDateCol.setCellValueFactory(
                new PropertyValueFactory<>("endingDate"));

        totalGenerationCol.setCellValueFactory(
                new PropertyValueFactory<>("totalGeneration"));

        totalPowerLossCol.setCellValueFactory(
                new PropertyValueFactory<>("totalPowerLoss"));

        performanceStatusCol.setCellValueFactory(
                new PropertyValueFactory<>("performanceStatus"));

        loadPerformanceData();
    }

    private void loadPerformanceData() {

        allPerformances = PlantPerformanceFileHandler.readAll();

        plantPerformanceTableView.setItems(
                FXCollections.observableArrayList(allPerformances)
        );
    }

    @javafx.fxml.FXML
    public void handleShowPerformance(ActionEvent actionEvent) {

        LocalDate start = startingDateDatePicker.getValue();
        LocalDate end = endingDateDatePicker.getValue();

        if (start == null || end == null) {
            showError("Please select both starting date and ending date.");
            return;
        }

        if (start.isAfter(end)) {
            showError("Starting date cannot be after ending date.");
            return;
        }

        filteredPerformances =
                FXCollections.observableArrayList();

        for (PlantPerformance performance : allPerformances) {

            if (performance.getStartingDate() == null ||
                    performance.getEndingDate() == null) {
                continue;
            }

            boolean startsAfterSelectedDate =
                    !performance.getStartingDate().isBefore(start);

            boolean endsBeforeSelectedDate =
                    !performance.getEndingDate().isAfter(end);

            if (startsAfterSelectedDate && endsBeforeSelectedDate) {
                filteredPerformances.add(performance);
            }
        }

        plantPerformanceTableView.setItems(filteredPerformances);

        if (filteredPerformances.isEmpty()) {
            showInformation(
                    "No plant performance records were found for the selected date range."
            );
        }
    }

    @javafx.fxml.FXML
    public void handleGenerateWeeklyReport(ActionEvent actionEvent) {

        LocalDate start = startingDateDatePicker.getValue();
        LocalDate end = endingDateDatePicker.getValue();

        if (start == null || end == null) {
            showError("Please select both starting date and ending date.");
            return;
        }

        if (start.isAfter(end)) {
            showError("Starting date cannot be after ending date.");
            return;
        }

        if (filteredPerformances.isEmpty()) {

            handleShowPerformance(null);

            if (filteredPerformances.isEmpty()) {
                return;
            }
        }

        plantPerformanceTableView.setItems(filteredPerformances);

        showInformation(
                "Weekly report generated successfully.\n" +
                        "Records displayed: " + filteredPerformances.size()
        );
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

    private void showError(String message) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInformation(String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}