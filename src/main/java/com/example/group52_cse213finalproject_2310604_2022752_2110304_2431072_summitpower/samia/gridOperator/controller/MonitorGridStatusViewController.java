package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.gridOperator.MonitorGridStatusFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.gridOperator.RecordGridOperationLogFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.MonitorGridStatus;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.RecordGridOperationLog;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class MonitorGridStatusViewController
{
    @javafx.fxml.FXML
    private TextField gridIdTextField;
    @javafx.fxml.FXML
    private TextField frequencyTextField;
    @javafx.fxml.FXML
    private TextField voltageTextField;
    @javafx.fxml.FXML
    private TextField monitoringDateTextField;
    @javafx.fxml.FXML
    private TextField gridSectionTextField;
    @javafx.fxml.FXML
    private TextField gridStatusTextField;

    @javafx.fxml.FXML
    public void initialize() {
        gridSectionTextField.setEditable(false);
        gridStatusTextField.setEditable(false);
        voltageTextField.setEditable(false);
        frequencyTextField.setEditable(false);
        monitoringDateTextField.setEditable(false);
    }

    public void showSuccess(String txt){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

    public void showError(String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
        String gridId = gridIdTextField.getText().trim();

        if (gridId.isEmpty()) {
            showError("Please enter Grid ID.");
            return;
        }

        for (RecordGridOperationLog status : RecordGridOperationLogFileHandler.readAll()) {

            if (status.getGridId().equalsIgnoreCase(gridId)) {

                gridSectionTextField.setText(status.getGridSection());
                gridStatusTextField.setText(status.getGridStatus());
                voltageTextField.setText(String.valueOf(status.getVoltage()));
                frequencyTextField.setText(String.valueOf(status.getFrequency()));
                monitoringDateTextField.setText(status.getOperationDate().toString());

                showSuccess("Record Found!");
                return;
            }
        }

        // If no record is found
        gridSectionTextField.clear();
        gridStatusTextField.clear();
        voltageTextField.clear();
        frequencyTextField.clear();
        monitoringDateTextField.clear();

        showError("No record found with this Grid ID.");
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        gridIdTextField.clear();
        gridSectionTextField.clear();
        gridStatusTextField.clear();
        voltageTextField.clear();
        frequencyTextField.clear();
        monitoringDateTextField.clear();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","gridOperator-dashboard-view.fxml","Grid Operator Dashboard");

    }
}