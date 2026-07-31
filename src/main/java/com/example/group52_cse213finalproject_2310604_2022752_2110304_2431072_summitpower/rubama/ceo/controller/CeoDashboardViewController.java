package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

public class CeoDashboardViewController
{

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void handleSearch(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleRefresh(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleLogOut(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","commonFiles","log-in-view.fxml","Log in!1");
    }

    @javafx.fxml.FXML
    public void handleSetOrChangeTariffRates(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "rubama","ceo","tariff-management-view.fxml","Tarrif Management");
    }

    @javafx.fxml.FXML
    public void handleAddOrRemoveAnEmployee(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","employee-management-view.fxml","Employee Management");
    }

    @javafx.fxml.FXML
    public void handleViewCustomerComplaintSummary(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","complaint-summary-view.fxml","View Complaint Summary");
    }

    @javafx.fxml.FXML
    public void handleViewPlantPerformanceSummary(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","plant-performance-view.fxml","View Plant Performance");
    }

    @javafx.fxml.FXML
    public void handleViewTotalRegisteredCustomers(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "rubama","ceo","customer-summary-view.fxml", "View Registered Customers");
    }

    @javafx.fxml.FXML
    public void handleApproveFuelPurchaseRequest(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","fuel-purchase-approval.fxml","Approve Fuel Purchase Request");
    }

    @javafx.fxml.FXML
    public void handleGenerateWeeklyReport(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","weekly-report-view.fxml","View Weekly Report");
    }

    @javafx.fxml.FXML
    public void handleCheckFinancialSummary(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","financial-summary-view.fxml","View Financial Summary");
    }
}