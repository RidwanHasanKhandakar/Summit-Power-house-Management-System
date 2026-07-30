package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Employee;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ManageEmployeeTrainingViewController
{
    @javafx.fxml.FXML
    private TextField employeeTextField;
    @javafx.fxml.FXML
    private CheckBox trainingStatusDoneCheckBox;
    @javafx.fxml.FXML
    private TableColumn<String, Employee> employeeNameCol;
    @javafx.fxml.FXML
    private TableColumn<Boolean, Employee> trainingStatusCol;
    @javafx.fxml.FXML
    private ComboBox<String> trainerNameComboBox;
    @javafx.fxml.FXML
    private CheckBox trainingStatusNotDoneCheckBox;
    @javafx.fxml.FXML
    private ComboBox<String> trainingIdComboBox;
    @javafx.fxml.FXML
    private TableView<Employee> showTrainingProgramTableView;
    @javafx.fxml.FXML
    private TableColumn<String, Employee> employeeIdCol;
    @javafx.fxml.FXML
    private TableColumn<String, Employee> trainingNameCom;
    @javafx.fxml.FXML
    private TableColumn<String, Employee> trainerIdCol;
    @javafx.fxml.FXML
    private TextField employeeIdTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void homeButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveTrainingButtonOnAction(ActionEvent actionEvent) {
    }
}