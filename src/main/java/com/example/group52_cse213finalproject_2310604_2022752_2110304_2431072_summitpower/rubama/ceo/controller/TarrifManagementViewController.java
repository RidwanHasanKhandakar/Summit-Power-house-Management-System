package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

public class TarrifManagementViewController
{
    @javafx.fxml.FXML
    private TableColumn dateCol;
    @javafx.fxml.FXML
    private DatePicker setTarrifDatePicker;
    @javafx.fxml.FXML
    private ComboBox customerTypeComboBox;
    @javafx.fxml.FXML
    private TextField setTarrifRateTextField;
    @javafx.fxml.FXML
    private TableColumn tarrifRateCol;
    @javafx.fxml.FXML
    private TableColumn customerTypeCol;
    @javafx.fxml.FXML
    private TableView tarrifTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSetTarrif(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","ceo-dashboard-view.fxml","CEO Dashboard");
    }
}