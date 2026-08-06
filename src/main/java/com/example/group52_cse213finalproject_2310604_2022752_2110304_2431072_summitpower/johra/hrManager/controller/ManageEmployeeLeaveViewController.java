package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
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

    }

    @javafx.fxml.FXML
    public void refreshButtonOnAction(ActionEvent actionEvent) {

        leaveIdTextField.clear();
        employeeIdTextField.clear();
        leaveTypeComboBox.setValue(null);
        reasonComboBox.setValue(null);
        totalDaysTextField.getText();
        startDateDatePicker.getValue();
        endDateDatePicker.getValue();
    }
}