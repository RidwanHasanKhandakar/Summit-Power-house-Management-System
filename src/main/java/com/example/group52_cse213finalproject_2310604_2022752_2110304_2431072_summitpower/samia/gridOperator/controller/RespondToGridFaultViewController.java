package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RespondToGridFaultViewController
{
    @javafx.fxml.FXML
    private TextField faultIdTextField;
    @javafx.fxml.FXML
    private TextArea responseActionTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> faultStatusComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> faultTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker faultDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> gridSectionComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        gridSectionComboBox.getItems().addAll(
                "North Grid",
                "South Grid",
                "East Grid",
                "West Grid"
        );
        faultTypeComboBox.getItems().addAll(
                "Power Failure",
                "Short Circuit",
                "Transmission Fault",
                "Equipment Failure"
        );
        faultStatusComboBox.getItems().addAll(
                "Pending",
                "In Progress",
                "Resolved"
        );
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        faultIdTextField.clear();
        gridSectionComboBox.setValue(null);
        faultTypeComboBox.setValue(null);
        faultDatePicker.setValue(null);
        responseActionTextArea.clear();
        faultStatusComboBox.setValue(null);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","gridOperator-dashboard-view.fxml","Grid Operator Dashboard");
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}