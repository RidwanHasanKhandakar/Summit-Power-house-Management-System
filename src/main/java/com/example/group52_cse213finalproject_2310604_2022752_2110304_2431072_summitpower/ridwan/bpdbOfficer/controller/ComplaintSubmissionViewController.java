package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.Complaint;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.bpdbOfficer.ComplaintFileHandler;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.time.LocalDate;

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

    private static int complaintCounter = 1001;

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

        //statusComboBox.setItems("Pending");

        complaintIdTextField.setEditable(false);
        complaintIdTextField.setText("COM- "+complaintCounter);

    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {

        complaintCategoryComboBox.setValue(null);
        complaintDetailsTextArea.clear();
        affectedSupplyDateDatePicker.setValue(null);

        statusComboBox.setValue("pending");

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","bpdbOfficer","bpdbOfficer-dashboard-view","BPDB Officer Dashboard");

    }

    @javafx.fxml.FXML
    public void handleSubmitComplaintButton(ActionEvent actionEvent) {

        String id = complaintIdTextField.getText();;
        String category = complaintCategoryComboBox.getValue();
        String details = complaintDetailsTextArea.getText().trim();
        LocalDate affectedDate = affectedSupplyDateDatePicker.getValue();
        String status = statusComboBox.getValue();

        if (category==null){
            showError("Please select a complaint category.");
            return;
        }
        if (details.isEmpty()){
            showError("Please enter complaint details.");
            return;
        }
        if (details.length() < 10){
            showError("Complaint details must be at least 10 characters long.");
            return;
        }
        if (details.length() > 300){
            showError("Complaint details must not exceed 300 characters.");
            return;
        }
        if (affectedDate==null){
            showError("Please select the affected supply date.");
            return;
        }
        if (affectedDate.isAfter(LocalDate.now())){
            showError("Affected supply date cannot be in the future.");
            return;
        }
        if (status==null){
            showError("Please select a complaint status.");
            return;
        }

        Complaint complaint = new Complaint(id, category, details, affectedDate, status);

        //ComplaintFileHandler.save(complaint);

        showSuc("Complaint submitted successfully!");

        complaintCounter++;
        complaintIdTextField.setText("COM- "+complaintCounter);

        handleClearButton(null);

    }

    public void showError(String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
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