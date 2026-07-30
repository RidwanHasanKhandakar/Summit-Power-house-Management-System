package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.ComplaintSummary;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ComplaintSummaryViewController
{
    @javafx.fxml.FXML
    private Label viewComplaintSummaryLabel;
    @javafx.fxml.FXML
    private DatePicker dateOfComplaintDatePicker;
    @javafx.fxml.FXML
    private TableColumn <ComplaintSummary,String> complaintIdCol;
    @javafx.fxml.FXML
    private TableColumn <ComplaintSummary,String> statusCol;
    @javafx.fxml.FXML
    private ComboBox <String> statusComboBox;
    @javafx.fxml.FXML
    private TextField customerIdTextField;
    @javafx.fxml.FXML
    private TableColumn <ComplaintSummary,LocalDate> dateOfComplaintCol;
    @javafx.fxml.FXML
    private TableColumn <ComplaintSummary,String> customerIdCol;
    @javafx.fxml.FXML
    private TableView <ComplaintSummary> complaintTableView;
    @javafx.fxml.FXML
    private TableColumn <ComplaintSummary,String> descriptionCol;

    @javafx.fxml.FXML
    public void initialize() {
        statusComboBox.getItems().addAll("Resolved", "Unresolved", "Pending");

        customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        complaintIdCol.setCellValueFactory(new PropertyValueFactory<>("complaintId"));
        dateOfComplaintCol.setCellValueFactory(new PropertyValueFactory<>("dateOfComplaint"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void handleComplaintSummary(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleViewComplaints(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
    }
}