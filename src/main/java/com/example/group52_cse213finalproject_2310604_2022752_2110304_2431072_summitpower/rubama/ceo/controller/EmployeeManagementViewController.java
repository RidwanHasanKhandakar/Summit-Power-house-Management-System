package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.EmployeeManagement;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeManagementViewController
{
    @javafx.fxml.FXML
    private TableView <EmployeeManagement> employeeTableView;
    @javafx.fxml.FXML
    private TableColumn <EmployeeManagement,String> employeeNameCol;
    @javafx.fxml.FXML
    private TextField employeeNameTextField;
    @javafx.fxml.FXML
    private ComboBox <String> roleComboBox;
    @javafx.fxml.FXML
    private TableColumn <EmployeeManagement,String> roleCol;
    @javafx.fxml.FXML
    private TableColumn <EmployeeManagement,String> employeeIdCol;
    @javafx.fxml.FXML
    private TextField employeeIdTextField;

    @javafx.fxml.FXML
    public void initialize() {
        roleComboBox.getItems().addAll("Plant Manager","Accountant","BPDB Officer","HR Manager","Inventory Manager","Engineer","Grid Operator");

        employeeIdCol.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        employeeNameCol.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));
    }

    @javafx.fxml.FXML
    public void handleRemoveEmployee(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleAddEmployee(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","ceo-dashboard-view.fxml","CEO Dashboard");
    }
}