package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
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
        fuelTypeComboBox.getSelectionModel().clearSelection();
        generatorIdTextField.clear();
        fuelConsumedTextField.clear();
        remarksTextArea.clear();
        operatingHoursTextField.clear();
        monitoringDatePicker.setValue(null);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","engineer-dashboard-view.fxml","Engineer Dashboard");
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}