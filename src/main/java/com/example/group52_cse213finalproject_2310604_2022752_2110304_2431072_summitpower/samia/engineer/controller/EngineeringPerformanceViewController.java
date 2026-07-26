package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model.EngineeringPerformance;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class EngineeringPerformanceViewController
{
    @javafx.fxml.FXML
    private TextField reportIdTextField;
    @javafx.fxml.FXML
    private DatePicker reportDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> performanceStatusComboBox;
    @javafx.fxml.FXML
    private TextField powerOutputTextField;
    @javafx.fxml.FXML
    private TextField generatorIdTextField;
    @javafx.fxml.FXML
    private TextField efficiencyTextField;
    @javafx.fxml.FXML
    private TableColumn<EngineeringPerformance,String> performanceStatusTabCol;
    @javafx.fxml.FXML
    private TableColumn<EngineeringPerformance,String> generatorIdTabCol;
    @javafx.fxml.FXML
    private TableColumn<EngineeringPerformance,String > reportIdTabCol;
    @javafx.fxml.FXML
    private TableView<EngineeringPerformance> tableView;
    @javafx.fxml.FXML
    private TableColumn<EngineeringPerformance,Double> efficiencyTabCol;
    @javafx.fxml.FXML
    private TableColumn<EngineeringPerformance,Double> powerOutputTabCol;

    @javafx.fxml.FXML
    public void initialize() {

        efficiencyTextField.setEditable(false);

        performanceStatusComboBox.getItems().addAll(
                "Excellent",
                "Good",
                "Average",
                "Poor"
        );

        reportIdTabCol.setCellValueFactory(
                new PropertyValueFactory<>("reportId"));

        generatorIdTabCol.setCellValueFactory(
                new PropertyValueFactory<>("generatorId"));

        powerOutputTabCol.setCellValueFactory(
                new PropertyValueFactory<>("powerOutput"));

        efficiencyTabCol.setCellValueFactory(
                new PropertyValueFactory<>("efficiencyPercentage"));

        performanceStatusTabCol.setCellValueFactory(
                new PropertyValueFactory<>("performanceStatus"));

    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateReportButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}