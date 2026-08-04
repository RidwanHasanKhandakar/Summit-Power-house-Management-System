package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.gridOperator.RecordGridOperationLogFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.RecordGridOperationLog;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class RecordGridOperationLogViewController
{
    @javafx.fxml.FXML
    private TableColumn<RecordGridOperationLog,String> operationTypeColumn;
    @javafx.fxml.FXML
    private TableColumn<RecordGridOperationLog,LocalDate> operationDateColumn;
    @javafx.fxml.FXML
    private DatePicker operationDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> operationTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<RecordGridOperationLog,String> operatorNameColumn;
    @javafx.fxml.FXML
    private TableColumn<RecordGridOperationLog,String> gridSectionColumn;
    @javafx.fxml.FXML
    private TextField operationIdTextField;
    @javafx.fxml.FXML
    private TextField operatorNameTextField;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private TableView<RecordGridOperationLog> operationLogTableView;
    @javafx.fxml.FXML
    private ComboBox<String> gridSectionComboBox;
    @javafx.fxml.FXML
    private TableColumn<RecordGridOperationLog,String> operationIdColumn;

    @javafx.fxml.FXML
    public void initialize() {
        gridSectionComboBox.getItems().addAll(
                "North Grid",
                "South Grid",
                "East Grid",
                "West Grid"
        );
        operationTypeComboBox.getItems().addAll(
                "Load Distribution",
                "Synchronization",
                "Maintenance",
                "Emergency Shutdown"
        );
        operationIdColumn.setCellValueFactory(new PropertyValueFactory<>("operationId"));

        gridSectionColumn.setCellValueFactory(new PropertyValueFactory<>("gridSection"));

        operationTypeColumn.setCellValueFactory(new PropertyValueFactory<>("operationType"));

        operationDateColumn.setCellValueFactory(new PropertyValueFactory<>("operationDate"));

        operatorNameColumn.setCellValueFactory(new PropertyValueFactory<>("operatorName"));

        operationLogTableView.setItems(RecordGridOperationLogFileHandler.readAll());
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
        operationIdTextField.clear();
        gridSectionComboBox.setValue(null);
        operationTypeComboBox.setValue(null);
        operationDatePicker.setValue(null);
        operatorNameTextField.clear();
        remarksTextArea.clear();
        operationLogTableView.getSelectionModel().clearSelection();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","gridOperator-dashboard-view.fxml","Grid Operator Dashboard");
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (operationIdTextField.getText().trim().isEmpty()) {
            showError("Please enter Operation ID.");
            return;
        }

        if (gridSectionComboBox.getValue() == null) {
            showError("Please select Grid Section.");
            return;
        }

        if (operationTypeComboBox.getValue() == null) {
            showError("Please select Operation Type.");
            return;
        }

        if (operationDatePicker.getValue() == null) {
            showError("Please select Operation Date.");
            return;
        }
        if (operationDatePicker.getValue().isBefore(LocalDate.now())) {
            showError("Operation Date cannot be in the past.");
            return;
        }

        if (operatorNameTextField.getText().trim().isEmpty()) {
            showError("Please enter Operator Name.");
            return;
        }

        String remarks = remarksTextArea.getText().trim();

        if (remarks.isEmpty()) {
            showError("Please enter Remarks.");
            return;
        }

        if (remarks.length() > 300) {
            showError("Remarks cannot exceed 300 characters.");
            return;
        }

        RecordGridOperationLog log = new RecordGridOperationLog(
                operationIdTextField.getText().trim(),
                gridSectionComboBox.getValue(),
                operationTypeComboBox.getValue(),
                operationDatePicker.getValue(),
                operatorNameTextField.getText().trim(),
                remarks
        );

        RecordGridOperationLogFileHandler.save(log);

        operationLogTableView.setItems(RecordGridOperationLogFileHandler.readAll());

        refreshButton(null);

        showSuccess("Operation Log saved successfully.");
    }
}