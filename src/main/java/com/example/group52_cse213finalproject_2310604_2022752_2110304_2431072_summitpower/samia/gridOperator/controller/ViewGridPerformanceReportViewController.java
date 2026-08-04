package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.gridOperator.ViewGridPerformanceReportFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.ViewGridPerformanceReport;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ViewGridPerformanceReportViewController
{
    @javafx.fxml.FXML
    private TableColumn<ViewGridPerformanceReport,Double> totalLoadTabCol;
    @javafx.fxml.FXML
    private TableColumn<ViewGridPerformanceReport,Double> availableCapacityTabCol;
    @javafx.fxml.FXML
    private TextField gridEfficiencyTextField;
    @javafx.fxml.FXML
    private TextField availableCapacityMWTextField;
    @javafx.fxml.FXML
    private TextField reportIdTextField;
    @javafx.fxml.FXML
    private TableColumn<ViewGridPerformanceReport,String> performanceStatusTabCol;
    @javafx.fxml.FXML
    private DatePicker reportDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> performanceStatusComboBox;
    @javafx.fxml.FXML
    private TableColumn<ViewGridPerformanceReport,Double> gridEfficiencyTabCol;
    @javafx.fxml.FXML
    private TableColumn<ViewGridPerformanceReport,String> reportIdTabCol;
    @javafx.fxml.FXML
    private TextField totalLoadMWTextField;
    @javafx.fxml.FXML
    private TableView<ViewGridPerformanceReport> gridPerformanceTableView;
    @javafx.fxml.FXML
    private ComboBox<String> gridSectionComboBox;
    @javafx.fxml.FXML
    private TableColumn<ViewGridPerformanceReport,String> gridSectionTabCol;
    @javafx.fxml.FXML
    private TableColumn<ViewGridPerformanceReport,LocalDate> reportDateTabCol;

    @javafx.fxml.FXML
    public void initialize() {

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
        reportIdTabCol.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        gridSectionTabCol.setCellValueFactory(new PropertyValueFactory<>("gridSection"));
        totalLoadTabCol.setCellValueFactory(new PropertyValueFactory<>("totalLoadMW"));
        availableCapacityTabCol.setCellValueFactory(new PropertyValueFactory<>("availableCapacityMW"));
        gridEfficiencyTabCol.setCellValueFactory(new PropertyValueFactory<>("gridEfficiency"));
        performanceStatusTabCol.setCellValueFactory(new PropertyValueFactory<>("performanceStatus"));
        reportDateTabCol.setCellValueFactory(new PropertyValueFactory<>("reportDate"));
        gridPerformanceTableView.setItems(ViewGridPerformanceReportFileHandler.readAll());
        gridEfficiencyTextField.setEditable(false);
        performanceStatusComboBox.setDisable(true);
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        reportIdTextField.clear();
        gridSectionComboBox.setValue(null);
        totalLoadMWTextField.clear();
        availableCapacityMWTextField.clear();
        gridEfficiencyTextField.clear();
        performanceStatusComboBox.getSelectionModel().clearSelection();
        reportDatePicker.setValue(null);
        gridPerformanceTableView.getSelectionModel().clearSelection();
    }
    public void showSuccess(String txt){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

    public void showError(String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","gridOperator-dashboard-view.fxml","Grid Operator Dashboard");
    }

    @javafx.fxml.FXML
    public void generateReportButton(ActionEvent actionEvent) {
        try {

            double totalLoad = Double.parseDouble(totalLoadMWTextField.getText().trim());

            double availableCapacity = Double.parseDouble(availableCapacityMWTextField.getText().trim());

            if (totalLoad <= 0 || availableCapacity <= 0) {
                showError("Load and Capacity must be greater than 0.");
                return;
            }
            if (totalLoad > availableCapacity) {
                showError("Total Load cannot exceed Available Capacity.");
                return;
            }

            double efficiency = (totalLoad / availableCapacity) * 100;

            gridEfficiencyTextField.setText(
                    String.format("%.2f", efficiency));

            if (efficiency >= 95) {
                performanceStatusComboBox.setValue("Excellent");
            }
            else if (efficiency >= 85) {
                performanceStatusComboBox.setValue("Good");
            }
            else if (efficiency >= 70) {
                performanceStatusComboBox.setValue("Average");
            }
            else {
                performanceStatusComboBox.setValue("Poor");
            }

        }
        catch (NumberFormatException e) {
            showError("Please enter valid numeric values.");
        }
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (reportIdTextField.getText().trim().isEmpty()) {
            showError("Please enter Report ID.");
            return;
        }

        if (gridSectionComboBox.getValue() == null) {
            showError("Please select Grid Section.");
            return;
        }

        double totalLoad;
        try {
            totalLoad = Double.parseDouble(totalLoadMWTextField.getText().trim());

            if (totalLoad <= 0) {
                showError("Total Load must be greater than 0.");
                return;
            }

        } catch (NumberFormatException e) {
            showError("Please enter a valid Total Load.");
            return;
        }

        double availableCapacity;
        try {
            availableCapacity = Double.parseDouble(availableCapacityMWTextField.getText().trim());

            if (availableCapacity <= 0) {
                showError("Available Capacity must be greater than 0.");
                return;
            }
            if (totalLoad > availableCapacity) {
                showError("Total Load cannot exceed Available Capacity.");
                return;
            }

        } catch (NumberFormatException e) {
            showError("Please enter a valid Available Capacity.");
            return;
        }

        if (gridEfficiencyTextField.getText().trim().isEmpty()) {
            showError("Please click Generate Report first.");
            return;
        }

        double gridEfficiency = Double.parseDouble(gridEfficiencyTextField.getText());
        if (performanceStatusComboBox.getValue() == null) {
            showError("Please click Generate Report first.");
            return;
        }


        if (reportDatePicker.getValue() == null) {
            showError("Please select Report Date.");
            return;
        }

        if (reportDatePicker.getValue().isBefore(LocalDate.now())) {
            showError("Report Date cannot be in the past.");
            return;
        }

        ViewGridPerformanceReport report = new ViewGridPerformanceReport(
                reportIdTextField.getText().trim(),
                gridSectionComboBox.getValue(),
                totalLoad,
                availableCapacity,
                gridEfficiency,
                performanceStatusComboBox.getValue(),
                reportDatePicker.getValue()
        );

        ViewGridPerformanceReportFileHandler.save(report);

        gridPerformanceTableView.setItems(
                ViewGridPerformanceReportFileHandler.readAll());

        refreshButton(null);

        showSuccess("Grid Performance Report saved successfully.");
    }
}