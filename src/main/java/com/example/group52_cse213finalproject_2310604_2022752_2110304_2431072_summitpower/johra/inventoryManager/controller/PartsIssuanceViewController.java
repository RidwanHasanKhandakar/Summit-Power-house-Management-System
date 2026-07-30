package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class PartsIssuanceViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> equipmentIdComboBox;
    @javafx.fxml.FXML
    private DatePicker issueDateDatePicker;
    @javafx.fxml.FXML
    private TextField quantityTextField;
    @javafx.fxml.FXML
    private TextField employeeIdTextField;

    @javafx.fxml.FXML
    public void initialize() {

        equipmentIdComboBox.getItems().addAll(
                "100",
                "101",
                "102",
                "103",
                "104"
        );
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent  actionEvent) {
    }

    @javafx.fxml.FXML
    public void savePartsIssuanceButtonOnAction(ActionEvent actionEvent) {
    }
}