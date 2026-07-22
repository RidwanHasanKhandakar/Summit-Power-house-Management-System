package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.PowerSupplyRecord;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.SupplyAgreement;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.PowerDemandRequestFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.PowerSupplyRecordFileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class PowerSupplyMonitoringViewController
{
    @javafx.fxml.FXML
    private TableView <PowerSupplyRecord> powerSupplyRecordsTableView;
    @javafx.fxml.FXML
    private ComboBox <String> supplyRegionComboBox;
    @javafx.fxml.FXML
    private TextArea recordDetailsTextArea;
    @javafx.fxml.FXML
    private TableColumn <PowerSupplyRecord,String> regionCol;
    @javafx.fxml.FXML
    private TableColumn <PowerSupplyRecord,String> statusCol;
    @javafx.fxml.FXML
    private TableColumn <PowerSupplyRecord,String> consumerNameCol;
    @javafx.fxml.FXML
    private ComboBox <String> supplyStatusComboBox;
    @javafx.fxml.FXML
    private TableColumn <PowerSupplyRecord,Double> supplyCapacityCol;
    @javafx.fxml.FXML
    private TextField searchRecordTextField;
    @javafx.fxml.FXML
    private TableColumn <PowerSupplyRecord, LocalDate> supplyDateCol;
    @javafx.fxml.FXML
    private TableColumn <PowerSupplyRecord,String> recordIDCol;

    @javafx.fxml.FXML
    public void initialize() {

        supplyRegionComboBox.getItems().addAll(
                "All",
                "Dhaka",
                "Chattogram",
                "Khulna",
                "Rajshahi",
                "Sylhet",
                "Barishal",
                "Rangpur",
                "Mymensingh",
                "Tangail");
        supplyStatusComboBox.getItems().addAll(
                "All",
                "Normal",
                "Interrupted",
                "Maintenance",
                "Completed");

        supplyStatusComboBox.setValue("All");
        supplyRegionComboBox.setValue("All");

        recordIDCol.setCellValueFactory(new PropertyValueFactory<>("recordId"));
        consumerNameCol.setCellValueFactory(new PropertyValueFactory<>("consumerName"));
        regionCol.setCellValueFactory(new PropertyValueFactory<>("region"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        supplyCapacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        supplyDateCol.setCellValueFactory(new PropertyValueFactory<>("supplyDate"));

        //powerSupplyRecordsTableView.setItems(readAgreement());
        loadTable();

    }

    private void loadTable(){
        ObservableList<PowerSupplyRecord> list = FXCollections.observableArrayList();
        list.addAll(PowerSupplyRecordFileHandler.readAll());
        powerSupplyRecordsTableView.setItems(list);
    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"bpdbOfficer","bpdbOfficer-dashboard-view.fxml", "BPDB Officer Dashboard!");
    }

    @javafx.fxml.FXML
    public void handleSearchButton(ActionEvent actionEvent) {

        String keyword = searchRecordTextField.getText().trim().toLowerCase();
        String region = supplyRegionComboBox.getValue();
        String status = supplyStatusComboBox.getValue();

        ObservableList<PowerSupplyRecord> filtered = FXCollections.observableArrayList();

        for (PowerSupplyRecord record : PowerSupplyRecordFileHandler.readAll()){
            boolean match = true;

            if (!keyword.isEmpty()){
                if (!(record.getRecordId().toLowerCase().contains(keyword)||record.getConsumerName().toLowerCase().contains(keyword))){
                    match=false;
                }
            }

            if (!region.equals("All")&&!record.getRegion().equals(region)){
                match=false;
            }

            if (!status.equals("All")&&!record.getStatus().equals(status)){
                match=false;
            }

            if (match){
                filtered.add(record);
            }
        }

        powerSupplyRecordsTableView.setItems(filtered);

    }

    @javafx.fxml.FXML
    public void handleViewDetailsButton(ActionEvent actionEvent) {

        PowerSupplyRecord selected = powerSupplyRecordsTableView.getSelectionModel().getSelectedItem();
        if(selected==null){
            showError("Please select a record!");
            return;
        }
        recordDetailsTextArea.setText(
                "Record ID : "+selected.getRecordId()+"\n\n"+
                "Consumer Name : "+selected.getConsumerName()+"\n\n"+
                "Capacity : "+selected.getCapacity()+"MW\n\n"+
                "Status : "+selected.getStatus()+"\n\n"+
                "Region : "+selected.getRegion()+"\n\n"+
                "Supply Date : "+selected.getSupplyDate()+"\n\n"+
                "Remarks : "+selected.getRemarks());
    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {

        searchRecordTextField.clear();
        //powerSupplyRecordsTableView.setItems(readAgreement());
        recordDetailsTextArea.clear();

        supplyRegionComboBox.setValue("All");
        supplyStatusComboBox.setValue("All");

        loadTable();

    }

    public void showError(String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

}