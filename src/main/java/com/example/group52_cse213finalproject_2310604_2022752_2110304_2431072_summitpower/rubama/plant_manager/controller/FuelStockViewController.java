package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.model.FuelStock;
import javafx.event.ActionEvent;
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

    @javafx.fxml.FXML
    public void initialize() {
        unitNameComboBox.getItems().addAll("Operations","Management","HR","Engineer","Accounts","Grid Operation");
        fuelTypeComboBox.getItems().addAll("Coal","Natural Gas","Nuclear Fuel","Petroleum","Organic Fuel");

        unitNameCol.setCellValueFactory(new PropertyValueFactory<>("unitName"));
        fuelTypeCol.setCellValueFactory(new PropertyValueFactory<>("fuelType"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleCheckFuelLevels(ActionEvent actionEvent) {
    }
}