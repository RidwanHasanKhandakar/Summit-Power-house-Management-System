package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Employee;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewEmployeeDetailsViewController
{
    @javafx.fxml.FXML
    private TableColumn<Employee, String> employeeNameCol;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> departmentCol;
    @javafx.fxml.FXML
    private TableColumn<Employee, Integer> salaryCol;
    @javafx.fxml.FXML
    private TableView<Employee> showEmployeeTableView;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> positionCol;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> employeeIdCol;

    @javafx.fxml.FXML
    public void initialize() {

        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        employeeIdCol.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
        employeeNameCol.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void showEmployeeButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadTableViewButtonOnAction(ActionEvent actionEvent) {
    }
}