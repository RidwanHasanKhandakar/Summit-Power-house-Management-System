package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.AdditionalPowerRequest;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class AdditionalPowerRequestViewController
{
    @javafx.fxml.FXML
    private TextField additionalCapacityTextField;
    @javafx.fxml.FXML
    private DatePicker endDateDatePicker;
    @javafx.fxml.FXML
    private TextArea justificationTextArea;
    @javafx.fxml.FXML
    private TextField requestIDTextField;
    @javafx.fxml.FXML
    private DatePicker startDateDatePicker;

    private static int requestCounter = 1001;

    @javafx.fxml.FXML
    public void initialize() {

        requestIDTextField.setEditable(false);
        requestIDTextField.setText("ASR- "+requestCounter);

    }

    @javafx.fxml.FXML
    public void handleSubmitRequestButton(ActionEvent actionEvent) {

        double capacity;

        try {
            capacity = Double.parseDouble(additionalCapacityTextField.getText());
            if (capacity <= 0) {
                showError("Please enter a positive power capacity");
                return;
            }
        } catch (NumberFormatException e) {
            showError("Please enter a valid power capacity");
            return;
        }

        LocalDate startDate = startDateDatePicker.getValue();
        LocalDate endDate = endDateDatePicker.getValue();
        String justification = justificationTextArea.getText().trim();

        if (startDate==null){
            showError("Please select a start date.");
            return;
        }
        if (startDate.isBefore(LocalDate.now())) {
            showError("Start date cannot be in the past.");
            return;
        }
        if (endDate==null){
            showError("Please select an end date.");
            return;
        }
        if (!endDate.isAfter(startDate)) {
            showError("End date must be after start date.");
            return;
        }
        if (justification.isEmpty()) {
            showError("Please provide a justification for the additional power request.");
            return;
        }
        if (justification.length()<10){
            showError("Justification must be at least 10 characters long.");
            return;
        }
        if (justification.length()>300){
            showError("Justification must not exceed 300 characters.");
            return;
        }

        AdditionalPowerRequest request = new AdditionalPowerRequest(requestIDTextField.getText(), capacity, startDate, endDate, justification,"Pending");

        showSuc("Additional Power Request Submitted Successfully!");

        requestCounter++;
        requestIDTextField.setText("ASR-"+requestCounter);

        handleClearButton(null);

    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {

        additionalCapacityTextField.clear();
        startDateDatePicker.setValue(null);
        endDateDatePicker.setValue(null);
        justificationTextArea.clear();

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((javafx.scene.Node) actionEvent.getSource(),"ridwan","bpdbOfficer","bpdbOfficer-dashboard-view.fxml","BPDB Officer Dashboard");

    }

    public void showSuc(String txt){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

    public void showError(String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

}