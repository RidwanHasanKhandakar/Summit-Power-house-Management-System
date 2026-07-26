package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class AccountantDashboardViewController
{
    @javafx.fxml.FXML
    private Text officerNameText;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleTrackFuelButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "Fuel-Inventory-view.fxml","Fuel Inventory!");

    }

    @javafx.fxml.FXML
    public void handleTaxAndAuditRequestButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "Tax-And-Audit-Request-view.fxml","Tax And Audit Request!");

    }

    @javafx.fxml.FXML
    public void handleProfitLossReportsButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "Profit-Loss-Reports-view.fxml","Profit Loss Reports!");

    }

    @javafx.fxml.FXML
    public void handleFuelInventoryButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "Fuel-Inventory-view.fxml","Fuel Inventory!");

    }

    @javafx.fxml.FXML
    public void handleLogIncomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "Log-Income-view.fxml","Log Income!");

    }

    @javafx.fxml.FXML
    public void handleApprovePurchaseRequestButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "Approve-Purchase-Request-view.fxml","Approve Purchase Request!");

    }

    @javafx.fxml.FXML
    public void handleSalaryPaymentsButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "Salary-Payments-view.fxml","Salary Payments!");

    }

    @javafx.fxml.FXML
    public void handleLogoutButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","commonFiles", "log-in-view.fxml","Log in!");

    }

    @javafx.fxml.FXML
    public void handleProfileButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "Accountant-Profile-view.fxml","Accountant Profile!");

    }

    @javafx.fxml.FXML
    public void handleFinancialStatements(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "Financial-Statements-view.fxml","Financial Statements!");

    }
}