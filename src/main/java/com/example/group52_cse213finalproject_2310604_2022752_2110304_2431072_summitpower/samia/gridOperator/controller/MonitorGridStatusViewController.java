package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.gridOperator.MonitorGridStatusFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.MonitorGridStatus;
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
    private DatePicker monitoringDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> gridStatusComboBox;
    @javafx.fxml.FXML
    private TextField frequencyTextField;
    @javafx.fxml.FXML
    private ComboBox<String> gridSectionComboBox;
    @javafx.fxml.FXML
    private TextField voltageTextField;

    @javafx.fxml.FXML
    public void initialize() {
        gridSectionComboBox.getItems().addAll(
                "North Grid",
                "South Grid",
                "East Grid",
                "West Grid"
        );

        gridStatusComboBox.getItems().addAll(
                "Normal",
                "Maintenance",
                "Fault"
        );
        voltageTextField.setEditable(false);
        frequencyTextField.setEditable(false);

        gridSectionComboBox.setDisable(true);
        gridStatusComboBox.setDisable(true);

        monitoringDatePicker.setDisable(true);
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

        for (MonitorGridStatus status : MonitorGridStatusFileHandler.readAll()) {

            if (status.getGridId().equalsIgnoreCase(gridId)) {

                gridSectionComboBox.setValue(status.getGridSection());
                gridStatusComboBox.setValue(status.getGridStatus());
                voltageTextField.setText(String.valueOf(status.getVoltage()));
                frequencyTextField.setText(String.valueOf(status.getFrequency()));
                monitoringDatePicker.setValue(status.getMonitoringDate());

                showSuccess("Record Found!");
                return;
            }
        }

        gridSectionComboBox.setValue(null);
        gridStatusComboBox.setValue(null);
        voltageTextField.clear();
        frequencyTextField.clear();
        monitoringDatePicker.setValue(null);

        showError("No record found with this Grid ID.");
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        gridIdTextField.clear();
        gridSectionComboBox.setValue(null);
        gridStatusComboBox.setValue(null);
        voltageTextField.clear();
        frequencyTextField.clear();
        monitoringDatePicker.setValue(null);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","gridOperator-dashboard-view.fxml","Grid Operator Dashboard");

    }
}