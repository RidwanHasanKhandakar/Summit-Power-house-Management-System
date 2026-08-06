package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model.ReportEquipmentFaults;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.engineer.ReportEquipmentFaultsFileHandler;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ReportEquipmentFaultsViewController
{
    @javafx.fxml.FXML
    private TextField faultIdTextField;
    @javafx.fxml.FXML
    private DatePicker reportDatePicker;
    @javafx.fxml.FXML
    private TextField generatorIdTextField;
    @javafx.fxml.FXML
    private TextField equipmentIdTextField;
    @javafx.fxml.FXML
    private TextArea faultDescriptionTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> faultSeverityComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> faultCategoryComboBox;
    @javafx.fxml.FXML
    private TableColumn<ReportEquipmentFaults,String> faultIdTabCol;
    @javafx.fxml.FXML
    private TableView<ReportEquipmentFaults> tableView;
    @javafx.fxml.FXML
    private TableColumn<ReportEquipmentFaults,LocalDate> reportDateTabCol;
    @javafx.fxml.FXML
    private TableColumn<ReportEquipmentFaults,String> generatorIdTabCol;
    @javafx.fxml.FXML
    private TableColumn<ReportEquipmentFaults,String> faultCategoryTabCol;
    @javafx.fxml.FXML
    private TableColumn<ReportEquipmentFaults,String> equipmentIdTabCol;
    @javafx.fxml.FXML
    private TableColumn<ReportEquipmentFaults,String> faultDescriptionTabCol;
    @javafx.fxml.FXML
    private TableColumn<ReportEquipmentFaults,String> faultSeverityTabCol;

    @javafx.fxml.FXML
    public void initialize() {
        faultCategoryComboBox.getItems().addAll(
                "Electrical",
                "Mechanical",
                "Overheating",
                "Leakage",
                "Other"
        );
        faultSeverityComboBox.getItems().addAll(
                "Low",
                "Medium",
                "High"
        );
        faultIdTabCol.setCellValueFactory(new PropertyValueFactory<>("faultId"));
        equipmentIdTabCol.setCellValueFactory(new PropertyValueFactory<>("equipmentId"));
        generatorIdTabCol.setCellValueFactory(new PropertyValueFactory<>("generatorId"));
        faultCategoryTabCol.setCellValueFactory(new PropertyValueFactory<>("faultCategory"));
        faultSeverityTabCol.setCellValueFactory(new PropertyValueFactory<>("faultSeverity"));
        reportDateTabCol.setCellValueFactory(new PropertyValueFactory<>("reportDate"));
        faultDescriptionTabCol.setCellValueFactory(new PropertyValueFactory<>("faultDescription"));

        tableView.setItems(ReportEquipmentFaultsFileHandler.readAll());

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
        faultIdTextField.clear();
        equipmentIdTextField.clear();
        generatorIdTextField.clear();
        faultCategoryComboBox.setValue(null);
        faultSeverityComboBox.setValue(null);
        reportDatePicker.setValue(null);
        faultDescriptionTextArea.clear();
        tableView.getSelectionModel().clearSelection();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","engineer-dashboard-view.fxml","Engineer Dashboard");
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if(faultIdTextField.getText().trim().isEmpty()){
            showError("Please enter Fault ID.");
            return;
        }

        if(equipmentIdTextField.getText().trim().isEmpty()){
            showError("Please enter Equipment ID.");
            return;
        }

        if(generatorIdTextField.getText().trim().isEmpty()){
            showError("Please enter Generator ID.");
            return;
        }

        if(faultCategoryComboBox.getValue()==null){
            showError("Please select Fault Category.");
            return;
        }

        if(faultSeverityComboBox.getValue()==null){
            showError("Please select Fault Severity.");
            return;
        }

        if(reportDatePicker.getValue()==null){
            showError("Please select Report Date.");
            return;
        }

        if(reportDatePicker.getValue().isBefore(LocalDate.now())){
            showError("Report Date cannot be in the past.");
            return;
        }

        if(faultDescriptionTextArea.getText().trim().isEmpty()){
            showError("Please enter Fault Description.");
            return;
        }
        ReportEquipmentFaults fault = new ReportEquipmentFaults(faultIdTextField.getText().trim(),
                        equipmentIdTextField.getText().trim(),
                        generatorIdTextField.getText().trim(),
                        faultCategoryComboBox.getValue(),
                        faultSeverityComboBox.getValue(),
                        reportDatePicker.getValue(),
                        faultDescriptionTextArea.getText().trim());
        ReportEquipmentFaultsFileHandler.save(fault);
        tableView.getItems().setAll(ReportEquipmentFaultsFileHandler.readAll());
        refreshButton(null);
        showSuccess("Equipment Fault Report saved successfully.");
    }
}