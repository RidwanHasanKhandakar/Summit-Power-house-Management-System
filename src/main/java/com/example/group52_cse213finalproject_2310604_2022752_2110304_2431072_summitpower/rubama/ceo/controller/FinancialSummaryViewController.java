package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.FinancialSummary;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class FinancialSummaryViewController
{
    @javafx.fxml.FXML
    private TableView <FinancialSummary> financialSummaryTableView;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private TableColumn <FinancialSummary,Integer> operationalCostCol;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private TableColumn <FinancialSummary,Integer> fuelCostCol;
    @javafx.fxml.FXML
    private TableColumn <FinancialSummary,String> revenueCol;
    @javafx.fxml.FXML
    private TableColumn <FinancialSummary,LocalDate> toDateCol;
    @javafx.fxml.FXML
    private TableColumn <FinancialSummary,LocalDate> fromDateCol;

    @javafx.fxml.FXML
    public void initialize() {
        fromDateCol.setCellValueFactory(new PropertyValueFactory<>("fromDate"));
        toDateCol.setCellValueFactory(new PropertyValueFactory<>("toDate"));
        revenueCol.setCellValueFactory(new PropertyValueFactory<>("revenue"));
        operationalCostCol.setCellValueFactory(new PropertyValueFactory<>("operationalCost"));
        fuelCostCol.setCellValueFactory(new PropertyValueFactory<>("fuelCost"));
    }

    @javafx.fxml.FXML
    public void handleLoadFinancialSummary(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","ceo-dashboard-view.fxml","CEO Dashboard");
    }
}