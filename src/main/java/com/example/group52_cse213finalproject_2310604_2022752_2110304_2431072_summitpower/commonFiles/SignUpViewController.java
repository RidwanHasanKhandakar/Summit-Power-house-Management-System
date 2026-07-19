package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.commonFiles;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.User;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.time.LocalDate;

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
    private DatePicker dateOfBirthDatePicker;
    @javafx.fxml.FXML
    private TextField phoneTextField;

    @javafx.fxml.FXML
    public void initialize() {
        genderComboBox.getItems().addAll("Male","Female","Others");
    }

    @javafx.fxml.FXML
    public void handleSignUpButton(ActionEvent actionEvent) {

        String fName = firstNameTextField.getText();
        String lName = lastNameTextField.getText();
        String pw = passwordTextField.getText();
        String address = addressTextField.getText();
        String gendar = genderComboBox.getValue();
        String email = emailTextField.getText();
        boolean terms = termsCheckBox.isSelected();
        String id = userIdTextField.getText();
        LocalDate dob = dateOfBirthDatePicker.getValue();
        int phone;

        try{
            phone = Integer.parseInt(phoneTextField.getText());
        }catch (NumberFormatException e){
            showError("You need to enter Int for Phone Number");
            return;
        }

        if (fName.isEmpty()||lName.isEmpty()||pw.isEmpty()||address.isEmpty()||gendar.isEmpty()||email.isEmpty()||!terms||id.isEmpty()||dob==null){
            showError("please fill out all fields and accept the terms and conditions!");
            return;
        }
        else {
            User user = new User(fName,lName,address,phone,gendar,id,email,pw);
            showSuc("Accountant Created Successfully");

            PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"log-in-view.fxml","Log In");
        }
    }

    @javafx.fxml.FXML
    public void handleAlreadyHaveAnAccount(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"log-in-view.fxml","Log In");
    }
    public void showError(String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }
    public void showSuc(String txt){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("confirmation");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }
}