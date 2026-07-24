package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.Invoice;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.time.LocalDate;

public class InvoicesViewController
{
    @javafx.fxml.FXML
    private TableView <Invoice> invoicesTableView;
    @javafx.fxml.FXML
    private TextField consumerNameTextField;
    @javafx.fxml.FXML
    private TableColumn <Invoice,String> idCol;
    @javafx.fxml.FXML
    private TableColumn <Invoice, LocalDate> dueDateCol;
    @javafx.fxml.FXML
    private TableColumn <Invoice,Double> amountCol;
    @javafx.fxml.FXML
    private TableColumn <Invoice,String> statusCol;
    @javafx.fxml.FXML
    private TextField invoicesIdTextField;
    @javafx.fxml.FXML
    private ComboBox <String> paymentStatusComboBox;
    @javafx.fxml.FXML
    private TableColumn <Invoice,String> nameCol;
    @javafx.fxml.FXML
    private TableColumn <Invoice,Double> paymentCol;
    @javafx.fxml.FXML
    private TextArea viewDetailsTextArea;

    @javafx.fxml.FXML
    public void initialize() {

        paymentStatusComboBox.getItems().addAll(
                "All",
                "Paid",
                "Pending",
                "Overdue",
                "Partially paid");

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"bpdbOfficer", "Invoices-view.fxml", "Invoices!");
    }

    @javafx.fxml.FXML
    public void handleReloadTableButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleViewDetailsButton(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void handleFilterInvoicesButton(ActionEvent actionEvent) {
    }
}