package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LogIncomeViewController
{
    @javafx.fxml.FXML
    private TableView salesIncomeTableView;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableColumn dateCol;
    @javafx.fxml.FXML
    private TableColumn clientNameCol;
    @javafx.fxml.FXML
    private TextField clientCompanyTextField;
    @javafx.fxml.FXML
    private TextField revenueTextField;
    @javafx.fxml.FXML
    private TableColumn unitsCol;
    @javafx.fxml.FXML
    private TextField soldTextField;
    @javafx.fxml.FXML
    private TableColumn salesIDCol;
    @javafx.fxml.FXML
    private TableColumn revenueCol;
    @javafx.fxml.FXML
    private Text totalRevenueText;

    @javafx.fxml.FXML
    public void initialize() {
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