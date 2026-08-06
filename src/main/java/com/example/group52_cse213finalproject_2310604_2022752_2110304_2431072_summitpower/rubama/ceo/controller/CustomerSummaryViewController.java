package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.CustomerSummary;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerSummaryViewController
{
    @javafx.fxml.FXML
    private TableColumn <CustomerSummary,String> industrialCustomersCol;
    @javafx.fxml.FXML
    private TableColumn <CustomerSummary,String> residentialCustomersCol;
    @javafx.fxml.FXML
    private TableView <CustomerSummary> customerSummaryTableView;
    @javafx.fxml.FXML
    private TableColumn <CustomerSummary,String> commercialCustomersCol;
    @javafx.fxml.FXML
    private DatePicker customerJoiningDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn <CustomerSummary,LocalDate> joiningDateCol;

    private ArrayList<CustomerSummary> allCustomerSummaries = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        joiningDateCol.setCellValueFactory(new PropertyValueFactory<>("customerJoiningDate"));
        commercialCustomersCol.setCellValueFactory(new PropertyValueFactory<>("commercialCustomers"));
        industrialCustomersCol.setCellValueFactory(new PropertyValueFactory<>("industrialCustomers"));
        residentialCustomersCol.setCellValueFactory(new PropertyValueFactory<>("residentialCustomers"));
    }

    @javafx.fxml.FXML
    public void handleShowCustomerSummary(ActionEvent actionEvent) {
        LocalDate selectedDate = customerJoiningDateDatePicker.getValue();

        ArrayList<CustomerSummary> filtered = new ArrayList<>();

        if (selectedDate == null) {
            filtered.addAll(allCustomerSummaries);
        } else {
            for (CustomerSummary cs : allCustomerSummaries) {
                if (cs.getCustomerJoiningDate().equals(selectedDate)) {
                    filtered.add(cs);
                }
            }
        }
        customerSummaryTableView.getItems().setAll(FXCollections.observableArrayList(filtered));
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","ceo-dashboard-view.fxml","CEO Dashboard");
    }
}