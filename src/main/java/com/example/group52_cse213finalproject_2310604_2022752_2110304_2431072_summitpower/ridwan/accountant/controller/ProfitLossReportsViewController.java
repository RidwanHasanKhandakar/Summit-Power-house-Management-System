package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.*;
//import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.accountant.ProfitLossReportFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.accountant.LogIncomeFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.accountant.PurchaseRequestFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.accountant.SalaryPaymentsFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.accountant.TrackFuelFileHandler;
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

        String month = selectMonthComboBox.getValue();
        String year = selectYearComboBox.getValue();

        double salesIncome = 0;
        //double expenses = 0;
        double salaryCost = 0;
        double fuelCost = 0;
        double otherExpenses=0;



        //Sale
        for (LogIncome income: LogIncomeFileHandler.readAll()){
            if (income.getTransactionDate()!=null
                    &&
                income.getTransactionDate().getMonth().toString().equalsIgnoreCase(month)
                    &&
                String.valueOf(income.getTransactionDate().getYear()).equals(year)){
                salesIncome+=income.getRevenueAmount();
            }

        }

        //fuel
        for (TrackFuel fuel : TrackFuelFileHandler.readAll()) {

            if (fuel.getExpenseDate() != null &&
                    fuel.getExpenseDate().getMonth().toString().equalsIgnoreCase(month) &&
                    String.valueOf(fuel.getExpenseDate().getYear()).equals(year)) {

                fuelCost += fuel.getAmount();
            }
        }

        //sal
        for (SalaryPayments salary : SalaryPaymentsFileHandler.readAll()) {

            if (salary.getPaymentDate() != null &&
                    salary.getPaymentStatus().equalsIgnoreCase("Paid") &&
                    salary.getPaymentDate().getMonth().toString().equalsIgnoreCase(month) &&
                    String.valueOf(salary.getPaymentDate().getYear()).equals(year)) {

                salaryCost += salary.getSalary();
            }
        }

        //purchase req [approved]
        for (PurchaseRequest request : PurchaseRequestFileHandler.readAll()) {

            if (request.getRequestDate() != null &&
                    request.getStatus().equalsIgnoreCase("Approved") &&
                    request.getRequestDate().getMonth().toString().equalsIgnoreCase(month) &&
                    String.valueOf(request.getRequestDate().getYear()).equals(year)) {

                otherExpenses += request.getCost();
            }
        }


        //double profitLoss = salesIncome - (expenses + salaryCost + fuelCost);
        double totalEx = fuelCost+salaryCost+otherExpenses;
        double profitLoss=salesIncome-totalEx;

//        ProfitLossReports report = new
//                ProfitLossReports(selectMonthComboBox.getValue(),selectYearComboBox.getValue(),salesIncome,expenses,salaryCost,fuelCost,profitLoss);

        //ProfitLossReportFileHandler.save(report);

        totalSalesIncomeText.setText(String.format("%.2f", salesIncome));
        totalFuelCostText.setText(String.format("%.2f", fuelCost));
        TotalSalaryCostText.setText(String.format("%.2f", salaryCost));
        totalExpenseText.setText(String.format("%.2f", otherExpenses));
        totalProfitLossText.setText(String.format("%.2f", profitLoss));

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