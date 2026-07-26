package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.commonFiles;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogInViewController
{
    @javafx.fxml.FXML
    private TextField userIdTextField;
    @javafx.fxml.FXML
    private PasswordField passwordPasswordField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleCreateAnAccountButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan","commonFiles", "sign-up-view.fxml","Sign Up!");
    }

    @javafx.fxml.FXML
    public void handleLogInButton(ActionEvent actionEvent) {
        String userId = userIdTextField.getText().trim();
        String password = passwordPasswordField.getText().trim();
        if (userId.isEmpty()||password.isEmpty()){
            showError("Please fill out all fields");
            return;
        } else if (userId.equals("bpdb")&&password.equals("123")) {
            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","bpdbOfficer", "bpdbOfficer-dashboard-view.fxml","BPDB Officer Dashboard!1");
        } else if (userId.equals("acc")&&password.equals("321")) {
            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan", "accountant", "accountant-dashboard-view.fxml","Accountant Dashboard!1");
        } else if(userId.equals("ceo")&&password.equals("123")){
            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","ceo-dashboard-view.fxml","Ceo Dashboard!");
        }
    }
    public void showError(String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }
}