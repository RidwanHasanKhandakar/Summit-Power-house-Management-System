package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.gridOperator.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    public void BackButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","gridOperator-dashboard-view.fxml","Grid Operator Dashboard");
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}