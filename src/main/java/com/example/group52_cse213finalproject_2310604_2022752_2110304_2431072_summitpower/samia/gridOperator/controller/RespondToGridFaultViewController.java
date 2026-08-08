package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.GridFaultOperation;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.SamiaSceneSwitch;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.gridOperator.RespondToGridFaultFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.RespondToGridFault;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.io.IOException;

public class RespondToGridFaultViewController
{
    @javafx.fxml.FXML
    private TextField faultIdTextField;
    @javafx.fxml.FXML
    private TextArea responseActionTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> faultStatusComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> faultTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker faultDatePicker;
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
        faultTypeComboBox.getItems().addAll(
                "Power Failure",
                "Short Circuit",
                "Transmission Fault",
                "Equipment Failure"
        );
        faultStatusComboBox.getItems().addAll(
                "Pending",
                "In Progress",
                "Resolved"
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
        faultIdTextField.clear();
        gridSectionComboBox.setValue(null);
        faultTypeComboBox.setValue(null);
        faultDatePicker.setValue(null);
        responseActionTextArea.clear();
        faultStatusComboBox.setValue(null);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        SamiaSceneSwitch.samiaSceneSwitch((Node) actionEvent.getSource(),
                "gridOperator",
                "gridOperator-dashboard-view.fxml",
                "Grid Operator Dashboard"
        );
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (faultIdTextField.getText().trim().isEmpty()) {
            showError("Please enter Fault ID.");
            return;
        }

        if (gridSectionComboBox.getValue() == null) {
            showError("Please select Grid Section.");
            return;
        }

        if (faultTypeComboBox.getValue() == null) {
            showError("Please select Fault Type.");
            return;
        }

        if (faultDatePicker.getValue() == null) {
            showError("Please select Fault Date.");
            return;
        }
        if (faultDatePicker.getValue().isAfter(java.time.LocalDate.now())) {
            showError("Fault Date cannot be in the future.");
            return;
        }

        if (faultStatusComboBox.getValue() == null) {
            showError("Please select Fault Status.");
            return;
        }

        String responseAction = responseActionTextArea.getText().trim();

        if (responseAction.isEmpty()) {
            showError("Please enter Response Action.");
            return;
        }

        if (responseAction.length() > 300) {
            showError("Response Action cannot exceed 300 characters.");
            return;
        }
        GridFaultOperation operation =
                new GridFaultOperation(
                        faultIdTextField.getText().trim(),
                        faultDatePicker.getValue(),
                        gridSectionComboBox.getValue(),
                        faultTypeComboBox.getValue()
                );

        String operationMessage = operation.executeOperation();

        RespondToGridFault respondToGridFault =
                new RespondToGridFault(
                        faultIdTextField.getText().trim(),
                        gridSectionComboBox.getValue(),
                        faultTypeComboBox.getValue(),
                        faultDatePicker.getValue(),
                        responseAction,
                        faultStatusComboBox.getValue()
                );

        RespondToGridFaultFileHandler.save(respondToGridFault);

        refreshButton(null);

        showSuccess(
                "Grid fault response saved successfully.\n\n"
                        + operationMessage
        );
    }

    @javafx.fxml.FXML
    public void viewHistoryButton(ActionEvent actionEvent) throws IOException {
        SamiaSceneSwitch.samiaSceneSwitch((Node) actionEvent.getSource(),
                "gridOperator",
                "respond-grid-fault-history.fxml",
                "View Grid Fault History"
        );
    }
}
