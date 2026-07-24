package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.Invoice;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.InvoicesFileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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

        idCol.setCellValueFactory(new PropertyValueFactory<>("invoiceId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("consumerName"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dueDateCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        paymentCol.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));

        loadTable();

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"bpdbOfficer", "bpdbOfficer-dashboard-view.fxml", "BPDB Officer Dashboard!");
    }

    @javafx.fxml.FXML
    public void handleReloadTableButton(ActionEvent actionEvent) {

        invoicesIdTextField.clear();
        viewDetailsTextArea.clear();
        loadTable();

    }

    @javafx.fxml.FXML
    public void handleViewDetailsButton(ActionEvent actionEvent) {

        Invoice selected = invoicesTableView.getSelectionModel().getSelectedItem();

        if(selected==null){
            showError("Please select an invoice.");
            return;
        }
        viewDetailsTextArea.setText("Invoice ID : "+selected.getInvoiceId()+"\n"+
                "Consumer Name : "+selected.getConsumerName()+"\n"+
                "Amount : "+selected.getAmount()+"\n"+
                "Due Date : "+selected.getDueDate()+"\n"+
                "Payment Date : "+selected.getPaymentDate()+"\n"+
                "Payment Status : "+selected.getPaymentStatus()+"\n"+
                "Details : "+selected.getRemarks()
        );

    }

    @javafx.fxml.FXML
    public void handleFilterInvoicesButton(ActionEvent actionEvent) {

        String keyWord = invoicesIdTextField.getText().trim().toLowerCase();
        ObservableList<Invoice> all = InvoicesFileHandler.readAll();
        ObservableList<Invoice> filtered = FXCollections.observableArrayList();
        for (Invoice invoice : all){
            if(keyWord.isEmpty()||invoice.getInvoiceId().toLowerCase().contains(keyWord)||invoice.getConsumerName().toLowerCase().contains(keyWord)){
                filtered.add(invoice);
            }
        }

        invoicesTableView.setItems(filtered);

    }

    public void loadTable(){
        invoicesTableView.setItems(InvoicesFileHandler.readAll());
    }

    public void showError(String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

}