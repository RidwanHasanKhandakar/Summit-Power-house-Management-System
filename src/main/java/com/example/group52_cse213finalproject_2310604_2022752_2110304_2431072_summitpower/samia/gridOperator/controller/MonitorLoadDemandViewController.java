package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class MonitorLoadDemandViewController
{
    @javafx.fxml.FXML
    private TextField currentLoadMWTextField;
    @javafx.fxml.FXML
    private ComboBox<String> demandStatusComboBox;
    @javafx.fxml.FXML
    private DatePicker monitoringDatePicker;
    @javafx.fxml.FXML
    private TextField demandIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> gridSectionComboBox;
    @javafx.fxml.FXML
    private TextField availableCapacityMWTextField;

    @javafx.fxml.FXML
    public void initialize() {

        gridSectionComboBox.getItems().addAll(
                "North Grid",
                "South Grid",
                "East Grid",
                "West Grid"
        );
        demandStatusComboBox.getItems().addAll(
                "Normal",
                "High Demand",
                "Critical"
        );
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        demandIdTextField.clear();
        gridSectionComboBox.setValue(null);
        currentLoadMWTextField.clear();
        availableCapacityMWTextField.clear();
        demandStatusComboBox.setValue(null);
        monitoringDatePicker.setValue(null);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }
}