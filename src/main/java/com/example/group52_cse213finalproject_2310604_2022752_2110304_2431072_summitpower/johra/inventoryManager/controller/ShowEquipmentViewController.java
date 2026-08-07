package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.JohraSceneSwitch;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.inventoryManager.AddEquipmentFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.Equipment;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;

public class ShowEquipmentViewController
{
    @javafx.fxml.FXML
    private TableColumn<Equipment, String> equipmentIdCol;
    @javafx.fxml.FXML
    private TableView<Equipment> showTableView;
    @javafx.fxml.FXML
    private TableColumn<Equipment, LocalDate> purchaseDateCol;
    @javafx.fxml.FXML
    private TableColumn<Equipment, String> quantityCol;
    @javafx.fxml.FXML
    private TableColumn<Equipment, String> equipmentNameCol;
    @javafx.fxml.FXML
    private TableColumn<Equipment, String> categoryCol;
    @javafx.fxml.FXML
    private TableColumn<Equipment, String> vendorCol;

    @javafx.fxml.FXML
    public void initialize() {

        equipmentIdCol.setCellValueFactory(new PropertyValueFactory<>("equipmentId"));
        equipmentNameCol.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        vendorCol.setCellValueFactory(new PropertyValueFactory<>("vendor"));
        purchaseDateCol.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));

        showTableView.setItems(AddEquipmentFileHandler.readAll());
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        JohraSceneSwitch.johraSceneSwitch((Node) actionEvent.getSource(), "inventoryManager", "addEquipment-view.fxml", "Add Equipments");
    }
}