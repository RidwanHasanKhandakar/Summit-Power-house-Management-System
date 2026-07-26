package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MonitorFuelConsumptionViewController
{
    @javafx.fxml.FXML
    private TextField fuelConsumedTextField;
    @javafx.fxml.FXML
    private ComboBox<String> fuelTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker monitoringDatePicker;
    @javafx.fxml.FXML
    private TextField generatorIdTextField;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private TextField operatingHoursTextField;

    @javafx.fxml.FXML
    public void initialize() {
        fuelTypeComboBox.getItems().addAll(
                "Natural Gas",
                "Diesel",
                "Furnace Oil"
        );
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}