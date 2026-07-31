package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddEmployeeViewController
{
    @javafx.fxml.FXML
    private TextField employeeIdComboBox;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private DatePicker dateOfBirthDatePicker;
    @javafx.fxml.FXML
    private TextField employeeIdTextfield;
    @javafx.fxml.FXML
    private ComboBox<String> positionComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> departmentComboBox;
    @javafx.fxml.FXML
    private TextField salaryComboBox;

    @javafx.fxml.FXML
    public void initialize() {

        positionComboBox.getItems().addAll(
                "Plant Manager",
                "Maintenance Engineer",
                "Head of Engineering",
                "Efficiency Engineer",
                "Finance Manager",
                "Plant Accountant",
                "Sourcing Manager",
                "Store Keeper",
                "HR Manager",
                "Site Admin",
                "Legal Counsel",
                "HSE Officer"
        );

        departmentComboBox.getItems().addAll(
                "Operations and Maintenance",
                "Engineering and Technical Services",
                "Finance and Accounts",
                "Supply Chain",
                "Human Resource",
                "Legal and Regulatory Affairs"
        );

    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "dashboardView.fxml", "HR Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void addEmployeeButtonOnAction(ActionEvent actionEvent) {
    }
}