package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.commonFiles;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class SignUpViewController
{
    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private TextField addressTextField;
    @javafx.fxml.FXML
    private TextField lastNameTextField;
    @javafx.fxml.FXML
    private TextField userIdTextField;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private ComboBox <String> genderComboBox;
    @javafx.fxml.FXML
    private TextField firstNameTextField;
    @javafx.fxml.FXML
    private CheckBox termsCheckBox;
    @javafx.fxml.FXML
    private TextField phoneTextField1;
    @javafx.fxml.FXML
    private DatePicker dateOfBirthDatePicker;

    @javafx.fxml.FXML
    public void initialize() {
        genderComboBox.getItems().addAll("Male","Female","Others");
    }

    @javafx.fxml.FXML
    public void handleSignUpButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleAlreadyHaveAnAccount(ActionEvent actionEvent) {
    }
}