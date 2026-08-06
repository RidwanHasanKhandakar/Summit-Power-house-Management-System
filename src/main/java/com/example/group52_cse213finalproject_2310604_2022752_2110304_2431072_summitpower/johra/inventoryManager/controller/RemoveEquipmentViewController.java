package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.Equipment;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.time.LocalDate;

public class RemoveEquipmentViewController
{
    @javafx.fxml.FXML
    private TableColumn<Equipment, String> equipmentCol;
    @javafx.fxml.FXML
    private TableColumn<Equipment, String> equipmentIdCol;
    @javafx.fxml.FXML
    private TableView<Equipment> showTableView;
    @javafx.fxml.FXML
    private TableColumn<Equipment, LocalDate> purchaseDateCol;
    @javafx.fxml.FXML
    private TableColumn<Equipment, String> quantityCol;
    @javafx.fxml.FXML
    private TableColumn<Equipment, String> categoryCol;
    @javafx.fxml.FXML
    private TableColumn<Equipment, String> vendorCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadTableViewButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void removeButtonOnACtion(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "inventoryManager", "dashboardView.fxml", "Inventory Manager Dashboard");
    }
}