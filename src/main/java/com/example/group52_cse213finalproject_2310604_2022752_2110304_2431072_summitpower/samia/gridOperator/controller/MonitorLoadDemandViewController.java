package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.gridOperator.MonitorLoadDemandFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.MonitorLoadDemand;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class MonitorLoadDemandViewController
{
    @javafx.fxml.FXML
    private TextField currentLoadMWTextField;
    @javafx.fxml.FXML
    private ComboBox<String> demandStatusComboBox;
    @javafx.fxml.FXML
    private DatePicker monitoringDatePicker;
    @javafx.fxml.FXML
    private TextField demandIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> gridSectionComboBox;
    @javafx.fxml.FXML
    private TextField availableCapacityMWTextField;

    @javafx.fxml.FXML
    public void initialize() {

        gridSectionComboBox.getItems().addAll(
                "North Grid",
                "South Grid",
                "East Grid",
                "West Grid"
        );
        demandStatusComboBox.getItems().addAll(
                "Normal",
                "High Demand",
                "Critical"
        );

        currentLoadMWTextField.setEditable(false);
        availableCapacityMWTextField.setEditable(false);

        gridSectionComboBox.setDisable(true);
        demandStatusComboBox.setDisable(true);

        monitoringDatePicker.setDisable(true);
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
    public void searchButton(ActionEvent actionEvent) {
        String demandId = demandIdTextField.getText().trim();

        if (demandId.isEmpty()) {
            showError("Please enter Demand ID.");
            return;
        }

        for (MonitorLoadDemand demand : MonitorLoadDemandFileHandler.readAll()) {

            if (demand.getDemandId().equalsIgnoreCase(demandId)) {

                gridSectionComboBox.setValue(demand.getGridSection());
                currentLoadMWTextField.setText(String.valueOf(demand.getCurrentLoadMW()));
                availableCapacityMWTextField.setText(String.valueOf(demand.getAvailableCapacityMW()));
                demandStatusComboBox.setValue(demand.getDemandStatus());
                monitoringDatePicker.setValue(demand.getMonitoringDate());

                showSuccess("Record Found!");
                return;
            }
        }

        refreshButton(null);
        showError("No record found with this Demand ID.");
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        demandIdTextField.clear();
        gridSectionComboBox.setValue(null);
        currentLoadMWTextField.clear();
        availableCapacityMWTextField.clear();
        demandStatusComboBox.setValue(null);
        monitoringDatePicker.setValue(null);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","gridOperator-dashboard-view.fxml","Grid Operator Dashboard");
    }
}