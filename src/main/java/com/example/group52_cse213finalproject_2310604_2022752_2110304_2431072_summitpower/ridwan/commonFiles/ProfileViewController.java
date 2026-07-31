package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.commonFiles;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.CurrentUser;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.User;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class ProfileViewController
{
    @javafx.fxml.FXML
    private Text firstNameText;
    @javafx.fxml.FXML
    private Text phoneText;
    @javafx.fxml.FXML
    private Text dobText;
    @javafx.fxml.FXML
    private Text userIdText;
    @javafx.fxml.FXML
    private Text lastNameText;
    @javafx.fxml.FXML
    private Text addressText;
    @javafx.fxml.FXML
    private Text genderText;
    @javafx.fxml.FXML
    private Text emailText;
    @javafx.fxml.FXML
    private Text roleText;

    @javafx.fxml.FXML
    public void initialize() {

        User user = CurrentUser.getUser();

        if (user!=null){

            firstNameText.setText(user.getFirstName());
            lastNameText.setText(user.getLastName());
            userIdText.setText(user.getUserId());
            emailText.setText(user.getEmail());
            roleText.setText(user.getRole());
            genderText.setText(user.getGender());
            phoneText.setText(String.valueOf(user.getPhoneNumber()));
            addressText.setText(user.getAddress());
            dobText.setText(user.getDateOfBirth().toString());

        }

    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) {

        //PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","bpdbOfficer","bpdbOfficer-dashboard-view.fxml","BPDB Officer Dashboard!");
        User user = CurrentUser.getUser();

        if (user==null){
            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridawn","commonFiles","log-in-view.fxml","Log In!");
            return;
        }

        switch (user.getRole()){
            case "CEO":
                PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","ceo","ceo-dashboard-view-fxml","CEO Dashboard!");
                break;

            case "Plant Manager":
                PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"rubama","plantManager","plant-manager-view-fxml","Plant Manager Dashboard!");
                break;

            case "BPDB Officer":
                PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","bpdbOfficer","bpdbOfficer-dashboard-view.fxml","BPDB Officer Dashboard!");
                break;

            case "Accountant":
                PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "ridwan","accountant","accountant-dashboard-view-fxml","Accountant Dashboard!");
                break;

            case "HR Manager":
                PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra","hrManager","dashboard-view.fxml","HR Manager Dashboard!");
                break;

            case "Inventory Manager":
                PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"johra", "inventoryManager", "dashboard-view.fxml","Inventory Manager Dashboard!");
                break;

            case "Engineer":
                PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "samia","engineer","engineer-dashboard-view.fxml","Engineer Dashboard!");
                break;

            case "Grid Operator":
                PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"samia","gridOperator","gridOperator-dashboard-view.fxml","Grid Operator Dashboard!");
                break;
        }
    }
}