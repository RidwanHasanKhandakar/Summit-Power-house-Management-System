package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.model.FuelStock;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class FuelStockViewController
{
    @javafx.fxml.FXML
    private ComboBox <String> fuelTypeComboBox;
    @javafx.fxml.FXML
    private TableView <FuelStock> checkFuelLevelsTableView;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableColumn <FuelStock,LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn <FuelStock,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn <FuelStock,String> unitNameCol;
    @javafx.fxml.FXML
    private ComboBox <String> unitNameComboBox;
    @javafx.fxml.FXML
    private TableColumn <FuelStock,String> fuelTypeCol;

    private ObservableList<FuelStock> allStocks = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        unitNameComboBox.getItems().addAll("Thermal Power","Hydroelectric Power","Biomass Power","Solar Power","Nuclear Power");
        fuelTypeComboBox.getItems().addAll("Coal","Natural Gas","Nuclear Fuel","Petroleum","Organic Fuel");

        unitNameCol.setCellValueFactory(new PropertyValueFactory<>("unitName"));
        fuelTypeCol.setCellValueFactory(new PropertyValueFactory<>("fuelType"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        allStocks.add(new FuelStock("Thermal Power", "Coal", "In Stock", LocalDate.of(2026, 8, 1)));
        allStocks.add(new FuelStock("Nuclear Power", "Nuclear Fuel", "Low", LocalDate.of(2026, 8, 2)));
        allStocks.add(new FuelStock("Solar Power", "Petroleum", "Out of Stock", LocalDate.of(2026, 8, 3)));
        allStocks.add(new FuelStock("Hydroelectric Power", "Natural Gas", "In Stock", LocalDate.of(2026, 8, 4)));
        allStocks.add(new FuelStock("Biomass Power", "Organic Fuel", "Low", LocalDate.of(2026, 8, 5)));

        checkFuelLevelsTableView.setItems(allStocks);
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","plant_manager","plant_manager-dashboard-view.fxml","Plant Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void handleCheckFuelLevels(ActionEvent actionEvent) {
        String unit = unitNameComboBox.getValue();
        String fuel = fuelTypeComboBox.getValue();
        LocalDate date = dateDatePicker.getValue();

        ObservableList<FuelStock> filtered = FXCollections.observableArrayList();

        for (FuelStock s : allStocks) {
            boolean match = true;
            if (unit != null && !s.getUnitName().equals(unit)) match = false;
            if (fuel != null && !s.getFuelType().equals(fuel)) match = false;
            if (date != null && !s.getDate().equals(date)) match = false;
            if (match) filtered.add(s);
        }

        checkFuelLevelsTableView.setItems(filtered);
    }
}