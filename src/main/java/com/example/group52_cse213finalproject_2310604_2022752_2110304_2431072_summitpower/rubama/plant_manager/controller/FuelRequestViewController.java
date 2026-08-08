package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.plant_manager.FuelRequestFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.model.FuelRequest;

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

public class FuelRequestViewController {

    @javafx.fxml.FXML
    private ComboBox<String> fuelTypeComboBox;

    @javafx.fxml.FXML
    private TableView<FuelRequest> checkFuelLevelsTableView;

    @javafx.fxml.FXML
    private DatePicker dateDatePicker;

    @javafx.fxml.FXML
    private TableColumn<FuelRequest, LocalDate> dateCol;

    @javafx.fxml.FXML
    private TableColumn<FuelRequest, String> statusCol;

    @javafx.fxml.FXML
    private TableColumn<FuelRequest, String> unitNameCol;

    @javafx.fxml.FXML
    private ComboBox<String> unitNameComboBox;

    @javafx.fxml.FXML
    private TableColumn<FuelRequest, String> fuelTypeCol;

    private ObservableList<FuelRequest> allRequests =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        unitNameComboBox.getItems().addAll(
                "Thermal Power",
                "Hydroelectric Power",
                "Biomass Power",
                "Solar Power",
                "Nuclear Power"
        );

        fuelTypeComboBox.getItems().addAll(
                "Coal",
                "Natural Gas",
                "Nuclear Fuel",
                "Petroleum",
                "Organic Fuel"
        );

        unitNameCol.setCellValueFactory(
                new PropertyValueFactory<>("unitName")
        );

        fuelTypeCol.setCellValueFactory(
                new PropertyValueFactory<>("fuelType")
        );

        statusCol.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        dateCol.setCellValueFactory(
                new PropertyValueFactory<>("date")
        );

        // Load previously saved fuel requests
        allRequests.setAll(FuelRequestFileHandler.readAll());

        checkFuelLevelsTableView.setItems(allRequests);
    }

    @javafx.fxml.FXML
    public void handleRequestFuel(ActionEvent actionEvent) {

        String unit = unitNameComboBox.getValue();
        String fuel = fuelTypeComboBox.getValue();
        LocalDate date = dateDatePicker.getValue();

        if (unit == null || fuel == null || date == null) {
            System.out.println("Please fill all fields.");
            return;
        }

        FuelRequest newRequest =
                new FuelRequest(unit, fuel, "Pending", date);

        // Save request to file
        FuelRequestFileHandler.save(newRequest);

        // Add request to current table
        allRequests.add(newRequest);

        checkFuelLevelsTableView.setItems(allRequests);

        // Clear fields
        unitNameComboBox.getSelectionModel().clearSelection();
        fuelTypeComboBox.getSelectionModel().clearSelection();
        dateDatePicker.setValue(null);

        System.out.println("Fuel request submitted successfully.");
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene(
                (Node) actionEvent.getSource(),
                "rubama",
                "plant_manager",
                "plant_manager-dashboard-view.fxml",
                "Plant Manager Dashboard"
        );
    }
}
