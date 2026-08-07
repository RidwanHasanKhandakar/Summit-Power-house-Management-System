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
    private CheckBox stockAvailableCheckBox;
    @javafx.fxml.FXML
    private ComboBox<String> equipmentOrFuelCategoryComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker reportDateDatePicker;
    @javafx.fxml.FXML
    private TextField reportIdTextField;
    @javafx.fxml.FXML
    private CheckBox stockNotAvailableCheckBox;

    @javafx.fxml.FXML
    public void initialize() {

        equipmentOrFuelCategoryComboBox.getItems().addAll(
                "Turbines",
                "Pumps",
                "Generators",
                "Transformers",
                "Broilers",
                "Chemicals"
        );

        reportTypeComboBox.getItems().addAll(
                "Maintenance",
                "Supply Chain Performance",
                "Audit & Safety"

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
        }

        if(reportTypeComboBox.getValue().isEmpty()){
            showError("Field cannot be empty");
        }

        if(reportDateDatePicker == null){
            showError("Field cannot be empty");
        }

        InventoryReport inventoryReport = new InventoryReport(reportDateDatePicker.getValue(), equipmentOrFuelCategoryComboBox.getValue(), reportTypeComboBox.getValue(), reportIdTextField.getText(), stockAvailableCheckBox.isSelected(), stockNotAvailableCheckBox.isSelected());

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
        stockAvailableCheckBox.setSelected(false);
        stockNotAvailableCheckBox.setSelected(false);

    }
}