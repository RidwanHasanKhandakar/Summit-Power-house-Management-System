package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.inventoryManager.EquipmentMaintenanceHistoryFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.EquipmentMaintenanceHistory;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

public class EquipmentMaintenanceHistoryViewController
{
    @javafx.fxml.FXML
    private
    TextField quantityUsedTextField;
    @javafx.fxml.FXML
    private TextField technicianTextField;
    @javafx.fxml.FXML
    private ComboBox<String> sparePartsUsedComboBox;
    @javafx.fxml.FXML
    private TextField equipmentIdTextField;
    @javafx.fxml.FXML
    private TextField maintenanceIdTextField;
    @javafx.fxml.FXML
    private DatePicker maintenanceDateDatePicker;

    @javafx.fxml.FXML
    public void initialize() {

        sparePartsUsedComboBox.getItems().addAll(
                "Oil filter",
                "Air Filter",
                "Bearing",
                "Lubricant",
                "Fuse",
                "Belt"
        );
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "dashboard-view.fxml", "Inventory Manager Dashboard");
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

        maintenanceIdTextField.clear();
        equipmentIdTextField.clear();
        quantityUsedTextField.clear();
        technicianTextField.clear();
        maintenanceDateDatePicker.setValue(null);
        sparePartsUsedComboBox.setValue(null);
    }

    @javafx.fxml.FXML
    public void addEquipmentMaintenanceButtonOnAction(ActionEvent actionEvent) {

        if(maintenanceIdTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(equipmentIdTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(sparePartsUsedComboBox.getValue() == null){
            showError("Field cannot be empty");
            return;
        }

        if(technicianTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(quantityUsedTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(maintenanceDateDatePicker.getValue() == null){
            showError("Field cannot be empty");
            return;
        }

        EquipmentMaintenanceHistory equipmentMaintenanceHistory = new EquipmentMaintenanceHistory(maintenanceIdTextField.getText(), equipmentIdTextField.getText(), sparePartsUsedComboBox.getValue(), quantityUsedTextField.getText(), technicianTextField.getText(), maintenanceDateDatePicker.getValue());

        EquipmentMaintenanceHistoryFileHandler.save(equipmentMaintenanceHistory);

        showInformation("Equipment maintenance history added successfully !");
    }
}