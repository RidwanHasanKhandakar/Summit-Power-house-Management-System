package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.WeeklyReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class WeeklyReportViewController
{
    @javafx.fxml.FXML
    private TableColumn <WeeklyReport,String> totalGenerationCol;
    @javafx.fxml.FXML
    private TableView <WeeklyReport> performanceTableView;
    @javafx.fxml.FXML
    private TableColumn <WeeklyReport,LocalDate> startingDateCol;
    @javafx.fxml.FXML
    private TableColumn <WeeklyReport,String> totalPowerLossCol;
    @javafx.fxml.FXML
    private DatePicker startingDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn <WeeklyReport,LocalDate> endingDateCol;
    @javafx.fxml.FXML
    private Label weeklyReportLabel;
    @javafx.fxml.FXML
    private DatePicker endingDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn <WeeklyReport,String> performanceStatusCol;

    private ArrayList<WeeklyReport> allReports = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
    performanceStatusCol.setCellValueFactory(new PropertyValueFactory<>("performanceStatus"));
    totalGenerationCol.setCellValueFactory(new PropertyValueFactory<>("totalGeneration"));
    totalPowerLossCol.setCellValueFactory(new PropertyValueFactory<>("totalPowerLoss"));
    startingDateCol.setCellValueFactory(new PropertyValueFactory<>("startingDate"));
    endingDateCol.setCellValueFactory(new PropertyValueFactory<>("endingDate"));
    }

    @javafx.fxml.FXML
    public void handleShowPerformance(ActionEvent actionEvent) {
        LocalDate start = startingDateDatePicker.getValue();
        LocalDate end = endingDateDatePicker.getValue();

        ArrayList<WeeklyReport> filtered = new ArrayList<>();
        for (WeeklyReport r : allReports) {
            boolean match = true;
            if (start != null && r.getStartingDate().isBefore(start)) match = false;
            if (end != null && r.getEndingDate().isAfter(end)) match = false;
            if (match) filtered.add(r);
        }
        performanceTableView.getItems().setAll(FXCollections.observableArrayList(filtered));
    }

    @javafx.fxml.FXML
    public void handleGenerateWeeklyReport(ActionEvent actionEvent) {
        ObservableList<WeeklyReport> displayed = performanceTableView.getItems();
        if (displayed.isEmpty()) {
            weeklyReportLabel.setText("No data.");
            return;
        }
        double totalGen = 0, totalLoss = 0;
        for (WeeklyReport r : displayed) {
            totalGen += Double.parseDouble(r.getTotalGeneration().replaceAll("\\D", ""));
            totalLoss += Double.parseDouble(r.getTotalPowerLoss().replaceAll("\\D", ""));
        }
        double eff = totalGen == 0 ? 0 : (totalGen - totalLoss) / totalGen * 100;
        weeklyReportLabel.setText(String.format("Records: %d | Gen: %.1f | Avg: %.1f | Loss: %.1f | Eff: %.1f%%",
                displayed.size(), totalGen, totalGen/displayed.size(), totalLoss/displayed.size(), eff));
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","ceo-dashboard-view.fxml","CEO Dashboard");
    }
}