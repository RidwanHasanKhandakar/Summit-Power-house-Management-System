package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.CurrentUser;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class DashboardViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void managePromotionButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "employeePromotionManagement-view.fxml", "Manage Promotion");
    }

    @javafx.fxml.FXML
    public void manageEmployeeTrainingButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "manageEmployeeTraining-view.fxml", "Manage Training");
    }

    @javafx.fxml.FXML
    public void profileButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "employeePromotionManagement-view.fxml", "Manage Promotion");
    }

    @javafx.fxml.FXML
    public void viewEmployeeDetailsButtonOnAction(ActionEvent actionEvent) {
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
            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan", "commonFiles", "sign-up-view.fxml", "Sign Up");
        }
    }

    @javafx.fxml.FXML
    public void performanceGradingButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "employeePerformanceGrading-view.fxml", "Promotion Management");
    }

    @javafx.fxml.FXML
    public void candidateSelectionButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "candidateSelection-view.fxml", "Candidate Selection");
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
    public void removeCurrentEmployeeOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "removeEmployee-view.fxml", "Remove Employee");
    }
}