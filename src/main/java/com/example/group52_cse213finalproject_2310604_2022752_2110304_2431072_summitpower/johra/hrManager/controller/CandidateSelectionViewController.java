package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Candidate;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

public class CandidateSelectionViewController
{
    @javafx.fxml.FXML
    private TextField candidateIdTextField;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private ComboBox<String> appliedPositionComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> qualificationComboBox;
    @javafx.fxml.FXML
    private TextField candidateNameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> experienceComboBox;
    @javafx.fxml.FXML
    private CheckBox isSelectCandidateCheckBox;
    @javafx.fxml.FXML
    private CheckBox isNotSelectCandidateCheckbox;
    @javafx.fxml.FXML
    private CheckBox isPendingCandidateCheckBox;
    @javafx.fxml.FXML
    private TextField interviewScoreTextField;

    @javafx.fxml.FXML
    public void initialize() {

        qualificationComboBox.getItems().addAll(
                "SSC",
                "HSC",
                "BSc",
                "MBA",
                "MSc"

        );

        appliedPositionComboBox.getItems().addAll(
                "Entry-level Staff",
                "Office Assistant",
                "Technician",
                "Electrical Engineer",
                "Mechanical Engineer",
                "HR"
        );

        experienceComboBox.getItems().addAll(
                "1 year",
                "2 years",
                "3 years",
                "4 years",
                "5 years"
        );

    }

    @javafx.fxml.FXML
    public void confirmButtonOnAction(ActionEvent actionEvent) {

        if(candidateIdTextField.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        if(candidateNameTextField.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        if(emailTextField.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        if(candidateIdTextField.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        if(qualificationComboBox.getValue().isEmpty()){
            showError("Field cannot be empty");
        }

        if(appliedPositionComboBox.getValue().isEmpty()){
            showError("Field cannot be empty");
        }

        if(experienceComboBox.getValue().isEmpty()){
            showError("Field cannot be empty");
        }

        if(interviewScoreTextField.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        /*if(isSelectCandidateCheckBox.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        if(isNotSelectCandidateCheckbox.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        if(isPendingCandidateCheckBox.getText().isEmpty()){
            showError("Field cannot be empty");
        }*/
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {

        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "dashboard-view.fxml", "HR Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void refreshButtonOnAction(ActionEvent actionEvent) {

        candidateIdTextField.clear();
        candidateNameTextField.clear();
        appliedPositionComboBox.setValue(null);
        qualificationComboBox.setValue(null);
        emailTextField.clear();
        experienceComboBox.setValue(null);
        isSelectCandidateCheckBox.setSelected(false);
        isNotSelectCandidateCheckbox.setSelected(false);
        isPendingCandidateCheckBox.setSelected(false);
        interviewScoreTextField.clear();
    }

    public void showError(String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("null");
        alert.setContentText(text);
        alert.showAndWait();
    }
}