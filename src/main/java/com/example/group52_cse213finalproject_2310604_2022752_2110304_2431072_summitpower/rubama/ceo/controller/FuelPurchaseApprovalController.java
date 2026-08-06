package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.FuelPurchaseApproval;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class FuelPurchaseApprovalController
{
    @javafx.fxml.FXML
    private TableColumn <FuelPurchaseApproval,String>  requestsCol;
    @javafx.fxml.FXML
    private TableColumn <FuelPurchaseApproval,String> approvalStatusCol;
    @javafx.fxml.FXML
    private TableView <FuelPurchaseApproval> fuelRequestsTableView;

    private ArrayList<FuelPurchaseApproval> allRequests = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        approvalStatusCol.setCellValueFactory(new PropertyValueFactory<>("approvalStatus"));
        requestsCol.setCellValueFactory(new PropertyValueFactory<>("requests"));
    }

    @javafx.fxml.FXML
    public void handleApproveNot(ActionEvent actionEvent) {
        FuelPurchaseApproval selected = fuelRequestsTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            System.out.println("No request selected to reject.");
            return;
        }

        selected.setApprovalStatus("Not Approved");

        handlePendingFuelRequests(null);

    }

    @javafx.fxml.FXML
    public void handlePendingFuelRequests(ActionEvent actionEvent) {
        ArrayList<FuelPurchaseApproval> pending = new ArrayList<>();
        for (FuelPurchaseApproval req : allRequests) {
            if ("Pending".equals(req.getApprovalStatus())) {
                pending.add(req);
            }
        }
        fuelRequestsTableView.getItems().setAll(FXCollections.observableArrayList(pending));
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","ceo-dashboard-view.fxml","CEO Dashboard");
    }

    @javafx.fxml.FXML
    public void handleApprove(ActionEvent actionEvent) {
        FuelPurchaseApproval selected = fuelRequestsTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            System.out.println("No request selected to approve.");
            return;
        }
        selected.setApprovalStatus("Approved");

        handlePendingFuelRequests(null);
    }
}