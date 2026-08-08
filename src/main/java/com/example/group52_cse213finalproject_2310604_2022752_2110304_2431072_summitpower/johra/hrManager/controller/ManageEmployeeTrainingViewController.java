package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.hrManager.EmployeeTrainingFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Employee;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.EmployeeTraining;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageEmployeeTrainingViewController
{
    @javafx.fxml.FXML
    private TableColumn<EmployeeTraining, String> employeeNameCol;
    @javafx.fxml.FXML
    private TableColumn<EmployeeTraining, Boolean> trainingStatusCol;
    @javafx.fxml.FXML
    private ComboBox<String> trainerNameComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> trainingIdComboBox;
    @javafx.fxml.FXML
    private TableView<EmployeeTraining> showTrainingProgramTableView;
    @javafx.fxml.FXML
    private TableColumn<EmployeeTraining, String> employeeIdCol;
    @javafx.fxml.FXML
    private TableColumn<EmployeeTraining, String> trainingNameCom;
    @javafx.fxml.FXML
    private TableColumn<EmployeeTraining, String> trainerIdCol;
    @javafx.fxml.FXML
    private TextField employeeIdTextField;
    @javafx.fxml.FXML
    private TextField employeeNameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> trainingStatusCombBox;

    @javafx.fxml.FXML
    public void initialize() {

        trainerNameComboBox.getItems().addAll(
                "Ridwan Hasan Khandakar",
                "Rubama Mehnaj",
                "Samia Islam",
                "Kazi Fatema Tuj Johra"
        );

        trainingIdComboBox.getItems().addAll(
                "111",
                "112",
                "113",
                "114"
        );

        trainingStatusCombBox.getItems().addAll(
                "Done",
                "Not Done"
        );

        employeeIdCol.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        employeeNameCol.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        trainerIdCol.setCellValueFactory(new PropertyValueFactory<>("trainingId"));
        trainingNameCom.setCellValueFactory(new PropertyValueFactory<>("trainerName"));
        trainingStatusCol.setCellValueFactory(new PropertyValueFactory<>("trainingStatus"));

    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "dashboard-view.fxml", "HR Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void saveTrainingButtonOnAction(ActionEvent actionEvent) {

        if(employeeIdTextField.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        if(employeeNameTextField.getText().isEmpty()){
            showError("Field cannot be empty");
        }

        if(trainingIdComboBox.getValue().isEmpty()){
            showError("Field cannot be empty");
        }

        if(trainerNameComboBox.getValue().isEmpty()){
            showError("Field cannot be empty");
        }

        if(trainingStatusCombBox.getValue() == null){
            showError("Field cannot be empty");
            return;
        }

        EmployeeTraining employeeTraining = new EmployeeTraining(employeeIdTextField.getText(), employeeNameTextField.getText(), trainingIdComboBox.getValue(), trainerNameComboBox.getValue(), trainingStatusCombBox.getValue());
        EmployeeTrainingFileHandler.save(employeeTraining);

        showInformation("Training information recorded successfully !");

        showTrainingProgramTableView.setItems(EmployeeTrainingFileHandler.readAll());

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

        employeeIdTextField.clear();
        employeeNameTextField.clear();
        trainingIdComboBox.setValue(null);
        trainerNameComboBox.setValue(null);
        trainingStatusCombBox.setValue(null);
        showTrainingProgramTableView.getSelectionModel().clearSelection();

    }

}