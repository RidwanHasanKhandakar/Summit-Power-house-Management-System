package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.hrManager.AddEmplyeeFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Employee;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class  AddEmployeeViewController {
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private DatePicker dateOfBirthDatePicker;
    @javafx.fxml.FXML
    private TextField employeeIdTextfield;
    @javafx.fxml.FXML
    private ComboBox<String> positionComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> departmentComboBox;
    @javafx.fxml.FXML
    private TextField employeeNameTextField;
    @javafx.fxml.FXML
    private TextField salaryTextField;

    //public static List<Employee> employeeList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        positionComboBox.getItems().addAll(
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

        departmentComboBox.getItems().addAll(
                "Operations and Maintenance",
                "Engineering and Technical Services",
                "Finance and Accounts",
                "Supply Chain",
                "Human Resource",
                "Legal and Regulatory Affairs"
        );

    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "dashboard-view.fxml", "HR Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void addEmployeeButtonOnAction(ActionEvent actionEvent) {

        String employeeId = employeeIdTextfield.getText();
        String employeeName = employeeNameTextField.getText();
        String email = emailTextField.getText();
        String department = departmentComboBox.getValue();

        if(department == null){
            showError("Please select a department");
            return;
        }

        String position = positionComboBox.getValue();

        if(position == null){
            showError("Please select a position");
            return;
        }

        LocalDate dateOfBirth = dateOfBirthDatePicker.getValue();

        if(dateOfBirth == null){
            showError("Please pick a date");
            return;
        }

        if(dateOfBirth.isAfter(LocalDate.now())){
            showError("Date of birth cannot be in future!");
            return;
        }

        if(employeeName.isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(employeeId.isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(email.isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(salaryTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        int salary;

        try{
            salary = Integer.parseInt(salaryTextField.getText());

            if(salary <= 0){
                showError("Salary cannot be less than 0");
                return;
            }
        }
        catch(NumberFormatException e){
            showError("Salary must be a number");
            return;
        }



        Employee addEmployee = new Employee(employeeId, employeeName, email, department, position, dateOfBirth, salary);

        AddEmplyeeFileHandler.save(addEmployee);

        //PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "viewEmployeeDetails-view.fxml", "View Employee");

        showInformation("Employee added successfully !");
    }

    public void showInformation(String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Success");
        alert.setContentText(text);
        alert.showAndWait();
    }

    public void showError(String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void refreshButtonOnAction(ActionEvent actionEvent) {

        employeeIdTextfield.clear();
        employeeNameTextField.clear();
        emailTextField.clear();
        positionComboBox.setValue(null);
        departmentComboBox.setValue(null);
        emailTextField.clear();
        salaryTextField.clear();
        dateOfBirthDatePicker.setValue(null);

    }
}