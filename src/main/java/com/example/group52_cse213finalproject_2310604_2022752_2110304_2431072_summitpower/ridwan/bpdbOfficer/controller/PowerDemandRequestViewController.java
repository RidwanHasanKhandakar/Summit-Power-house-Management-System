package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.PowerDemandRequest;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.bpdbOfficer.PowerDemandRequestFileHandler;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class PowerDemandRequestViewController {

    @javafx.fxml.FXML
    private TextField reqCapacityTextField;

    @javafx.fxml.FXML
    private ComboBox<String> purposeOfDemandComboBox;

    @javafx.fxml.FXML
    private TextArea remarksTextArea;

    @javafx.fxml.FXML
    private ComboBox<String> priorityLavelComboBox;

    @javafx.fxml.FXML
    private DatePicker EndDateDatePicker;

    @javafx.fxml.FXML
    private DatePicker startDateDatePicker;

    @javafx.fxml.FXML
    private TextField reqIdTextField;


    @javafx.fxml.FXML
    public void initialize() {

        // Generate request ID from existing records
        reqIdTextField.setText(
                PowerDemandRequestFileHandler.generateNextRequestId()
        );

        reqIdTextField.setEditable(false);


        priorityLavelComboBox.getItems().addAll(
                "Low",
                "Medium",
                "High",
                "Emergency"
        );


        purposeOfDemandComboBox.getItems().addAll(
                "Residential Supply",
                "Industrial Supply",
                "Commercial Supply",
                "Agricultural Supply",
                "Emergency Supply",
                "Other"
        );
    }


    @javafx.fxml.FXML
    public void handleSubmitRequestButton(ActionEvent actionEvent) {

        double capacity;

        // Validate capacity
        try {

            capacity = Double.parseDouble(
                    reqCapacityTextField.getText().trim()
            );

        } catch (NumberFormatException e) {

            showError("Please enter a valid power capacity.");
            return;
        }


        if (capacity <= 0) {

            showError("Please enter a valid power capacity.");
            return;
        }


        // Validate start date
        LocalDate startDate =
                startDateDatePicker.getValue();

        if (startDate == null) {

            showError("Please select a valid start date.");
            return;
        }


        if (startDate.isBefore(LocalDate.now())) {

            showError("Please select a valid start date.");
            return;
        }


        // Validate end date
        LocalDate endDate =
                EndDateDatePicker.getValue();

        if (endDate == null) {

            showError("Please select an end date.");
            return;
        }


        if (!endDate.isAfter(startDate)) {

            showError(
                    "End date must be after the start date."
            );

            return;
        }


        // Validate priority
        if (priorityLavelComboBox.getValue() == null) {

            showError("Please select a priority level.");
            return;
        }


        // Validate purpose
        if (purposeOfDemandComboBox.getValue() == null) {

            showError("Please select a purpose of request.");
            return;
        }


        // Validate remarks
        String remarks =
                remarksTextArea.getText().trim();

        if (remarks.length() > 100) {

            showError(
                    "Remarks cannot exceed 100 characters."
            );

            return;
        }


        // Create model object
        PowerDemandRequest request =
                new PowerDemandRequest(
                        reqIdTextField.getText(),
                        capacity,
                        startDate,
                        endDate,
                        priorityLavelComboBox.getValue(),
                        purposeOfDemandComboBox.getValue(),
                        remarks
                );


        // Save request to .bin file
        PowerDemandRequestFileHandler.save(request);


        // Confirmation
        showSuc(
                "Power Demand Request submitted successfully."
        );


        // Clear form and generate next ID
        clearForm();
    }


    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {

        clearForm();
    }


    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene(
                (Node) actionEvent.getSource(),
                "ridwan",
                "bpdbOfficer",
                "bpdbOfficer-dashboard-view.fxml",
                "BPDB Officer Dashboard!"
        );
    }


    private void clearForm() {

        // Generate next ID from saved records
        reqIdTextField.setText(
                PowerDemandRequestFileHandler.generateNextRequestId()
        );

        reqCapacityTextField.clear();

        priorityLavelComboBox.setValue(null);

        purposeOfDemandComboBox.setValue(null);

        startDateDatePicker.setValue(null);

        EndDateDatePicker.setValue(null);

        remarksTextArea.clear();
    }


    public void showError(String txt) {

        Alert alert =
                new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error!");

        alert.setHeaderText(null);

        alert.setContentText(txt);

        alert.showAndWait();
    }


    public void showSuc(String txt) {

        Alert alert =
                new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Saved!");

        alert.setHeaderText(null);

        alert.setContentText(txt);

        alert.showAndWait();
    }
}