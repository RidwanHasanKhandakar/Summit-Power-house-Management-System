package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.TariffManagement;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class TariffManagementViewController
{
    @javafx.fxml.FXML
    private TableColumn <TariffManagement, LocalDate> dateCol;
    @javafx.fxml.FXML
    private ComboBox <String> customerTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn <TariffManagement,String> customerTypeCol;
    @javafx.fxml.FXML
    private TableView <TariffManagement> tariffTableView;
    @javafx.fxml.FXML
    private DatePicker setTariffDatePicker;
    @javafx.fxml.FXML
    private TableColumn <TariffManagement,Integer> tariffRateCol;
    @javafx.fxml.FXML
    private TextField setTariffRateTextField;

    @javafx.fxml.FXML
    public void initialize() {
        customerTypeComboBox.getItems().addAll("Industrial Customer","Residential Customer","Commercial Customer");

        customerTypeCol.setCellValueFactory(new PropertyValueFactory<>("customerType"));
        tariffRateCol.setCellValueFactory(new PropertyValueFactory<>("setTariffRate"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("setTariffDate"));
    }

    @javafx.fxml.FXML
    public void handleSetTariff(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","ceo-dashboard-view.fxml","CEO Dashboard");
    }
}