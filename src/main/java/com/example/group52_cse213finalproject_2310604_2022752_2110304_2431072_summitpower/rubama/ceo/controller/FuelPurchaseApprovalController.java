package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FuelPurchaseApprovalController
{
    @javafx.fxml.FXML
    private TableColumn requestsCol;
    @javafx.fxml.FXML
    private TableColumn approvalStatusCol;
    @javafx.fxml.FXML
    private TableView fuelRequestsTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
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
}