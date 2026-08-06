package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model.UpdateMaintenanceStatus;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.engineer.UpdateMaintenanceStatusFileHandler;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class UpdateMaintenanceStatusViewController
{
    @javafx.fxml.FXML
    private DatePicker maintenanceDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> maintenanceStatusComboBox;
    @javafx.fxml.FXML
    private TextField generatorIdTextField;
    @javafx.fxml.FXML
    private TextField maintenanceIdTextField;
    @javafx.fxml.FXML
    private TextField updatedByTextField;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private TableColumn<UpdateMaintenanceStatus,String> updatedByTabCol;
    @javafx.fxml.FXML
    private TableColumn<UpdateMaintenanceStatus,String> maintenanceStatusTabCol;
    @javafx.fxml.FXML
    private TableView<UpdateMaintenanceStatus> tableView;
    @javafx.fxml.FXML
    private TableColumn<UpdateMaintenanceStatus,String> generatorIdTabCol;
    @javafx.fxml.FXML
    private TableColumn<UpdateMaintenanceStatus,LocalDate> maintenanceDateTabCol;
    @javafx.fxml.FXML
    private TableColumn<UpdateMaintenanceStatus,String> maintenanceIdTabCol;
    @javafx.fxml.FXML
    private TableColumn<UpdateMaintenanceStatus,String> remarksTabCol;

    @javafx.fxml.FXML
    public void initialize() {
        maintenanceStatusComboBox.getItems().addAll(
                "Pending",
                "In Progress",
                "Completed"
        );

        maintenanceIdTabCol.setCellValueFactory(new PropertyValueFactory<>("maintenanceId"));
        generatorIdTabCol.setCellValueFactory(new PropertyValueFactory<>("generatorId"));
        maintenanceDateTabCol.setCellValueFactory(new PropertyValueFactory<>("maintenanceDate"));
        maintenanceStatusTabCol.setCellValueFactory(new PropertyValueFactory<>("maintenanceStatus"));
        updatedByTabCol.setCellValueFactory(new PropertyValueFactory<>("updatedBy"));
        remarksTabCol.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        tableView.setItems(UpdateMaintenanceStatusFileHandler.readAll());
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
        maintenanceStatusComboBox.setValue(null);
        maintenanceDatePicker.setValue(null);
        updatedByTextField.clear();
        remarksTextArea.clear();
        tableView.getSelectionModel().clearSelection();

    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","engineer-dashboard-view.fxml","Engineer Dashboard");
    }

    @javafx.fxml.FXML
    public void updateButton(ActionEvent actionEvent) {
        if(maintenanceIdTextField.getText().trim().isEmpty()){
            showError("Please enter Maintenance ID.");
            return;
        }

        if(generatorIdTextField.getText().trim().isEmpty()){
            showError("Please enter Generator ID.");
            return;
        }

        if(maintenanceDatePicker.getValue() == null){
            showError("Please select Maintenance Date.");
            return;
        }

        if(maintenanceDatePicker.getValue().isBefore(LocalDate.now())){
            showError("Maintenance Date cannot be in the past.");
            return;
        }

        if(maintenanceStatusComboBox.getValue() == null){
            showError("Please select Maintenance Status.");
            return;
        }

        if(updatedByTextField.getText().trim().isEmpty()){
            showError("Please enter Updated By.");
            return;
        }

        if(remarksTextArea.getText().trim().isEmpty()){
            showError("Please enter Remarks.");
            return;
        }

        for(UpdateMaintenanceStatus s : UpdateMaintenanceStatusFileHandler.readAll()){

            if(s.getMaintenanceId().equalsIgnoreCase(
                    maintenanceIdTextField.getText().trim())){

                showError("Maintenance ID already exists.");
                return;
            }
        }

        UpdateMaintenanceStatus status = new UpdateMaintenanceStatus(
                maintenanceIdTextField.getText().trim(),
                generatorIdTextField.getText().trim(),
                maintenanceDatePicker.getValue(),
                maintenanceStatusComboBox.getValue(),
                updatedByTextField.getText().trim(),
                remarksTextArea.getText().trim()
        );

        UpdateMaintenanceStatusFileHandler.save(status);
        tableView.getItems().setAll(UpdateMaintenanceStatusFileHandler.readAll()
        );

        refreshButton(null);

        showSuccess("Maintenance Status Updated Successfully.");
    }
}