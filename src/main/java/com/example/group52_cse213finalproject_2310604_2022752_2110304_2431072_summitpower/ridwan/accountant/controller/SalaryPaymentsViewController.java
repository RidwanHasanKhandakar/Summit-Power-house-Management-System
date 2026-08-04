package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.SalaryPayments;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.accountant.SalaryPaymentsFileHandler;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
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
                "Bkash",
                "Nagad");

        idCol.setCellValueFactory(new PropertyValueFactory<>("paymentID"));
        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        paymentCol.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));

        salaryTableView.setItems(SalaryPaymentsFileHandler.readAll());

    }

    @javafx.fxml.FXML
    public void handleProcessPaymentButton(ActionEvent actionEvent) {

        SalaryPayments selected = salaryTableView.getSelectionModel().getSelectedItem();

        if (selected==null){
            showError("Please select a salary payment to process.");
            return;
        }
        if (paymentComboBox.getValue()==null){
            showError("Please select a payment method.");
            return;
        }
        if (paymentdateDatePicker.getValue()==null){
            showError("Please select a payment date.");
            return;
        }
        if (selected.getPaymentStatus().equalsIgnoreCase("Paid")){
            showError("This salary payment has already been processed.");
            return;
        }

        selected.setPaymentMethod(paymentComboBox.getValue());
        selected.setPaymentDate(paymentdateDatePicker.getValue());
        selected.setPaymentStatus("Paid");
        selected.setMonth(selectMonthComboBox.getValue());

        SalaryPaymentsFileHandler.overwrite(salaryTableView.getItems());

        salaryTableView.refresh();

        showSuc("Salary payment for " + selected.getEmployeeName() + " processed successfully.");

    }

    @javafx.fxml.FXML
    public void handleLoadSalariesButton(ActionEvent actionEvent) {

        if (selectMonthComboBox.getValue()==null){
            showError("Please select a month.");
            return;
        }

        salaryTableView.setItems(SalaryPaymentsFileHandler.readAll());

        showSuc("Salary payments for " + selectMonthComboBox.getValue() + " loaded successfully.");

    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {

        paymentComboBox.getSelectionModel().clearSelection();
        selectMonthComboBox.getSelectionModel().clearSelection();
        paymentdateDatePicker.setValue(null);

        salaryTableView.getSelectionModel().clearSelection();

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "accountant", "accountant-dashboard-view.fxml","Accountant Dashboard");

    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {

        salaryTableView.setItems(SalaryPaymentsFileHandler.readAll());
        showSuc("Salary payments refreshed successfully.");

    }

    public void showSuc(String txt){

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Success!");
        a.setHeaderText(null);
        a.setContentText(txt);
        a.showAndWait();

    }

    public void showError (String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

}