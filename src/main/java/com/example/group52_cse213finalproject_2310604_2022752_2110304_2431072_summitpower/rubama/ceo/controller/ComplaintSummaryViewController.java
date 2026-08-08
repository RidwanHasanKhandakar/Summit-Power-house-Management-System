package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;
//package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

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

        loadAllComplaints();
    }


    private void loadAllComplaints() {

        complaintTableView.setItems(
                CustomerComplaintFileHandler.readAll()
        );
    }


    /*
     * =========================================================
     * VIEW COMPLAINTS
     * =========================================================
     *
     * This button ONLY filters the TableView.
     *
     * It does NOT calculate the summary.
     */
    @FXML
    public void handleViewComplaints(ActionEvent actionEvent) {

        ObservableList<CustomerComplaint> allComplaints =
                CustomerComplaintFileHandler.readAll();

        ObservableList<CustomerComplaint> filteredComplaints =
                FXCollections.observableArrayList();

        LocalDate selectedDate =
                dateOfComplaintDatePicker.getValue();

        String selectedStatus =
                statusComboBox.getValue();


        for (CustomerComplaint complaint : allComplaints) {

            if (complaint == null) {
                continue;
            }

            boolean dateMatches = true;
            boolean statusMatches = true;


            // Date filter
            if (selectedDate != null) {

                dateMatches =
                        complaint.getDateOfComplaint() != null &&
                                complaint.getDateOfComplaint()
                                        .equals(selectedDate);
            }


            // Status filter
            if (selectedStatus != null &&
                    !selectedStatus.equals("All")) {

                statusMatches =
                        complaint.getStatus() != null &&
                                complaint.getStatus()
                                        .equalsIgnoreCase(selectedStatus);
            }


            if (dateMatches && statusMatches) {

                filteredComplaints.add(complaint);
            }
        }


        complaintTableView.setItems(filteredComplaints);


        if (filteredComplaints.isEmpty()) {

            showAlert(
                    Alert.AlertType.INFORMATION,
                    "View Complaints",
                    "No complaints found for the selected criteria."
            );
        }
    }


    /*
     * =========================================================
     * COMPLAINT SUMMARY
     * =========================================================
     *
     * This button ONLY calculates the summary.
     *
     * It does NOT change the TableView.
     */
    @FXML
    public void handleComplaintSummary(ActionEvent actionEvent) {

        ObservableList<CustomerComplaint> allComplaints =
                CustomerComplaintFileHandler.readAll();

        LocalDate selectedDate =
                dateOfComplaintDatePicker.getValue();

        /*
         * If the CEO does not select a date,
         * today's date is used.
         */
        if (selectedDate == null) {
            selectedDate = LocalDate.now();
        }


        /*
         * Determine the week containing the selected date.
         *
         * Monday = first day
         * Sunday = last day
         */
        LocalDate weekStart =
                selectedDate.with(DayOfWeek.MONDAY);

        LocalDate weekEnd =
                selectedDate.with(DayOfWeek.SUNDAY);


        String selectedStatus =
                statusComboBox.getValue();


        int selectedDateCount = 0;
        int selectedWeekCount = 0;
        int pendingCount = 0;


        for (CustomerComplaint complaint : allComplaints) {

            if (complaint == null ||
                    complaint.getDateOfComplaint() == null) {
                continue;
            }


            LocalDate complaintDate =
                    complaint.getDateOfComplaint();

            String complaintStatus =
                    complaint.getStatus();


            /*
             * Count pending complaints.
             *
             * Pending count is based on all complaints,
             * regardless of the selected date/status filter.
             */
            if (complaintStatus != null &&
                    complaintStatus.equalsIgnoreCase("Pending")) {

                pendingCount++;
            }


            /*
             * Status condition for the date/week statistics.
             */
            boolean statusMatches =
                    selectedStatus == null ||
                            selectedStatus.equals("All") ||
                            (complaintStatus != null &&
                                    complaintStatus.equalsIgnoreCase(selectedStatus));


            if (!statusMatches) {
                continue;
            }


            /*
             * Selected date count
             */
            if (complaintDate.equals(selectedDate)) {

                selectedDateCount++;
            }


            /*
             * Selected week count
             */
            boolean belongsToSelectedWeek =
                    !complaintDate.isBefore(weekStart) &&
                            !complaintDate.isAfter(weekEnd);

            if (belongsToSelectedWeek) {

                selectedWeekCount++;
            }
        }


        viewComplaintSummaryLabel.setText(
                "Summary for: " + selectedDate +
                        "\nComplaints on Selected Date: "
                        + selectedDateCount +
                        "\nComplaints This Week: "
                        + selectedWeekCount +
                        "\nPending Complaints: "
                        + pendingCount
        );
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

        Alert alert =
                new Alert(alertType);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}
