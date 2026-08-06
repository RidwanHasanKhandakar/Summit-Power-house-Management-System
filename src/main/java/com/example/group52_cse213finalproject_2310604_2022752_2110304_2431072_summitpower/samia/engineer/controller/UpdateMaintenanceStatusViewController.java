package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

public class UpdateMaintenanceStatusViewController
{
    @javafx.fxml.FXML
    private DatePicker maintenanceDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> maintenanceStatusComboBox;
    @javafx.fxml.FXML
    private TextField generatorIdTextField;
    @javafx.fxml.FXML
    private TextField maintenanceIdTextField;
    @javafx.fxml.FXML
    private TextField updatedByTextField;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;

    @javafx.fxml.FXML
    public void initialize() {
        maintenanceStatusComboBox.getItems().addAll(
                "Pending",
                "In Progress",
                "Completed"
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
        maintenanceIdTextField.clear();
        generatorIdTextField.clear();
        maintenanceStatusComboBox.setValue(null);
        maintenanceDatePicker.setValue(null);
        remarksTextArea.clear();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer","engineer-dashboard-view.fxml","Engineer Dashboard");
    }

    @javafx.fxml.FXML
    public void updateButton(ActionEvent actionEvent) {
    }
}