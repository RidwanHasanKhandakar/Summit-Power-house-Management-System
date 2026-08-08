package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.ContractPerformance;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.bpdbOfficer.ContractPerformanceFileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.Locale;

public class ContractPerformanceViewController
{
    @javafx.fxml.FXML
    private TableColumn <ContractPerformance,Double> suppliedCapCol;
    @javafx.fxml.FXML
    private TextField contractIDTextField;
    @javafx.fxml.FXML
    private TextArea viewPerformanceTextArea;
    @javafx.fxml.FXML
    private TextField consumerNameTextField;
    @javafx.fxml.FXML
    private TableColumn <ContractPerformance, LocalDate> startDateCol;
    @javafx.fxml.FXML
    private TableColumn <ContractPerformance,String> statusCol;
    @javafx.fxml.FXML
    private ComboBox <String> statusComboBox;
    @javafx.fxml.FXML
    private TableColumn <ContractPerformance,String> consumerNameCol;
    @javafx.fxml.FXML
    private TableColumn <ContractPerformance,Double> contractedCapCol;
    @javafx.fxml.FXML
    private TableColumn <ContractPerformance,String> contractIDCol;
    @javafx.fxml.FXML
    private TableView <ContractPerformance> contractPerformanceTableView;
    @javafx.fxml.FXML
    private TableColumn <ContractPerformance,LocalDate> EndDateCol;

    @javafx.fxml.FXML
    public void initialize() {

        statusComboBox.getItems().addAll(
                "All",
                "Active",
                "Inactive",
                "Terminated"
        );

        contractIDCol.setCellValueFactory(new PropertyValueFactory<>("contractID"));
        consumerNameCol.setCellValueFactory(new PropertyValueFactory<>("consumerName"));
        contractedCapCol.setCellValueFactory(new PropertyValueFactory<>("contractedCapacity"));
        suppliedCapCol.setCellValueFactory(new PropertyValueFactory<>("suppliedCapacity"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("contractedStartDate"));
        EndDateCol.setCellValueFactory(new PropertyValueFactory<>("contractedEndDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        //statusComboBox.setItems("All");
        loadTabel();

    }

    private void loadTabel() {
        contractPerformanceTableView.setItems(ContractPerformanceFileHandler.readAll());
    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "bpdbOfficer", "bpdbOfficer-dashboard-view.fxml","BPDB Officer Dashboard");

    }

    @javafx.fxml.FXML
    public void handleViewPerformanceButton(ActionEvent actionEvent) {

        ContractPerformance contract = contractPerformanceTableView.getSelectionModel().getSelectedItem();

        if (contract==null){
            showError("Please select a ontract.");
            return;
        }

        double fulfillment = (contract.getSuppliedCapacity()/contract.getContractedCapacity())*100;

        viewPerformanceTextArea.setText(
                "Contract ID : "+contract.getContractID()+"\n"+
                        "Consumer : "+contract.getConsumerName()+"\n"+
                        "Contracted Capacity : "+contract.getContractedCapacity()+"MW\n"+
                        "Supplied Capacity : "+contract.getSuppliedCapacity()+"MW\n"+
                        "Fulfillment : "+String.format("%.2f",fulfillment)+"%\n"+
                        "Status : "+contract.getStatus()+"\n"+
                        "Contract Start : "+contract.getContractStartDate()+"\n"+
                        "Contract End : "+contract.getContractEndDate()
        );

    }

    @javafx.fxml.FXML
    public void handleSearchButton(ActionEvent actionEvent) {

        String contractID = contractIDTextField.getText().trim().toLowerCase();
        String consumerName = consumerNameTextField.getText().trim().toLowerCase();
        String status = statusComboBox.getValue();

        ObservableList<ContractPerformance> all = ContractPerformanceFileHandler.readAll();

        ObservableList<ContractPerformance> filtered = FXCollections.observableArrayList();

        for (ContractPerformance contract : all){

            boolean matchID = contractID.isEmpty() || contract.getContractID().toLowerCase().contains(contractID);
            boolean matchConsumer = consumerName.isEmpty()||contract.getConsumerName().toLowerCase().contains(consumerName);
            boolean matchStatus = status ==null || status.equals("All")||contract.getStatus().equalsIgnoreCase(status);

            if(matchID&&matchConsumer&&matchStatus){
                filtered.add(contract);
            }

        }

        contractPerformanceTableView.setItems(filtered);

    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {

        contractIDTextField.clear();
        consumerNameTextField.clear();
        statusComboBox.setValue("All");
        viewPerformanceTextArea.clear();

        loadTabel();

    }

    public void showError(String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

}