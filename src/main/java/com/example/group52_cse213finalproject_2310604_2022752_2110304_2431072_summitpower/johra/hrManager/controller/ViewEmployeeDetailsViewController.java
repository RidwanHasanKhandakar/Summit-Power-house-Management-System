package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.hrManager.AddEmplyeeFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Employee;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
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
    private ComboBox<String> filterDepartmentComboBox;

    @javafx.fxml.FXML
    public void initialize() {

        filterDepartmentComboBox.getItems().addAll(
                "Operations and Maintenance",
                "Engineering and Technical Services",
                "Finance and Accounts",
                "Supply Chain",
                "Human Resource",
                "Legal and Regulatory Affairs"
        );

        employeeIdCol.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        employeeNameCol.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        dobCol.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));

        //showEmployeeTableView.setItems(AddEmplyeeFileHandler.readAll());

        //showEmployeeTableView.setItems(FXCollections.observableList(AddEmployeeViewController.employeeList));
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "dashboard-view.fxml", "HR Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void loadTableViewButtonOnAction(ActionEvent actionEvent) {

        String department =  filterDepartmentComboBox.getValue();

        showEmployeeTableView.getItems().clear();

        if (department == null) {
            showEmployeeTableView.setItems(AddEmplyeeFileHandler.readAll());
            return;
        }

        for(Employee employee : AddEmplyeeFileHandler.readAll()){
            if(employee.getDepartment().equals(department)){
                showEmployeeTableView.getItems().add(employee);
            }
        }

        //showEmployeeTableView.setItems(FXCollections.observableList(AddEmployeeViewController.employeeList));

    }

    @javafx.fxml.FXML
    public void refreshButtonOnAction(ActionEvent actionEvent) {

        filterDepartmentComboBox.setValue(null);

    }
}