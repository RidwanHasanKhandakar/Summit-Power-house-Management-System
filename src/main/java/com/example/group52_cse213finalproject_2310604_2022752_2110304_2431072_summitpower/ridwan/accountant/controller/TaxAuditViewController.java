package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.TaxAudit;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.accountant.TaxAuditFileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class TaxAuditViewController
{
    @javafx.fxml.FXML
    private ComboBox <String> yearComboBox;
    @javafx.fxml.FXML
    private TableColumn <TaxAudit,String> titleCol;
    @javafx.fxml.FXML
    private Label titleLabel;
    @javafx.fxml.FXML
    private TableView <TaxAudit> taxAndAuditTableView;
    @javafx.fxml.FXML
    private Label createdDateLabel;
    @javafx.fxml.FXML
    private TextField searchTextField;
    @javafx.fxml.FXML
    private Label recordTypeLabel;
    @javafx.fxml.FXML
    private TableColumn <TaxAudit,Integer> recordIDCol;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private ComboBox <String> recordTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn <TaxAudit,String> recordTypeCol;
    @javafx.fxml.FXML
    private TableColumn <TaxAudit,String> yearCol;
    @javafx.fxml.FXML
    private TableColumn <TaxAudit, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn <TaxAudit,String> statusCol;
    @javafx.fxml.FXML
    private Label recordIDLabel;

    @javafx.fxml.FXML
    public void initialize() {

        recordTypeComboBox.getItems().addAll(
                "All",
                "Tax Record",
                "Audit Record"
        );

        yearComboBox.getItems().addAll(
                "All",
                "2020",
                "2021",
                "2022",
                "2023",
                "2024",
                "2025",
                "2026"
        );

        recordIDCol.setCellValueFactory(new PropertyValueFactory<>("recordId"));
        recordTypeCol.setCellValueFactory(new PropertyValueFactory<>("recordType"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("createdDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        taxAndAuditTableView.setItems(TaxAuditFileHandler.readAll());

    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {

        recordTypeComboBox.getSelectionModel().clearSelection();
        yearComboBox.getSelectionModel().clearSelection();

        searchTextField.clear();

        recordIDLabel.setText(" ");
        recordTypeLabel.setText(" ");
        titleLabel.setText(" ");
        createdDateLabel.setText(" ");
        statusLabel.setText(" ");

        taxAndAuditTableView.getSelectionModel().clearSelection();

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "accountant", "accountant-dashboard-view.fxml","Accountant Dashboard");

    }

    @javafx.fxml.FXML
    public void handleLoadRecordsButton(ActionEvent actionEvent) {

        if (recordTypeComboBox.getValue()==null){
            showErr("Please select a record type.");
            return;
        }
        if (yearComboBox.getValue()==null){
            showErr("Please select a year.");
            return;
        }

        ObservableList<TaxAudit> filteredList = FXCollections.observableArrayList();

        for (TaxAudit rec : TaxAuditFileHandler.readAll()){
            boolean matchedType = recordTypeComboBox.getValue().equals("All") || rec.getRecordType().equals(recordTypeComboBox.getValue());
            boolean yearMatched = yearComboBox.getValue().equals("All") || rec.getYear().equals(yearComboBox.getValue());
            boolean searchMatched = searchTextField.getText().isEmpty() || rec.getTitle().toLowerCase().contains(searchTextField.getText().trim().toLowerCase());

            if (matchedType&&yearMatched&&searchMatched){
                filteredList.add(rec);
            }
        }

        taxAndAuditTableView.setItems(filteredList);
        showInfo(filteredList.size()+" record(s) found.");

    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {

        taxAndAuditTableView.setItems(TaxAuditFileHandler.readAll());
        showInfo("Table refreshed.");

    }

    @javafx.fxml.FXML
    public void handleViewDetailsButton(ActionEvent actionEvent) {

        TaxAudit selected = taxAndAuditTableView.getSelectionModel().getSelectedItem();

        if (selected==null){
            showErr("Please select a record.");
            return;
        }

        recordIDLabel.setText(String.valueOf(selected.getRecordId()));
        recordTypeLabel.setText(selected.getRecordType());
        titleLabel.setText(selected.getTitle());
        createdDateLabel.setText(String.valueOf(selected.getCreatedDate()));
        statusLabel.setText(selected.getStatus());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Record Details");
        alert.setHeaderText("Details of Record ID: " + selected.getRecordId());
        alert.setContentText(selected.getDetails());
        alert.showAndWait();

    }

    public void showErr(String txt){

        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error!");
        a.setHeaderText(null);
        a.setContentText(txt);
        a.showAndWait();

    }

    public void showInfo(String txt){

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information");
        a.setHeaderText(null);
        a.setContentText(txt);
        a.showAndWait();

    }

}