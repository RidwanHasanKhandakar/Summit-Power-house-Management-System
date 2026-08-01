package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*
        ;

public class CreateNoticeViewController
{
    @javafx.fxml.FXML
    private DatePicker publishDateDatePicker;
    @javafx.fxml.FXML
    private TextField subjectTextField;
    @javafx.fxml.FXML
    private TextArea contentTextArea;
    @javafx.fxml.FXML
    private TextField createdbyTextField;
    @javafx.fxml.FXML
    private TextField noticeIdTextField;
    @javafx.fxml.FXML
    private DatePicker expiryDateDatePicker;

    @javafx.fxml.FXML
    public void initialize() {

        if(noticeIdTextField.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        if(subjectTextField.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        if(contentTextArea.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        if(createdbyTextField.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        if(publishDateDatePicker == null){
            showError("Field cannot be empty");
        }

        if(expiryDateDatePicker == null){
            showError("Field cannot be empty");
        }

    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "dashboardView.fxml", "HR Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void createNoticeButtonOnAction(ActionEvent actionEvent) {
    }

    public void showError(String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void refreshButtonOnAction(ActionEvent actionEvent) {

        noticeIdTextField.clear();
        subjectTextField.clear();
        contentTextArea.clear();
        createdbyTextField.clear();
        publishDateDatePicker.setValue(null);
        expiryDateDatePicker.setValue(null);

    }
}