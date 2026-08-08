package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.gridOperator.LoadDistributionFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.LoadDistribution;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

public class LoadDistributionViewController
{
    @javafx.fxml.FXML
    private DatePicker distributionDatePicker;
    @javafx.fxml.FXML
    private TextField loadMWTextField;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> gridSectionComboBox;
    @javafx.fxml.FXML
    private TextField distributionIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> distributionStatusComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        gridSectionComboBox.getItems().addAll(
                "North Grid",
                "South Grid",
                "East Grid",
                "West Grid"
        );

        distributionStatusComboBox.getItems().addAll(
                "Distributed",
                "Pending",
                "Cancelled"
        );
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
        distributionIdTextField.clear();
        gridSectionComboBox.setValue(null);
        loadMWTextField.clear();
        distributionStatusComboBox.setValue(null);
        distributionDatePicker.setValue(null);
        remarksTextArea.clear();
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (distributionIdTextField.getText().trim().isEmpty()) {
            showError("Please enter Distribution ID.");
            return;
        }

        if (gridSectionComboBox.getValue() == null) {
            showError("Please select Grid Section.");
            return;
        }

        double loadMW;

        try {
            loadMW = Double.parseDouble(loadMWTextField.getText());

            if (loadMW <= 0) {
                showError("Load must be greater than 0.");
                return;
            }

        } catch (NumberFormatException e) {
            showError("Please enter a valid Load (MW).");
            return;
        }

        if (distributionStatusComboBox.getValue() == null) {
            showError("Please select Distribution Status.");
            return;
        }

        if (distributionDatePicker.getValue() == null) {
            showError("Please select Distribution Date.");
            return;
        }
        if (distributionDatePicker.getValue().isBefore(java.time.LocalDate.now())) {
            showError("Distribution Date cannot be in the past.");
            return;
        }

        String remarks = remarksTextArea.getText().trim();

        if (remarks.isEmpty()) {
            showError("Please enter Remarks.");
            return;
        }

        if (remarks.length() > 300) {
            showError("Remarks cannot exceed 300 characters.");
            return;
        }

        LoadDistribution loadDistribution = new LoadDistribution(
                distributionIdTextField.getText().trim(),
                gridSectionComboBox.getValue(),
                loadMW,
                distributionStatusComboBox.getValue(),
                distributionDatePicker.getValue(),
                remarks
        );

        LoadDistributionFileHandler.save(loadDistribution);
        System.out.println("Saved!");
        System.out.println(loadDistribution);
        System.out.println(LoadDistributionFileHandler.readAll());
        System.out.println("Saved records: " + LoadDistributionFileHandler.readAll().size());

        showSuccess("Load Distribution saved successfully.");
        refreshButton(null);
    }

    @javafx.fxml.FXML
    public void viewHistoryButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "samia", "gridOperator", "load-distribution-history.fxml", "Load Distribution History");
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","gridOperator-dashboard-view.fxml","Grid Operator Dashboard");

    }
}