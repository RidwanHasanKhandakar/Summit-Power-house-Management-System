package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.model.ShiftReport;
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

public class ShiftReportViewController
{
    @javafx.fxml.FXML
    private TableView <ShiftReport> checkMaintenanceScheduleTableView;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableColumn <ShiftReport,LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn <ShiftReport,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn <ShiftReport,String> unitNameCol;
    @javafx.fxml.FXML
    private ComboBox <String> unitNameComboBox;
    @javafx.fxml.FXML
    private TableColumn <ShiftReport,String> unitNoCol;
    @javafx.fxml.FXML
    private ComboBox <String> unitNoComboBox;

    private ObservableList<ShiftReport> allReports = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        unitNameComboBox.getItems().addAll("Thermal Power","Hydroelectric Power","Biomass Power","Solar Power","Nuclear Power");
        unitNoComboBox.getItems().addAll("TP12","HP13","BP14","SP15","NP16");

        unitNameCol.setCellValueFactory(new PropertyValueFactory<>("unitName"));
        unitNoCol.setCellValueFactory(new PropertyValueFactory<>("unitNo"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        allReports.add(new ShiftReport("Thermal Power", "TP12", "Active", LocalDate.of(2026, 8, 1)));
        allReports.add(new ShiftReport("Hydroelectric Power", "HP13", "Completed", LocalDate.of(2026, 8, 2)));
        allReports.add(new ShiftReport("Solar Power", "SP15", "Ongoing", LocalDate.of(2026, 8, 3)));
        allReports.add(new ShiftReport("Nuclear Power", "NP16", "Breakdown", LocalDate.of(2026, 8, 4)));
        allReports.add(new ShiftReport("Thermal Power", "TP12", "Maintenance", LocalDate.of(2026, 8, 5)));

        checkMaintenanceScheduleTableView.setItems(allReports);
    }

    @javafx.fxml.FXML
    public void handleViewReport(ActionEvent actionEvent) {
        String unit = unitNameComboBox.getValue();
        String unitNo = unitNoComboBox.getValue();
        LocalDate date = dateDatePicker.getValue();

        ObservableList<ShiftReport> filtered = FXCollections.observableArrayList();

        for (ShiftReport r : allReports) {
            boolean match = unit == null || r.getUnitName().equals(unit);
            if (unitNo != null && !r.getUnitNo().equals(unitNo)) match = false;
            if (date != null && !r.getDate().equals(date)) match = false;
            if (match) filtered.add(r);
        }

        checkMaintenanceScheduleTableView.setItems(filtered);
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","plant_manager","plant_manager-dashboard-view.fxml","Plant Manager Dashboard");
    }
}