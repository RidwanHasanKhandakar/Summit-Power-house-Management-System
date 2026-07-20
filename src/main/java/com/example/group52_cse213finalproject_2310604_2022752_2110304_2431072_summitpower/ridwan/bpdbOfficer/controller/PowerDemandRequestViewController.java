package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PowerDemandRequestViewController
{
    @javafx.fxml.FXML
    private TextField reqCapacityTextField;
    @javafx.fxml.FXML
    private ComboBox <String> purposeOfDemandComboBox;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private ComboBox <String> priorityLavelComboBox;
    @javafx.fxml.FXML
    private DatePicker EndDateDatePicker;
    @javafx.fxml.FXML
    private DatePicker startDateDatePicker;
    @javafx.fxml.FXML
    private TextField reqIdTextField;

    @javafx.fxml.FXML
    public void initialize() {
        priorityLavelComboBox.getItems().addAll(
                "Low",
                "Medium",
                "High",
                "Emergency");
        purposeOfDemandComboBox.getItems().addAll(
                "Residential Supply",
                "Industrial Supply",
                "Commercial Supply",
                "Agricultural Supply",
                "Emergency Supply",
                "Other");
    }

    @javafx.fxml.FXML
    public void handleSubmitRequestButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {

        priorityLavelComboBox.setValue(null);
        purposeOfDemandComboBox.setValue(null);

        reqIdTextField.clear();
        reqCapacityTextField.clear();
        remarksTextArea.clear();

        startDateDatePicker.setValue(null);
        EndDateDatePicker.setValue(null);

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"bpdbOfficer","bpdbOfficer-dashboard-view.fxml", "BPDB Officer Dashboard!");
    }
}