package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EngineeringPerformanceViewController
{
    @javafx.fxml.FXML
    private TextField reportIdTextField;
    @javafx.fxml.FXML
    private DatePicker reportDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> performanceStatusComboBox;
    @javafx.fxml.FXML
    private TextField powerOutputTextField;
    @javafx.fxml.FXML
    private TextField generatorIdTextField;
    @javafx.fxml.FXML
    private TextField efficiencyTextField;

    @javafx.fxml.FXML
    public void initialize() {
        performanceStatusComboBox.getItems().addAll(
                "Excellent",
                "Good",
                "Average",
                "Poor"
        );
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateReportButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}