package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.commonFiles;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class LogInViewController
{
    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private TextField userIdTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleCreateAnAccountButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "sign-up-view.fxml","Sign-Up");
    }

    @javafx.fxml.FXML
    public void handleLogInButton(ActionEvent actionEvent) {
        String userId = userIdTextField.getText();
        String password = passwordTextField.getText();
        if (userId.isEmpty()||password.isEmpty()){
            showError("Please fill out all fields");
            return;
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