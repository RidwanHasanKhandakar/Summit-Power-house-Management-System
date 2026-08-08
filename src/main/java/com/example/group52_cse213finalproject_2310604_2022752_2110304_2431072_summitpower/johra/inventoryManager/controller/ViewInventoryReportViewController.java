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
    private TableColumn<InventoryReport, String> reportTypeCol;
    @javafx.fxml.FXML
    private TableView<InventoryReport> showTableView;
    @javafx.fxml.FXML
    private TableColumn<InventoryReport, LocalDate> dateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<InventoryReport, LocalDate> quantityCol;
    @javafx.fxml.FXML
    private TableColumn<InventoryReport, LocalDate> categoryCol;
    @javafx.fxml.FXML
    private TableColumn<InventoryReport, LocalDate> reportIdCol;
    @javafx.fxml.FXML
    private TableColumn<InventoryReport, LocalDate> itemCol;
    @javafx.fxml.FXML
    private ComboBox<String> filterReportTypeComboBox;

    @javafx.fxml.FXML
    public void initialize() {

        filterReportTypeComboBox.getItems().addAll(
                "Inventory Summary",
                "Stock Availability",
                "Low Stock",
                "Inventory Audit"
        );

        reportIdCol.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        reportTypeCol.setCellValueFactory(new PropertyValueFactory<>("reportType"));
        itemCol.setCellValueFactory(new PropertyValueFactory<>("item"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dateDatePicker.setCellValueFactory(new PropertyValueFactory<>("reportDate"));

    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "dashboard-view.fxml", "Inventory Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void loadTableViewButtonOnAction(ActionEvent actionEvent) {

        String filteredReportType =  filterReportTypeComboBox.getValue();

        showTableView.getItems().clear();

        if(filteredReportType == null){

            showTableView.setItems(InventoryReportFileHandler.readAll());
        }

        for(InventoryReport inventoryReport : InventoryReportFileHandler.readAll()){

            if(inventoryReport.getReportType().equals(filteredReportType)){

                showTableView.getItems().add(inventoryReport);

            }
        }

    }

}