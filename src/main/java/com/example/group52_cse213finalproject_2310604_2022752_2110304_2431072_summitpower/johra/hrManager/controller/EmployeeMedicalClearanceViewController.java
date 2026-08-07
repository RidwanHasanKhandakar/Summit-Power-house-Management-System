package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.hrManager.EmployeeMedicalClearanceFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.EmployeeMedicalClearance;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.*
        ;

public class EmployeeMedicalClearanceViewController
{
    @javafx.fxml.FXML
    private TextField clearanceIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> medicalStatusComboBox;
    @javafx.fxml.FXML
    private TextField employeeNameTextField;
    @javafx.fxml.FXML
    private TextField doctorNameTextField;
    @javafx.fxml.FXML
    private DatePicker checkupDateDatePicker;
    @javafx.fxml.FXML
    private TextField employeeIdTextField;

    @javafx.fxml.FXML
    public void initialize() {

        medicalStatusComboBox.getItems().addAll(
                "Cleared",
                "Pending",
                "Not Cleared"
        );

    }

    @javafx.fxml.FXML
    public void saveRecordButtonOnAction(ActionEvent actionEvent) {

        if(employeeIdTextField.getText().isEmpty()){

            showError("Field cannot be empty");
            return;

        }

        if(employeeNameTextField.getText().isEmpty()){

            showError("Field cannot be empty");
            return;

        }

        if(clearanceIdTextField.getText().isEmpty()){

            showError("Field cannot be empty");
            return;

        }

        if(doctorNameTextField.getText().isEmpty()){

            showError("Field cannot be empty");
            return;

        }

        if(checkupDateDatePicker.getValue() == null){

            showError("Field cannot be empty");
            return;

        }

        EmployeeMedicalClearance employeeMedicalClearance = new EmployeeMedicalClearance(clearanceIdTextField.getText(), employeeNameTextField.getText(), employeeNameTextField.getText(), doctorNameTextField.getText(), medicalStatusComboBox.getValue(), checkupDateDatePicker.getValue());

        EmployeeMedicalClearanceFileHandler.save(employeeMedicalClearance);

        showInformation("Employee Medical Clearance recorded successfully !");

    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "dashboard-view.fxml", "HR Manager Dashboard");
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

        clearanceIdTextField.clear();
        medicalStatusComboBox.setValue(null);
        employeeNameTextField.clear();
        doctorNameTextField.clear();
        checkupDateDatePicker.setValue(null);
        employeeIdTextField.clear();

    }
}