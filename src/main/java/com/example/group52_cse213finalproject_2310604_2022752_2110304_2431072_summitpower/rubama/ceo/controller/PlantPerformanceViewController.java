package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.PlantPerformance;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlantPerformanceViewController
{
    @javafx.fxml.FXML
    private TableColumn <PlantPerformance,String> totalGenerationCol;
    @javafx.fxml.FXML
    private TableColumn <PlantPerformance, LocalDate> startingDateCol;
    @javafx.fxml.FXML
    private TableColumn <PlantPerformance,String> totalPowerLossCol;
    @javafx.fxml.FXML
    private DatePicker startingDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn <PlantPerformance, LocalDate> endingDateCol;
    @javafx.fxml.FXML
    private DatePicker endingDateDatePicker;
    @javafx.fxml.FXML
    private TableView <PlantPerformance> plantPerformanceTableView;
    @javafx.fxml.FXML
    private TableColumn <PlantPerformance,String> performanceStatusCol;
    @javafx.fxml.FXML
    private Label effieciencyLabel;

    private ArrayList<PlantPerformance> allPerformances = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        totalGenerationCol.setCellValueFactory(new PropertyValueFactory<>("totalGeneration"));
        totalPowerLossCol.setCellValueFactory(new PropertyValueFactory<>("totalPowerLoss"));
        performanceStatusCol.setCellValueFactory(new PropertyValueFactory<>("performanceStatus"));
        startingDateCol.setCellValueFactory(new PropertyValueFactory<>("startingDate"));
        endingDateCol.setCellValueFactory(new PropertyValueFactory<>("endingDate"));
    }

    @javafx.fxml.FXML
    public void handleShowPerformance(ActionEvent actionEvent) {
        LocalDate start = startingDateDatePicker.getValue();
        LocalDate end = endingDateDatePicker.getValue();

        ArrayList<PlantPerformance> filtered = new ArrayList<>();
        for (PlantPerformance p : allPerformances) {
            if (start != null && p.getStartingDate().isBefore(start)) continue;
            if (end != null && p.getEndingDate().isAfter(end)) continue;
            filtered.add(p);
        }
        plantPerformanceTableView.getItems().setAll(FXCollections.observableArrayList(filtered));
    }

    @javafx.fxml.FXML
    public void handleShowPlantEfficiency(ActionEvent actionEvent) {
        double totalGen = 0, totalLoss = 0;

        for (PlantPerformance p : plantPerformanceTableView.getItems()) {
            double gen = Double.parseDouble(p.getTotalGeneration());
            double loss = Double.parseDouble(p.getTotalPowerLoss());
            totalGen += gen;
            totalLoss += loss;
        }

        if (totalGen == 0) {
            effieciencyLabel.setText("Efficiency: N/A");
            return;
        }

        double eff = (totalGen - totalLoss) / totalGen * 100;
        effieciencyLabel.setText(String.format("Efficiency: %.2f%%", eff));
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","ceo-dashboard-view.fxml","CEO Dashboard");
    }
}