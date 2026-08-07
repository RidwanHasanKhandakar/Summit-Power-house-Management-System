package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.hrManager.PerformanceGradingFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.PerformanceGrading;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EmployeePerformanceGradingViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> efficiencyScoreComboBox;
    @javafx.fxml.FXML
    private TextField employeeIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> evaluationYearComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> teamworkScoreComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> attendanceScoreComboBox;
    @javafx.fxml.FXML
    private Label finalRatingLabel;
    @javafx.fxml.FXML
    private ComboBox<String> evaluationMonthComboBox;

    @javafx.fxml.FXML
    public void initialize() {

        attendanceScoreComboBox.getItems().addAll(
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10"
        );

        teamworkScoreComboBox.getItems().addAll(
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10"
        );

        efficiencyScoreComboBox.getItems().addAll(
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10"
        );

        evaluationMonthComboBox.getItems().addAll(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        );

        evaluationYearComboBox.getItems().addAll(
                "2026",
                "2027",
                "2028",
                "2029",
                "2030"
        );
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "dashboard-view.fxml", "HR Manager Dashboard");
    }


    @javafx.fxml.FXML
    public void saveEmployeePerformanceButtonOnAction(ActionEvent actionEvent) {

        if(employeeIdTextField.getText().isEmpty()){
            showError("Field cannot be empty");
            return;
        }

        if(attendanceScoreComboBox.getValue() == null){
            showError("Field cannot be empty");
            return;
        }

        if(teamworkScoreComboBox.getValue() == null){
            showError("Field cannot be empty");
            return;
        }

        if(efficiencyScoreComboBox.getValue() == null){
            showError("Field cannot be empty");
            return;
        }

        if(evaluationMonthComboBox.getValue() == null){
            showError("Field cannot be empty");
            return;
        }

        if(evaluationYearComboBox.getValue() == null){
            showError("Field cannot be empty");
            return;
        }

        int attendance = Integer.parseInt(attendanceScoreComboBox.getValue());
        int teamwork = Integer.parseInt(teamworkScoreComboBox.getValue());
        int efficiency = Integer.parseInt(efficiencyScoreComboBox.getValue());
        int finalRating = (attendance + teamwork + efficiency) / 3;

        finalRatingLabel.setText(String.valueOf(finalRating));

        PerformanceGrading performanceGrading = new PerformanceGrading(employeeIdTextField.getText(), evaluationMonthComboBox.getValue(), evaluationYearComboBox.getValue(), attendanceScoreComboBox.getValue(), teamworkScoreComboBox.getValue(), efficiencyScoreComboBox.getValue(), String.valueOf(finalRating));
        PerformanceGradingFileHandler.save(performanceGrading);

        showInformation("Performance grading saved successfully !");

    }

    public void showInformation(String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Success");
        alert.setContentText(text);
        alert.showAndWait();
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

        employeeIdTextField.clear();
        attendanceScoreComboBox.setValue(null);
        teamworkScoreComboBox.setValue(null);
        efficiencyScoreComboBox.setValue(null);
        evaluationMonthComboBox.setValue(null);
        evaluationYearComboBox.setValue(null);

    }

}