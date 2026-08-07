package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.CustomerComplaint;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.ceo.CustomerComplaintFileHandler;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class CustomerComplaintViewController
{
    @javafx.fxml.FXML
    private TableColumn <CustomerComplaint,String> complaintIdCol;
    @javafx.fxml.FXML
    private TableColumn <CustomerComplaint,String> statusCol;
    @javafx.fxml.FXML
    private ComboBox <String> statusComboBox;
    @javafx.fxml.FXML
    private DatePicker dateOfComplaintDatePicker1;
    @javafx.fxml.FXML
    private TextField  complaintIdTextField;
    @javafx.fxml.FXML
    private TableColumn <CustomerComplaint, LocalDate> dateOfComplaintCol;
    @javafx.fxml.FXML
    private TableColumn <CustomerComplaint,String> categoryCol;
    @javafx.fxml.FXML
    private TextField categoryTextField;
    @javafx.fxml.FXML
    private TableView <CustomerComplaint> complaintTableView;

    @javafx.fxml.FXML
    public void initialize() {
        statusComboBox.getItems().addAll("Pending", "In Progress", "Resolved","Closed");
        complaintIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));  // FIXED
        dateOfComplaintCol.setCellValueFactory(new PropertyValueFactory<>("dateOfComplaint"));
        complaintTableView.setItems(CustomerComplaintFileHandler.readAll());
    }

    public void showError(String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

    public void showSuccess(String txt){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","ceo-dashboard-view.fxml","View Dashboard");
    }


    @javafx.fxml.FXML
    public void handleSaveComplaints(ActionEvent actionEvent) {
        CustomerComplaint complaint = new CustomerComplaint(
                complaintIdTextField.getText().trim(),
                statusComboBox.getValue(),
                categoryTextField.getText().trim(),
                dateOfComplaintDatePicker1.getValue()
        );
        CustomerComplaintFileHandler.save(complaint);
        complaintTableView.setItems(CustomerComplaintFileHandler.readAll());

        complaintIdTextField.clear();
        categoryTextField.clear();
        statusComboBox.setValue(null);
        dateOfComplaintDatePicker1.setValue(null);
        showSuccess("Complaint saved successfully.");

    }
}