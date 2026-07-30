package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.Equipment;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.InventoryReport;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ViewInventoryReportViewController
{
    @javafx.fxml.FXML
    private TableColumn<InventoryReport, String> fuelOrEquipmentCategoryCol;
    @javafx.fxml.FXML
    private TableColumn<InventoryReport, String> reportTypeCol;
    @javafx.fxml.FXML
    private TableColumn<InventoryReport, LocalDate> reportDateCol;
    @javafx.fxml.FXML
    private TableColumn<InventoryReport, String> stockStatusCol;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadTableViewButtonOnAction(ActionEvent actionEvent) {
    }
}