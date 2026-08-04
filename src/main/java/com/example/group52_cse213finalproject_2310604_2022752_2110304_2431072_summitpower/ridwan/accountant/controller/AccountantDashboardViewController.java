package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.accountant.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.CurrentUser;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.User;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.rrhinSceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class AccountantDashboardViewController
{
    @javafx.fxml.FXML
    private Text officerNameText;

    @javafx.fxml.FXML
    public void initialize() {

        User user = CurrentUser.getUser();
        if(user!=null){
            officerNameText.setText(CurrentUser.getUser().getFirstName()+" "+CurrentUser.getUser().getLastName());
        }

    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    @javafx.fxml.FXML
    public void handleTrackFuelButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "Fuel-Inventory-view.fxml","Fuel Inventory!");

    }

    @javafx.fxml.FXML
    public void handleTaxAndAuditRequestButton(ActionEvent actionEvent) throws IOException {

        //PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "tax-audit-view.fxml","Tax And Audit Records!");
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower/ridwan/accountant/tax-audit-view.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Tax Audit!");

    }

    @javafx.fxml.FXML
    public void handleProfitLossReportsButton(ActionEvent actionEvent) {

        //PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "Profit-Loss-Reports-view.fxml","Profit Loss Reports!");
        rrhinSceneSwitch.rahinSceneSwitcher((Node) actionEvent.getSource(), "accountant", "Profit-Loss-Reports-view.fxml","Profit Loss Reports!");

    }

    @javafx.fxml.FXML
    public void handleFuelInventoryButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "Fuel-Inventory-view.fxml","Fuel Inventory!");

    }

    @javafx.fxml.FXML
    public void handleLogIncomeButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "Log-Income-view.fxml","Log Income!");

    }

    @javafx.fxml.FXML
    public void handleApprovePurchaseRequestButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "purchase-request-view.fxml","Approve Purchase Request!");

    }

    @javafx.fxml.FXML
    public void handleSalaryPaymentsButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "Salary-Payments-view.fxml","Salary Payments!");

    }

    @javafx.fxml.FXML
    public void handleLogoutButton(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout!");
        alert.setHeaderText("Confirm Logout!");
        alert.setContentText("Are you sure you want to logout >?");
        Optional<ButtonType> res = alert.showAndWait();
        if (res.get()==ButtonType.OK){
            CurrentUser.logout();
            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","commonFiles", "log-in-view.fxml","Log in!");
        }

    }

    @javafx.fxml.FXML
    public void handleProfileButton(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","commonFiles", "profile-view.fxml","Accountant Profile!");

    }

    @javafx.fxml.FXML
    public void handleFinancialStatements(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "Financial-Statements-view.fxml","Financial Statements!");

    }
}