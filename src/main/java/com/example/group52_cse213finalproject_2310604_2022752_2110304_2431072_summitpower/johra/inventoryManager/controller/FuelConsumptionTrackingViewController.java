package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.inventoryManager.FuelConsumptionFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.FuelConsumption;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

public class FuelConsumptionTrackingViewController
{
    @javafx.fxml.FXML
    private DatePicker consumptioDateDatePicker;
    @javafx.fxml.FXML
    private TextField quantityUsedTextField;
    @javafx.fxml.FXML
    private ComboBox<String> fuelTypeComboBox;
    @javafx.fxml.FXML
    private TextField consumptionIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> plantUnitComboBox;

    @javafx.fxml.FXML
    public void initialize() {

        fuelTypeComboBox.getItems().addAll(
                "Natural Gas",
                "Diesel",
                "Furnace Oil"
        );

        plantUnitComboBox.getItems().addAll(
                "Plant A",
                "Plant B",
                "Plant C",
                "Plant D"
        );
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "dashboard-view.fxml", "Inventory Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void addFuelConsumptionButtonOnAction(ActionEvent actionEvent) {

        if(consumptionIdTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(quantityUsedTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(fuelTypeComboBox.getValue() == null){
            showError("Field cannot be empty");
            return;
        }

        if(plantUnitComboBox.getValue() == null){
            showError("Field cannot be empty");
            return;
        }

        if(consumptioDateDatePicker.getValue() == null){
            showError("Field cannot be empty");
            return;
        }

        FuelConsumption fuelConsumption = new FuelConsumption(consumptionIdTextField.getText(), fuelTypeComboBox.getValue(), quantityUsedTextField.getText(), plantUnitComboBox.getValue(), consumptioDateDatePicker.getValue());

        FuelConsumptionFileHandler.save(fuelConsumption);

        showInformation("Fuel consumption recorded successfully !");

    }

    public void showError(String text){

        Alert alert =new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();

    }


    public void showInformation(String text){

        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Success");
        alert.setContentText(text);
        alert.showAndWait();

    }

    @javafx.fxml.FXML
    public void refreshButtonOnAction(ActionEvent actionEvent) {

        consumptionIdTextField.clear();
        fuelTypeComboBox.setValue(null);
        plantUnitComboBox.setValue(null);
        quantityUsedTextField.clear();
        consumptioDateDatePicker.setValue(null);
    }
}