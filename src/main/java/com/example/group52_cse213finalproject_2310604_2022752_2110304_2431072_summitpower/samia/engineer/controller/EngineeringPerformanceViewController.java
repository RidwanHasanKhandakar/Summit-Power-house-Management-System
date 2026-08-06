package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.model.EngineeringPerformance;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.engineer.EngineeringPerformanceFileHandler;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class EngineeringPerformanceViewController
{
    @javafx.fxml.FXML
    private TextField reportIdTextField;
    @javafx.fxml.FXML
    private DatePicker reportDatePicker;
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
    private TextField performanceStatusTextField;
    @javafx.fxml.FXML
    private TableColumn<EngineeringPerformance,LocalDate> reportDateTabCol;

    @javafx.fxml.FXML
    public void initialize() {

        efficiencyTextField.setEditable(false);
        performanceStatusTextField.setEditable(false);

        reportIdTabCol.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        generatorIdTabCol.setCellValueFactory(new PropertyValueFactory<>("generatorId"));
        powerOutputTabCol.setCellValueFactory(new PropertyValueFactory<>("powerOutput"));
        efficiencyTabCol.setCellValueFactory(new PropertyValueFactory<>("efficiencyPercentage"));
        reportDateTabCol.setCellValueFactory(new PropertyValueFactory<>("reportDate"));
        performanceStatusTabCol.setCellValueFactory(new PropertyValueFactory<>("performanceStatus"));
        tableView.setItems(EngineeringPerformanceFileHandler.readAll());

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
    public void refreshButton(ActionEvent actionEvent) {
        reportIdTextField.clear();
        generatorIdTextField.clear();
        reportDatePicker.setValue(null);
        powerOutputTextField.clear();
        efficiencyTextField.clear();
        performanceStatusTextField.clear();
        tableView.getSelectionModel().clearSelection();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","engineer-dashboard-view.fxml","Engineer Dashboard");
    }

    @javafx.fxml.FXML
    public void generateReportButton(ActionEvent actionEvent) {
        if (reportIdTextField.getText().trim().isEmpty()) {
            showError("Please enter Report ID.");
            return;
        }

        if (generatorIdTextField.getText().trim().isEmpty()) {
            showError("Please enter Generator ID.");
            return;
        }

        double powerOutput;

        try {
            powerOutput = Double.parseDouble(powerOutputTextField.getText().trim());

            if (powerOutput <= 0) {
                showError("Power Output must be greater than 0.");
                return;
            }

        } catch (NumberFormatException e) {
            showError("Please enter a valid Power Output.");
            return;
        }

        if (reportDatePicker.getValue() == null) {
            showError("Please select Report Date.");
            return;
        }

        if (reportDatePicker.getValue().isBefore(java.time.LocalDate.now())) {
            showError("Report Date cannot be in the past.");
            return;
        }

        double efficiency = powerOutput / 10;

        efficiencyTextField.setText(String.format("%.2f", efficiency));

        if (efficiency >= 95) {
            performanceStatusTextField.setText("Excellent");
        }
        else if (efficiency >= 85) {
            performanceStatusTextField.setText("Good");
        }
        else if (efficiency >= 70) {
            performanceStatusTextField.setText("Average");
        }
        else {
            performanceStatusTextField.setText("Poor");
        }

        showSuccess("Engineering Performance Report Generated Successfully.");
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (reportIdTextField.getText().trim().isEmpty()) {
            showError("Please enter Report ID.");
            return;
        }

        if (generatorIdTextField.getText().trim().isEmpty()) {
            showError("Please enter Generator ID.");
            return;
        }

        double powerOutput;

        try {
            powerOutput = Double.parseDouble(powerOutputTextField.getText().trim());

            if (powerOutput <= 0) {
                showError("Power Output must be greater than 0.");
                return;
            }

        } catch (NumberFormatException e) {
            showError("Please enter a valid Power Output.");
            return;
        }

        if (efficiencyTextField.getText().trim().isEmpty()) {
            showError("Please click Generate Report first.");
            return;
        }

        if (performanceStatusTextField.getText().trim().isEmpty()) {
            showError("Please click Generate Report first.");
            return;
        }

        if (reportDatePicker.getValue() == null) {
            showError("Please select Report Date.");
            return;
        }

        if (reportDatePicker.getValue().isBefore(java.time.LocalDate.now())) {
            showError("Report Date cannot be in the past.");
            return;
        }

        double efficiency = Double.parseDouble(efficiencyTextField.getText());

        EngineeringPerformance performance =
                new EngineeringPerformance(
                        reportIdTextField.getText().trim(),
                        generatorIdTextField.getText().trim(),
                        reportDatePicker.getValue(),
                        powerOutput,
                        efficiency,
                        performanceStatusTextField.getText().trim()
                );

        EngineeringPerformanceFileHandler.save(performance);

        tableView.setItems(
                EngineeringPerformanceFileHandler.readAll());

        refreshButton(null);

        showSuccess("Engineering Performance saved successfully.");
    }
}