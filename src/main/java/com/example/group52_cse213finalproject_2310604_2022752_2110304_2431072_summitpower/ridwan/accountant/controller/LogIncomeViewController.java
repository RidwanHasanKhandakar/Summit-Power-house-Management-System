package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.LogIncome;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.accountant.LogIncomeFileHandler;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
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

    private int saleCounter = 1;

    @javafx.fxml.FXML
    public void initialize() {

        salesIDCol.setCellValueFactory(new PropertyValueFactory<>("saleID"));
        clientNameCol.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("transactionDate"));
        unitsCol.setCellValueFactory(new PropertyValueFactory<>("unitsSold"));
        revenueCol.setCellValueFactory(new PropertyValueFactory<>("revenueAmount"));

        loadData();

    }

    private void loadData(){

        ObservableList<LogIncome> list = LogIncomeFileHandler.readAll();
        salesIncomeTableView.setItems(list);
        if (!list.isEmpty()){
            saleCounter=list.get(list.size()-1).getSaleID()+1;
        }
        calculateTotalRevenue();

    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {

        clientCompanyTextField.clear();
        soldTextField.clear();
        revenueTextField.clear();
        dateDatePicker.setValue(null);

        salesIncomeTableView.getSelectionModel().clearSelection();

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "accountant", "accountant-dashboard-view.fxml", "Accountant Dashboard");

    }

    @javafx.fxml.FXML
    public void handleLogSaleButton(ActionEvent actionEvent) {

        if (clientCompanyTextField.getText().isEmpty() || soldTextField.getText().isEmpty() || revenueTextField.getText().isEmpty() || dateDatePicker.getValue() == null) {
            showError("Please fill in all fields before logging a sale.");
            return;
        }

        double unitSold;
        double revenueAmount;

        try{
            unitSold = Double.parseDouble(soldTextField.getText().trim());
            revenueAmount = Double.parseDouble(revenueTextField.getText().trim());
        }
        catch (NumberFormatException e){
            showError("Please enter valid numbers for units sold and revenue amount.");
            return;
        }

        if (unitSold <= 0 || revenueAmount <= 0) {
            showError("Units sold and revenue amount must be greater than zero.");
            return;
        }

        LogIncome income = new LogIncome(saleCounter++, clientCompanyTextField.getText().trim(), unitSold, revenueAmount, dateDatePicker.getValue());

        LogIncomeFileHandler.save(income);

        //salesIncomeTableView.setItems(LogIncomeFileHandler.readAll());

        loadData();

        //calculateTotalRevenue();

        showSuc("Electricity sale logged successfully!");

        handleClearButton(null);

    }

    private void calculateTotalRevenue() {

        double totalRevenue = 0;
        for (LogIncome income : LogIncomeFileHandler.readAll()) {
            totalRevenue += income.getRevenueAmount();
        }

        totalRevenueText.setText(String.format("%.2f", totalRevenue));

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