package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

public class ProfitLossReportsViewController
{
    @javafx.fxml.FXML
    private Text totalProfitLossText;
    @javafx.fxml.FXML
    private ComboBox <String> selectYearComboBox;
    @javafx.fxml.FXML
    private ComboBox <String> selectMonthComboBox;
    @javafx.fxml.FXML
    private Text totalSalesIncomeText;
    @javafx.fxml.FXML
    private Text totalFuelCostText;
    @javafx.fxml.FXML
    private Text totalExpenseText;
    @javafx.fxml.FXML
    private Text TotalSalaryCostText;

    @javafx.fxml.FXML
    public void initialize() {

        selectMonthComboBox.getItems().addAll("January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December");

        selectYearComboBox.getItems().addAll("2020",
                "2021",
                "2022",
                "2023",
                "2024");

    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "accountant", "accountant-dashboard-view.fxml", "Accountant Dashboard");

    }

    @javafx.fxml.FXML
    public void handleGenerateReportButton(ActionEvent actionEvent) {
    }
}