package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.FuelPurchaseApproval;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FuelPurchaseApprovalController
{
    @javafx.fxml.FXML
    private TableColumn <FuelPurchaseApproval,String>  requestsCol;
    @javafx.fxml.FXML
    private TableColumn <FuelPurchaseApproval,String> approvalStatusCol;
    @javafx.fxml.FXML
    private TableView <FuelPurchaseApproval> fuelRequestsTableView;

    @javafx.fxml.FXML
    public void initialize() {
        approvalStatusCol.setCellValueFactory(new PropertyValueFactory<>("requests"));
        requestsCol.setCellValueFactory(new PropertyValueFactory<>("approvalStatus"));
    }

    @Deprecated
    public void handleAprove(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleApproveNot(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handlePendingFuelRequests(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","ceo-dashboard-view.fxml","CEO Dashboard");
    }

    @javafx.fxml.FXML
    public void handleApprove(ActionEvent actionEvent) {
    }
}