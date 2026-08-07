package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.FinancialSummary;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

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

    private ArrayList<FinancialSummary> allFinancialSummaries = new ArrayList<>();

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
        LocalDate from = fromDatePicker.getValue();
        LocalDate to = toDatePicker.getValue();

        ArrayList<FinancialSummary> filtered = new ArrayList<>();

        for (FinancialSummary fs : allFinancialSummaries) {
            boolean match = true;

            if (from != null && fs.getFromDate().isBefore(from)) {
                match = false;
            }
            if (to != null && fs.getToDate().isAfter(to)) {
                match = false;
            }
            if (match) {
                filtered.add(fs);
            }
        }
        financialSummaryTableView.getItems().setAll(FXCollections.observableArrayList(filtered));
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","ceo-dashboard-view.fxml","CEO Dashboard");
    }
}