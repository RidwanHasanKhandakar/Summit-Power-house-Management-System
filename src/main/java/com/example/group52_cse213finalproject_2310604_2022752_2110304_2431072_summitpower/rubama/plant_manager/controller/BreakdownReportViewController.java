package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.model.BreakdownReport;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class BreakdownReportViewController
{
    @javafx.fxml.FXML
    private TableView <BreakdownReport> checkMaintenanceScheduleTableView;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableColumn <BreakdownReport, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn <BreakdownReport,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn <BreakdownReport,String> unitNameCol;
    @javafx.fxml.FXML
    private ComboBox <String> unitNameComboBox;
    @javafx.fxml.FXML
    private TableColumn <BreakdownReport,String> unitNoCol;
    @javafx.fxml.FXML
    private ComboBox <String> unitNoComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        unitNameComboBox.getItems().addAll("Thermal Power","Hydroelectric Power","Biomass Power","Solar Power","Nuclear Power");
        unitNoComboBox.getItems().addAll("TP12","HP13","BP14","SP15","NP16");

        unitNameCol.setCellValueFactory(new PropertyValueFactory<>("unitName"));
        unitNoCol.setCellValueFactory(new PropertyValueFactory<>("unitNo"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

    }

    @javafx.fxml.FXML
    public void handleViewBreakDownReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","plant_manager","plant_manager-dashboard-view.fxml","Plant Manager Dashboard");
    }
}