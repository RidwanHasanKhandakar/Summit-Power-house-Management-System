package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Candidate;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Employee;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class EmployeePromotionManagementViewController
{
    @javafx.fxml.FXML
    private TableColumn<String, Employee> employeeNameCol;
    @javafx.fxml.FXML
    private TableColumn<String, Employee> departNameCol;
    @javafx.fxml.FXML
    private TextField newSalaryTextField;
    @javafx.fxml.FXML
    private TableView<Employee> showTableView;
    @javafx.fxml.FXML
    private TableColumn<String, Employee> employeeIdCol;
    @javafx.fxml.FXML
    private TableColumn<Integer, Employee> newSalaryCol;
    @javafx.fxml.FXML
    private TableColumn<String, Employee> newPositionCol;
    @javafx.fxml.FXML
    private ComboBox<String> newpositionComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadTableViewButtonOnAction(ActionEvent actionEvent) {
    }
}