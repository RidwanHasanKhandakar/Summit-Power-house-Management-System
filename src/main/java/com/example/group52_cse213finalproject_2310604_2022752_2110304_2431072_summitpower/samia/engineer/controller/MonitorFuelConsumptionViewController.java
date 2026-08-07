package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model.MonitorFuelConsumption;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.engineer.MonitorFuelConsumptionFileHandler;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class MonitorFuelConsumptionViewController
{
    @javafx.fxml.FXML
    private TextField fuelConsumedTextField;
    @javafx.fxml.FXML
    private ComboBox<String> fuelTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker monitoringDatePicker;
    @javafx.fxml.FXML
    private TextField generatorIdTextField;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private TextField operatingHoursTextField;
    @javafx.fxml.FXML
    private TableColumn<MonitorFuelConsumption,Double> operatingHoursTabCol;
    @javafx.fxml.FXML
    private TableColumn<MonitorFuelConsumption,LocalDate> monitoringDateTabCol;
    @javafx.fxml.FXML
    private TableColumn<MonitorFuelConsumption,String> fuelTypeTabCol;
    @javafx.fxml.FXML
    private TableView<MonitorFuelConsumption> tableView;
    @javafx.fxml.FXML
    private TableColumn<MonitorFuelConsumption,Double> fuelConsumedTabCol;
    @javafx.fxml.FXML
    private TableColumn<MonitorFuelConsumption,String> generatorIdTabCol;
    @javafx.fxml.FXML
    private TableColumn<MonitorFuelConsumption,String> remarksTabCol;

    @javafx.fxml.FXML
    public void initialize() {
        fuelTypeComboBox.getItems().addAll(
                "Natural Gas",
                "Diesel",
                "Furnace Oil"
        );

        generatorIdTabCol.setCellValueFactory(new PropertyValueFactory<>("generatorId"));
        fuelTypeTabCol.setCellValueFactory(new PropertyValueFactory<>("fuelType"));
        fuelConsumedTabCol.setCellValueFactory(new PropertyValueFactory<>("fuelConsumed"));
        operatingHoursTabCol.setCellValueFactory(new PropertyValueFactory<>("operatingHours"));
        monitoringDateTabCol.setCellValueFactory(new PropertyValueFactory<>("monitoringDate"));
        remarksTabCol.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        tableView.setItems(MonitorFuelConsumptionFileHandler.readAll());
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
    public void refreshButton(ActionEvent actionEvent) {
        fuelTypeComboBox.setValue(null);
        generatorIdTextField.clear();
        fuelConsumedTextField.clear();
        remarksTextArea.clear();
        operatingHoursTextField.clear();
        monitoringDatePicker.setValue(null);
        tableView.getSelectionModel().clearSelection();
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
        if(fuelTypeComboBox.getValue() == null){
            showError("Please select Fuel Type.");
            return;
        }
        double fuelConsumed;

        try{
            fuelConsumed = Double.parseDouble(fuelConsumedTextField.getText().trim());

            if(fuelConsumed <= 0){
                showError("Fuel Consumed must be greater than 0.");
                return;
            }

        }catch(NumberFormatException e){
            showError("Please enter a valid Fuel Consumed value.");
            return;
        }
        double operatingHours;

        try{
            operatingHours = Double.parseDouble(operatingHoursTextField.getText().trim());

            if(operatingHours <= 0){
                showError("Operating Hours must be greater than 0.");
                return;
            }

        }catch(NumberFormatException e){
            showError("Please enter valid Operating Hours.");
            return;
        }
        if(monitoringDatePicker.getValue() == null){
            showError("Please select Monitoring Date.");
            return;
        }
        if(monitoringDatePicker.getValue().isAfter(LocalDate.now())){
            showError("Monitoring Date cannot be in the future.");
            return;
        }

        if(remarksTextArea.getText().trim().isEmpty()){
            showError("Please enter Remarks.");
            return;
        }

        MonitorFuelConsumption fuel = new MonitorFuelConsumption(
                generatorIdTextField.getText().trim(),
                fuelTypeComboBox.getValue(),
                fuelConsumed,
                operatingHours,
                monitoringDatePicker.getValue(),
                remarksTextArea.getText().trim()
        );

        MonitorFuelConsumptionFileHandler.save(fuel);
        tableView.getItems().setAll(MonitorFuelConsumptionFileHandler.readAll());
        refreshButton(null);
        showSuccess("Fuel Consumption record saved successfully.");
    }
}