package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.model.UnitControl;
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

public class UnitControlViewController
{
    @javafx.fxml.FXML
    private TableView <UnitControl> checkMaintenanceScheduleTableView;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableColumn <UnitControl, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn <UnitControl,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn <UnitControl,String> unitNameCol;
    @javafx.fxml.FXML
    private ComboBox <String> unitNameComboBox;
    @javafx.fxml.FXML
    private TableColumn <UnitControl,String> unitNoCol;
    @javafx.fxml.FXML
    private ComboBox <String> unitNoComboBox;

    private ObservableList<UnitControl> allControls = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        unitNameComboBox.getItems().addAll("Thermal Power","Hydroelectric Power","Biomass Power","Solar Power","Nuclear Power");
        unitNoComboBox.getItems().addAll("TP12","HP13","BP14","SP15","NP16");

        unitNameCol.setCellValueFactory(new PropertyValueFactory<>("unitName"));
        unitNoCol.setCellValueFactory(new PropertyValueFactory<>("unitNo"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        allControls.add(new UnitControl("Thermal Power", "TP12", "Active", LocalDate.of(2026, 8, 1)));
        allControls.add(new UnitControl("Hydroelectric Power", "HP13", "Idle", LocalDate.of(2026, 8, 2)));
        allControls.add(new UnitControl("Solar Power", "SP15", "Active", LocalDate.of(2026, 8, 3)));
        allControls.add(new UnitControl("Nuclear Power", "NP16", "Offline", LocalDate.of(2026, 8, 4)));
        allControls.add(new UnitControl("Thermal Power", "TP12", "Maintenance", LocalDate.of(2026, 8, 5)));

        checkMaintenanceScheduleTableView.setItems(allControls);
    }

    @javafx.fxml.FXML
    public void handleViewUnitControl(ActionEvent actionEvent) {
        String unit = unitNameComboBox.getValue();
        String unitNo = unitNoComboBox.getValue();
        LocalDate date = dateDatePicker.getValue();

        ObservableList<UnitControl> filtered = FXCollections.observableArrayList();
        for (UnitControl u : allControls) {
            if ((unit == null || u.getUnitName().equals(unit)) &&
                    (unitNo == null || u.getUnitNo().equals(unitNo)) &&
                    (date == null || u.getDate().equals(date))) {
                filtered.add(u);
            }
        }
        checkMaintenanceScheduleTableView.setItems(filtered);
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","plant_manager","plant_manager-dashboard-view.fxml","Plant Manager Dashboard");
    }
}