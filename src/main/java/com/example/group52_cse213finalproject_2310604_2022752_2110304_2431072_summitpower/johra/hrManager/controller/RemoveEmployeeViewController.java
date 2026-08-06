package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Employee;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

public class RemoveEmployeeViewController
{
    @javafx.fxml.FXML
    private TableColumn<Employee, String> employeeNameCol;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> departmentCol;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> employeeIdCol;
    @javafx.fxml.FXML
    private TableView<Employee> removeEmployeeTableView;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> positionCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void removeButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "dashboardView.fxml", "HR Manager Dashboard");
    }

    @Deprecated
    public void searchButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadTableViewButtonOnAction(ActionEvent actionEvent) {
    }
}