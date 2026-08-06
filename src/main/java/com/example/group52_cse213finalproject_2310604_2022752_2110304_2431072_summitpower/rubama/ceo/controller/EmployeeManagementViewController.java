package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.EmployeeManagement;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

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

    private ArrayList<EmployeeManagement> allEmployees = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        roleComboBox.getItems().addAll("Plant Manager","Accountant","BPDB Officer","HR Manager","Inventory Manager","Engineer","Grid Operator");

        employeeIdCol.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        employeeNameCol.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));

        allEmployees.add(new EmployeeManagement("Ridwan Rahin", "RR1", "Engineer"));
        allEmployees.add(new EmployeeManagement("Rubama Mehnaj", "RM2", "Plant Manager"));
        allEmployees.add(new EmployeeManagement("Fatema Johra", "FJ3", "Accountant"));
        allEmployees.add(new EmployeeManagement("Samia Islam", "SI4", "Grid Operator"));

        employeeTableView.getItems().setAll(FXCollections.observableArrayList(allEmployees));
    }

    @javafx.fxml.FXML
    public void handleRemoveEmployee(ActionEvent actionEvent) {
        EmployeeManagement selected = employeeTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            System.out.println("No employee selected to remove!");
            return;
        }
        allEmployees.remove(selected);
        employeeTableView.getItems().setAll(FXCollections.observableArrayList(allEmployees));
    }

    @javafx.fxml.FXML
    public void handleAddEmployee(ActionEvent actionEvent) {
        String id = employeeIdTextField.getText().trim();
        String name = employeeNameTextField.getText().trim();
        String role = roleComboBox.getValue();

        if (id.isEmpty() || name.isEmpty() || role == null) {
            System.out.println("All fields must be filled!");
            return;
        }
        EmployeeManagement newEmp = new EmployeeManagement(id, name, role);
        allEmployees.add(newEmp);

        employeeTableView.getItems().setAll(FXCollections.observableArrayList(allEmployees));

        employeeIdTextField.clear();
        employeeNameTextField.clear();
        roleComboBox.getSelectionModel().clearSelection();
    }

    @javafx.fxml.FXML
    public void handleReturn(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","ceo-dashboard-view.fxml","CEO Dashboard");
    }
}