package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.commonFiles;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.CurrentUser;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.User;
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
}