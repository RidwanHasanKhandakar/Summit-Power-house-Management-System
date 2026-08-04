package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.ProfitLossReports;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.accountant.ProfitLossReportFileHandler;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
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

        selectMonthComboBox.getSelectionModel().clearSelection();
        selectYearComboBox.getSelectionModel().clearSelection();

        totalSalesIncomeText.setText("");
        totalExpenseText.setText("");
        TotalSalaryCostText.setText("");
        totalFuelCostText.setText("");
        totalProfitLossText.setText("");

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "accountant", "accountant-dashboard-view.fxml", "Accountant Dashboard");

    }

    @javafx.fxml.FXML
    public void handleGenerateReportButton(ActionEvent actionEvent) {

        if (selectMonthComboBox.getValue()==null || selectYearComboBox.getValue()==null){
            showError("Please select a month and year.");
            return;
        }

        double salesIncome = 2500000;
        double expenses = 450000;
        double salaryCost = 320000;
        double fuelCost = 900000;

        double profitLoss = salesIncome - (expenses + salaryCost + fuelCost);

        ProfitLossReports report = new
                ProfitLossReports(selectMonthComboBox.getValue(),selectYearComboBox.getValue(),salesIncome,expenses,salaryCost,fuelCost,profitLoss);

        ProfitLossReportFileHandler.save(report);

        totalSalesIncomeText.setText(String.format("%.2f",salesIncome));
        totalExpenseText.setText(String.format("%.2f",expenses));
        TotalSalaryCostText.setText(String.format("%.2f",salaryCost));
        totalFuelCostText.setText(String.format("%.2f",fuelCost));
        totalProfitLossText.setText(String.format("%.2f",profitLoss));

        showSuc("Profit and Loss Report generated successfully!");
    }

    public void showError(String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

    public void showSuc(String txt){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

}