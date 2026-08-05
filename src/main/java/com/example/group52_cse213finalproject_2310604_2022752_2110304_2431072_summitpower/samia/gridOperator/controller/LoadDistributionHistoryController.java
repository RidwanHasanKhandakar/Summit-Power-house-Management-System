package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.gridOperator.LoadDistributionFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.LoadDistribution;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class LoadDistributionHistoryController
{
    @javafx.fxml.FXML
    private TableColumn<LoadDistribution,String> loadColumn;
    @javafx.fxml.FXML
    private TableColumn<LoadDistribution,String> remarksColumn;
    @javafx.fxml.FXML
    private TableColumn<LoadDistribution,String> statusColumn;
    @javafx.fxml.FXML
    private TableColumn<LoadDistribution,String> gridColumn;
    @javafx.fxml.FXML
    private TableView<LoadDistribution> tableView;
    @javafx.fxml.FXML
    private TableColumn<LoadDistribution,LocalDate> dateColumn;
    @javafx.fxml.FXML
    private TableColumn<LoadDistribution,String> idColumn;

    @javafx.fxml.FXML
    public void initialize() {
        System.out.println("History Controller Loaded");

        idColumn.setCellValueFactory(new PropertyValueFactory<>("distributionId"));
        gridColumn.setCellValueFactory(new PropertyValueFactory<>("gridSection"));
        loadColumn.setCellValueFactory(new PropertyValueFactory<>("loadMW"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("distributionStatus"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("distributionDate"));
        remarksColumn.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        tableView.setItems(LoadDistributionFileHandler.readAll());
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "samia", "gridOperator", "load-distribution-view.fxml", "Load Distribution");
    }
}