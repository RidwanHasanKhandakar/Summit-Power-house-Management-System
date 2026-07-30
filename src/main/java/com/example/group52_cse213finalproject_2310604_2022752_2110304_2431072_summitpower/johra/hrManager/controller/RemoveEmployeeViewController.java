package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Employee;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class RemoveEmployeeViewController
{
    @javafx.fxml.FXML
    private TableColumn<String, Employee> employeeNameCol;
    @javafx.fxml.FXML
    private TableColumn<String, Employee> departmentCol;
    @javafx.fxml.FXML
    private TableColumn<String, Employee> employeeIdCol;
    @javafx.fxml.FXML
    private TableView<Employee> removeEmployeeTableView;
    @javafx.fxml.FXML
    private TableColumn<String, Employee> positionCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void removeButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void searchButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadTableViewButtonOnAction(ActionEvent actionEvent) {
    }
}