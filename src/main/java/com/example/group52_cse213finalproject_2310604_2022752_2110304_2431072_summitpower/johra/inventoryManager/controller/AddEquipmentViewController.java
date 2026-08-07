package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.JohraSceneSwitch;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.inventoryManager.AddEquipmentFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.Equipment;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AddEquipmentViewController
{
    @javafx.fxml.FXML
    private TextField equipmentNameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> vendorComboBox;
    @javafx.fxml.FXML
    private TextField equipmentIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> equipmentCategoryComboBox;
    @javafx.fxml.FXML
    private DatePicker purchaseDateDatePicker;
    @javafx.fxml.FXML
    private TextField quantityTextField;

    @javafx.fxml.FXML
    public void initialize() {

        equipmentCategoryComboBox.getItems().addAll(
                "Primary Generation & Rotating Machinery",
                "Electrical Systems & Distribution",
                "Thermal Cycle & Fluid Handling",
                "Instrumentation & Control"
        );

        vendorComboBox.getItems().addAll(
                "GE Vernova",
                "Siemens Energy",
                "Mitsubishi Corporation",
                " Honeywell",
                "Hitachi Energy"
        );
    }

    @javafx.fxml.FXML
    public void addEquipmentButtonOnAction(ActionEvent actionEvent) {

        if(equipmentIdTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(equipmentNameTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(quantityTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(vendorComboBox.getValue().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(equipmentCategoryComboBox.getValue().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(purchaseDateDatePicker.getValue() == null){
            showError("Field cannot be empty");
            return;
        }

        if(purchaseDateDatePicker.getValue().isAfter(LocalDate.now())){
            showError("Purchase date cannot be in future !");
            return;
        }

        Equipment equipment = new Equipment(equipmentIdTextField.getText(), equipmentNameTextField.getText(), equipmentCategoryComboBox.getValue(), vendorComboBox.getValue(), quantityTextField.getText(), purchaseDateDatePicker.getValue());

        AddEquipmentFileHandler.save(equipment);

        showInformation("Equipment added successfully!");
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "dashboard-view.fxml", "Inventory Manager Dashboard");
    }

    public void showError(String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }

    public void showInformation(String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void refreshButtonOnAction(ActionEvent actionEvent) {

        equipmentIdTextField.clear();
        equipmentNameTextField.clear();
        quantityTextField.clear();
        equipmentCategoryComboBox.setValue(null);
        vendorComboBox.setValue(null);
        purchaseDateDatePicker.setValue(null);

    }

    @javafx.fxml.FXML
    public void viewButtonOnAction(ActionEvent actionEvent) throws IOException{

        JohraSceneSwitch.johraSceneSwitch((Node) actionEvent.getSource(), "inventoryManager", "showEquipment-view.fxml", "Show Equipments");

    }
}