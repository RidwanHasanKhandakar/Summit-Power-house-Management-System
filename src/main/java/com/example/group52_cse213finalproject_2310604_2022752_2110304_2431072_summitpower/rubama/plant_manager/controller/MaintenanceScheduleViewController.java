package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.plant_manager.model.MaintenanceSchedule;
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

public class MaintenanceScheduleViewController
{
    @javafx.fxml.FXML
    private TableView <MaintenanceSchedule> checkMaintenanceScheduleTableView;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableColumn <MaintenanceSchedule,LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn <MaintenanceSchedule,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn <MaintenanceSchedule,String> unitNameCol;
    @javafx.fxml.FXML
    private ComboBox <String> unitNameComboBox;
    @javafx.fxml.FXML
    private TableColumn <MaintenanceSchedule,String> unitNoCol;
    @javafx.fxml.FXML
    private ComboBox <String> unitNoComboBox;

    private ObservableList<MaintenanceSchedule> allSchedules = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        unitNameComboBox.getItems().addAll("Thermal Power","Hydroelectric Power","Biomass Power","Solar Power","Nuclear Power");
        unitNoComboBox.getItems().addAll("TP12","HP13","BP14","SP15","NP16");

        unitNameCol.setCellValueFactory(new PropertyValueFactory<>("unitName"));
        unitNoCol.setCellValueFactory(new PropertyValueFactory<>("unitNo"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        allSchedules.add(new MaintenanceSchedule("Thermal Power", "TP12", "Scheduled", LocalDate.of(2026, 8, 1)));
        allSchedules.add(new MaintenanceSchedule("Hydroelectric Power", "HP13", "Completed", LocalDate.of(2026, 8, 2)));
        allSchedules.add(new MaintenanceSchedule("Solar Power", "SP15", "Pending", LocalDate.of(2026, 8, 3)));
        allSchedules.add(new MaintenanceSchedule("Nuclear Power", "NP16", "Scheduled", LocalDate.of(2026, 8, 4)));
        allSchedules.add(new MaintenanceSchedule("Thermal Power", "TP12", "Overdue", LocalDate.of(2026, 8, 5)));

        checkMaintenanceScheduleTableView.setItems(allSchedules);
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","plant_manager","plant_manager-dashboard-view.fxml","Plant Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void handleViewSchedule(ActionEvent actionEvent) {
        String unit = unitNameComboBox.getValue();
        String unitNo = unitNoComboBox.getValue();
        LocalDate date = dateDatePicker.getValue();

        ObservableList<MaintenanceSchedule> filtered = FXCollections.observableArrayList();

        for (MaintenanceSchedule m : allSchedules) {
            boolean match = true;
            if (unit != null && !m.getUnitName().equals(unit)) match = false;
            if (unitNo != null && !m.getUnitNo().equals(unitNo)) match = false;
            if (date != null && !m.getDate().equals(date)) match = false;
            if (match) filtered.add(m);
        }

        checkMaintenanceScheduleTableView.setItems(filtered);
    }
}