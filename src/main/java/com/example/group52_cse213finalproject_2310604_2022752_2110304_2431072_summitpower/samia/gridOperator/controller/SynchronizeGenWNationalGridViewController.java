package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.gridOperator.SynchronizeGenWNationalGridFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.SynchronizeGenWNationalGrid;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class SynchronizeGenWNationalGridViewController
{
    @javafx.fxml.FXML
    private DatePicker synchronizationDatePicker;
    @javafx.fxml.FXML
    private TextField synchronizationIdTextField;
    @javafx.fxml.FXML
    private TextField generatorIdTextField;
    @javafx.fxml.FXML
    private TextField gridVoltageTextField;
    @javafx.fxml.FXML
    private TextField generatorVoltageTextField;
    @javafx.fxml.FXML
    private ComboBox<String> synchronizationStatusComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> gridSectionComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        gridSectionComboBox.getItems().addAll(
                "North Grid",
                "South Grid",
                "East Grid",
                "West Grid"
        );
        synchronizationStatusComboBox.getItems().addAll(
                "Successful",
                "Pending",
                "Failed"
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
        synchronizationIdTextField.clear();
        generatorIdTextField.clear();
        gridSectionComboBox.setValue(null);
        generatorVoltageTextField.clear();
        gridVoltageTextField.clear();
        synchronizationStatusComboBox.setValue(null);
        synchronizationDatePicker.setValue(null);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","gridOperator-dashboard-view.fxml","Grid Operator Dashboard");
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (synchronizationIdTextField.getText().trim().isEmpty()) {
            showError("Please enter Synchronization ID.");
            return;
        }

        if (generatorIdTextField.getText().trim().isEmpty()) {
            showError("Please enter Generator ID.");
            return;
        }

        if (gridSectionComboBox.getValue() == null) {
            showError("Please select Grid Section.");
            return;
        }

        double generatorVoltage;
        double gridVoltage;

        try {
            generatorVoltage = Double.parseDouble(generatorVoltageTextField.getText());

            if (generatorVoltage <= 0) {
                showError("Generator Voltage must be greater than 0.");
                return;
            }

        } catch (NumberFormatException e) {
            showError("Please enter a valid Generator Voltage.");
            return;
        }

        try {
            gridVoltage = Double.parseDouble(gridVoltageTextField.getText());

            if (gridVoltage <= 0) {
                showError("Grid Voltage must be greater than 0.");
                return;
            }

        } catch (NumberFormatException e) {
            showError("Please enter a valid Grid Voltage.");
            return;
        }
        if (generatorVoltage != gridVoltage) {
            showError("Generator Voltage and Grid Voltage must be equal for synchronization.");
            return;
        }

        if (synchronizationStatusComboBox.getValue() == null) {
            showError("Please select Synchronization Status.");
            return;
        }

        if (synchronizationDatePicker.getValue() == null) {
            showError("Please select Synchronization Date.");
            return;
        }

        if (synchronizationDatePicker.getValue().isBefore(java.time.LocalDate.now())) {
            showError("Synchronization Date cannot be in the past.");
            return;
        }

        SynchronizeGenWNationalGrid sync =
                new SynchronizeGenWNationalGrid(
                        synchronizationIdTextField.getText().trim(),
                        generatorIdTextField.getText().trim(),
                        gridSectionComboBox.getValue(),
                        generatorVoltage,
                        gridVoltage,
                        synchronizationStatusComboBox.getValue(),
                        synchronizationDatePicker.getValue()
                );

        SynchronizeGenWNationalGridFileHandler.save(sync);

        showSuccess("Synchronization record saved successfully.");

        refreshButton(null);
    }
}