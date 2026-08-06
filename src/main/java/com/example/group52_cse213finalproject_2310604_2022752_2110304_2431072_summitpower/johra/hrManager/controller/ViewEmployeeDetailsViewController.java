package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Employee;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

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
    private TableColumn<Employee, LocalDate> dobCol;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> emailCol;

    @javafx.fxml.FXML
    public void initialize() {

        employeeIdCol.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        employeeNameCol.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        dobCol.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));

        showEmployeeTableView.setItems(FXCollections.observableList(AddEmployeeViewController.employeeList));
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "dashboard-view.fxml", "HR Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void loadTableViewButtonOnAction(ActionEvent actionEvent) {

        showEmployeeTableView.setItems(FXCollections.observableList(AddEmployeeViewController.employeeList));

    }
}