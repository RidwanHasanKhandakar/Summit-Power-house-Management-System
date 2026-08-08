package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.CustomerComplaint;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.ceo.CustomerComplaintFileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
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
    private TableColumn <CustomerComplaint,String> complaintIdCol;
    @javafx.fxml.FXML
    private TableColumn <CustomerComplaint,String> statusCol;
    @javafx.fxml.FXML
    private ComboBox <String> statusComboBox;
    @javafx.fxml.FXML
    private TableColumn <CustomerComplaint,LocalDate> dateOfComplaintCol;
    @javafx.fxml.FXML
    private TableView <CustomerComplaint> complaintTableView;
    @javafx.fxml.FXML
    private TableColumn <CustomerComplaint,String> categoryCol;

    //private ArrayList<Complaint> allComplaints = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        statusComboBox.getItems().addAll("Pending", "In Progress", "Resolved","Closed");

        complaintIdCol.setCellValueFactory(new PropertyValueFactory<>("complaintId"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        dateOfComplaintCol.setCellValueFactory(new PropertyValueFactory<>("dateOfComplaint"));

        complaintTableView.setItems(CustomerComplaintFileHandler.readAll());
    }

    @javafx.fxml.FXML
    public void handleComplaintSummary(ActionEvent actionEvent) {
        int total = 0;
        int pending = 0;
        int inProgress = 0;
        int resolved = 0;
        int closed = 0;

        for (CustomerComplaint c : CustomerComplaintFileHandler.readAll()) {

            total++;

            switch (c.getStatus()) {

                case "Pending":
                    pending++;
                    break;

                case "In Progress":
                    inProgress++;
                    break;

                case "Resolved":
                    resolved++;
                    break;

                case "Closed":
                    closed++;
                    break;
            }
        }

        viewComplaintSummaryLabel.setText(
                "Total: " + total +
                        "\nPending: " + pending +
                        "\nIn Progress: " + inProgress +
                        "\nResolved: " + resolved +
                        "\nClosed: " + closed
        );
    }

    @javafx.fxml.FXML
    public void handleViewComplaints(ActionEvent actionEvent) {
        ObservableList<CustomerComplaint> filtered = FXCollections.observableArrayList();
        LocalDate date = dateOfComplaintDatePicker.getValue();
        String status = statusComboBox.getValue();

        for (CustomerComplaint c : CustomerComplaintFileHandler.readAll()) {

            boolean match = date == null || c.getDateOfComplaint().equals(date);
            if (status != null && !c.getStatus().equals(status)) {
                match = false;
            }

            if (match) {
                filtered.add(c);
            }
        }

        complaintTableView.setItems(filtered);
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","ceo-dashboard-view.fxml","CEO Dashboard");
    }
}