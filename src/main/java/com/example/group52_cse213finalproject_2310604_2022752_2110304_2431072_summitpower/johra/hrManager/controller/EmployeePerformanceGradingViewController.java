package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class EmployeePerformanceGradingViewController
{
    @javafx.fxml.FXML
    private TextField totalDaysPresentTextField;
    @javafx.fxml.FXML
    private TextField overtimeDaysTextField;
    @javafx.fxml.FXML
    private ComboBox<String> efficiencyScoreComboBox;
    @javafx.fxml.FXML
    private TextField employeeIdTextField;

    @javafx.fxml.FXML
    public void initialize() {

        efficiencyScoreComboBox.getItems().addAll(
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10"
        );
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "dashboardView.fxml", "HR Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void gradeEmployeeButtonOnAction(ActionEvent actionEvent) {
    }
}