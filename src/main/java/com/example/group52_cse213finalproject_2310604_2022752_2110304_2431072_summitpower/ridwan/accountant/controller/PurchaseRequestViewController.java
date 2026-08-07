package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.model.PurchaseRequest;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.accountant.PurchaseRequestFileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class PurchaseRequestViewController {

    @javafx.fxml.FXML
    private Label estCostLabel;
    @javafx.fxml.FXML
    private TableColumn<PurchaseRequest, String> departmentCol;
    @javafx.fxml.FXML
    private TableColumn<PurchaseRequest, LocalDate> requestDateCol;
    @javafx.fxml.FXML
    private TableColumn<PurchaseRequest, String> requestByCol;
    @javafx.fxml.FXML
    private ComboBox<String> departmentComboBox;
    @javafx.fxml.FXML
    private TableColumn<PurchaseRequest, Double> costCol;
    @javafx.fxml.FXML
    private Label departmentLabel;
    @javafx.fxml.FXML
    private TableView<PurchaseRequest> purchaseAppTableView;
    @javafx.fxml.FXML
    private TableColumn<PurchaseRequest, Integer> reqIDCol;
    @javafx.fxml.FXML
    private TableColumn<PurchaseRequest, String> statusCol;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private Label requestByLabel;
    @javafx.fxml.FXML
    private Label requestIDLabel;
    @javafx.fxml.FXML
    private TextField minimumAmountTextField;

    @javafx.fxml.FXML
    public void initialize() {

        departmentComboBox.getItems().addAll(
                "All",
                "Operations",
                "Customer Service",
                "Engineering",
                "Grid Management",
                "Human Resources",
                "Inventory Management",
                "Plant Management"
        );

        statusComboBox.getItems().addAll(
                "All",
                "Pending",
                "Approved",
                "Rejected"
        );

        reqIDCol.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        requestByCol.setCellValueFactory(new PropertyValueFactory<>("requestedBy"));
        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        requestDateCol.setCellValueFactory(new PropertyValueFactory<>("requestDate"));
        costCol.setCellValueFactory(new PropertyValueFactory<>("cost"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        //purchaseAppTableView.setItems(PurchaseRequestFileHandler.readAll());
        loadTable();

        purchaseAppTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, selected) -> {

            if (selected != null) {

                requestIDLabel.setText(String.valueOf(selected.getRequestId()));
                requestByLabel.setText(selected.getRequestedBy());
                departmentLabel.setText(selected.getDepartment());
                estCostLabel.setText(String.format("%.2f", selected.getCost()));

            }

        });

    }

    private void loadTable(){
        purchaseAppTableView.setItems(PurchaseRequestFileHandler.readAll());
    }

    @javafx.fxml.FXML
    public void handleLoadRequestButton(ActionEvent actionEvent) {

        double minimumAmount = 0;

        if (!minimumAmountTextField.getText().trim().isEmpty()) {

            try {
                minimumAmount = Double.parseDouble(minimumAmountTextField.getText().trim());
                if (minimumAmount<0){
                    showError("Minimum amount cannot be negative.");
                    return;
                }
            } catch (NumberFormatException e) {
                showError("Minimum amount must be numeric.");
                return;
            }

        }

        ObservableList<PurchaseRequest> filtered = FXCollections.observableArrayList();

        for (PurchaseRequest request : PurchaseRequestFileHandler.readAll()) {

            boolean departmentMatch =
                    departmentComboBox.getValue() == null ||
                            departmentComboBox.getValue().equals("All") ||
                            request.getDepartment().equalsIgnoreCase(departmentComboBox.getValue());

            boolean statusMatch =
                    statusComboBox.getValue() == null ||
                            statusComboBox.getValue().equals("All") ||
                            request.getStatus().equalsIgnoreCase(statusComboBox.getValue());

            boolean amountMatch =
                    request.getCost() >= minimumAmount;

            if (departmentMatch && statusMatch && amountMatch) {
                filtered.add(request);
            }

        }

        purchaseAppTableView.setItems(filtered);

        showInformation(filtered.size() + " request(s) found.");

    }

    @javafx.fxml.FXML
    public void handleApproveButton(ActionEvent actionEvent) {

        PurchaseRequest selected = purchaseAppTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showError("Please select a request.");
            return;
        }

        if (selected.getStatus().equalsIgnoreCase("Approved")){
            showInformation("This request is already approved.");
            return;
        }

        if (selected.getStatus().equalsIgnoreCase("Rejected")){
            showError("Rejected requests cannot be approved.");
            return;
        }

        ObservableList<PurchaseRequest> allReqs = PurchaseRequestFileHandler.readAll();
        for (PurchaseRequest request:allReqs){
            if (request.getRequestId()==selected.getRequestId()){
                request.setStatus("Approved");
                request.setRemarks("Approved by Accountant");
                break;
            }
        }

        PurchaseRequestFileHandler.overwrite(allReqs);

        loadTable();

        purchaseAppTableView.getSelectionModel().clearSelection();
        showInformation("Purchase request approved successfully.");

        //selected.setStatus("Approved");

        //PurchaseRequestFileHandler.overwrite(purchaseAppTableView.getItems());



        //purchaseAppTableView.refresh();

        //showInformation("Purchase request approved.");

    }

    @javafx.fxml.FXML
    public void handleRejectButton(ActionEvent actionEvent) {

        PurchaseRequest selected = purchaseAppTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showError("Please select a request.");
            return;
        }

        if (selected.getStatus().equalsIgnoreCase("Rejected")) {
            showInformation("This request is already rejected.");
            return;
        }

        if (selected.getStatus().equalsIgnoreCase("Approved")) {
            showError("Approved requests cannot be rejected.");
            return;
        }

        ObservableList<PurchaseRequest> allRequests = PurchaseRequestFileHandler.readAll();

        for (PurchaseRequest request : allRequests) {

            if (request.getRequestId() == selected.getRequestId()) {

                request.setStatus("Rejected");
                request.setRemarks("Rejected by Accountant");
                break;

            }

        }

//        selected.setStatus("Rejected");
//
//        PurchaseRequestFileHandler.overwrite(purchaseAppTableView.getItems());
//
//        purchaseAppTableView.refresh();
//
//        showInformation("Purchase request rejected.");

        PurchaseRequestFileHandler.overwrite(allRequests);

        loadTable();

        purchaseAppTableView.getSelectionModel().clearSelection();

        showInformation("Purchase request rejected successfully.");

    }

    @javafx.fxml.FXML
    public void handleRefreshButton(ActionEvent actionEvent) {

        loadTable();

        requestIDLabel.setText("");
        requestByLabel.setText("");
        departmentLabel.setText("");
        estCostLabel.setText("");

        purchaseAppTableView.getSelectionModel().clearSelection();

        showInformation("Table refreshed.");

    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene(
                (Node) actionEvent.getSource(),
                "ridwan",
                "accountant",
                "accountant-dashboard-view.fxml",
                "Accountant Dashboard"
        );

    }

    private void showError(String txt) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();

    }

    private void showInformation(String txt) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();

    }

}