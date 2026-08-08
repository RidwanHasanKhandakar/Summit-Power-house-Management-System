package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.model.PowerGeneration;
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

public class PowerGenerationViewController
{
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableColumn <PowerGeneration,LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn <PowerGeneration,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn <PowerGeneration,String> unitNameCol;
    @javafx.fxml.FXML
    private TableView <PowerGeneration> powerGenerationTableView;
    @javafx.fxml.FXML
    private ComboBox <String> unitNameComboBox;
    @javafx.fxml.FXML
    private TableColumn <PowerGeneration,String> unitNoCol;
    @javafx.fxml.FXML
    private ComboBox <String> unitNoComboBox;

    private ObservableList<PowerGeneration> allGenerations = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        unitNameComboBox.getItems().addAll("Thermal Power","Hydroelectric Power","Biomass Power","Solar Power","Nuclear Power");
        unitNoComboBox.getItems().addAll("TP12","HP13","BP14","SP15","NP16");

        unitNameCol.setCellValueFactory(new PropertyValueFactory<>("unitName"));
        unitNoCol.setCellValueFactory(new PropertyValueFactory<>("unitNo"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        allGenerations.add(new PowerGeneration("Thermal Power", "TP12", "Active", LocalDate.of(2026, 8, 1)));
        allGenerations.add(new PowerGeneration("Hydroelectric Power", "HP13", "Idle", LocalDate.of(2026, 8, 2)));
        allGenerations.add(new PowerGeneration("Solar Power", "SP15", "Active", LocalDate.of(2026, 8, 3)));
        allGenerations.add(new PowerGeneration("Nuclear Power", "NP16", "Maintenance", LocalDate.of(2026, 8, 4)));
        allGenerations.add(new PowerGeneration("Thermal Power", "TP12", "Offline", LocalDate.of(2026, 8, 5)));

        powerGenerationTableView.setItems(allGenerations);
    }

    @javafx.fxml.FXML
    public void handleViewGeneration(ActionEvent actionEvent) {
        String unit = unitNameComboBox.getValue();
        String unitNo = unitNoComboBox.getValue();
        LocalDate date = dateDatePicker.getValue();

        ObservableList<PowerGeneration> filtered = FXCollections.observableArrayList();

        for (PowerGeneration p : allGenerations) {
            boolean match = unit == null || p.getUnitName().equals(unit);
            if (unitNo != null && !p.getUnitNo().equals(unitNo)) match = false;
            if (date != null && !p.getDate().equals(date)) match = false;
            if (match) filtered.add(p);
        }
        powerGenerationTableView.setItems(filtered);
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","plant_manager","plant_manager-dashboard-view.fxml","Plant Manager Dashboard");
    }
}