package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.commonFiles;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.User;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.UserFileHandler;
import javafx.collections.ObservableList;
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
        }
//        else if (userId.equals("bpdb")&&password.equals("123")) {
//            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","bpdbOfficer", "bpdbOfficer-dashboard-view.fxml","BPDB Officer Dashboard!1");
//        } else if (userId.equals("acc")&&password.equals("321")) {
//            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan", "accountant", "accountant-dashboard-view.fxml","Accountant Dashboard!1");
//        } else if(userId.equals("ceo")&&password.equals("123")){
//            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","ceo-dashboard-view.fxml","Ceo Dashboard!");
//        }
        ObservableList<User> users = UserFileHandler.readAll();

        for (User user : users){
            if (user.getUserId().equals(userId)&&user.getPassword().equals(password)){
                if (user.getRole().equals("CEO")){
                    PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo", "ceo-dashboard-view.fxml","CEO Dashboard!");
                }
                else if (user.getRole().equals("Plant Manager")) {
                    PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","plant_manager", "plant_manager-dashboard-view.fxml","Plant Manager Dashboard!");
                }
                else if (user.getRole().equals("BPDB Officer")){
                    PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","bpdbOfficer", "bpdbOfficer-dashboard-view.fxml","BPDB Officer Dashboard!");
                }
                else if (user.getRole().equals("Accountant")){
                    PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","accountant", "accountant-dashboard-view.fxml","Accountant Dashboard!");
                }
                else if (user.getRole().equals("HR Manager")){
                    PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"johra","hrManager", "dashboard-view.fxml","HR Manager Dashboard!");
                }
                else if (user.getRole().equals("Inventory Manager")){
                    PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"johra","inventoryManager", "dashboard-view.fxml","Inventory Manager Dashboard!");
                }
                else if (user.getRole().equals("Engineer")){
                    PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","engineer", "engineer-dashboard-view.fxml","Engineer Dashboard!");
                }
                else if (user.getRole().equals("Grid Operator")){
                    PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator", "gridOperator-dashboard-view.fxml","Grid Operator Dashboard!");
                }
                return;
            }
        }
        showError("Invalid User Id or Password.");
    }
    public void showError(String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }
}