package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmployeeManagementViewController
{
    @javafx.fxml.FXML
    private TableView employeeTableView;
    @javafx.fxml.FXML
    private TableColumn employeeNameCol;
    @javafx.fxml.FXML
    private TextField employeeNameTextField;
    @javafx.fxml.FXML
    private ComboBox roleComboBox;
    @javafx.fxml.FXML
    private TableColumn roleCol;
    @javafx.fxml.FXML
    private TableColumn employeeIdCol;
    @javafx.fxml.FXML
    private TextField employeeIdTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleRemoveEmployee(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleAddEmployee(ActionEvent actionEvent) {
    }
}