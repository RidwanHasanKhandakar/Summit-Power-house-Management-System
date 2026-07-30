package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.Equipment;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ViewEquipmentDetailsViewController
{
    @javafx.fxml.FXML
    private TableView<Equipment> showTableView;
    @javafx.fxml.FXML
    private TableColumn<Equipment, String> equipmentCategoryCol;
    @javafx.fxml.FXML
    private TableColumn<Equipment, LocalDate> purchaseDateCol;
    @javafx.fxml.FXML
    private TableColumn<Equipment, String> quantityCol;
    @javafx.fxml.FXML
    private TableColumn<Equipment, String> equipmentNameCol;
    @javafx.fxml.FXML
    private TableColumn<Equipment, String> vendorCol;

    @javafx.fxml.FXML
    public void initialize() {
        equipmentCategoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        equipmentNameCol.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));
        purchaseDateCol.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        vendorCol.setCellValueFactory(new PropertyValueFactory<>("vendor"));
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadTableViewButtonOnAction(ActionEvent actionEvent) {
    }
}