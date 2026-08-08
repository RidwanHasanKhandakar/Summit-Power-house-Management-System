package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.CustomerComplaint;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.ceo.CustomerComplaintFileHandler;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class CustomerComplaintViewController {

    @FXML
    private TableColumn<CustomerComplaint, String> complaintIdCol;

    @FXML
    private TableColumn<CustomerComplaint, String> statusCol;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private DatePicker dateOfComplaintDatePicker1;

    @FXML
    private TextField complaintIdTextField;

    @FXML
    private TableColumn<CustomerComplaint, LocalDate> dateOfComplaintCol;

    @FXML
    private TableColumn<CustomerComplaint, String> categoryCol;

    @FXML
    private TextField categoryTextField;

    @FXML
    private TableView<CustomerComplaint> complaintTableView;


    @FXML
    public void initialize() {

        statusComboBox.setItems(
                FXCollections.observableArrayList(
                        "Pending",
                        "In Progress",
                        "Resolved",
                        "Closed"
                )
        );

        complaintIdCol.setCellValueFactory(
                new PropertyValueFactory<>("complaintId")
        );

        dateOfComplaintCol.setCellValueFactory(
                new PropertyValueFactory<>("dateOfComplaint")
        );

        statusCol.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        categoryCol.setCellValueFactory(
                new PropertyValueFactory<>("category")
        );

        loadTable();
    }


    private void loadTable() {

        complaintTableView.setItems(
                CustomerComplaintFileHandler.readAll()
        );

        complaintTableView.refresh();
    }


    @FXML
    public void handleSaveComplaints(ActionEvent actionEvent) {

        String complaintId =
                complaintIdTextField.getText().trim();

        String category =
                categoryTextField.getText().trim();

        String status =
                statusComboBox.getValue();

        LocalDate complaintDate =
                dateOfComplaintDatePicker1.getValue();


        // Validation
        if (complaintId.isEmpty()) {

            showError("Please enter a Complaint ID.");
            return;
        }

        if (status == null || status.trim().isEmpty()) {

            showError("Please select a complaint status.");
            return;
        }

        if (category.isEmpty()) {

            showError("Please enter the complaint category.");
            return;
        }

        if (complaintDate == null) {

            showError("Please select the complaint date.");
            return;
        }


        // Prevent duplicate Complaint ID
        for (CustomerComplaint existing :
                CustomerComplaintFileHandler.readAll()) {

            if (existing.getComplaintId() != null &&
                    existing.getComplaintId()
                            .equalsIgnoreCase(complaintId)) {

                showError(
                        "Complaint ID already exists. " +
                                "Please enter a unique Complaint ID."
                );

                return;
            }
        }


        CustomerComplaint complaint =
                new CustomerComplaint(
                        complaintId,
                        status,
                        category,
                        complaintDate
                );


        CustomerComplaintFileHandler.save(complaint);

        loadTable();

        clearFields();

        showSuccess(
                "Complaint saved successfully."
        );
    }


    private void clearFields() {

        complaintIdTextField.clear();

        categoryTextField.clear();

        statusComboBox.getSelectionModel().clearSelection();

        dateOfComplaintDatePicker1.setValue(null);
    }


    @FXML
    public void handleReturn(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene(
                (Node) actionEvent.getSource(),
                "rubama",
                "ceo",
                "ceo-dashboard-view.fxml",
                "View Dashboard"
        );
    }


    private void showError(String txt) {

        Alert alert =
                new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(txt);

        alert.showAndWait();
    }


    private void showSuccess(String txt) {

        Alert alert =
                new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(txt);

        alert.showAndWait();
    }
}