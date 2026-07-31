package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.RecordGridOperationLog;
import javafx.event.ActionEvent;
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
        operationIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("operationId"));

        gridSectionColumn.setCellValueFactory(
                new PropertyValueFactory<>("gridSection"));

        operationTypeColumn.setCellValueFactory(
                new PropertyValueFactory<>("operationType"));

        operationDateColumn.setCellValueFactory(
                new PropertyValueFactory<>("operationDate"));

        operatorNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("operatorName"));
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
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}