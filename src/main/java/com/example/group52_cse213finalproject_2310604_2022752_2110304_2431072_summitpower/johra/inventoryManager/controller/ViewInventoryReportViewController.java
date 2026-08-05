package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.inventoryManager.InventoryReportFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.Equipment;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.InventoryReport;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
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
    private ComboBox<String> filterReportTypeComboBox;
    @javafx.fxml.FXML
    private TableView<InventoryReport> showTableView;

    @javafx.fxml.FXML
    public void initialize() {

        filterReportTypeComboBox.getItems().addAll(
                "Maintenance",
                "Supply Chain Performance",
                "Audit & Safety"
        );

        reportDateCol.setCellValueFactory(new PropertyValueFactory<>("reportDate"));
        fuelOrEquipmentCategoryCol.setCellValueFactory(new PropertyValueFactory<>("equipmentOrFuelCategory"));
        reportTypeCol.setCellValueFactory(new PropertyValueFactory<>("reportType"));
        stockStatusCol.setCellValueFactory(new PropertyValueFactory<>("stockStatus"));

    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "dashboardView.fxml", "Inventory Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void loadTableViewButtonOnAction(ActionEvent actionEvent) {

        String selectedReportType =  filterReportTypeComboBox.getValue();

        if(selectedReportType != null){

            ObservableList<InventoryReport> allReports = InventoryReportFileHandler.readAll();

            ObservableList<InventoryReport> filteredReports = allReports.filtered(report -> report.getReportType().equals(selectedReportType)
            );

        showTableView.setItems(filteredReports);

        }
    }
}