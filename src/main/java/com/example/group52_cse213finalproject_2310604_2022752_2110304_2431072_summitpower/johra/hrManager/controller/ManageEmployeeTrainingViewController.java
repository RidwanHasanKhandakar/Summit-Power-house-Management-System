package com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.controller;

import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.PrimarySceneSwitcher;
import com.example.group52_cse213finalproject_2310604_2022752_2110304_2431072_summitpower.johra.hrManager.model.Employee;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;

public class ManageEmployeeTrainingViewController
{
    @javafx.fxml.FXML
    private TextField employeeTextField;
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
        PrimarySceneSwitcher.primarySwitchScene((Node) actionEvent.getSource(), "johra", "hrManager", "dashboardView.fxml", "HR Manager Dashboard");
    }

    @javafx.fxml.FXML
    public void saveTrainingButtonOnAction(ActionEvent actionEvent) {
    }
}