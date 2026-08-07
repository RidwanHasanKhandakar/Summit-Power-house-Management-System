package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.FuelInventory;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.accountant.FuelInventoryFileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn <FuelInventory,Double> quantityCol;
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

        fuelIDCol.setCellValueFactory(new PropertyValueFactory<>("fuelId"));
        fuelTypeCol.setCellValueFactory(new PropertyValueFactory<>("fuelType"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        unitCostCol.setCellValueFactory(new PropertyValueFactory<>("unitCost"));
        totalValueCol.setCellValueFactory(new PropertyValueFactory<>("totalValue"));
        lastUpdatedCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdated"));

        //fuelInventoryValuationTableView.setItems(FuelInventoryFileHandler.readAll());

        handleRefreshButton(null);

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "accountant", "accountant-dashboard-view.fxml","Accountant Dashboard");

    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {

        fuelInventoryValuationTableView.setItems(FuelInventoryFileHandler.readAll());

        fuelTypeComboBox.getSelectionModel().select("All");

        fromDateDatePicker.setValue(null);
        toDateDatePicker.setValue(null);

        totalQuantityLabel.setText("");
        totalInventoryValueLabel.setText("");
        avrgUnitCostLabel.setText("");


        showInformation("Inventory refreshed!");

    }

    @javafx.fxml.FXML
    public void handleCalculateViewsButton(ActionEvent actionEvent) {

        if(fuelInventoryValuationTableView.getItems().isEmpty()){
            showError("No inventory record found.");
            return;
        }

        double totalQuantity = 0;
        double totalValue = 0;
        double totalUnitCost = 0;

        for (FuelInventory fuel : fuelInventoryValuationTableView.getItems()){
            totalQuantity+=fuel.getQuantity();
            totalValue+=fuel.getTotalValue();
            totalUnitCost+=fuel.getUnitCost();
        }

        double avrgCost = totalUnitCost/fuelInventoryValuationTableView.getItems().size();

        totalQuantityLabel.setText(String.format("%.2f",totalQuantity));

        totalInventoryValueLabel.setText(String.format("%.2f",totalValue));

        avrgUnitCostLabel.setText(String.format("%.2f",avrgCost));

        showInformation("Inventory valuation calculated.");

    }

    @javafx.fxml.FXML
    public void handleFilterButton(ActionEvent actionEvent) {

        if(fuelTypeComboBox.getValue()==null){
            showError("Please select a fuel type.");
            return;
        }
        if(fromDateDatePicker.getValue()==null){
            showError("Please select From date.");
            return;
        }
        if(toDateDatePicker.getValue()==null){
            showError("Please select To date.");
            return;
        }
        if (fromDateDatePicker.getValue().isAfter(toDateDatePicker.getValue())){
            showError("From date cannot be after to Date.");
            return;
        }

        ObservableList<FuelInventory>filterdList = FXCollections.observableArrayList();

        for (FuelInventory fuel : FuelInventoryFileHandler.readAll()){
            boolean typeMatch = fuelTypeComboBox.getValue().equals("All")||fuel.getFuelType().equalsIgnoreCase(fuelTypeComboBox.getValue());
            boolean dateMatch = !fuel.getLastUpdated().isBefore(fromDateDatePicker.getValue())&&!fuel.getLastUpdated().isAfter(toDateDatePicker.getValue());
            if(typeMatch&&dateMatch){
                filterdList.add(fuel);
            }
        }

        fuelInventoryValuationTableView.setItems(filterdList);

        showInformation(filterdList.size()+"record(s) found.");

    }

    public void showInformation(String txt){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information!");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();

    }

    public void showError(String txt){

        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error!");
        a.setHeaderText(null);
        a.setContentText(txt);
        a.showAndWait();

    }

}