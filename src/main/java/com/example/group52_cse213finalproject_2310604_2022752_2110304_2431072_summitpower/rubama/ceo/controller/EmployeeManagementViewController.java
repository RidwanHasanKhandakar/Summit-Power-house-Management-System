package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.ceo.model.EmployeeManagement;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.rubama.fileHandler.ceo.EmployeeManagementFileHandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeManagementViewController {

    @FXML
    private TableView<EmployeeManagement> employeeTableView;

    @FXML
    private TableColumn<EmployeeManagement, String> employeeNameCol;

    @FXML
    private TextField employeeNameTextField;

    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    private TableColumn<EmployeeManagement, String> roleCol;

    @FXML
    private TableColumn<EmployeeManagement, String> employeeIdCol;

    @FXML
    private TextField employeeIdTextField;


    @FXML
    public void initialize() {

        roleComboBox.setItems(
                FXCollections.observableArrayList(
                        "Plant Manager",
                        "Accountant",
                        "BPDB Officer",
                        "HR Manager",
                        "Inventory Manager",
                        "Engineer",
                        "Grid Operator"
                )
        );


        employeeIdCol.setCellValueFactory(
                new PropertyValueFactory<>("employeeId")
        );

        employeeNameCol.setCellValueFactory(
                new PropertyValueFactory<>("employeeName")
        );

        roleCol.setCellValueFactory(
                new PropertyValueFactory<>("role")
        );


        loadEmployees();
    }


    private void loadEmployees() {

        ObservableList<EmployeeManagement> employees =
                EmployeeManagementFileHandler.readAll();

        employeeTableView.setItems(employees);

        employeeTableView.refresh();
    }


    @FXML
    public void handleAddEmployee(ActionEvent actionEvent) {

        String employeeId =
                employeeIdTextField.getText().trim();

        String employeeName =
                employeeNameTextField.getText().trim();

        String role =
                roleComboBox.getValue();


        /*
         * Validate required fields.
         */
        if (employeeId.isEmpty()) {

            showError(
                    "Please enter the Employee ID."
            );

            return;
        }


        if (employeeName.isEmpty()) {

            showError(
                    "Please enter the Employee Name."
            );

            return;
        }


        if (role == null ||
                role.trim().isEmpty()) {

            showError(
                    "Please select an Employee Role."
            );

            return;
        }


        /*
         * Verify that Employee ID is unique.
         *
         * This directly satisfies the CRA requirement:
         * "The system checks that the employee ID is
         * not already used."
         */
        ObservableList<EmployeeManagement> employees =
                EmployeeManagementFileHandler.readAll();


        for (EmployeeManagement employee : employees) {

            if (employee.getEmployeeId() != null &&
                    employee.getEmployeeId()
                            .equalsIgnoreCase(employeeId)) {

                showError(
                        "Employee ID already exists.\n" +
                                "Please enter a different Employee ID."
                );

                return;
            }
        }


        /*
         * Create employee.
         */
        EmployeeManagement newEmployee =
                new EmployeeManagement(
                        employeeName,
                        employeeId,
                        role
                );


        /*
         * Save employee permanently.
         */
        EmployeeManagementFileHandler.save(
                newEmployee
        );


        /*
         * Refresh TableView.
         */
        loadEmployees();


        /*
         * Clear input fields.
         */
        clearFields();


        /*
         * CRA-required success notification.
         */
        showSuccess(
                "Employee added successfully."
        );
    }


    @FXML
    public void handleRemoveEmployee(ActionEvent actionEvent) {

        EmployeeManagement selectedEmployee =
                employeeTableView
                        .getSelectionModel()
                        .getSelectedItem();


        if (selectedEmployee == null) {

            showError(
                    "Please select an employee to remove."
            );

            return;
        }


        /*
         * Ask for confirmation before removing.
         */
        Alert confirmation =
                new Alert(
                        Alert.AlertType.CONFIRMATION
                );

        confirmation.setTitle(
                "Remove Employee"
        );

        confirmation.setHeaderText(
                "Remove Selected Employee?"
        );

        confirmation.setContentText(
                "Employee ID: " +
                        selectedEmployee.getEmployeeId() +
                        "\nEmployee Name: " +
                        selectedEmployee.getEmployeeName()
        );


        var result =
                confirmation.showAndWait();


        if (result.isEmpty() ||
                result.get() !=
                        javafx.scene.control.ButtonType.OK) {

            return;
        }


        /*
         * Remove from current list.
         */
        ObservableList<EmployeeManagement> employees =
                EmployeeManagementFileHandler.readAll();

        employees.remove(selectedEmployee);


        /*
         * Save updated list.
         */
        EmployeeManagementFileHandler.saveAll(
                employees
        );


        /*
         * Refresh TableView.
         */
        loadEmployees();


        /*
         * CRA-required success notification.
         */
        showSuccess(
                "Employee removed successfully."
        );
    }


    private void clearFields() {

        employeeIdTextField.clear();

        employeeNameTextField.clear();

        roleComboBox
                .getSelectionModel()
                .clearSelection();
    }


    private void showError(String message) {

        Alert alert =
                new Alert(
                        Alert.AlertType.ERROR
                );

        alert.setTitle("Error");

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();
    }


    private void showSuccess(String message) {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setTitle("Success");

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();
    }


    @FXML
    public void handleReturn(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene(
                (Node) actionEvent.getSource(),
                "rubama",
                "ceo",
                "ceo-dashboard-view.fxml",
                "CEO Dashboard"
        );
    }
}
