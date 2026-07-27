package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.FuelInventory;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.time.LocalDate;

public class FuelInventoryViewController
{
    @javafx.fxml.FXML
    private Label totalInventoryValueLabel;
    @javafx.fxml.FXML
    private ComboBox <String> fuelTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn <FuelInventory, LocalDate> lastUpdatedCol;
    @javafx.fxml.FXML
    private Label avrgUnitCostLabel;
    @javafx.fxml.FXML
    private TableColumn <FuelInventory,Double> unitCostCol;
    @javafx.fxml.FXML
    private DatePicker toDateDatePicker;
    @javafx.fxml.FXML
    private DatePicker fromDateDatePicker;
    @javafx.fxml.FXML
    private TableView <FuelInventory> fuelInventoryValuationTableView;
    @javafx.fxml.FXML
    private TableColumn <FuelInventory,Double> totalValueCol;
    @javafx.fxml.FXML
    private Label totalQuantityLabel;
    @javafx.fxml.FXML
    private TableColumn <FuelInventory,Integer> quantityCol;
    @javafx.fxml.FXML
    private TableColumn <FuelInventory,String> fuelIDCol;
    @javafx.fxml.FXML
    private TableColumn <FuelInventory,String> fuelTypeCol;

    @javafx.fxml.FXML
    public void initialize() {

        fuelTypeComboBox.getItems().addAll(
                "All",
                "Diesel",
                "Furnace Oil",
                "Natural Gas",
                "Coal",
                "LPG",
                "Petrol",
                "Kerosene",
                "Biofuel",
                "Ethanol",
                "Biodiesel",
                "Hydrogen",
                "Methanol",
                "Propane",
                "Butane",
                "Wood",
                "Peat",
                "Charcoal"
                );



    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "accountant", "accountant-dashboard-view.fxml","Accountant Dashboard");

    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleCalculateViewsButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleFilterButton(ActionEvent actionEvent) {
    }
}