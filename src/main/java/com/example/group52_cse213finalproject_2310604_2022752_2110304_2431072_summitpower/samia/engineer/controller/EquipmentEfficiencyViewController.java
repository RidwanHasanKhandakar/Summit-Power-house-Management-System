package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model.EquipmentEfficiency;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.engineer.EquipmentEfficiencyFileHandler;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

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
    private TableView<EquipmentEfficiency> tableView;
    @javafx.fxml.FXML
    private TableColumn<EquipmentEfficiency,Double> efficiencyTabCol;
    @javafx.fxml.FXML
    private TableColumn<EquipmentEfficiency,String> generatorIdTabCol;
    @javafx.fxml.FXML
    private TableColumn<EquipmentEfficiency,Double> fuelConsumptionTabCol;
    @javafx.fxml.FXML
    private TableColumn<EquipmentEfficiency,LocalDate> analysisDateTabCol;
    @javafx.fxml.FXML
    private TableColumn<EquipmentEfficiency,String> equipmentIdTabCol;
    @javafx.fxml.FXML
    private TableColumn<EquipmentEfficiency,Double> powerOutputTabCol;

    @javafx.fxml.FXML
    public void initialize() {
        efficiencyTextField.setEditable(false);
        equipmentIdTabCol.setCellValueFactory(new PropertyValueFactory<>("equipmentId"));
        generatorIdTabCol.setCellValueFactory(new PropertyValueFactory<>("generatorId"));
        powerOutputTabCol.setCellValueFactory(new PropertyValueFactory<>("powerOutput"));
        fuelConsumptionTabCol.setCellValueFactory(new PropertyValueFactory<>("fuelConsumption"));
        efficiencyTabCol.setCellValueFactory(new PropertyValueFactory<>("efficiency"));
        analysisDateTabCol.setCellValueFactory(new PropertyValueFactory<>("analysisDate"));
        tableView.setItems(EquipmentEfficiencyFileHandler.readAll());
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        equipmentIdTextField.clear();
        generatorIdTextField.clear();
        powerOutputTextField.clear();
        fuelConsumptionTextField.clear();
        efficiencyTextField.clear();
        analysisDatePicker.setValue(null);
        tableView.getSelectionModel().clearSelection();

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
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","engineer-dashboard-view.fxml","Engineer Dashboard");
    }

    @javafx.fxml.FXML
    public void calculateButton(ActionEvent actionEvent) {
        if (equipmentIdTextField.getText().trim().isEmpty()) {
            showError("Please enter Equipment ID.");
            return;
        }

        if (generatorIdTextField.getText().trim().isEmpty()) {
            showError("Please enter Generator ID.");
            return;
        }

        double powerOutput;
        try {
            powerOutput = Double.parseDouble(powerOutputTextField.getText().trim());

            if (powerOutput <= 0) {
                showError("Power Output must be greater than 0.");
                return;
            }

        } catch (NumberFormatException e) {
            showError("Please enter a valid Power Output.");
            return;
        }

        double fuelConsumption;
        try {
            fuelConsumption = Double.parseDouble(fuelConsumptionTextField.getText().trim());

            if (fuelConsumption <= 0) {
                showError("Fuel Consumption must be greater than 0.");
                return;
            }

        } catch (NumberFormatException e) {
            showError("Please enter a valid Fuel Consumption.");
            return;
        }

        if (analysisDatePicker.getValue() == null) {
            showError("Please select Analysis Date.");
            return;
        }
        if (analysisDatePicker.getValue().isAfter(LocalDate.now())) {
            showError("Analysis Date cannot be in the future.");
            return;
        }

        double efficiency = powerOutput / fuelConsumption;

        efficiencyTextField.setText(String.format("%.2f", efficiency));

        showSuccess("Efficiency calculated successfully.");
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (equipmentIdTextField.getText().trim().isEmpty()) {
            showError("Please enter Equipment ID.");
            return;
        }

        if (generatorIdTextField.getText().trim().isEmpty()) {
            showError("Please enter Generator ID.");
            return;
        }

        double powerOutput;
        try {
            powerOutput = Double.parseDouble(powerOutputTextField.getText().trim());

            if (powerOutput <= 0) {
                showError("Power Output must be greater than 0.");
                return;
            }

        } catch (NumberFormatException e) {
            showError("Please enter a valid Power Output.");
            return;
        }

        double fuelConsumption;
        try {
            fuelConsumption = Double.parseDouble(fuelConsumptionTextField.getText().trim());

            if (fuelConsumption <= 0) {
                showError("Fuel Consumption must be greater than 0.");
                return;
            }

        } catch (NumberFormatException e) {
            showError("Please enter a valid Fuel Consumption.");
            return;
        }

        if (efficiencyTextField.getText().trim().isEmpty()) {
            showError("Please click Calculate first.");
            return;
        }

        if (analysisDatePicker.getValue() == null) {
            showError("Please select Analysis Date.");
            return;
        }
        if (analysisDatePicker.getValue().isAfter(LocalDate.now())) {
            showError("Analysis Date cannot be in the future.");
            return;
        }
        double efficiency = Double.parseDouble(efficiencyTextField.getText());

        EquipmentEfficiency equipment = new EquipmentEfficiency(equipmentIdTextField.getText().trim(),
                generatorIdTextField.getText().trim(),
                powerOutput,
                fuelConsumption,
                efficiency,
                analysisDatePicker.getValue());

        EquipmentEfficiencyFileHandler.save(equipment);
        tableView.setItems(EquipmentEfficiencyFileHandler.readAll());
        refreshButton(null);
        showSuccess("Equipment Efficiency saved successfully.");
    }
}