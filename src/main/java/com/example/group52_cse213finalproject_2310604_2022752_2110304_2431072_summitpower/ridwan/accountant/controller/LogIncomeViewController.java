package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.LogIncome;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.time.LocalDate;

public class LogIncomeViewController
{
    @javafx.fxml.FXML
    private TableView <LogIncome> salesIncomeTableView;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableColumn <LogIncome, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn <LogIncome,String> clientNameCol;
    @javafx.fxml.FXML
    private TextField clientCompanyTextField;
    @javafx.fxml.FXML
    private TextField revenueTextField;
    @javafx.fxml.FXML
    private TableColumn <LogIncome,Double> unitsCol;
    @javafx.fxml.FXML
    private TextField soldTextField;
    @javafx.fxml.FXML
    private TableColumn <LogIncome,Integer> salesIDCol;
    @javafx.fxml.FXML
    private TableColumn <LogIncome,Double> revenueCol;
    @javafx.fxml.FXML
    private Text totalRevenueText;

    @javafx.fxml.FXML
    public void initialize() {

        salesIDCol.setCellValueFactory(new PropertyValueFactory<>("saleID"));
        clientNameCol.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("transactionDate"));
        unitsCol.setCellValueFactory(new PropertyValueFactory<>("unitsSold"));
        revenueCol.setCellValueFactory(new PropertyValueFactory<>("revenueAmount"));

    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "accountant", "accountant-dashboard-view.fxml", "Accountant Dashboard");

    }

    @javafx.fxml.FXML
    public void handleLogSaleButton(ActionEvent actionEvent) {
    }
}