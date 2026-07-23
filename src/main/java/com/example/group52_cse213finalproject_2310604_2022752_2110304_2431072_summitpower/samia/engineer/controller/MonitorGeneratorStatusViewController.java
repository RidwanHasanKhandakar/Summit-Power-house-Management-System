package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.samia.engineer.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class MonitorGeneratorStatusViewController
{
    @javafx.fxml.FXML
    private TextField powerOutputTextField;
    @javafx.fxml.FXML
    private TextField runningStatusTextField;
    @javafx.fxml.FXML
    private TextField generatorIdTextField;
    @javafx.fxml.FXML
    private TextField runningHoursTextField;
    @javafx.fxml.FXML
    private TextField fuelLevelTextField;
    @javafx.fxml.FXML
    private TextField frequencyTextField;
    @javafx.fxml.FXML
    private ComboBox<String> plantUnitComBox;
    @javafx.fxml.FXML
    private TextField voltageTextField;
    @javafx.fxml.FXML
    private DatePicker maintenanceDateDatePicker;
    @javafx.fxml.FXML
    private TextField engineTemperatureTextField;

    @javafx.fxml.FXML
    public void initialize() {
        plantUnitComBox.getItems().addAll("Unit 1",
                "Unit 2",
                "Unit 3",
                "Unit 4");
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        }
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }
}