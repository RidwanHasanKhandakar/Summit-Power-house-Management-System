package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model.EngineeringPerformance;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.engineer.EngineeringPerformanceFileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class MaintenancePerformanceAnalyticsController
{
    @javafx.fxml.FXML
    private ComboBox<String> statusFilterComboBox;
    @javafx.fxml.FXML
    private TableView<EngineeringPerformance> performanceTableView;
    @javafx.fxml.FXML
    private TableColumn<EngineeringPerformance,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<EngineeringPerformance,String> generatorIdCol;
    @javafx.fxml.FXML
    private TableColumn<EngineeringPerformance,Double> efficiencyCol;
    @javafx.fxml.FXML
    private TableColumn<EngineeringPerformance,LocalDate> reportDateCol;
    @javafx.fxml.FXML
    private PieChart performancePieChart;
    @javafx.fxml.FXML
    private TableColumn<EngineeringPerformance,String> reportIdCol;

    @javafx.fxml.FXML
    public void initialize() {
        statusFilterComboBox.getItems().addAll(
                "Excellent",
                "Good",
                "Average",
                "Poor"
        );

        reportIdCol.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        generatorIdCol.setCellValueFactory(new PropertyValueFactory<>("generatorId"));
        efficiencyCol.setCellValueFactory(new PropertyValueFactory<>("efficiencyPercentage"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("performanceStatus"));
        reportDateCol.setCellValueFactory(new PropertyValueFactory<>("reportDate"));

        performanceTableView.setItems(
                EngineeringPerformanceFileHandler.readAll()
        );

        loadPieChart();
    }
    private void loadPieChart(){

        int excellent = 0;
        int good = 0;
        int average = 0;
        int poor = 0;

        for(EngineeringPerformance p : EngineeringPerformanceFileHandler.readAll()){

            switch (p.getPerformanceStatus()){

                case "Excellent":
                    excellent++;
                    break;

                case "Good":
                    good++;
                    break;

                case "Average":
                    average++;
                    break;

                case "Poor":
                    poor++;
                    break;
            }
        }

        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(new PieChart.Data("Excellent", excellent), new PieChart.Data("Good", good), new PieChart.Data("Average", average), new PieChart.Data("Poor", poor));

        performancePieChart.setData(pieData);
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        statusFilterComboBox.setValue(null);

        performanceTableView.setItems(
                EngineeringPerformanceFileHandler.readAll()
        );

        loadPieChart();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "samia", "engineer", "engineer-dashboard-view.fxml", "Engineer Dashboard");
    }

    @javafx.fxml.FXML
    public void filterButton(ActionEvent actionEvent) {
        String selected = statusFilterComboBox.getValue();
        if(selected == null){
            performanceTableView.setItems(EngineeringPerformanceFileHandler.readAll());
            return;
        }
        ObservableList<EngineeringPerformance> filtered = FXCollections.observableArrayList();

        for(EngineeringPerformance p : EngineeringPerformanceFileHandler.readAll()){

            if(p.getPerformanceStatus().equals(selected)){
                filtered.add(p);
            }
        }

        performanceTableView.setItems(filtered);
    }
}