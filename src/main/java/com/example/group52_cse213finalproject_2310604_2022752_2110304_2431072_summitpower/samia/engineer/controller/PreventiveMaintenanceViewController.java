package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model.PreventiveMaintenance;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.engineer.PreventiveMaintenanceFileHandler;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class PreventiveMaintenanceViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> priorityComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> maintenanceStatusComboBox;
    @javafx.fxml.FXML
    private TextField generatorIdTextField;
    @javafx.fxml.FXML
    private TextField maintenanceIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> maintenanceTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker scheduledDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> plantUnitComboBox;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private TextField engineerNameTextField;
    @javafx.fxml.FXML
    private TableColumn<PreventiveMaintenance,String> maintenanceTypeTabCol;
    @javafx.fxml.FXML
    private TableColumn<PreventiveMaintenance,String> engineerNameTabCol;
    @javafx.fxml.FXML
    private TableColumn<PreventiveMaintenance,String> plantUnitTabCol;
    @javafx.fxml.FXML
    private TableColumn<PreventiveMaintenance,String> maintenanceStatusTabCol;
    @javafx.fxml.FXML
    private TableView<PreventiveMaintenance> tableView;
    @javafx.fxml.FXML
    private TableColumn<PreventiveMaintenance,String> priorityTabCol;
    @javafx.fxml.FXML
    private TableColumn<PreventiveMaintenance,String> generatorIdTabCol;
    @javafx.fxml.FXML
    private TableColumn<PreventiveMaintenance,LocalDate> scheduledDateTabCol;
    @javafx.fxml.FXML
    private TableColumn<PreventiveMaintenance,String> maintenanceIdTabCol;
    @javafx.fxml.FXML
    private TableColumn<PreventiveMaintenance,String> remarksTabCol;

    @javafx.fxml.FXML
    public void initialize() {
        plantUnitComboBox.getItems().addAll(
                "Unit 1",
                "Unit 2",
                "Unit 3",
                "Unit 4"
        );
        maintenanceTypeComboBox.getItems().addAll(
                "Inspection",
                "Oil Change",
                "Filter Replacement",
                "Cleaning",
                "Testing"
        );
        priorityComboBox.getItems().addAll(
                "Low",
                "Medium",
                "High"
        );
        maintenanceStatusComboBox.getItems().addAll(
                "Pending",
                "In Progress",
                "Completed"
        );
        maintenanceIdTabCol.setCellValueFactory(new PropertyValueFactory<>("maintenanceId"));
        generatorIdTabCol.setCellValueFactory(new PropertyValueFactory<>("generatorId"));
        plantUnitTabCol.setCellValueFactory(new PropertyValueFactory<>("plantUnit"));
        maintenanceTypeTabCol.setCellValueFactory(new PropertyValueFactory<>("maintenanceType"));
        scheduledDateTabCol.setCellValueFactory(new PropertyValueFactory<>("scheduledDate"));
        engineerNameTabCol.setCellValueFactory(new PropertyValueFactory<>("engineerName"));
        priorityTabCol.setCellValueFactory(new PropertyValueFactory<>("priority"));
        maintenanceStatusTabCol.setCellValueFactory(new PropertyValueFactory<>("maintenanceStatus"));
        remarksTabCol.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        tableView.setItems(PreventiveMaintenanceFileHandler.readAll());

    }

    public void showSuccess(String txt){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }
    public void showError(String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        maintenanceIdTextField.clear();
        generatorIdTextField.clear();
        plantUnitComboBox.setValue(null);
        maintenanceTypeComboBox.setValue(null);
        scheduledDatePicker.setValue(null);
        engineerNameTextField.clear();
        priorityComboBox.setValue(null);
        maintenanceStatusComboBox.setValue(null);
        remarksTextArea.clear();
        tableView.getSelectionModel().clearSelection();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","engineer-dashboard-view.fxml","Engineer Dashboard");
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if(maintenanceIdTextField.getText().trim().isEmpty()){
            showError("Please enter Maintenance ID.");
            return;
        }

        if(generatorIdTextField.getText().trim().isEmpty()){
            showError("Please enter Generator ID.");
            return;
        }

        if(plantUnitComboBox.getValue()==null){
            showError("Please select Plant Unit.");
            return;
        }

        if(maintenanceTypeComboBox.getValue()==null){
            showError("Please select Maintenance Type.");
            return;
        }

        if(scheduledDatePicker.getValue()==null){
            showError("Please select Scheduled Date.");
            return;
        }

        if(scheduledDatePicker.getValue().isBefore(LocalDate.now())){
            showError("Scheduled Date cannot be in the past.");
            return;
        }

        if(engineerNameTextField.getText().trim().isEmpty()){
            showError("Please enter Engineer Name.");
            return;
        }

        if(priorityComboBox.getValue()==null){
            showError("Please select Priority.");
            return;
        }

        if(maintenanceStatusComboBox.getValue()==null){
            showError("Please select Maintenance Status.");
            return;
        }

        if(remarksTextArea.getText().trim().isEmpty()){
            showError("Please enter Remarks.");
            return;
        }

        PreventiveMaintenance maintenance = new PreventiveMaintenance(maintenanceIdTextField.getText().trim(),
                        generatorIdTextField.getText().trim(),
                        plantUnitComboBox.getValue(),
                        maintenanceTypeComboBox.getValue(),
                        scheduledDatePicker.getValue(),
                        engineerNameTextField.getText().trim(),
                        priorityComboBox.getValue(),
                        maintenanceStatusComboBox.getValue(),
                        remarksTextArea.getText().trim());
        PreventiveMaintenanceFileHandler.save(maintenance);
        tableView.getItems().setAll(PreventiveMaintenanceFileHandler.readAll());
        refreshButton(null);
        showSuccess("Preventive Maintenance saved successfully.");
    }
}