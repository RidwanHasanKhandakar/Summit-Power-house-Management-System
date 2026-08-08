package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.CurrentUser;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Optional;

public class DashboardViewController
{

    @javafx.fxml.FXML
    private Label hrManagerOfficerNameLabel;

    @javafx.fxml.FXML
    public void initialize() {
        User user = CurrentUser.getUser();

        if (user!=null){
            hrManagerOfficerNameLabel.setText(CurrentUser.getUser().getFirstName()+" "+CurrentUser.getUser().getLastName());
        }
    }

    @javafx.fxml.FXML
    public void manageEmployeeTrainingButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "manageEmployeeTraining-view.fxml", "Manage Training");
    }

    @javafx.fxml.FXML
    public void profileButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "commonFiles", "profile-view.fxml", "Profile");
    }

    @javafx.fxml.FXML
    public void logOutButtonOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout!");
        alert.setHeaderText("Confirm Log Out");
        alert.setContentText("Are you sure you want to log out?");
        Optional<ButtonType> res = alert.showAndWait();
        if(res.isPresent() && res.get() == ButtonType.OK){
            CurrentUser.logout();
            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "commonFiles", "log-in-view.fxml", "Login");
        }
    }

    Stage stage;

    @javafx.fxml.FXML
    public void performanceGradingButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "employeePerformanceGrading-view.fxml", "Promotion Management");
    }

    @javafx.fxml.FXML
    public void addEmployeeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "addEmployee-view.fxml", "Add Employee");
    }

    @javafx.fxml.FXML
    public void createNoticeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "createNotice-view.fxml", "Create Notice");
    }

    @javafx.fxml.FXML
    public void employeeMedicalClearanceButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "employeeMedicalClearance-view.fxml", "Employee Medical Clearance");
    }

    @javafx.fxml.FXML
    public void manageEmployeeLeaveButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "manageEmployeeLeave-view.fxml", "Manage Employee Leave");
    }

    @javafx.fxml.FXML
    public void employeeAwardManagementButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "employeeAwardManagement-view.fxml", "Employee Award Management");
    }

    @javafx.fxml.FXML
    public void viewEmployeeDetailsButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "viewEmployeeDetails-view.fxml", "View Employee Details");
    }
}