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

        for(MonitorGeneratorStatus status : MonitorGeneratorStatusFileHandler.readAll()){

            if(status.getGeneratorId().equalsIgnoreCase(generatorIdTextField.getText().trim()) && status.getPlantUnit().equals(plantUnitComBox.getValue())){

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

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if(generatorIdTextField.getText().trim().isEmpty()){
            showError("Please enter Generator ID.");
            return;
        }

        if(plantUnitComBox.getValue() == null){
            showError("Please select Plant Unit.");
            return;
        }

        if(runningStatusTextField.getText().trim().isEmpty()){
            showError("Please enter Running Status.");
            return;
        }

        double powerOutput;
        try{
            powerOutput = Double.parseDouble(powerOutputTextField.getText().trim());

            if(powerOutput <= 0){
                showError("Power Output must be greater than 0.");
                return;
            }

        }catch(NumberFormatException e){
            showError("Please enter a valid Power Output.");
            return;
        }

        double voltage;
        try{
            voltage = Double.parseDouble(voltageTextField.getText().trim());

            if(voltage <= 0){
                showError("Voltage must be greater than 0.");
                return;
            }

        }catch(NumberFormatException e){
            showError("Please enter a valid Voltage.");
            return;
        }

        double frequency;
        try{
            frequency = Double.parseDouble(frequencyTextField.getText().trim());

            if(frequency <= 0){
                showError("Frequency must be greater than 0.");
                return;
            }

        }catch(NumberFormatException e){
            showError("Please enter a valid Frequency.");
            return;
        }

        double fuelLevel;
        try{
            fuelLevel = Double.parseDouble(fuelLevelTextField.getText().trim());

            if(fuelLevel < 0 || fuelLevel > 100){
                showError("Fuel Level must be between 0 and 100.");
                return;
            }

        }catch(NumberFormatException e){
            showError("Please enter a valid Fuel Level.");
            return;
        }

        double engineTemperature;
        try{
            engineTemperature = Double.parseDouble(engineTemperatureTextField.getText().trim());

            if(engineTemperature <= 0){
                showError("Engine Temperature must be greater than 0.");
                return;
            }

        }catch(NumberFormatException e){
            showError("Please enter a valid Engine Temperature.");
            return;
        }

        int runningHours;
        try{
            runningHours = Integer.parseInt(runningHoursTextField.getText().trim());

            if(runningHours < 0){
                showError("Running Hours cannot be negative.");
                return;
            }

        }catch(NumberFormatException e){
            showError("Please enter valid Running Hours.");
            return;
        }

        if(maintenanceDateDatePicker.getValue() == null){
            showError("Please select Last Maintenance Date.");
            return;
        }

        if(maintenanceDateDatePicker.getValue().isAfter(java.time.LocalDate.now())){
            showError("Last Maintenance Date cannot be in the future.");
            return;
        }

        String plantUnit = (String) plantUnitComBox.getValue();

        MonitorGeneratorStatus status = new MonitorGeneratorStatus(
                generatorIdTextField.getText().trim(),
                plantUnit,
                runningStatusTextField.getText().trim(),
                powerOutput,
                voltage,
                frequency,
                fuelLevel,
                engineTemperature,
                runningHours,
                maintenanceDateDatePicker.getValue());

        MonitorGeneratorStatusFileHandler.save(status);
        refreshButton(null);

        showSuccess("Generator Status saved successfully.");
    }
}