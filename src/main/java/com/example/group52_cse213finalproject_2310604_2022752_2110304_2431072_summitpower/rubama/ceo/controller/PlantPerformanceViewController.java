package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PlantPerformanceViewController
{
    @javafx.fxml.FXML
    private TableColumn totalGenerationCol;
    @javafx.fxml.FXML
    private TableColumn startingDateCol;
    @javafx.fxml.FXML
    private TableColumn totalPowerLossCol;
    @javafx.fxml.FXML
    private DatePicker startingDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn endingDateCol;
    @javafx.fxml.FXML
    private DatePicker endingDateDatePicker;
    @javafx.fxml.FXML
    private TableView plantPerformanceTableView;
    @javafx.fxml.FXML
    private TableColumn performanceStatusCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleShowPerformance(ActionEvent actionEvent) {
    }
}