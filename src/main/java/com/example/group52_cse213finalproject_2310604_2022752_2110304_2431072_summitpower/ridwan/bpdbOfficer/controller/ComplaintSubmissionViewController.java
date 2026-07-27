package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ComplaintSubmissionViewController
{
    @javafx.fxml.FXML
    private ComboBox <String> statusComboBox;
    @javafx.fxml.FXML
    private TextField complaintIdTextField;
    @javafx.fxml.FXML
    private TextArea complaintDetailsTextArea;
    @javafx.fxml.FXML
    private DatePicker affectedSupplyDateDatePicker;
    @javafx.fxml.FXML
    private ComboBox <String> complaintCategoryComboBox;

    @javafx.fxml.FXML
    public void initialize() {

        complaintCategoryComboBox.getItems().addAll(
                "Billing Issue",
                "Service Interruption",
                "Metering Problem",
                "Safety Concern",
                "Customer Service Complaint",
                "Technical Issue",
                "Payment Dispute",
                "Equipment Malfunction",
                "Environmental Concern",
                "Other"
        );

        statusComboBox.getItems().addAll(
                "Pending",
                "In Progress",
                "Resolved",
                "Closed"
        );

    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSubmitComplaintButton(ActionEvent actionEvent) {
    }
}