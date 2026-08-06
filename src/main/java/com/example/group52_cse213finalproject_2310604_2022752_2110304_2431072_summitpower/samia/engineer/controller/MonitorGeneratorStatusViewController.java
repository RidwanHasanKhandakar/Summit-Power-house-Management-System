package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model.MonitorGeneratorStatus;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.engineer.MonitorGeneratorStatusFileHandler;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class MonitorGeneratorStatusViewController {
    @javafx.fxml.FXML
    private TextField powerOutputTextField;
    @javafx.fxml.FXML
    private TextField runningStatusTextField;
    @javafx.fxml.FXML
    private TextField generatorIdTextField;
    @javafx.fxml.FXML
    private TextField runningHoursTextField;
    @javafx.fxml.FXML
    private TextField fuelLevelTextField;
    @javafx.fxml.FXML
    private TextField frequencyTextField;
    @javafx.fxml.FXML
    private ComboBox<String> plantUnitComBox;
    @javafx.fxml.FXML
    private TextField voltageTextField;
    @javafx.fxml.FXML
    private DatePicker maintenanceDateDatePicker;
    @javafx.fxml.FXML
    private TextField engineTemperatureTextField;

    @javafx.fxml.FXML
    public void initialize() {
        plantUnitComBox.getItems().addAll(
                "Unit 1",
                "Unit 2",
                "Unit 3",
                "Unit 4"
        );
        runningStatusTextField.setEditable(false);
        powerOutputTextField.setEditable(false);
        voltageTextField.setEditable(false);
        frequencyTextField.setEditable(false);
        fuelLevelTextField.setEditable(false);
        engineTemperatureTextField.setEditable(false);
        runningHoursTextField.setEditable(false);
        maintenanceDateDatePicker.setEditable(false);
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
        if(generatorIdTextField.getText().trim().isEmpty()){
            showError("Please enter Generator ID.");
            return;
        }

        if(plantUnitComBox.getValue()==null){
            showError("Please select Plant Unit.");
            return;
        }

        for(MonitorGeneratorStatus status :
                MonitorGeneratorStatusFileHandler.readAll()){

            if(status.getGeneratorId().equalsIgnoreCase(generatorIdTextField.getText().trim())
                    && status.getPlantUnit().equals(plantUnitComBox.getValue())){

                runningStatusTextField.setText(status.getRunningStatus());
                powerOutputTextField.setText(String.valueOf(status.getPowerOutput()));
                voltageTextField.setText(String.valueOf(status.getVoltage()));
                frequencyTextField.setText(String.valueOf(status.getFrequency()));
                fuelLevelTextField.setText(String.valueOf(status.getFuelLevel()));
                engineTemperatureTextField.setText(String.valueOf(status.getEngineTemperature()));
                runningHoursTextField.setText(String.valueOf(status.getRunningHours()));
                maintenanceDateDatePicker.setValue(status.getLastMaintenanceDate());
                showSuccess("Generator Found.");
                return;
            }
        }

        showError("Generator not found.");

    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        generatorIdTextField.clear();
        runningStatusTextField.clear();
        powerOutputTextField.clear();
        voltageTextField.clear();
        frequencyTextField.clear();
        fuelLevelTextField.clear();
        engineTemperatureTextField.clear();
        runningHoursTextField.clear();
        plantUnitComBox.getSelectionModel().clearSelection();
        maintenanceDateDatePicker.setValue(null);
    }


    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","engineer-dashboard-view.fxml","Engineer Dashboard");
    }
}