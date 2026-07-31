package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EquipmentEfficiencyViewController
{
    @javafx.fxml.FXML
    private DatePicker analysisDatePicker;
    @javafx.fxml.FXML
    private TextField powerOutputTextField;
    @javafx.fxml.FXML
    private TextField generatorIdTextField;
    @javafx.fxml.FXML
    private TextField equipmentIdTextField;
    @javafx.fxml.FXML
    private TextField efficiencyTextField;
    @javafx.fxml.FXML
    private TextField fuelConsumptionTextField;

    @javafx.fxml.FXML
    public void initialize() {
        efficiencyTextField.setEditable(false);
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        equipmentIdTextField.clear();
        generatorIdTextField.clear();
        powerOutputTextField.clear();
        fuelConsumptionTextField.clear();
        efficiencyTextField.clear();
        analysisDatePicker.setValue(null);

    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","engineer-dashboard-view.fxml","Engineer Dashboard");
    }

    @javafx.fxml.FXML
    public void calculateButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}