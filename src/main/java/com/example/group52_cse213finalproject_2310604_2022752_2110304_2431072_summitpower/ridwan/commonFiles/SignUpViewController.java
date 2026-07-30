package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.commonFiles;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.User;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.UserFileHandler;
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
    private ComboBox <String> roleComboBox;

    @javafx.fxml.FXML
    public void initialize() {

        genderComboBox.getItems().addAll("Male","Female","Others");

        roleComboBox.getItems().addAll(
                "CEO",
                "Plant Manager",
                "BPDB Officer",
                "Accountant",
                "HR Manager",
                "Inventory Manager",
                "Engineer",
                "Grid Operator");
    }

    @javafx.fxml.FXML
    public void handleSignUpButton(ActionEvent actionEvent) {

            String fName = firstNameTextField.getText().trim();
            String lName = lastNameTextField.getText().trim();
            String pw = passwordTextField.getText().trim();
            String address = addressTextField.getText().trim();
            String gender = genderComboBox.getValue();
            String email = emailTextField.getText().trim();
            boolean terms = termsCheckBox.isSelected();
            String id = userIdTextField.getText().trim();
            LocalDate dob = dateOfBirthDatePicker.getValue();
            String role = roleComboBox.getValue();
            //String phone;

            // Required fields
            if (fName.isEmpty()
                    || lName.isEmpty()
                    || pw.isEmpty()
                    || address.isEmpty()
                    || email.isEmpty()
                    || id.isEmpty()
                    || dob == null
                    || gender == null
                    || role == null
                    || !terms) {

                showError("Please fill out all fields and accept the terms and conditions.");
                return;
            }

            // Name validation
            if (!fName.matches("[A-Za-z ]+") || !lName.matches("[A-Za-z ]+")) {
                showError("First and Last Name can contain only letters.");
                return;
            }

            // User ID
            if (id.contains(" ")) {
                showError("User ID cannot contain spaces.");
                return;
            }

            // Password
            if (pw.length() < 6) {
                showError("Password must be at least 6 characters.");
                return;
            }

            // Email
            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                showError("Invalid email address.");
                return;
            }

            // Date of Birth
            if (dob.isAfter(LocalDate.now())) {
                showError("Date of Birth cannot be in the future.");
                return;
            }

            // Phone Number
            String phoneStr = phoneTextField.getText().trim();

            if (!phoneStr.matches("\\d{11}")) {
                showError("Phone number must contain exactly 11 digits.");
                return;
            }

            if(!phoneStr.matches("\\d{11}")){
                showError("Phone number ust contain exactly 11 digits.");
                return;
            }

            // Duplicate check
            for (User u : UserFileHandler.readAll()) {

                if (u.getUserId().equalsIgnoreCase(id)) {
                    showError("User ID already exists.");
                    return;
                }

                if (u.getEmail().equalsIgnoreCase(email)) {
                    showError("Email already exists.");
                    return;
                }
            }

            // Create User
            User user = new User(
                    fName,
                    lName,
                    address,
                    phoneStr,
                    gender,
                    dob,
                    id,
                    email,
                    pw,
                    role
            );

            UserFileHandler.save(user);

            showSuc(role + " Account Created Successfully.");

            PrimarySceneSwitcher.primarySwitchScene(
                    (Node) actionEvent.getSource(),
                    "ridwan",
                    "commonFiles",
                    "log-in-view.fxml",
                    "Log In"
            );

    }

    @javafx.fxml.FXML
    public void handleAlreadyHaveAnAccount(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"ridwan","commonFiles","log-in-view.fxml","Log In!");
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