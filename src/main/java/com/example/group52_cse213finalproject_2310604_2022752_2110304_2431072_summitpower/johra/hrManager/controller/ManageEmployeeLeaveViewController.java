package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.hrManager.EmployeeLeaveFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.hrManager.EmployeeTrainingFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.EmployeeLeave;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

public class ManageEmployeeLeaveViewController
{
    @javafx.fxml.FXML
    private TextField leaveIdTextField;
    @javafx.fxml.FXML
    private DatePicker endDateDatePicker;
    @javafx.fxml.FXML
    private TextField totalDaysTextField;
    @javafx.fxml.FXML
    private ComboBox<String> leaveTypeComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> reasonComboBox;
    @javafx.fxml.FXML
    private DatePicker startDateDatePicker;
    @javafx.fxml.FXML
    private TextField employeeIdTextField;

    @javafx.fxml.FXML
    public void initialize() {

        leaveTypeComboBox.getItems().addAll(
                "Casual Leave",
                "Sick Leave",
                "Annual Leave",
                "Emergency Leave",
                "Maternity Leave",
                "Unpaid Leave"
        );

        reasonComboBox.getItems().addAll(
                "Personal Matters",
                "Medical Treatment",
                "Family Emergency",
                "Vacation",
                "Travel",
                "Family Function",
                "Maternity",
                "Childcare",
                "Religious Occasion",
                "Other"
        );
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "dashboard-view.fxml", "HR Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void saveEmployeeLeaveButtonOnAction(ActionEvent actionEvent) {

        if(leaveIdTextField.getText().isEmpty()){

            showError("Field cannot be empty");
            return;
        }

        if(employeeIdTextField.getText().isEmpty()){

            showError("Field cannot be empty");
            return;

        }

        if(leaveTypeComboBox.getValue().isEmpty()){

            showError("Field cannot be empty");
            return;
        }

        if(reasonComboBox.getValue().isEmpty()){

            showError("Field cannot be empty");
            return;
        }

        if(startDateDatePicker.getValue() == null){

            showError("Field cannot be empty");
            return;
        }

        if(endDateDatePicker.getValue() == null){

            showError("Field cannot be empty");
            return;
        }

        EmployeeLeave employeeLeave = new EmployeeLeave(leaveIdTextField.getText(), employeeIdTextField.getText(), leaveTypeComboBox.getValue(), totalDaysTextField.getText(), reasonComboBox.getValue(), startDateDatePicker.getValue(), endDateDatePicker.getValue());

        EmployeeLeaveFileHandler.save(employeeLeave);

        showInformation("Employee leave information recorded successfully !");

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

        leaveIdTextField.clear();
        employeeIdTextField.clear();
        leaveTypeComboBox.setValue(null);
        reasonComboBox.setValue(null);
        totalDaysTextField.clear();
        startDateDatePicker.setValue(null);
        endDateDatePicker.setValue(null);

    }
}