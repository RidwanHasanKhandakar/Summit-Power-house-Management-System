package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.JohraSceneSwitch;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.hrManager.CreateNoticeFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.inventoryManager.AddEquipmentFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Notice;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.Equipment;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.inventoryManager.model.Vendor;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*
        ;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

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
    }


    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "dashboard-view.fxml", "HR Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void createNoticeButtonOnAction(ActionEvent actionEvent) {

        if(noticeIdTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(subjectTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(contentTextArea.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(createdbyTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(publishDateDatePicker.getValue() == null){
            showError("Field cannot be empty");
            return;
        }

        if(publishDateDatePicker.getValue().isBefore(LocalDate.now())){
            showError("Publish Date must be today! ");
            return;
        }

        if(expiryDateDatePicker.getValue() == null){
            showError("Field cannot be empty");
            return;
        }

        if(expiryDateDatePicker.getValue().isBefore(publishDateDatePicker.getValue())){
            showError("Expiry Date cannot be before publish Date");
            return;
        }

        Notice notice = new Notice(noticeIdTextField.getText(), subjectTextField.getText(), contentTextArea.getText(), createdbyTextField.getText(), publishDateDatePicker.getValue(), expiryDateDatePicker.getValue());

        CreateNoticeFileHandler.save(notice);

        showInformation("Notice created successfully !");

    }

    public void showError(String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }

    public void showInformation(String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Success");
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

    @javafx.fxml.FXML
    public void loadNoticeButtonOnAction(ActionEvent actionEvent) throws IOException {
        JohraSceneSwitch.johraSceneSwitch((Node) actionEvent.getSource(), "hrManager", "noticeDetails-view.fxml", "Notice Details");

    }
}