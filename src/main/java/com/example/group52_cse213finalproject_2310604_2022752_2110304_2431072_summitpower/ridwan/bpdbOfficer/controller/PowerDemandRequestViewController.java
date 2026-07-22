package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.bpdbOfficer.model.PowerDemandRequest;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.ridwan.fileHandler.PowerDemandRequestFileHandler;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.time.LocalDate;

public class PowerDemandRequestViewController
{
    @javafx.fxml.FXML
    private TextField reqCapacityTextField;
    @javafx.fxml.FXML
    private ComboBox <String> purposeOfDemandComboBox;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private ComboBox <String> priorityLavelComboBox;
    @javafx.fxml.FXML
    private DatePicker EndDateDatePicker;
    @javafx.fxml.FXML
    private DatePicker startDateDatePicker;
    @javafx.fxml.FXML
    private TextField reqIdTextField;

    private static int reqCounter = 1001;

    @javafx.fxml.FXML
    public void initialize() {

        reqIdTextField.setText("REQ-"+reqCounter++);
        reqIdTextField.setEditable(false);

        priorityLavelComboBox.getItems().addAll(
                "Low",
                "Medium",
                "High",
                "Emergency");
        purposeOfDemandComboBox.getItems().addAll(
                "Residential Supply",
                "Industrial Supply",
                "Commercial Supply",
                "Agricultural Supply",
                "Emergency Supply",
                "Other");
    }

    @javafx.fxml.FXML
    public void handleSubmitRequestButton(ActionEvent actionEvent) {

        double capacity;

        try{
            capacity=Double.parseDouble(reqCapacityTextField.getText());
        }catch (NumberFormatException e){
            showError("Please enter a valid power capacity");
            return;
        }

        if (capacity<=0){
            showError("Please enter a valid power capacity.");
            return;
        }

        LocalDate startDate = startDateDatePicker.getValue();

        if (startDate==null){
            showError("Please select a valid date.");
            return;
        }
        if (startDate.isBefore(LocalDate.now())){
            showError("Please select a valid start date.");
            return;
        }

        LocalDate endDate = EndDateDatePicker.getValue();

        if (endDate==null){
            showError("End date must be after the start date.");
            return;
        }
        if (!endDate.isAfter(startDate)){
            showError("End date must be after the start date.");
            return;
        }

        if (priorityLavelComboBox.getValue()==null){
            showError("Please select a priority level.");
            return;
        }

        if (purposeOfDemandComboBox.getValue()==null){
            showError("Please select a purpose of request.");
            return;
        }

        String remarks = remarksTextArea.getText();

        if (remarks.length()>100){
            showError("Remarks cannot be exceed 100 characters.");
            return;
        }

        PowerDemandRequest request = new PowerDemandRequest(reqIdTextField.getText(),capacity,startDate,endDate,priorityLavelComboBox.getValue(),purposeOfDemandComboBox.getValue(),remarks);
        PowerDemandRequestFileHandler.save(request);
        showSuc("Power Demand request submitted successfully.");

        clearForm();

    }

    @javafx.fxml.FXML
    public void handleClearButton(ActionEvent actionEvent) {

        clearForm();
    }

    @javafx.fxml.FXML
    public void handleHomeButton(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(),"bpdbOfficer","bpdbOfficer-dashboard-view.fxml", "BPDB Officer Dashboard!");
    }

    public void showError(String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

    public void showSuc (String txt){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Saved!");
        alert.setHeaderText(null);
        alert.setContentText(txt);
        alert.showAndWait();
    }

    private void clearForm(){
        reqIdTextField.setText("REQ-"+reqCounter++);
        reqCapacityTextField.clear();
        priorityLavelComboBox.setValue(null);
        purposeOfDemandComboBox.setValue(null);
        startDateDatePicker.setValue(null);
        EndDateDatePicker.setValue(null);
        remarksTextArea.clear();
    }

}