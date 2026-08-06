package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Candidate;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Employee;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

public class EmployeePromotionManagementViewController
{
    @javafx.fxml.FXML
    private TableColumn<Employee, String> employeeNameCol;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> departNameCol;
    @javafx.fxml.FXML
    private TextField newSalaryTextField;
    @javafx.fxml.FXML
    private TableView<Employee> showTableView;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> employeeIdCol;
    @javafx.fxml.FXML
    private TableColumn<Employee, Integer> newSalaryCol;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> newPositionCol;
    @javafx.fxml.FXML
    private ComboBox<String> newpositionComboBox;

    @javafx.fxml.FXML
    public void initialize() {

        newpositionComboBox.getItems().addAll(
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
    }

    @javafx.fxml.FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "dashboardView.fxml", "HR Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void loadTableViewButtonOnAction(ActionEvent actionEvent) {
    }
}