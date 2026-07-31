package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewGridPerformanceReportViewController
{
    @javafx.fxml.FXML
    private TableColumn<ViewGridPerformanceReportViewController,Double> totalLoadTabCol;
    @javafx.fxml.FXML
    private TableColumn<ViewGridPerformanceReportViewController,Double> availableCapacityTabCol;
    @javafx.fxml.FXML
    private TextField gridEfficiencyTextField;
    @javafx.fxml.FXML
    private TextField availableCapacityMWTextField;
    @javafx.fxml.FXML
    private TextField reportIdTextField;
    @javafx.fxml.FXML
    private TableColumn<ViewGridPerformanceReportViewController,String> performanceStatusTabCol;
    @javafx.fxml.FXML
    private DatePicker reportDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> performanceStatusComboBox;
    @javafx.fxml.FXML
    private TableColumn<ViewGridPerformanceReportViewController,Double> gridEfficiencyTabCol;
    @javafx.fxml.FXML
    private TableColumn<ViewGridPerformanceReportViewController,String> reportIdTabCol;
    @javafx.fxml.FXML
    private TextField totalLoadMWTextField;
    @javafx.fxml.FXML
    private TableView<ViewGridPerformanceReportViewController> gridPerformanceTableView;
    @javafx.fxml.FXML
    private ComboBox<String> gridSectionComboBox;
    @javafx.fxml.FXML
    private TableColumn<ViewGridPerformanceReportViewController,String> gridSectionTabCol;

    @javafx.fxml.FXML
    public void initialize() {
        gridEfficiencyTextField.setEditable(false);

        gridSectionComboBox.getItems().addAll(
                "North Grid",
                "South Grid",
                "East Grid",
                "West Grid"
        );
        performanceStatusComboBox.getItems().addAll(
                "Excellent",
                "Good",
                "Average",
                "Poor"
        );
        reportIdTabCol.setCellValueFactory(
                new PropertyValueFactory<>("reportId")
        );

        gridSectionTabCol.setCellValueFactory(
                new PropertyValueFactory<>("gridSection")
        );

        totalLoadTabCol.setCellValueFactory(
                new PropertyValueFactory<>("totalLoadMW")
        );

        availableCapacityTabCol.setCellValueFactory(
                new PropertyValueFactory<>("availableCapacityMW")
        );

        gridEfficiencyTabCol.setCellValueFactory(
                new PropertyValueFactory<>("gridEfficiency")
        );

        performanceStatusTabCol.setCellValueFactory(
                new PropertyValueFactory<>("performanceStatus")
        );
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        reportIdTextField.clear();
        gridSectionComboBox.setValue(null);
        totalLoadMWTextField.clear();
        availableCapacityMWTextField.clear();
        gridEfficiencyTextField.clear();
        performanceStatusComboBox.setValue(null);
        reportDatePicker.setValue(null);
        gridPerformanceTableView.getSelectionModel().clearSelection();
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