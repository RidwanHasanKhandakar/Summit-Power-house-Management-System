package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReportEquipmentFaultsViewController
{
    @javafx.fxml.FXML
    private TextField faultIdTextField;
    @javafx.fxml.FXML
    private DatePicker reportDatePicker;
    @javafx.fxml.FXML
    private TextField generatorIdTextField;
    @javafx.fxml.FXML
    private TextField equipmentIdTextField;
    @javafx.fxml.FXML
    private TextArea faultDescriptionTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> faultSeverityComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> faultCategoryComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        faultCategoryComboBox.getItems().addAll(
                "Electrical",
                "Mechanical",
                "Overheating",
                "Leakage",
                "Other"
        );
        faultSeverityComboBox.getItems().addAll(
                "Low",
                "Medium",
                "High"
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