package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.fileHandler.gridOperator.TransmissionLineInfoFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.model.TransmissionLineInfo;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class TransmissionLineInfoViewController
{
    @javafx.fxml.FXML
    private TextField lineNameTextField;
    @javafx.fxml.FXML
    private TextField lineLengthTextField;
    @javafx.fxml.FXML
    private TableView<TransmissionLineInfo> transmissionLineTableView;
    @javafx.fxml.FXML
    private TableColumn<TransmissionLineInfo,String> sourceStationColumn;
    @javafx.fxml.FXML
    private TextField sourceStationTextField;
    @javafx.fxml.FXML
    private TableColumn<TransmissionLineInfo,String> destinationStationColumn;
    @javafx.fxml.FXML
    private TableColumn<TransmissionLineInfo,Double> voltageLevelColumn;
    @javafx.fxml.FXML
    private TableColumn<TransmissionLineInfo,String> lineStatusColumn;
    @javafx.fxml.FXML
    private TableColumn<TransmissionLineInfo,String> lineIdColumn;
    @javafx.fxml.FXML
    private TableColumn<TransmissionLineInfo,String> lineNameColumn;
    @javafx.fxml.FXML
    private ComboBox<String> lineStatusComboBox;
    @javafx.fxml.FXML
    private TextField destinationStationTextField;
    @javafx.fxml.FXML
    private TextField lineIdTextField;
    @javafx.fxml.FXML
    private TextField voltageLevelTextField;

    @javafx.fxml.FXML
    public void initialize() {
        lineStatusComboBox.getItems().addAll(
                "Operational",
                "Under Maintenance",
                "Fault"
        );
        lineIdColumn.setCellValueFactory(new PropertyValueFactory<>("lineId"));
        lineNameColumn.setCellValueFactory(new PropertyValueFactory<>("lineName"));
        sourceStationColumn.setCellValueFactory(new PropertyValueFactory<>("sourceStation"));
        destinationStationColumn.setCellValueFactory(new PropertyValueFactory<>("destinationStation"));
        voltageLevelColumn.setCellValueFactory(new PropertyValueFactory<>("voltageLevel"));
        lineStatusColumn.setCellValueFactory(new PropertyValueFactory<>("lineStatus"));
        transmissionLineTableView.setItems(TransmissionLineInfoFileHandler.readAll());
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
        lineIdTextField.clear();
        lineNameTextField.clear();
        sourceStationTextField.clear();
        destinationStationTextField.clear();
        voltageLevelTextField.clear();
        lineLengthTextField.clear();
        lineStatusComboBox.setValue(null);
        transmissionLineTableView.getSelectionModel().clearSelection();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","gridOperator-dashboard-view.fxml","Grid Operator Dashboard");
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (lineIdTextField.getText().trim().isEmpty()) {
            showError("Please enter Line ID.");
            return;
        }

        if (lineNameTextField.getText().trim().isEmpty()) {
            showError("Please enter Line Name.");
            return;
        }

        if (sourceStationTextField.getText().trim().isEmpty()) {
            showError("Please enter Source Station.");
            return;
        }

        if (destinationStationTextField.getText().trim().isEmpty()) {
            showError("Please enter Destination Station.");
            return;
        }

        double voltageLevel;

        try {
            voltageLevel = Double.parseDouble(voltageLevelTextField.getText().trim());

            if (voltageLevel <= 0) {
                showError("Voltage Level must be greater than 0.");
                return;
            }

        } catch (NumberFormatException e) {
            showError("Please enter a valid Voltage Level.");
            return;
        }

        double lineLength;

        try {
            lineLength = Double.parseDouble(lineLengthTextField.getText().trim());

            if (lineLength <= 0) {
                showError("Line Length must be greater than 0.");
                return;
            }

        } catch (NumberFormatException e) {
            showError("Please enter a valid Line Length.");
            return;
        }

        if (lineStatusComboBox.getValue() == null) {
            showError("Please select Line Status.");
            return;
        }

        TransmissionLineInfo line = new TransmissionLineInfo(
                lineIdTextField.getText().trim(),
                lineNameTextField.getText().trim(),
                sourceStationTextField.getText().trim(),
                destinationStationTextField.getText().trim(),
                voltageLevel,
                lineLength,
                lineStatusComboBox.getValue()
        );

        TransmissionLineInfoFileHandler.save(line);

        refreshButton(null);

        transmissionLineTableView.setItems(
                TransmissionLineInfoFileHandler.readAll());

        showSuccess("Transmission Line saved successfully.");
    }
}