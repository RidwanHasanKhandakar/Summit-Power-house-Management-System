package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.inventoryManager.InventoryReportFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.InventoryReport;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.time.LocalDate;

public class InventoryReportViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> equipmentOrFuelCategoryComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker reportDateDatePicker;
    @javafx.fxml.FXML
    private TextField reportIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> itemComboBox;
    @javafx.fxml.FXML
    private TextField quantityTextField;

    @javafx.fxml.FXML
    public void initialize() {

        itemComboBox.getItems().addAll(
                "Turbines",
                "Pumps",
                "Generators",
                "Transformers",
                "Broilers",
                "Chemicals",
                "Cooling Fan",
                "Air Filter",
                "Diesel",
                "Safety Helmet"
        );

        reportTypeComboBox.getItems().addAll(
                "Inventory Summary",
                "Stock Availability",
                "Low Stock",
                "Inventory Audit"

        );

        equipmentOrFuelCategoryComboBox.getItems().addAll(
                "Equipment",
                "Spare Parts",
                "Fuel",
                "Chemicals",
                "Safety Equipment",
                "Maintenance Supplies"
        );
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "dashboard-view.fxml", "Inventory Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void createReportButtonOnAction(ActionEvent actionEvent) {

        if(reportIdTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(reportTypeComboBox.getValue().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(reportDateDatePicker.getValue() == null){
            showError("Field cannot be empty");
            return;
        }

        if(reportDateDatePicker.getValue().isBefore(LocalDate.now())){
            showError("Date cannot be in future");
            return;
        }

        InventoryReport inventoryReport = new InventoryReport(reportDateDatePicker.getValue(), equipmentOrFuelCategoryComboBox.getValue(), reportTypeComboBox.getValue(), reportIdTextField.getText(), itemComboBox.getValue(), quantityTextField.getText());

        InventoryReportFileHandler.save(inventoryReport);

        showInformation("Inventory report created successfully");

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

        reportIdTextField.clear();
        equipmentOrFuelCategoryComboBox.setValue(null);
        reportDateDatePicker.setValue(null);
        itemComboBox.setValue(null);
        quantityTextField.clear();
        reportTypeComboBox.setValue(null);

    }
}