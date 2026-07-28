package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.SalaryPayments;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SalaryPaymentsViewController
{
    @javafx.fxml.FXML
    private TableView <SalaryPayments> salaryTableView;
    @javafx.fxml.FXML
    private TableColumn <SalaryPayments,Integer> idCol;
    @javafx.fxml.FXML
    private TableColumn <SalaryPayments,String> departmentCol;
    @javafx.fxml.FXML
    private TableColumn <SalaryPayments,Double> salaryCol;
    @javafx.fxml.FXML
    private TableColumn <SalaryPayments,String> nameCol;
    @javafx.fxml.FXML
    private TableColumn <SalaryPayments,String> paymentCol;
    @javafx.fxml.FXML
    private ComboBox <String> selectMonthComboBox;
    @javafx.fxml.FXML
    private DatePicker paymentdateDatePicker;
    @javafx.fxml.FXML
    private ComboBox <String> paymentComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        selectMonthComboBox.getItems().addAll(
                "January",
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
        paymentComboBox.getItems().addAll(
                "Bank Transfer",
                "Cash",
                "Bkash");

        idCol.setCellValueFactory(new PropertyValueFactory<>("paymentID"));
        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        paymentCol.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));


    }

    @javafx.fxml.FXML
    public void handleProcessPaymentButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleLoadSalariesButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "accountant", "accountant-dashboard-view.fxml","Accountant Dashboard");

    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {
    }
}