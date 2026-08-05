package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.gridOperator.LoadDistributionFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.LoadDistribution;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class MonitorLoadDemandViewController
{
    @javafx.fxml.FXML
    private TextField currentLoadMWTextField;
    @javafx.fxml.FXML
    private TextField demandIdTextField;
    @javafx.fxml.FXML
    private TextField availableCapacityMWTextField;
    @javafx.fxml.FXML
    private TextField demandStatusTextField;
    @javafx.fxml.FXML
    private TextField monitoringDateTextField;
    @javafx.fxml.FXML
    private TextField gridSectionTextField;

    @javafx.fxml.FXML
    public void initialize() {

        gridSectionTextField.setEditable(false);
        currentLoadMWTextField.setEditable(false);
        availableCapacityMWTextField.setEditable(false);
        demandStatusTextField.setEditable(false);
        monitoringDateTextField.setEditable(false);
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

        for (LoadDistribution demand : LoadDistributionFileHandler.readAll()) {

            if (demand.getDistributionId().equalsIgnoreCase(demandId)) {

                gridSectionTextField.setText(demand.getGridSection());

                currentLoadMWTextField.setText(String.valueOf(demand.getLoadMW()));

// Assume every grid has 1000 MW capacity
                double totalCapacity = 1000;
                double availableCapacity = totalCapacity - demand.getLoadMW();

                availableCapacityMWTextField.setText(String.valueOf(availableCapacity));

                if (demand.getLoadMW() < 500) {
                    demandStatusTextField.setText("Normal");
                }
                else if (demand.getLoadMW() < 800) {
                    demandStatusTextField.setText("High Demand");
                }
                else {
                    demandStatusTextField.setText("Critical");
                }

                monitoringDateTextField.setText(demand.getDistributionDate().toString());

                showSuccess("Record Found!");
                return;
            }
        }

        refreshButton(null);
        showError("No record found with this Demand ID.");
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        gridSectionTextField.clear();
        currentLoadMWTextField.clear();
        availableCapacityMWTextField.clear();
        demandStatusTextField.clear();
        monitoringDateTextField.clear();
        demandIdTextField.clear();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","gridOperator-dashboard-view.fxml","Grid Operator Dashboard");
    }
}
//The monitor page retrieves the load information from the previously scheduled load distribution record. Therefore the Distribution ID is used as the unique identifier.