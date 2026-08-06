package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.ComplaintSummary;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

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

    private ArrayList<ComplaintSummary> allComplaints = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        statusComboBox.getItems().addAll("Resolved", "Unresolved", "Pending");

        customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        complaintIdCol.setCellValueFactory(new PropertyValueFactory<>("complaintId"));
        dateOfComplaintCol.setCellValueFactory(new PropertyValueFactory<>("complaintDate"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void handleComplaintSummary(ActionEvent actionEvent) {
        int total = 0, resolved = 0, unresolved = 0, pending = 0;

        for (ComplaintSummary c : complaintTableView.getItems()) {
            total++;
            String s = c.getStatus();
            if ("Resolved".equals(s)) resolved++;
            else if ("Unresolved".equals(s)) unresolved++;
            else if ("Pending".equals(s)) pending++;
        }

        String summary = "Total: " + total +
                "  |  Resolved: " + resolved +
                "  |  Unresolved: " + unresolved +
                "  |  Pending: " + pending;
        viewComplaintSummaryLabel.setText(summary);
    }

    @javafx.fxml.FXML
    public void handleViewComplaints(ActionEvent actionEvent) {
        String customerId = customerIdTextField.getText().trim();
        LocalDate date = dateOfComplaintDatePicker.getValue();
        String status = statusComboBox.getValue();

        ArrayList<ComplaintSummary> filtered = new ArrayList<>();

        for (ComplaintSummary c : allComplaints) {
            boolean match = customerId.isEmpty() || c.getCustomerId().equals(customerId);

            if (date != null && !c.getComplaintDate().equals(date)) {
                match = false;
            }
            if (status != null && !c.getStatus().equals(status)) {
                match = false;
            }

            if (match) {
                filtered.add(c);
            }
        }
        complaintTableView.getItems().setAll(FXCollections.observableArrayList(filtered));
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","ceo-dashboard-view.fxml","CEO Dashboard");
    }
}