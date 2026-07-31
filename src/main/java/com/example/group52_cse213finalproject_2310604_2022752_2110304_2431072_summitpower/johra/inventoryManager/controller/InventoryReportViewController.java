package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

public class InventoryReportViewController
{
    @javafx.fxml.FXML
    private CheckBox stockAvailableCheckBox;
    @javafx.fxml.FXML
    private ComboBox<String> equipmentOrFuelCategoryComboBox;
    @javafx.fxml.FXML
    private CheckBox stoxkNotAvailableCheckBox;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker reportDateDatePicker;

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
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "dashboardView.fxml", "Inventory Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void createReportButtonOnAction(ActionEvent actionEvent) {
    }
}