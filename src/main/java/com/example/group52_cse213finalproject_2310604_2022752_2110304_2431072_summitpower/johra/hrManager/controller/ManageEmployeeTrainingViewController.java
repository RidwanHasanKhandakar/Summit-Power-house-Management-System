package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.fileHandler.hrManager.EmployeeTrainingFileHandler;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Employee;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.EmployeeTraining;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

public class ManageEmployeeTrainingViewController
{
    @javafx.fxml.FXML
    private CheckBox trainingStatusDoneCheckBox;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> employeeNameCol;
    @javafx.fxml.FXML
    private TableColumn<Employee, Boolean> trainingStatusCol;
    @javafx.fxml.FXML
    private ComboBox<String> trainerNameComboBox;
    @javafx.fxml.FXML
    private CheckBox trainingStatusNotDoneCheckBox;
    @javafx.fxml.FXML
    private ComboBox<String> trainingIdComboBox;
    @javafx.fxml.FXML
    private TableView<Employee> showTrainingProgramTableView;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> employeeIdCol;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> trainingNameCom;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> trainerIdCol;
    @javafx.fxml.FXML
    private TextField employeeIdTextField;
    @javafx.fxml.FXML
    private TextField employeeNameTextField;

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

        EmployeeTraining employeeTraining = new EmployeeTraining(employeeIdTextField.getText(), employeeNameTextField.getText(), trainingIdComboBox.getValue(), trainerNameComboBox.getValue(), trainingStatusDoneCheckBox.isSelected(), trainingStatusNotDoneCheckBox.isSelected());

        EmployeeTrainingFileHandler.save(employeeTraining);

        showInformation("Training information recorded successfully !");
    }

    public void showError(String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("null");
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
        trainingStatusNotDoneCheckBox.setSelected(false);
        trainingStatusDoneCheckBox.setSelected(false);

    }
}