package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.hrManager.EmployeeAwardFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.EmployeeAward;
import javafx.scene.Node;
import javafx.scene.control.*;

import javafx.event.ActionEvent;

public class EmployeeAwardManagementViewController
{
    @javafx.fxml.FXML
    private DatePicker awardDateDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> awardTypeComboBox;
    @javafx.fxml.FXML
    private TextField employeeNameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> awardNameComboBox;
    @javafx.fxml.FXML
    private TextField employeeIdTextField;

    @javafx.fxml.FXML
    public void initialize() {

        awardTypeComboBox.getItems().addAll(
                "Performance",
                "Safety",
                "Attendance",
                "Teamwork",
                "Leadership",
                "Innovation",
                "Service",
                "Special Recognition"
        );

        awardNameComboBox.getItems().addAll(
                "Best Employee of the Month",
                "Outstanding Performance Award",
                "Best Safety Performer",
                "Perfect Attendance Award",
                "Team Excellence Award",
                "Leadership Award",
                "Innovation Award",
                "Employee of the Year"
        );
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "dashboard-view.fxml", "HR Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void saveEmployeeAwardButtonOnAction(ActionEvent actionEvent) {
        if(employeeIdTextField.getText().isEmpty()){
            showError("Field cannot be empty !");
            return;
        }

        if(employeeNameTextField.getText().isEmpty()){
            showError("Field cannot be empty !");
            return;
        }

        if(awardNameComboBox.getValue() == null){
            showError("Field cannot be empty !");
            return;
        }

        if(awardTypeComboBox.getValue() == null){
            showError("Field cannot be empty !");
            return;
        }

        if(awardDateDatePicker.getValue() == null){
            showError("Field cannot be empty !");
            return;
        }

        EmployeeAward employeeAward = new EmployeeAward(employeeIdTextField.getText(), employeeNameTextField.getText(), awardNameComboBox.getValue(), awardTypeComboBox.getValue(),awardDateDatePicker.getValue());

        EmployeeAwardFileHandler.save(employeeAward);

        showInformation("Employee award information recorded successfully !");
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

        employeeIdTextField.clear();
        employeeNameTextField.clear();
        awardTypeComboBox.setValue(null);
        awardNameComboBox.setValue(null);
        awardDateDatePicker.setValue(null);
    }
}