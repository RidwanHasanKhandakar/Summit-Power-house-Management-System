package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.FuelPurchaseApproval;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.ceo.FuelPurchaseApprovalFileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class FuelPurchaseApprovalController {

    @javafx.fxml.FXML
    private TableColumn<FuelPurchaseApproval, String> requestsCol;

    @javafx.fxml.FXML
    private TableColumn<FuelPurchaseApproval, String> approvalStatusCol;

    @javafx.fxml.FXML
    private TableView<FuelPurchaseApproval> fuelRequestsTableView;

    private ObservableList<FuelPurchaseApproval> allRequests =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        requestsCol.setCellValueFactory(
                new PropertyValueFactory<>("requests")
        );

        approvalStatusCol.setCellValueFactory(
                new PropertyValueFactory<>("approvalStatus")
        );

        loadRequests();
    }

    private void loadRequests() {

        allRequests = FuelPurchaseApprovalFileHandler.readAll();

        fuelRequestsTableView.setItems(
                FXCollections.observableArrayList(allRequests)
        );
    }

    @javafx.fxml.FXML
    public void handlePendingFuelRequests(ActionEvent actionEvent) {

        ObservableList<FuelPurchaseApproval> pending =
                FXCollections.observableArrayList();

        for (FuelPurchaseApproval request : allRequests) {

            if ("Pending".equalsIgnoreCase(
                    request.getApprovalStatus())) {

                pending.add(request);
            }
        }

        fuelRequestsTableView.setItems(pending);
        fuelRequestsTableView.refresh();

        if (pending.isEmpty()) {
            showInformation("No pending fuel purchase requests found.");
        }
    }

    @javafx.fxml.FXML
    public void handleApprove(ActionEvent actionEvent) {

        FuelPurchaseApproval selected =
                fuelRequestsTableView.getSelectionModel()
                        .getSelectedItem();

        if (selected == null) {
            showError("Please select a fuel purchase request first.");
            return;
        }

        if (!"Pending".equalsIgnoreCase(
                selected.getApprovalStatus())) {

            showError("Only pending requests can be approved.");
            return;
        }

        selected.setApprovalStatus("Approved");

        FuelPurchaseApprovalFileHandler.saveAll(allRequests);

        handlePendingFuelRequests(null);

        showInformation(
                "Request approved. Order placed."
        );
    }

    @javafx.fxml.FXML
    public void handleApproveNot(ActionEvent actionEvent) {

        FuelPurchaseApproval selected =
                fuelRequestsTableView.getSelectionModel()
                        .getSelectedItem();

        if (selected == null) {
            showError("Please select a fuel purchase request first.");
            return;
        }

        if (!"Pending".equalsIgnoreCase(
                selected.getApprovalStatus())) {

            showError("Only pending requests can be rejected.");
            return;
        }

        selected.setApprovalStatus("Not Approved");

        FuelPurchaseApprovalFileHandler.saveAll(allRequests);

        handlePendingFuelRequests(null);

        showInformation(
                "Fuel purchase request was not approved."
        );
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene(
                (Node) actionEvent.getSource(),
                "rubama",
                "ceo",
                "ceo-dashboard-view.fxml",
                "CEO Dashboard"
        );
    }

    private void showError(String message) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInformation(String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fuel Purchase");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}