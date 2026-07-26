package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PreventiveMaintenanceViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> priorityComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> maintenanceStatusComboBox;
    @javafx.fxml.FXML
    private TextField generatorIdTextField;
    @javafx.fxml.FXML
    private TextField maintenanceIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> maintenanceTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker scheduledDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> plantUnitComboBox;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private TextField engineerNameTextField;

    @javafx.fxml.FXML
    public void initialize() {
        plantUnitComboBox.getItems().addAll(
                "Unit 1",
                "Unit 2",
                "Unit 3",
                "Unit 4"
        );
        maintenanceTypeComboBox.getItems().addAll(
                "Inspection",
                "Oil Change",
                "Filter Replacement",
                "Cleaning",
                "Testing"
        );
        priorityComboBox.getItems().addAll(
                "Low",
                "Medium",
                "High"
        );
        maintenanceStatusComboBox.getItems().addAll(
                "Pending",
                "In Progress",
                "Completed"
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