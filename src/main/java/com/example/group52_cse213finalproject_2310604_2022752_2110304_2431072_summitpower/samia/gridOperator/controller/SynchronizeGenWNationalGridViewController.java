package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class SynchronizeGenWNationalGridViewController
{
    @javafx.fxml.FXML
    private DatePicker synchronizationDatePicker;
    @javafx.fxml.FXML
    private TextField synchronizationIdTextField;
    @javafx.fxml.FXML
    private TextField generatorIdTextField;
    @javafx.fxml.FXML
    private TextField gridVoltageTextField;
    @javafx.fxml.FXML
    private TextField generatorVoltageTextField;
    @javafx.fxml.FXML
    private ComboBox<String> synchronizationStatusComboBox;
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
        synchronizationStatusComboBox.getItems().addAll(
                "Successful",
                "Pending",
                "Failed"
        );

    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        synchronizationIdTextField.clear();
        generatorIdTextField.clear();
        gridSectionComboBox.setValue(null);
        generatorVoltageTextField.clear();
        gridVoltageTextField.clear();
        synchronizationStatusComboBox.setValue(null);
        synchronizationDatePicker.setValue(null);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","gridOperator-dashboard-view.fxml","Grid Operator Dashboard");
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}