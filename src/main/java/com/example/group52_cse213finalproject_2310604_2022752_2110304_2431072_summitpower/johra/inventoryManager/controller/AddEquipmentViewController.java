package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.io.*;
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
        }

        if(equipmentNameTextField.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        if(quantityTextField.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        if(vendorComboBox.getValue().isEmpty()){
            showError("Field cannot be empty");
        }

        if(equipmentCategoryComboBox.getValue().isEmpty()){
            showError("Field cannot be empty");
        }

        if(purchaseDateDatePicker == null){
            showError("Field cannot be empty");
        }
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "dashboardView.fxml", "Inventory Manager Dashboard");
    }

    public void showError(String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
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
}