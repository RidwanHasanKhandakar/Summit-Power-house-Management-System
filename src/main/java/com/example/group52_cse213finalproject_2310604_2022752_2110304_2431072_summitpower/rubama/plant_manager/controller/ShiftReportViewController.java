package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.model.ShiftReport;
import javafx.event.ActionEvent;
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

    @javafx.fxml.FXML
    public void initialize() {
        unitNameComboBox.getItems().addAll("Operations","Management","HR","Engineer","Accounts","Grid Operation");
        unitNoComboBox.getItems().addAll("Op121","Mgt131","Hr141","Eng151","Acn161","Go171");

        unitNameCol.setCellValueFactory(new PropertyValueFactory<>("unitName"));
        unitNoCol.setCellValueFactory(new PropertyValueFactory<>("unitNo"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @javafx.fxml.FXML
    public void handleViewReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
    }
}