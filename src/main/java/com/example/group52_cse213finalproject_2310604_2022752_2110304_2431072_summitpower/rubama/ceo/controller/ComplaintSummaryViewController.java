package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.CustomerComplaint;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.ceo.CustomerComplaintFileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ComplaintSummaryViewController {

    @FXML
    private Label viewComplaintSummaryLabel;

    @FXML
    private DatePicker dateOfComplaintDatePicker;

    @FXML
    private TableColumn<CustomerComplaint, String> complaintIdCol;

    @FXML
    private TableColumn<CustomerComplaint, String> statusCol;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private TableColumn<CustomerComplaint, LocalDate> dateOfComplaintCol;

    @FXML
    private TableView<CustomerComplaint> complaintTableView;

    @FXML
    private TableColumn<CustomerComplaint, String> categoryCol;


    @FXML
    public void initialize() {

        // Status options from the complaint records
        statusComboBox.setItems(
                FXCollections.observableArrayList(
                        "All",
                        "Pending",
                        "In Progress",
                        "Resolved",
                        "Closed"
                )
        );

        statusComboBox.getSelectionModel().select("All");

        // TableView column mappings
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

        // Load all complaints initially
        loadAllComplaints();
    }


    private void loadAllComplaints() {

        ObservableList<CustomerComplaint> complaints =
                CustomerComplaintFileHandler.readAll();

        complaintTableView.setItems(complaints);
    }


    /**
     * Calculates the complaint summary.
     *
     * CRA requirements:
     * - Total complaints for selected date
     * - Total complaints for selected week
     * - Pending complaints
     */
    @FXML
    public void handleComplaintSummary(ActionEvent actionEvent) {

        ObservableList<CustomerComplaint> complaints =
                CustomerComplaintFileHandler.readAll();

        if (complaints == null || complaints.isEmpty()) {

            viewComplaintSummaryLabel.setText(
                    "Total Complaints: 0\n" +
                            "Today's Complaints: 0\n" +
                            "This Week's Complaints: 0\n" +
                            "Pending Complaints: 0"
            );

            complaintTableView.setItems(
                    FXCollections.observableArrayList()
            );

            return;
        }

        LocalDate selectedDate = dateOfComplaintDatePicker.getValue();

        // If no date is selected, use today's date.
        if (selectedDate == null) {
            selectedDate = LocalDate.now();
        }

        LocalDate weekStart =
                selectedDate.with(DayOfWeek.MONDAY);

        LocalDate weekEnd =
                selectedDate.with(DayOfWeek.SUNDAY);

        String selectedStatus =
                statusComboBox.getValue();

        int totalForSelectedDate = 0;
        int totalForSelectedWeek = 0;
        int pendingCount = 0;

        ObservableList<CustomerComplaint> filteredComplaints =
                FXCollections.observableArrayList();

        for (CustomerComplaint complaint : complaints) {

            if (complaint == null ||
                    complaint.getDateOfComplaint() == null) {
                continue;
            }

            LocalDate complaintDate =
                    complaint.getDateOfComplaint();

            String complaintStatus =
                    complaint.getStatus();

            // Pending count
            if (complaintStatus != null &&
                    complaintStatus.equalsIgnoreCase("Pending")) {

                pendingCount++;
            }

            // Date matching
            boolean matchesSelectedDate =
                    complaintDate.equals(selectedDate);

            boolean matchesSelectedWeek =
                    !complaintDate.isBefore(weekStart) &&
                            !complaintDate.isAfter(weekEnd);

            // Status matching
            boolean matchesStatus =
                    selectedStatus == null ||
                            selectedStatus.equals("All") ||
                            (complaintStatus != null &&
                                    complaintStatus.equalsIgnoreCase(selectedStatus));

            /*
             * Table displays complaints according to
             * selected date and selected status.
             */
            if (matchesSelectedDate && matchesStatus) {
                filteredComplaints.add(complaint);
                totalForSelectedDate++;
            }

            if (matchesSelectedWeek && matchesStatus) {
                totalForSelectedWeek++;
            }
        }

        complaintTableView.setItems(filteredComplaints);

        viewComplaintSummaryLabel.setText(
                "Selected Date: " + selectedDate +
                        "\nToday's Complaints: " + totalForSelectedDate +
                        "\nThis Week's Complaints: " + totalForSelectedWeek +
                        "\nPending Complaints: " + pendingCount
        );
    }


    /**
     * Filters and displays complaint records.
     */
    @FXML
    public void handleViewComplaints(ActionEvent actionEvent) {

        ObservableList<CustomerComplaint> complaints =
                CustomerComplaintFileHandler.readAll();

        ObservableList<CustomerComplaint> filtered =
                FXCollections.observableArrayList();

        LocalDate selectedDate =
                dateOfComplaintDatePicker.getValue();

        String selectedStatus =
                statusComboBox.getValue();

        for (CustomerComplaint complaint : complaints) {

            if (complaint == null ||
                    complaint.getDateOfComplaint() == null) {
                continue;
            }

            boolean dateMatches =
                    selectedDate == null ||
                            complaint.getDateOfComplaint()
                                    .equals(selectedDate);

            boolean statusMatches =
                    selectedStatus == null ||
                            selectedStatus.equals("All") ||
                            (complaint.getStatus() != null &&
                                    complaint.getStatus()
                                            .equalsIgnoreCase(selectedStatus));

            if (dateMatches && statusMatches) {
                filtered.add(complaint);
            }
        }

        complaintTableView.setItems(filtered);

        if (filtered.isEmpty()) {

            showAlert(
                    Alert.AlertType.INFORMATION,
                    "Complaint Summary",
                    "No complaints found for the selected criteria."
            );
        }
    }


    @FXML
    public void handleReturn(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene(
                (Node) actionEvent.getSource(),
                "rubama",
                "ceo",
                "ceo-dashboard-view.fxml",
                "CEO Dashboard"
        );
    }


    private void showAlert(
            Alert.AlertType alertType,
            String title,
            String message) {

        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}